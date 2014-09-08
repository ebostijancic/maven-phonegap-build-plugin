package at.bostijancic.phonegap.build;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import at.bostijancic.phonegap.build.PhoneGapBuildAuthentication.AuthResponse;

import com.google.api.client.http.HttpResponseException;

public class TestPhonegapBuildAuthentication {
	final PhoneGapBuildAuthentication authentication = new PhoneGapBuildAuthentication();
	
	@Test
	public void shouldAuthenticateWithCorrectCredentials() throws IOException {
		
		final AuthResponse response = authentication.authenticate("username", "password");
		
		Assert.assertTrue(response.isSuccess());
		
		System.out.println(response.getToken());
	}
	
	@Test(expected = HttpResponseException.class)
	public void shouldNotAuthenticateWithWrongCredentials() throws IOException {
		authentication.authenticate("username", "password");			
	}
}
