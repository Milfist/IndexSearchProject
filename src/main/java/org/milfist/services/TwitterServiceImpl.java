package org.milfist.services;

import static org.milfist.common.Constants.AT;
import static org.milfist.common.Constants.COLON;
import static org.milfist.common.Constants.HASH;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ElasticSearchService esService;
	
	public List<String> getTwitts(String filter) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		QueryResult result = twitter.search(new Query(HASH.getValue().concat(filter)));
		Gson gson = new Gson();		
		
		// TODO Refactor
		List<String> list = result.getTweets().stream().map(gson::toJson).collect(Collectors.toList()); 
		
		this.esService.indexing(list, filter);		
				
				
        return list;
		
	}
	
	public Stream<String> getTwittsExample(String filter) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		QueryResult result = twitter.search(new Query(HASH.getValue().concat(filter)));
		return result.getTweets().stream().map(this::getFormatedMessage);
	}

	@Override
	public String getFormatedMessage(Status status) {
		return AT.getValue() + status.getUser().getScreenName() + COLON.getValue() + status.getText();
	}

}
