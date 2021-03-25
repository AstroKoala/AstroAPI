package com.astroapi.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.jooq.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astroapi.app.Config;
import com.astroapi.db.Routines;
import com.astroapi.db.routines.GetUserSession;
import com.astroapi.db.routines.GetVerification;
import com.astroapi.models.Settings;
import com.astroapi.models.User;


@RestController
@ComponentScan
@RequestMapping("/api")
public class LoginService {
	
	 	private Configuration conf = Config.getInstance().getDatabase().configuration();

	 	@PutMapping("/reset_pass")
    @ResponseBody
    public ResponseEntity<?> resetPass(@RequestParam(value ="pass") String pass, @RequestParam(value ="email") String email, HttpServletResponse response) throws Exception {
			try {
				Routines.updatePassword(conf, email, PasswordService.getSaltedHash(pass));
				response = generateCookie(email, response);
				return new ResponseEntity<>(getUserAndSettings(email).toLinkedHashMap(), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
    
	 	
    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login( @RequestParam(value ="pass") String passwd, 
    																@RequestParam(value ="email") String email,
    																HttpServletResponse response) throws Exception {
    	response = generateCookie(email, response);
    	// we won't have pass to check against if email isn't valid, so both cases will return false
    	if (PasswordService.check(passwd,Routines.authWithEmail(conf, email)))
    		return new ResponseEntity<>(getUserAndSettings(email).toLinkedHashMap(), HttpStatus.OK);
			else
    		return new ResponseEntity<>(new User().toLinkedHashMap(), HttpStatus.UNAUTHORIZED);
    }
    
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register( @RequestParam(value="email") String email,
    																	 @RequestParam(value="pass") String pass,
    																	 @RequestParam(value="username") String username
    																  ) {
    	try {
    		Routines.addNewUser(conf, email, PasswordService.getSaltedHash(pass), username);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception e) {
    		if (e.getMessage().contains("Duplicate entry")) {
    			LinkedHashMap<String, String> map = new LinkedHashMap<>();
    			if (e.getMessage().contains("email_UNIQUE"))
    				map.put("error_msg", "There's already an account associated with that email.");
    			if (e.getMessage().contains("user_name_UNIQUE"))
    				map.put("error_msg", "Sorry, that username is taken.");
    			return new ResponseEntity<>(map, HttpStatus.OK);
    		}
    		else
    			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    /* COOKIES */
    private HttpServletResponse generateCookie(String email, HttpServletResponse response) throws Exception {
      Cookie cookie = new Cookie("key", PasswordService.getSaltedHash(email));
      cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
      cookie.setSecure(false);
      cookie.setHttpOnly(false);
      cookie.setPath("/");
      response.addCookie(cookie);
  		return response;
  	}
    
    @GetMapping("/check_cookie")
    @ResponseBody
		public ResponseEntity<?> checkCookie(@CookieValue(value = "key", defaultValue = "") String cookieValue, HttpServletResponse response) {
    	GetUserSession session = Routines.getUserSession(conf, cookieValue);
    	if (session.getId() == null)
    		return new ResponseEntity<>(new User().toLinkedHashMap(), HttpStatus.OK); //expect to get no user if can't find a saved session
    	return session.getCook().equals(cookieValue) ? new ResponseEntity<>(getUserAndSettings(session.getEmail()).toLinkedHashMap(), HttpStatus.OK) : new ResponseEntity<>(new User().toLinkedHashMap(), HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping("/store_cookie")
    @ResponseBody
		public ResponseEntity<?> storeCookie( @CookieValue(value = "key") String cookie, 
																					@RequestParam(value ="id") String userId, 
																					@RequestParam(value ="email") String email,
																					HttpServletResponse response) {
    	try{
    		Routines.storeSession(conf, cookie, Integer.parseInt(userId));
    		return new ResponseEntity<>(new HashMap<String, String>().put("email", email), HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(new HashMap<String, String>().put("email", email), HttpStatus.OK);
    	}
    }
    
    
    @DeleteMapping("/delete_cookie")
    @ResponseBody
		public ResponseEntity<?> deleteCookie(@RequestParam(value = "cookie") String cookie, HttpServletResponse response) {
    	if (!cookie.equals("")) {
    		try {
    			Routines.deleteSessionByCookie(conf, cookie);
    			return new ResponseEntity<>(HttpStatus.OK);
    		} catch (Exception e) {
    			e.printStackTrace();
    			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
    		}
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }   
    
    @PostMapping("/send_verification_email")
    @ResponseBody
    public ResponseEntity<?> sendVerificationEmail(@RequestParam(value ="email") String email,
																										@RequestParam(value ="verification") String verification) {
    	try{
    		Routines.deleteVerification(conf, email);
    		Routines.createVerification(conf, email, getTime(), verification);
    		MailService.sendVerification(email, verification);
    		return new ResponseEntity<>(new HashMap<String, String>().put("email", email), HttpStatus.OK);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(new HashMap<String, String>().put("email", email), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GetMapping("/verify_email")
    @ResponseBody
    public ResponseEntity<?> verifyEmail(@RequestParam(value ="email") String email, 
																					@RequestParam(value ="verification") String verification) {
			if (Routines.getUserByEmail(conf, email).getUserverified() == 1) {
    		return new ResponseEntity<>("Already Verified", HttpStatus.BAD_REQUEST);
			}
			GetVerification proc = Routines.getVerification(conf, email);
			if (proc.getExpiry() != null && checkTime(DateTime.parse(proc.getExpiry())) && proc.getVerificationcode().equals(verification)) {
				try{
					Routines.verifyUserEmail(conf, email);
					Routines.deleteVerification(conf, email);
					getUserAndSettings(email);
					return new ResponseEntity<>(getUserAndSettings(email), HttpStatus.OK);
				} catch(Exception e) {
	    		e.printStackTrace();
	    		return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
			}
			return new ResponseEntity<>("Invalid Link", HttpStatus.BAD_REQUEST);
    }
    
    private static String getTime() {
    	return new DateTime().toDateTime(DateTimeZone.UTC).toString(); // Converting default zone to UTC
    }
    
    private static boolean checkTime(DateTime oldTime) {
      Period p = new Period(oldTime, new DateTime().toDateTime(DateTimeZone.UTC));
      long hours = p.getHours();
      return (hours < 2);
    }
    
    private User getUserAndSettings(String email) {
    	User user = new User(Routines.getUserByEmail(conf, email));
			Settings settings = new Settings(Routines.getSettingsForUser(conf, user.getId()));
			user.setSettings(settings);
			return user;
    }
}


