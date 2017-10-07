package es.loganalyzer.elasticsearchdataupdater.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@ComponentScan("es.loganalyzer.elasticsearchdataupdater")
@PropertySource("classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "es/loganalyzer/elasticsearchdataupdater/repository")
public class EsConfiguration {
}