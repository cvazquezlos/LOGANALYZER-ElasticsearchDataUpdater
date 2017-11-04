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

	public String getTest_no() {
		return test_no;
	}

	public void setTest_no(String test_no) {
		this.test_no = test_no;
	}

	public String getEntire_log() {
		return entire_log;
	}

	public void setEntire_log(String entire_log) {
		this.entire_log = entire_log;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getThread_name() {
		return thread_name;
	}

	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLogger_name() {
		return logger_name;
	}

	public void setLogger_name(String logger_name) {
		this.logger_name = logger_name;
	}

	public String getFormatted_message() {
		return formatted_message;
	}

	public void setFormatted_message(String formatted_message) {
		this.formatted_message = formatted_message;
	}

	@Override
	public String toString() {
		return "Log{" + "entire_log='" + entire_log + '\'' + ", timestamp='" + timestamp + '\'' + ", thread_name='"
				+ thread_name + '\'' + ", level='" + level + '\'' + ", logger_name='" + logger_name + '\''
				+ ", formatted_message='" + formatted_message + '\'' + ", test_no='" + test_no + "\'}";
	}
}