package encoderapp.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderapp.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	String errMsg = "Either your username or password is incorrect, please check and try again!";

	@Test
	public void loginWithInvalidUserName() throws InterruptedException, IOException {

		landingPage.loginApplication("staff011", "SMSupermalls1!");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg);

	}

	@Test
	public void loginWithInvalidPassword() throws InterruptedException, IOException {

		landingPage.loginApplication("staff01", "SMSupermalls11!");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg);

	}

	@Test
	public void loginWithoutAccess() throws InterruptedException, IOException {

		landingPage.loginApplication("riztest", "Password@1");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg);

	}

}
