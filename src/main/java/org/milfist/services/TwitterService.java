package org.milfist.services;

import twitter4j.TwitterException;

public interface TwitterService {

	public String[] getTwitts(String filter) throws TwitterException;
	
}
