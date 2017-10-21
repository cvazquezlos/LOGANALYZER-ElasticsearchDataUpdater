package es.loganalyzer.elasticsearchdataupdater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import es.loganalyzer.elasticsearchdataupdater.model.Log;
import es.loganalyzer.elasticsearchdataupdater.repository.LogRepository;

import java.util.List;

@Service
public class ESLogService {
	private final LogRepository repository;

	@Autowired
	public ESLogService(LogRepository repository) {
		this.repository = repository;
	}

	public void delete(Log log) {
		repository.delete(log);
	}

	public Iterable<Log> findAll() {
		return repository.findAll();
	}

	public List<Log> findByTimestamp(String timestamp, int page, int size) {
		return repository.findByTimestamp(timestamp, new PageRequest(page, size)).getContent();
	}
	
	public Log findOne(Integer id) {
		return repository.findOne(id);
	}

	public Integer save(Log log) {
		return repository.save(log).getId();
	}
}