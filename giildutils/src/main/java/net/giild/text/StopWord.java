package net.giild.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.logging.Logger;

import org.apache.spark.api.java.function.Function;

public class StopWord implements Function<String,String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass().getName());
	private String file = "./english_stop.txt";
	private HashSet<String> blockwords = new HashSet<String>();
	
	public StopWord() {
		this.loadBlockWords();
	}
	
	public StopWord(String blockfile) {
		this.file = blockfile;
		this.loadBlockWords();
	}

	protected void loadBlockWords() {
		if (blockwords.size() == 0) {
			try {
				FileInputStream resourceStream = new FileInputStream(this.file);
				BufferedReader breader = new BufferedReader(new InputStreamReader(resourceStream));
				String line = null;
				while ( (line = breader.readLine()) != null) {
					line = line.trim().toLowerCase();
					if (line.length() > 0) {
						blockwords.add(line);
					}
				}
				breader.close();
			} catch (IOException e) {
				log.warning(e.getMessage());
			}
		}
	}
	
	@Override
	public String call(String text) throws Exception {
		if (this.blockwords.contains(text)) {
			return "";
		} else {
			return text;
		}
	}

}
