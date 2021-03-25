package com.astroapi.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astroapi.app.Config;
import com.astroapi.db.Routines;
import com.astroapi.models.User;


@RestController
@ComponentScan
@RequestMapping("/api/settings")
public class SettingsService {
	
	 	@PutMapping("/save_settings")
    @ResponseBody
    public ResponseEntity<?> saveSettings(@RequestParam(value = "uid") Integer uid, @RequestParam(value = "settings") boolean settings) {
	 		byte settingsByte = (byte)(settings?1:0);
	 		try {
	 			Routines.updateSettingsByUid(Config.getInstance().getDatabase().configuration(), uid, settingsByte);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }    
	 	
		@GetMapping("/get_settings")
    @ResponseBody
    public ResponseEntity<?> getSettings(@RequestParam(value ="pass") String pass, @RequestParam(value ="email") String email) {
			try {
				return new ResponseEntity<>(new User(Routines.getUserByEmail(Config.getInstance().getDatabase().configuration(), email)).toLinkedHashMap(), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }    
}


