package es.loganalyzer.elasticsearchdataupdater.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import es.loganalyzer.elasticsearchdataupdater.model.Log;

@Repository
public interface LogRepository extends ElasticsearchCrudRepository<Log, Integer> {

    @Query("{\"bool\":{\"filter\":{\"timestamp\":\"?0\"}}}")
    Page<Log> findByTimestamp(String timestamp, Pageable pageable);

}