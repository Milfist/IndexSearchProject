package org.milfist.services;

import java.util.List;
import java.util.stream.Stream;

import twitter4j.Status;
import twitter4j.TwitterException;

public interface TwitterService {
	
	public static final String HASH = "#";
	public static final String AT = "@";
	public static final String COLON = ":";
	
	public List<String> getTwitts(String filter) throws TwitterException;

	public Stream<String> getTwittsExample(String filter) throws TwitterException;

	public String getFormatedMessage(Status status);
	
}
