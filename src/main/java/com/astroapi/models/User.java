/**
 * 
 */
package com.astroapi.models;

import java.util.LinkedHashMap;

import com.astroapi.db.routines.GetUserByEmail;

/**
 * @author trevorlandreneau
 *
 */
public class User {
	
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private int age;
	private boolean verified;
	private String userName;
	private String ipAddress;
	private Settings settings;
	
	public User () {
		
	}
	
	public User (GetUserByEmail proc) {
		if (proc.getUseremail() != null) {
			this.id = proc.getUserid();
			this.lastName = proc.getUserlastname();
			this.firstName = proc.getUserfirstname();
			this.email = proc.getUseremail();
			this.age = (proc.getUserage() == null) ? 0 : proc.getUserage();
			this.verified = (proc.getUserverified() == 1);
			this.userName = proc.getUsername();
			this.settings = new Settings();
		}
	}
	
	public User(String lastName, String firstName, String email, int age, String userName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
		this.userName = userName;
	}
	
	public User(int id, String lastName, String firstName, String email, int age, int verified, String userName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
		this.verified = (verified == 1) ? true : false;
		this.userName = userName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVerified() {
		return this.verified;
	}

	public void setVerified(int verified) {
		this.verified = (verified == 0) ? false : true;
	}
	
	public String getipAddress() {
		return this.ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public boolean getVerified() {
		return this.verified;
	}
	
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public Settings getSettings() {
		return settings;
	}


	public LinkedHashMap<String, Object> toLinkedHashMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("id", this.id);
		map.put("last_name", this.getLastName());
		map.put("first_name", this.getFirstName());
		map.put("email", this.getEmail());
		map.put("age", this.age);
		map.put("verified", this.getVerified());
		map.put("user_name", this.getUserName());
		map.put("ipAddress", this.getipAddress());
		map.put("settings", this.getSettings());
		return map;
	}
	
}
