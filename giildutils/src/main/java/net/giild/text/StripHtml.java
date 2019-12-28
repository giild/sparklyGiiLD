package net.giild.text;

import org.apache.spark.api.java.function.Function;

public class StripHtml implements Function<String,String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StripHtml() {}

	@Override
	public String call(String text) throws Exception {
		text = text.replaceAll("</?\\s*[A-Za-z]*[^>]*>", " ");
		text = text.replace(",", "");
		text = text.replace(".", "");
		text = text.replace("?", "");
		text = text.replaceAll("&nbsp;", " ");
		text = text.replaceAll("&#39;", "\'");
		text = text.replaceAll("\"", "");
		text = text.replace("\\s+", " ");
		return text;
	}

}
