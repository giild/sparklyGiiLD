package net.giild.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

import org.apache.spark.api.java.function.Function;

public class StopWord implements Function<String,String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String file = "./english_stop.txt";
	private HashSet<String> blockwords = new HashSet<String>();
	
	public StopWord() {
		this.loadBlockWords();
	}
	
	public StopWord(String blockfile) {
		this.file = blockfile;
	}

	protected void loadBlockWords() {
		if (blockwords.size() == 0) {
			InputStream resourceStream = StopWord.class.getResourceAsStream(this.file);
			BufferedReader breader = new BufferedReader(new InputStreamReader(resourceStream));
			String line = null;
			try {
				while ( (line = breader.readLine()) != null) {
					line = line.trim().toLowerCase();
					if (line.length() > 0) {
						blockwords.add(line);
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("stop word cout: " + this.blockwords.size());
	}
	
	@Override
	public String call(String text) throws Exception {
		for (String b: this.blockwords) {
			text = text.replace(b, "");
		}
		text = text.replace("\\s+", " ");
		if (text == null) {
			text = "";
		}
		return text;
	}

}
