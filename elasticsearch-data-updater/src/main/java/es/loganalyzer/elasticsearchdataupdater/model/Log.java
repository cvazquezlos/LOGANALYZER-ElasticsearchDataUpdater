package es.loganalyzer.elasticsearchdataupdater.model;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(indexName = "loganalyzer", type = "logs")
public class Log {

	@Id
	private String id;

	private String entireLog;
	private @Field(type = Date)String timeStamp;
	private String threadName;
	private String level;
	private String loggerName;
	private String formattedMessage;

	public Log() {
	}

	public Log(String id, String entireLog) {
		this.id = id;
		this.entireLog = entireLog;
		this.timeStamp = "-";
		this.threadName = "-";
		this.level = "-";
		this.loggerName = "-";
		this.formattedMessage = "-";
	}

	public Log(String id, String entireLog, String timeStamp, String threadName, String level, String loggerName,
			String formattedMessage) {
		this.id = id;
		this.entireLog = entireLog;
		this.timeStamp = timeStamp;
		this.threadName = threadName;
		this.level = level;
		this.loggerName = loggerName;
		this.formattedMessage = formattedMessage;
	}

	@Override
	public String toString() {
		return "Log{" + "entireLog='" + entireLog + '\'' + ", timeStamp='" + timeStamp + '\'' + ", threadName='"
				+ threadName + '\'' + ", level='" + level + '\'' + ", loggerName='" + loggerName + '\''
				+ ", formattedMessage='" + formattedMessage + '\'' + '}';
	}
}