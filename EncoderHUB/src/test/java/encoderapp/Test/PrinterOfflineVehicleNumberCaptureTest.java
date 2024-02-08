package encoderapp.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderapp.PageObjects.PrinterOfflineVehicleNumberCapture;
import encoderapp.PageObjects.VehicleNumberSearch;
import encoderapp.TestComponents.BaseTest;

public class PrinterOfflineVehicleNumberCaptureTest extends BaseTest {
	
	@Test
	public void carNumberCaptureTest() throws InterruptedException {
		mobileAppSettings();
		landingPage.loginApplication("encoder01", "Password@1");
		Assert.assertTrue(landingPage.successLogin());
		
		PrinterOfflineVehicleNumberCapture vehicleNumberCapture = new PrinterOfflineVehicleNumberCapture(driver);
		String carNumInput = vehicleNumberCapture.carNumberCaptureInputs(generateRandomString());
		String carNumText = vehicleNumberCapture.vehicleNumberInputConfirmation();
		Assert.assertEquals(carNumText, carNumInput);
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		
		Assert.assertEquals(vehicleNumberCapture.confirmCapture(), "Ticket Saved!");
		VehicleNumberSearch search = vehicleNumberCapture.doneCapture();
		
		String expectedRes= search.parkedVehicleSearchEntryEncoder(carNumInput);
		Assert.assertEquals(expectedRes, carNumInput);

	}
	@Test	
	public void motorcycleNumberCaptureTest() throws InterruptedException {
		mobileAppSettings();
		landingPage.loginApplication("encoder01", "Password@1");
		Assert.assertTrue(landingPage.successLogin());
		
		PrinterOfflineVehicleNumberCapture motorcycleNumberCapture = new PrinterOfflineVehicleNumberCapture(driver);
		String motorcycleNumInput = motorcycleNumberCapture.motorcycleNumberCaptureInputs(generateRandomString());
		String motorcycleNumText = motorcycleNumberCapture.vehicleNumberInputConfirmation();
		Assert.assertEquals(motorcycleNumText, motorcycleNumInput);
		motorcycleNumberCapture.stubNumberInput(generateRandomNumber(7));
		
		Assert.assertEquals(motorcycleNumberCapture.confirmCapture(), "Ticket Saved!");
		VehicleNumberSearch search = motorcycleNumberCapture.doneCapture();
		
		String expectedRes =search.parkedVehicleSearchEntryEncoder(motorcycleNumInput);
		Assert.assertEquals(expectedRes, motorcycleNumInput);
		
	}

}
