package at.bostijancic.phonegap.build;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestPhonegapBuildAuthentication {
	
	@Test
	public void shouldAuthenticateWithCorrectCredentials() throws IOException {
		final PhoneGapBuildAuthentication authentication = new PhoneGapBuildAuthentication();
		
		final String accessToken = authentication.authenticate("username", "password");
		
		Assert.assertTrue(StringUtils.isNotBlank(accessToken));
		
		System.out.println(accessToken);
	}
	
	@Test
	public void shouldNotAuthenticateWithWrongCredentials() {
		Assert.fail();
	}
}
