package encoderDesktop.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderDesktop.TestComponents.BaseTest;

public class AllLoginTest extends BaseTest {
	String errMsg1 = "Either your username or password is incorrect, please check and try again!";
	String errMsg2 = "Your account has been restricted. Please contact our support team for assistance.";
	String errMsg3 = "Oops! You are blocked from accessing this page. To gain access, contact your admin for support.";

	@Test
	public void webLoginWithInvalidUserName() throws InterruptedException, IOException {
		
		landingPage.loginApplication("invalid01", "Password@1");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg1);

	}

	@Test
	public void webLoginWithInvalidPassword() throws InterruptedException, IOException {
		
		landingPage.loginApplication("encoder01", "Invalid@1");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg1);

	}

	@Test
	public void webLoginRestrictedAccess() throws InterruptedException, IOException {
		
		landingPage.loginApplication("restricted01", "fW^9>y=RHz6T");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg3);

	}

	@Test
	public void mobileLoginWithInvalidUserName() throws InterruptedException, IOException {
		mobileAppSettings();
		landingPage.loginApplication("invalid01", "Password@1");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg1);

	}

	@Test
	public void mobileLoginWithInvalidPassword() throws InterruptedException, IOException {
		mobileAppSettings();
		landingPage.loginApplication("encoder01", "invalid@1");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg1);

	}

	@Test
	public void mobileLoginRestrictedAccess() throws InterruptedException, IOException {
		mobileAppSettings();
		landingPage.loginApplication("restricted01", "fW^9>y=RHz6T");
		Assert.assertEquals(landingPage.getErrorMsg(), errMsg3);

	}

}
