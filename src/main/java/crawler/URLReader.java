/**
 * 
 */
package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author debmalyajash
 *
 */
public class URLReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			read(args[0]);
		} else {
			System.err.println("Please specify URL to read");
		}

	}

	/**
	 * @param string
	 */
	private static void read(String surl) {
		URL url = null;
	    String inputLine;

	    try {
	        url = new URL(surl);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    BufferedReader in = null;
	    PrintWriter writer = null;
	    try {
	        in = new BufferedReader(new InputStreamReader(url.openStream()));
	        writer = new PrintWriter(new File("oscars.xml"));
	        while ((inputLine = in.readLine()) != null) {
	            System.out.println(inputLine);
	            writer.println(inputLine);
	        }
	        in.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	if (in != null) {
	    		try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	if (writer  != null) {
	    		writer.close();
	    	}
	    }
		
	}

}
