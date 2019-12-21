package ga.firesoftwares.fireapi.utils.web;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * Some useful stuff about requests
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class Requests {
	/**
	 * Get a Web file content
	 * @param url URL to the file
	 * @return Content of file
	 * @throws IOException Thrown when file not found on distant web server
	 */
	public static String getWebFileContent(String url) throws IOException {
        // Setting application HTTP agent to "Chrome".
        System.setProperty("http.agent", "Chrome");
        
		// Getting content from web
		URL urlObj = new URL(url);
        InputStream is = new BufferedInputStream(urlObj.openConnection().getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        // Setting variables
        String content = new String();
        StringBuilder sb = new StringBuilder();
        
        // Creating String with content in buffer
        while ((content = reader.readLine()) != null) sb.append(content);
        
        return sb.toString();
	}
	
	/**
	 * Check if network is available.
	 * @param checkAddress Network address to ping
	 * @param timeout Timeout in milliseconds
	 * @return boolean true if network is available
	 * @throws IOException Thrown if file is not found
	 */
	public static boolean netIsAvailable(InetAddress checkAddress, int timeout) throws IOException {    	
		return checkAddress.isReachable(timeout);
	}
}
