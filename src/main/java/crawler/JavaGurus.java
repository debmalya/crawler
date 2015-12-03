/**
 * 
 */
package crawler;

import java.io.IOException;

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
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect("https://java.net/website/java-champions/bios.html").timeout(0).get();
			Elements elements = document.getElementsByTag("a");
			for (Element element:elements) {
				System.out.println(element.ownText());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
