package org.milfist.services;

import java.util.List;

public interface ElasticSearchService {
	
	public void indexing(List<?> lista, String index);
	
	public void searching(String index);
}
