package at.bostijancic.phonegap.build;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "auth")
public class PhoneGapBuildAuthentication extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		throw new RuntimeException("Implement this.");
	}
}
