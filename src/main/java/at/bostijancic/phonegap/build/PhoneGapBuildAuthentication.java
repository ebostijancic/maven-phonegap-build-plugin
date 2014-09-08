package at.bostijancic.phonegap.build;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;


/**
 *	
 * @author ebostijancic 08.09.2014
 */
public class PhoneGapBuildAuthentication {

	public String authenticate(String username, String password) throws IOException {
		NetHttpTransport httpTransport = new NetHttpTransport();
		HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
		
		
		final HttpRequest authRequest = requestFactory.buildPostRequest(new GenericUrl("https://build.phonegap.com/token"), null);
		final HttpHeaders authHeaders = new HttpHeaders();
		
		authHeaders.setBasicAuthentication(username, password);
		authRequest.setHeaders(authHeaders);
		
		authRequest.setHeaders(authHeaders);
				
		return authRequest.execute().getStatusMessage();
	}
}
