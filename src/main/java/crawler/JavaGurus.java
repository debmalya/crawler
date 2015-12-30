/**
 * 
 */
package crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author debmalyajash
 *
 */
public class JavaGurus {

	/**
	 * Set of java gurus.
	 */
	private static Set<String> gurus = new HashSet<>();
	
	/**
	 * Key is the person name, value is their achievements.
	 */
	private static Map<String,String> aboutThem = new HashMap<String,String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isRepeated = false;
		try {
			Document document = Jsoup
					.connect(
							"https://java.net/website/java-champions/bios.html")
					.timeout(0).get();
			Elements elements = document.getElementsByTag("a");
			for (Element element : elements) {
				
				if (gurus.add(element.ownText()) && !isRepeated) {					
					aboutThem.put(element.ownText(), null);
				} else {					
					isRepeated = true;
					System.out.println(element.ownText()+ " " + element.nextSibling());
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param document
	 *            complete document
	 * @return
	 */
	public Elements getAllElements(Document document) {
		return document.getElementsByTag("a");
	}

}
