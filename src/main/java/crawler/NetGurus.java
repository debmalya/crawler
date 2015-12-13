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
				System.out.println(document.html());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
