package es.loganalyzer.elasticsearchdataupdater.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "loganalyzer", type = "logs")
public class Log {

	@Id
	private String id;

	private String test_no;
	private String entire_log;
	private String timestamp;
	private String thread_name;
	private String level;
	private String logger_name;
	private String formatted_message;

	public Log() {
	}

	public Log(String id, String test_no, String entire_log) {
		this.id = id;
		this.test_no = test_no;
		this.entire_log = entire_log;
		this.timestamp = "-";
		this.thread_name = "-";
		this.level = "-";
		this.logger_name = "-";
		this.formatted_message = "-";
	}

	public Log(String id, String test_no, String entire_log, String level, String formatted_message) {
		this.id = id;
		this.test_no = test_no;
		this.entire_log = entire_log;
		this.timestamp = "-";
		this.thread_name = "-";
		this.level = level;
		this.logger_name = "-";
		this.formatted_message = formatted_message;
	}

	public Log(String id, String test_no, String entire_log, String formatted_message) {
		this.id = id;
		this.test_no = test_no;
		this.entire_log = entire_log;
		this.timestamp = "-";
		this.thread_name = "-";
		this.level = "-";
		this.logger_name = "-";
		this.formatted_message = formatted_message;
	}

	public Log(String id, String test_no, String entire_log, String timestamp, String thread_name, String level,
			String logger_name, String formatted_message) {
		this.id = id;
		this.test_no = test_no;
		this.entire_log = entire_log;
		this.timestamp = timestamp;
		this.thread_name = thread_name;
		this.level = level;
		this.logger_name = logger_name;
		this.formatted_message = formatted_message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestNo() {
		return test_no;
	}

	public void setTestNo(String test_no) {
		this.test_no = test_no;
	}

	public String getEntireLog() {
		return entire_log;
	}

	public void setEntireLog(String entire_log) {
		this.entire_log = entire_log;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getThreadName() {
		return thread_name;
	}

	public void setThreadName(String thread_name) {
		this.thread_name = thread_name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLoggerName() {
		return logger_name;
	}

	public void setLoggerName(String logger_name) {
		this.logger_name = logger_name;
	}

	public String getFormattedMessage() {
		return formatted_message;
	}

	public void setFormattedMessage(String formatted_message) {
		this.formatted_message = formatted_message;
	}

	@Override
	public String toString() {
		return "Log{" + "entire_log='" + entire_log + '\'' + ", timestamp='" + timestamp + '\'' + ", thread_name='"
				+ thread_name + '\'' + ", level='" + level + '\'' + ", logger_name='" + logger_name + '\''
				+ ", formatted_message='" + formatted_message + '\'' + ", test_no='" + test_no + "\'}";
	}
}