package com.astroapi.test.database_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.astroapi.app.Config;

class ConfigTest {
	
//	@BeforeAll
//	static void setUpBeforeClass() {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() {}
//	
//	@BeforeEach
//	void setUp() {}
//	
//	@AfterEach
//	void tearDown() {}
	
	@Test
	void testDatabaseConnection() {
		assertEquals(true, Config.getInstance().getDatabase());
	}

}
