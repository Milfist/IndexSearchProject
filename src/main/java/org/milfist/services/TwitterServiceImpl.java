package org.milfist.services;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterServiceImpl implements TwitterService {

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
