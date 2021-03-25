package com.astroapi.services;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Results;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astroapi.app.Config;
import com.astroapi.db.Routines;
import com.astroapi.models.Post;


@RestController
@ComponentScan
@RequestMapping("/api/posts")
public class PostService {

	 	@PostMapping("/publish_post")
    @ResponseBody
    public ResponseEntity<?> publishPost(@RequestParam(value ="id") int id, @RequestParam(value ="body") String body, HttpServletResponse response) {
			try {
				Routines.publishPost(Config.getInstance().getDatabase().configuration(), body, id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
    
	 	@GetMapping("/get_posts_from_friends")
    @ResponseBody
    public ResponseEntity<?> getPostsFromFriends(@RequestParam(required = false,value ="uid") int uid, @RequestParam(required = false, value = "showSelf") boolean showSelf, HttpServletResponse response) {
	 		ArrayList<Post> list = new ArrayList<>();
	 		
	 		DSLContext create = DSL.using(Config.getInstance().getDatabase().configuration());
	 		try {
	 			String where = "first_user_id = " + uid;
	 			// if option to show self is not true, add filter "and" clause to query
	 			if (!showSelf)
	 				where += " and Posts.userId != " + uid;
	 			String sql = "SELECT Posts.*, Users.first_name, Users.last_name"
	 								+ " FROM Posts"
	 								+ " JOIN Users"
	 								+ " ON Posts.userId = Users.id" 
	 								+ " WHERE EXISTS (SELECT * FROM Friendship WHERE " + where + ")" ;
	 			Results res = create.fetchMany(sql);
				for (Result<Record> r : res) {
					for (Record record : r) {
						Post p = new Post();
				    p.setId((Integer) record.getValue("id"));
				  	p.setUserId((Integer) record.getValue("userId"));
				  	p.setBody((String) record.getValue("body"));
				  	p.setLikes((Integer) record.getValue("likes"));
				  	p.setComments((Integer) record.getValue("comments"));
				  	p.setDatePosted(new DateTime(record.getValue("date_posted")));
				  	p.setPostedByFirstName((String) record.getValue("first_name"));
				  	p.setPostedByLastName((String) record.getValue("last_name"));
				    list.add(p);
					}
				}	
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
    
}


