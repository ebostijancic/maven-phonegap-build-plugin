package at.bostijancic.phonegap.build;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;


/**
 *	
 * @author ebostijancic 08.09.2014
 */
public class PhoneGapBuildAuthentication {
	public static final AuthResponse INVALID_AUTH = new AuthResponse("");
		
	public static class AuthResponse {
		private String token;
	
		public AuthResponse() {	}

		public AuthResponse(String token) {
			this.token = token;
		}

		public String getToken() {
			return token;
		}
		
		public boolean isSuccess() {
			return StringUtils.isNotBlank(getToken());
		}
	}

	public AuthResponse authenticate(String username, String password) throws IOException {
		NetHttpTransport httpTransport = new NetHttpTransport();
		HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
		
		// post to authenticate.
		final HttpRequest authRequest = requestFactory.buildPostRequest(new GenericUrl("https://build.phonegap.com/token"), null);
		
		// add basic authentication header with username and password. 
		authRequest.setHeaders(getAuthHeaders(username, password));
		final HttpResponse response = authRequest.execute();
		
		// return authToken from the auth request.
		return getAuthTokenFromResponse(response); 
	}

	private HttpHeaders getAuthHeaders(String username, String password) {
		final HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setBasicAuthentication(username, password);
		return authHeaders;
	}
	
	private AuthResponse getAuthTokenFromResponse(HttpResponse response) throws IOException {
		// if authentication was successful (OK 200), return the authToken.
		if (response.isSuccessStatusCode()) {
			final Gson gson = new Gson();
			return gson.fromJson(response.parseAsString(), AuthResponse.class);
		}
		
		return INVALID_AUTH;
	}
}
