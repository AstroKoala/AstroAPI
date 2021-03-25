package com.astroapi.test.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.jooq.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.astroapi.db.Routines;
import com.astroapi.db.routines.AddNewUser;
import com.astroapi.db.routines.DeleteUserByEmail;
import com.astroapi.app.Config;
import com.astroapi.models.User;

class TestRetrieveUser {
	
	private User testUser;
	private Configuration conf;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		conf = Config.getInstance().getDatabase().configuration();
		testUser = new User("Testy","McTesterson", "TEST@MAIL", 26, "TESTY");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		createTestUser();
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		conf = null;
		testUser = null;
	}

	@AfterEach
	void tearDown() throws Exception {
		deleteTestUser();
	}
	
	@Test
	void getUserByEmail() {
		User retUser = new User(Routines.getUserByEmail(conf, testUser.getEmail()));
		assertNotEquals(0, retUser.getId());
		assertEquals(testUser.getEmail(), retUser.getEmail());
	}
	
	void createTestUser() {
		AddNewUser proc = new AddNewUser();
		proc.setInemail("TEST@MAIL");
		proc.setInpass("password");
		proc.setInusername("TESTY");
		assertEquals(0, proc.execute(conf)); // 0 if success
	}
	
	void deleteTestUser() {
		DeleteUserByEmail proc = new DeleteUserByEmail();
		proc.setUseremail(testUser.getEmail());
		assertEquals(0, proc.execute(conf)); // 0 if success
	}

}
