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
public class URLCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: URLCrawler <URL> ");
		} else {
			if (!args[0].startsWith("http")) {
				args[0] = "http://" + args[0];
			}
			processURL(args[0]);
		}

	}

	/**
	 * To process the passed URL and retrieve text.
	 * 
	 * @param urlAddress
	 *            URL
	 */
	private static void processURL(String urlAddress) {
		try {
			Document doc = Jsoup.connect(urlAddress).get();
			Element bodyElement = doc.body();
			printText(bodyElement);
			printAllLinks(bodyElement);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param bodyElement
	 */
	private static void printAllLinks(Element bodyElement) {
		Elements links = bodyElement.select("a[href]");
		for (Element link:links) {
			System.out.println(link.attr("href"));
		}
		
	}

	/**
	 * @param bodyElement
	 * @return
	 */
	private static void printText(Element bodyElement) {
		String completeText = bodyElement.text();
		String[] allWords = completeText.split(" ");
		int characterCount = 0;
		for (String each : allWords) {
			characterCount += each.length();
			if (characterCount > 80) {
				System.out.println(each);
				characterCount = 0;
			} else {
				System.out.print(each + " ");
			}
		}
	}

}
