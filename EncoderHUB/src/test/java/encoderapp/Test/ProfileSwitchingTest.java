package encoderapp.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderapp.PageObjects.ProfileSwitch;
import encoderapp.TestComponents.BaseTest;
import encoderapp.TestComponents.Retry;

public class ProfileSwitchingTest extends BaseTest{
	
	@Test (retryAnalyzer=Retry.class)
	public void profileSwitch() throws InterruptedException {
		
		landingPage.loginApplication("staff01", "SMSupermalls1!");
		Boolean smLogo = landingPage.successLogin();
		Assert.assertTrue(smLogo);
		
		ProfileSwitch profileSwitch = new ProfileSwitch(driver);
		String exitEncoder = profileSwitch.ExitEncoderProfile();
		Assert.assertEquals(exitEncoder, "Exit Encoder");
		String entryEncoder = profileSwitch.EntryEncoderProfile();
		Assert.assertEquals(entryEncoder, "Entry Encoder");
	}

}
