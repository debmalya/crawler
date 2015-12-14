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
public class NetGurus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length > 0 ) {
			try {
				Document document = Jsoup
						.connect(
								args[0])
						.timeout(0).get();
				System.out.println(getHTML(document));
				System.out.println(getText(document));
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

}
