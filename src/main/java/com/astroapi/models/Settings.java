package com.astroapi.models;

public class Settings {
	private boolean showOwnPostsInFeed;
	
	Settings () {}
	
	public Settings (byte showOwnPostsInFeed) {
		this.showOwnPostsInFeed = (showOwnPostsInFeed == 1);
	}
	
	public void setShowOwnPostsInFeed(byte showOwnPostsInFeed) {
		this.showOwnPostsInFeed = (showOwnPostsInFeed == 1);
	}
	public boolean getShowOwnPostsInFeed() {
		return this.showOwnPostsInFeed;
	}
	
}
