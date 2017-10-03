package es.loganalyzer.elasticsearchdataupdater.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import es.loganalyzer.elasticsearchdataupdater.model.Log;

public interface LogRepository extends ElasticsearchRepository<Log, String>{
	List<Log> findEmployeesByTimeStamp(String timeStamp);
}
