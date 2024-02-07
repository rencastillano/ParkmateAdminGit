package encoderapp.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderapp.PageObjects.ProfileSwitch;
import encoderapp.PageObjects.VehicleNumberCapturing;
import encoderapp.PageObjects.VehicleNumberSearch;
import encoderapp.TestComponents.BaseTest;

public class VehicleSearchTest extends BaseTest{
	
	VehicleNumberCapturing vehicleNumberCapture;
	@Test
	public void carParkedVehicleSearch() throws InterruptedException {
		
		//need to change profile role to exit encoder
		landingPage.loginApplication("staff01", "SMSupermalls1!");
		Boolean smLogo = landingPage.successLogin();
		Assert.assertTrue(smLogo);
		
		vehicleNumberCapture = new VehicleNumberCapturing(driver);
		String carNumInput = vehicleNumberCapture.carNumberCaptureInputs(generateRandomString());
		vehicleNumberCapture.vehicleNumberInputConfirmation();
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		vehicleNumberCapture.confirmCapture();
		VehicleNumberSearch search = vehicleNumberCapture.doneCapture();
		
		ProfileSwitch profileSwitch = new ProfileSwitch(driver);
		profileSwitch.ExitEncoderProfile();
		
		String expectedRes = search.parkedVehicleSearchExitEncoder(carNumInput);
		Assert.assertEquals(expectedRes, carNumInput);
	}
	
	@Test
	public void motorcyleParkedVehicleSearch() throws InterruptedException {
		
		landingPage.loginApplication("staff01", "SMSupermalls1!");
		Boolean smLogo = landingPage.successLogin();
		Assert.assertTrue(smLogo);
		
		vehicleNumberCapture = new VehicleNumberCapturing(driver);
		String motorcycleNumInput = vehicleNumberCapture.motorcycleNumberCaptureInputs(generateRandomString());
		vehicleNumberCapture.vehicleNumberInputConfirmation();
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		vehicleNumberCapture.confirmCapture();
		VehicleNumberSearch search = vehicleNumberCapture.doneCapture();
		
		ProfileSwitch profileSwitch = new ProfileSwitch(driver);
		profileSwitch.ExitEncoderProfile();
		
		String expectedRes = search.parkedVehicleSearchExitEncoder(motorcycleNumInput);
		Assert.assertEquals(expectedRes, motorcycleNumInput);
	}

}
