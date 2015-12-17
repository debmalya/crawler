/**
 * 
 */
package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author debmalyajash
 *
 */
public class NetGurus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length > 0 ) {
			try {
				if (!args[0].startsWith("http")) {
					args[0] = "http://"+args[0];
				}
				Document document = Jsoup
						.connect(
								args[0])
						.timeout(0).get();
				System.out.println(getHTML(document));
				List<String> lines = getTextLineByLine(document);
				for (String eachline : lines) {
					System.out.println(eachline);
				}
				getAllLinks(document);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * Get HTML document from the URL
	 * @param document to be converted.
	 * @return HTML string.
	 */
	public static String getHTML(Document document) {
		return document.html();
	}
	
	/**
	 * Get text from the document.
	 * @param document to be parsed.
	 * @return text.
	 */
	public static String getText(Document document) {
		return document.text();
	}
	
	/**
	 * 
	 * @param document retrieved from the passed URL.
	 * @return get only text and return them maximum 80 characters in each line.
	 */
	public static List<String> getTextLineByLine(Document document) {
		List<String> textList = new ArrayList<>();
		String[] split = document.text().split(" ");
		int count = 0;
		StringBuilder eachLine = new StringBuilder();
		for (String each:split) {
			
			if (count + each.length() < 80) {
				eachLine.append(" ");
				eachLine.append(each);
				
			} else {
				textList.add(eachLine.toString());
				eachLine.delete(0, eachLine.length());
				count = 0;
			}
			count += each.length();
		}
		return textList;
	}
	
	/**
	 * Print all the links of the documents.
	 * @param document
	 */
	public static void getAllLinks(Document document) {
		Elements elements = document.getElementsByTag("a");
		for (Element element : elements) {
			System.out.println(element.text()+" " + element.html());
		}
	}

}
