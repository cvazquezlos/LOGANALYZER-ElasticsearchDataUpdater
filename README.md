# LOGANALYZER - Elasticsearch Data Updater

## Getting started with this tool
This tool works with LOGANALYZER and SpringLogsGenerator repositories. It sends data from SpringLogsGenerator tool to Elasticsearch using Java ES Client (helped by Spring Data). Just provide this tool the required content (log.txt file at root directory), modify the model, service and repository properly and run the application.

You can run this client via cmd:
1. Open your cmd and navigate inside the target folder.
2. Execute `java -jar elasticsearch-data-updater-1.0.0-SNAPSHOT.jar` followed by `"inserting"` if you want to add new information to Elasticsearch or `"deleting"` if you want to empty the DDBB content.
3. Wait till the process has been initialized and I has finished.
