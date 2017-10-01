package es.loganalyzer.elasticsearchdataupdater.model;

public class Log {

	private String entireLog;
	private String timeStamp;
	private String threadName;
	private String level;
	private String loggerName;
	private String formattedMessage;
	
	public Log() {
	}

	public Log(String entireLog, String timeStamp, String threadName, String level, String loggerName,
			String formattedMessage) {
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