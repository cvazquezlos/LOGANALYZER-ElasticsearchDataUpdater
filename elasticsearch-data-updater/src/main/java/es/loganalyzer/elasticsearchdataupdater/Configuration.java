package es.loganalyzer.elasticsearchdataupdater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import es.loganalyzer.elasticsearchdataupdater.model.Log;
import es.loganalyzer.elasticsearchdataupdater.repository.LogRepository;

@Configuration
@EnableElasticsearchRepositories
class Configuration {

	@Autowired
	ElasticsearchOperations operations;

	@Autowired
	LogRepository repository;

	@Bean
	public NodeClientFactoryBean client() {
		NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
		bean.setClusterName(UUID.randomUUID().toString());
		bean.setEnableHttp(false);
		bean.setPathData("target/elasticsearchTestData");
		bean.setPathHome("src/test/resources/test-home-dir");

		return bean;
	}

	@Bean
	public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
		return new ElasticsearchTemplate(client);
	}

	@PreDestroy
	public void deleteIndex() {
		operations.deleteIndex(Log.class);
	}
 //https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-elasticsearch-example/
	@PostConstruct
	public void insertDataSample() {
		// Remove all documents
		repository.deleteAll();
		operations.refresh(Log.class);
		// Get all logs
		ArrayList<String> data = new ArrayList<String>();
		try {
			File f = new File("src/main/resources/log.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		int index = this.getFirstIndex(data);
		for (int i=0; i<index; i++) {
			repository.save(Log.builder().entireLog(data.get(0)));
			data.remove(0);
		}
		index = this.getSecondIndex(data);
	}
	
	private int getFirstIndex(ArrayList<String> data) {
		int i = 0;
		for(String log: data) {
			if (log.startsWith("R")) 
				break;
			i++;
		}
		return i+2;
	}
	
	private int getSecondIndex(ArrayList<String> data) {
		int i = 0; 
		for(String log: data) {
			if (log.startsWith("Tests run"))
				break;
			i++;
		}
		return i;
	}
}
