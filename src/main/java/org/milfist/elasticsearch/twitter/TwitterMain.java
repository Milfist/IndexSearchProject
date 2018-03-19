package org.milfist.elasticsearch.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterMain {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		// The factory instance is re-useable and thread safe.
	    Twitter twitter = TwitterFactory.getSingleton();
	    Query query = new Query("#Madrid");
	    QueryResult result = twitter.search(query);
	    System.out.println("Tamaño de la lista: " + result.getTweets().size());
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	}

}
