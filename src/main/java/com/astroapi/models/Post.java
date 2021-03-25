package com.astroapi.models;

import java.util.LinkedHashMap;

import org.joda.time.DateTime;

public class Post {
	private int id;
	private int userId;
	private String body;
	private int likes;
	private int comments;
	private DateTime datePosted;
	private String postedByFirstName;
	private String postedByLastName;
	
	public Post() { }
	
	public Post(int id, int userId, String body, int likes,int comments, DateTime datePosted) {
		this.id = id;
		this.userId = userId;
		this.body = body;
		this.likes = likes;
		this.comments = comments;
		this.datePosted = datePosted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public DateTime getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(DateTime datePosted) {
		this.datePosted = datePosted;
	}
	
	public String getPostedByFirstName() {
		return postedByFirstName;
	}

	public void setPostedByFirstName(String postedByFirstName) {
		this.postedByFirstName = postedByFirstName;
	}

	public String getPostedByLastName() {
		return postedByLastName;
	}

	public void setPostedByLastName(String postedByLastName) {
		this.postedByLastName = postedByLastName;
	}

	public LinkedHashMap<String, Object> toLinkedHashMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("id", this.getId());
		map.put("userId", this.getUserId());
		map.put("body", this.getBody());
		map.put("likes", this.getLikes());
		map.put("comments", this.getComments());
		map.put("datePosted", this.getDatePosted());
		map.put("postedByFirstName",this.getPostedByFirstName());
		map.put("postedByLastName",this.getPostedByLastName());
		return map;
	}
}
