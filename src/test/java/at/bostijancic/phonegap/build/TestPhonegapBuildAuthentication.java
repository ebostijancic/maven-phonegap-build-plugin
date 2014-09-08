package at.bostijancic.phonegap.build;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import at.bostijancic.phonegap.build.PhoneGapBuildAuthentication.AuthResponse;

public class TestPhonegapBuildAuthentication {
	
	@Test
	public void shouldAuthenticateWithCorrectCredentials() throws IOException {
		final PhoneGapBuildAuthentication authentication = new PhoneGapBuildAuthentication();
		
		final AuthResponse response = authentication.authenticate("username", "password");
		
		Assert.assertTrue(response.isSuccess());
		
		System.out.println(response.getToken());
	}
	
	@Test
	public void shouldNotAuthenticateWithWrongCredentials() {
		Assert.fail();
	}
}
