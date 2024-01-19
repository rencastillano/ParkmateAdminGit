package encoderapp.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import encoderapp.PageObjects.VehicleNumberCapturing;
import encoderapp.PageObjects.VehicleNumberSearch;
import encoderapp.TestComponents.BaseTest;

public class VehicleNumberCaptureTest extends BaseTest {
	
	VehicleNumberCapturing vehicleNumberCapture;
	
	@Test
	public void carNumberCaptureTest() throws InterruptedException {

		landingPage.loginApplication("staff01", "SMSupermalls1!");
		Boolean smLogo = landingPage.successLogin();
		Assert.assertTrue(smLogo);
		
		vehicleNumberCapture = new VehicleNumberCapturing(driver);
		String carNumInput = vehicleNumberCapture.carNumberCaptureInputs(generateRandomString());
		String carNumText = vehicleNumberCapture.vehicleNumberInputConfirmation();
		Assert.assertEquals(carNumText, carNumInput);
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		
		String actualText = vehicleNumberCapture.confirmCapture();
		Assert.assertEquals(actualText, "Ticket Saved!");
		vehicleNumberCapture.doneCapture();
		
		VehicleNumberSearch search = new VehicleNumberSearch(driver);
		search.parkedVehicleSearchEntryEncoder(carNumInput);
		String expectedRes = search.parkedVehicleSearchEntryEncoder(carNumInput);
		Assert.assertEquals(expectedRes, carNumInput);

	}
	@Test	
	public void motorcycleNumberCaptureTest() throws InterruptedException {

		landingPage.loginApplication("staff01", "SMSupermalls1!");
		Boolean smLogo = landingPage.successLogin();
		Assert.assertTrue(smLogo);
		
		vehicleNumberCapture = new VehicleNumberCapturing(driver);
		String motorcycleNumInput = vehicleNumberCapture.motorcycleNumberCaptureInputs(generateRandomString());
		String motorcycleNumText = vehicleNumberCapture.vehicleNumberInputConfirmation();
		Assert.assertEquals(motorcycleNumText, motorcycleNumInput);
		vehicleNumberCapture.stubNumberInput(generateRandomNumber(7));
		
		String actualText = vehicleNumberCapture.confirmCapture();
		Assert.assertEquals(actualText, "Ticket Saved!");
		vehicleNumberCapture.doneCapture();
		
		VehicleNumberSearch search = new VehicleNumberSearch(driver);
		search.parkedVehicleSearchEntryEncoder(motorcycleNumInput);
		String expectedRes = search.parkedVehicleSearchEntryEncoder(motorcycleNumInput);
		Assert.assertEquals(expectedRes, motorcycleNumInput);
		
	}

}
