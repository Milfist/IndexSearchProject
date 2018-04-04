package org.milfist.services;

import java.net.InetSocketAddress;
import java.util.List;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
	// TODO Refactor
	@Override
	public void indexing(List<?> lista, String index) {
				
		Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch").build();

        Client client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(System.getProperty("elasticsearch.ip"), 9300)));

		client.admin().indices()
			        	.create(new CreateIndexRequest(index))
			        	.actionGet();
		
	}

	@Override
	public void searching(String index) {
		// TODO Auto-generated method stub

	}

}
