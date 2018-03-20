package org.milfist.services;

import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterServiceImpl implements TwitterService {

	public String[] getTwitts(String filter) throws TwitterException {
		
		//TODO: Refactor
		
		Twitter twitter = TwitterFactory.getSingleton();
	    Query query = new Query(filter);
	    QueryResult result = twitter.search(query);
	    System.out.println("Tamaño de la lista: " + result.getTweets().size());
	    
	    String[] array = new String[result.getTweets().size()];
	    int count = 0;
	    for (Status status : result.getTweets()) {
	    	array[count] = "@" + status.getUser().getScreenName() + ":" + status.getText();
	    }
		
		return array;
	}

}
