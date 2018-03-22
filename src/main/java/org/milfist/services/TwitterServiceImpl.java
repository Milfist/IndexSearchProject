package org.milfist.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterServiceImpl implements TwitterService {

	public List<?> getTwitts2(String filter) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		QueryResult result = twitter.search(new Query(HASH.concat(filter)));
		Gson gson = new Gson();		 
        return result.getTweets().stream().map(gson::toJson).collect(Collectors.toList());
		
	}
	
	public Stream<String> getTwitts(String filter) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		QueryResult result = twitter.search(new Query(HASH.concat(filter)));
		return result.getTweets().stream().map(status -> this.getFormatedMessage(status));
	}

	@Override
	public String getFormatedMessage(Status status) {
		return AT + status.getUser().getScreenName() + COLON + status.getText();
	}

}
