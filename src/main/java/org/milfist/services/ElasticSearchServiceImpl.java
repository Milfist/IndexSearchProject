package org.milfist.services;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.net.InetSocketAddress;
import java.util.List;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
	// TODO Refactor
	@Override
	public void indexing(List<?> lista, String index) {
		// Client client = new TransportClient().addTransportAddress(new
		// InetSocketTransportAddress("localhost", 9300));
		
		
		Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch").build();

        Client client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300)));
                //.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9301)));
		
		
		
		

//		nodeBuilder().settings(Settings.builder().put("path.home", "/path/to/elasticsearch/home/dir"));
		
//		Node node = nodeBuilder().clusterName("elasticsearch").client(true).node();
//		Client client = node.client();

		client.admin().indices()
			        	.create(new CreateIndexRequest(index))
			        	.actionGet();
		
	}

	@Override
	public void searching(String index) {
		// TODO Auto-generated method stub

	}

}
