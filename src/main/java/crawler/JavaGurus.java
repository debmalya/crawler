/**
 * 
 */
package crawler;

import java.io.IOException;
import java.util.HashSet;
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

	private static Set<String> gurus = new HashSet<>();

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
					System.out.println(element.ownText());
				} else {					
					isRepeated = true;
//					/html/body/p[2]/table/tbody/tr[2]/td/p[2]
//					what text comes after this is about java guru.
//					Repeated - here will come the details of guru.
//					Get the details.
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
