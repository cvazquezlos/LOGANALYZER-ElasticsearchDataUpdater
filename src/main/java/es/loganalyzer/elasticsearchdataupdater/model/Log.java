package es.loganalyzer.elasticsearchdataupdater.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "loganalyzer", type = "logs")
public class Log {

	@Id
	private Integer id;

	private String entireLog;
	private String timestamp;
	private String threadName;
	private String level;
	private String loggerName;
	private String formattedMessage;

	public Log() {
	}

	public Log(Integer id, String entireLog) {
		this.id = id;
		this.entireLog = entireLog;
		this.timestamp = "-";
		this.threadName = "-";
		this.level = "-";
		this.loggerName = "-";
		this.formattedMessage = "-";
	}

	public Log(Integer id, String entireLog, String level, String formattedMessage) {
		this.id = id;
		this.entireLog = entireLog;
		this.timestamp = "-";
		this.threadName = "-";
		this.level = level;
		this.loggerName = "-";
		this.formattedMessage = formattedMessage;
	}

	public Log(Integer id, String entireLog, String formattedMessage) {
		this.id = id;
		this.entireLog = entireLog;
		this.timestamp = "-";
		this.threadName = "-";
		this.level = "-";
		this.loggerName = "-";
		this.formattedMessage = formattedMessage;
	}

	public Log(Integer id, String entireLog, String timeStamp, String threadName, String level, String loggerName,
			String formattedMessage) {
		this.id = id;
		this.entireLog = entireLog;
		this.timestamp = timeStamp;
		this.threadName = threadName;
		this.level = level;
		this.loggerName = loggerName;
		this.formattedMessage = formattedMessage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntireLog() {
		return entireLog;
	}

	public void setEntireLog(String entireLog) {
		this.entireLog = entireLog;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public String getFormattedMessage() {
		return formattedMessage;
	}

	public void setFormattedMessage(String formattedMessage) {
		this.formattedMessage = formattedMessage;
	}

	@Override
	public String toString() {
		return "Log{" + "entireLog='" + entireLog + '\'' + ", timeStamp='" + timestamp + '\'' + ", threadName='"
				+ threadName + '\'' + ", level='" + level + '\'' + ", loggerName='" + loggerName + '\''
				+ ", formattedMessage='" + formattedMessage + '\'' + '}';
	}
}