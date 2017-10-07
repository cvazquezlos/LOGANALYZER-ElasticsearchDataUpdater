package es.loganalyzer.elasticsearchdataupdater.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import es.loganalyzer.elasticsearchdataupdater.model.Log;
import es.loganalyzer.elasticsearchdataupdater.repository.LogRepository;

@SpringBootApplication
@Import(EsConfiguration.class)
public class Application {
	
	@Autowired
	public static LogRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		inserDataIntoElasticsearch();
	}

	public static void inserDataIntoElasticsearch() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			File f = new File("log.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				data.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------- start01------------------------------------");
		Integer i = 0;
		while (data.get(0).indexOf("2") != 0) {
			Log log = new Log(i.toString(), data.get(0));
			System.out.println(data.get(0));
			data.remove(0);
			i++;
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------- start02------------------------------------");
		while (data.get(0).indexOf("T") != 0) {
			String[] args = getArgs(data.get(0));
			Log log = new Log(i.toString(), data.get(0), args[0], args[1], args[2], args[3], args[4]);
			System.out.println(data.get(0));
			data.remove(0);
			i++;
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------- start03------------------------------------");
		while (data.get(0) != null) {
			Log log = new Log(i.toString(), data.get(0));
			System.out.println(data.get(0));
			data.remove(0);
			i++;
		}
	}

	private static String[] getArgs(String string) {
		String[] args = new String[5];
		String[] data = string.split(" ");
		args[0] = data[0] + " " + data[1];
		args[1] = data[2].replace("[", "").replace("]", "");
		args[2] = data[3];
		args[3] = data[5];
		args[4] = data[7];
		for (int i = 8; i < data.length; i++) {
			args[4] += args[4] + " " + data[i];
		}
		return args;
	}

}