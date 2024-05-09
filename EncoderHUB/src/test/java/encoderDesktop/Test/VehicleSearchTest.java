package encoderDesktop.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderDesktop.PageObjects.PrinterOfflineVehicleNumberCapture;
import encoderDesktop.PageObjects.ProfileSwitch;
import encoderDesktop.PageObjects.VehicleNumberSearch;
import encoderDesktop.TestComponents.BaseTest;

public class VehicleSearchTest extends BaseTest{
	
	PrinterOfflineVehicleNumberCapture vehicleNumberCapture;
	@Test
	public void carParkedVehicleSearch() throws InterruptedException {
		mobileAppSettings();
		//need to change profile role to exit encoder
		landingPage.loginApplication("encoder01", "Password@1");
		Assert.assertTrue(landingPage.successLogin());
		
		vehicleNumberCapture = new PrinterOfflineVehicleNumberCapture(driver);
		String carNumInput = vehicleNumberCapture.carNumberCaptureInputs(generateRandomString());
		vehicleNumberCapture.vehicleNumberInputConfirmation();
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		vehicleNumberCapture.confirmCapture();
		VehicleNumberSearch search = vehicleNumberCapture.doneCapture();
		
//		ProfileSwitch profileSwitch = new ProfileSwitch(driver);
//		profileSwitch.ExitEncoderProfile();
		
		String expectedRes = search.parkedVehicleSearchExitEncoder(carNumInput);
		Assert.assertEquals(expectedRes, carNumInput);
	}
	
	@Test
	public void motorcyleParkedVehicleSearch() throws InterruptedException {
		mobileAppSettings();
		landingPage.loginApplication("encoder01", "Password@1");
		Assert.assertTrue(landingPage.successLogin());
		
		vehicleNumberCapture = new PrinterOfflineVehicleNumberCapture(driver);
		String motorcycleNumInput = vehicleNumberCapture.motorcycleNumberCaptureInputs(generateRandomString());
		vehicleNumberCapture.vehicleNumberInputConfirmation();
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		vehicleNumberCapture.confirmCapture();
		VehicleNumberSearch search = vehicleNumberCapture.doneCapture();
		
//		ProfileSwitch profileSwitch = new ProfileSwitch(driver);
//		profileSwitch.ExitEncoderProfile();
		
		String expectedRes = search.parkedVehicleSearchExitEncoder(motorcycleNumInput);
		Assert.assertEquals(expectedRes, motorcycleNumInput);
	}

}
