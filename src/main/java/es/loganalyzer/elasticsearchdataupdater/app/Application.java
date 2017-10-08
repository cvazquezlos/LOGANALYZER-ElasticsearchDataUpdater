package es.loganalyzer.elasticsearchdataupdater.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import es.loganalyzer.elasticsearchdataupdater.model.Log;
import es.loganalyzer.elasticsearchdataupdater.service.ESLogService;

@SpringBootApplication
@Import(EsConfiguration.class)
public class Application {

	private static ESLogService service;

	@Autowired
	public void ESLogService(ESLogService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// resetIndex();
		inserDataIntoElasticsearch();
	}

	public static void inserDataIntoElasticsearch() {
		ArrayList<String> data = new ArrayList<String>();
		// Reading current test number and writing the next one.
		Integer testNo = 0;
		try {
			File f = new File("testno.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				testNo = Integer.valueOf(line);
			}
			data.add(0, "[INFO] Building project and starting unit test number " + testNo + "...");
			testNo += 1;
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(testNo.toString());
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		testNo -= 1;
		// Reading all log.txt content.
		try {
			File f = new File("log.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.add("[INFO] Finishing unit test number " + testNo + "...");
		Integer i = 0;
		// Till last [INFO] message.
		System.out.println("TILL LAST [INFO] MESSAGE");
		while (data.get(0).indexOf("-") != 0) {
			System.out.println(data.get(0));
			String[] args = getArgsNormal(data.get(0));
			Log log = new Log(i.toString(), data.get(0), args[0], args[1]);
			service.save(log);
			data.remove(0);
			i++;
		}
		// Till First Running menssage.
		System.out.println("TILL RUNNING MESSAGE");
		while (data.get(0).indexOf("2") != 0) {
			System.out.println(data.get(0));
			Log log = new Log(i.toString(), data.get(0), data.get(0));
			service.save(log);
			data.remove(0);
			i++;
		}
		// Till last JUnit log message.
		System.out.println("TILL LAST JUNIT LOG MESSAGE");
		while (data.get(0).indexOf("T") != 0) {
			String[] args = getArgsLogback(data.get(0));
			System.out.println(data.get(0));
			Log log = new Log(i.toString(), data.get(0), args[0], args[1], args[2], args[3], args[4]);
			service.save(log);
			data.remove(0);
			i++;
		}
		// Till First [INFO] menssage.
		System.out.println("TILL FIRST [INFO] MESSAGE");
		while (data.get(0).indexOf("[") != 0) {
			System.out.println(data.get(0));
			Log log = new Log(i.toString(), data.get(0), data.get(0));
			service.save(log);
			data.remove(0);
			i++;
		}
		System.out.println("LAST [INFO] MESSAGES");
		while (!data.isEmpty()) {
			System.out.println(data.get(0));
			String[] args = getArgsNormal(data.get(0));
			Log log = new Log(i.toString(), data.get(0), args[0], args[1]);
			service.save(log);
			data.remove(0);
			i++;
		}
	}

	private static String[] getArgsLogback(String string) {
		String[] args = new String[5];
		String[] data = string.split(" ");
		args[0] = data[0] + " " + data[1];
		args[1] = data[2].replace("[", "").replace("]", "");
		args[2] = data[3];
		args[3] = data[5];
		args[4] = data[7];
		for (int i = 8; i < data.length; i++) {
			args[4] += " " + data[i];
		}
		return args;
	}

	private static String[] getArgsNormal(String string) {
		String[] args = new String[5];
		String[] data = string.split(" ");
		args[0] = data[0].replace("[", "").replace("]", "");
		if (data.length != 1) {
			args[1] = data[1];
			for (int i = 2; i < data.length; i++) {
				args[1] += " " + data[i];
			}
		} else {
			args[1] = "";
		}
		return args;
	}

	private static void resetIndex() {
		Iterable<Log> savedLogs = service.findAll();
		for (Log log : savedLogs) {
			service.delete(log);
		}
	}
}