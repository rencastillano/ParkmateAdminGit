package encoderDesktop.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoderDesktop.AbstractComponents.AbstractComponent;

public class PrinterOfflineVehicleNumberCapture extends AbstractComponent {

	WebDriver driver;
	
	public PrinterOfflineVehicleNumberCapture(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//CarNumberCaptureInputs
	@FindBy(css="#vehicleNumber")
	WebElement inputVehicleNumber;
	
	@FindBy(xpath="//div[@class='relative']/button[@type='button']")
	WebElement inputCancelBtn;
	
	@FindBy(xpath="//button[text()='Save and Print Ticket']")
	WebElement saveAndPrintBtn;
	
	@FindBy(xpath="//img[@alt='Car']")
	WebElement carType;
	
	@FindBy(xpath="//img[@alt='Motorcycle']")
	WebElement motorcycleType;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement addStubCancelBtn;
	
	//AddStubNumber
	@FindBy(xpath="//h2[@class='font-henry-sans-bold text-5xl']")
	WebElement addStubvehicleNumber;
	
	@FindBy(xpath="//button[text()='Confirm and Assign Parking Stub']")
	WebElement confirmAndAssignBtnParkingStub;
	
	//addStubNumber
	@FindBy(css="#parkingStubEntry")
	WebElement addParkingStubInputBox;
	
	@FindBy(xpath="//button[text()='Assign and Save']")
	WebElement addStubAssignAndSaveBtn;
	
	@FindBy(xpath="//div[text()='Ticket Saved!']")
	WebElement confirmCaprure;
	
	@FindBy(xpath="//button[text()='Ok']")
	WebElement capturedOK;
	
	
	public String carNumberCaptureInputs(String carNumberInput) throws InterruptedException {

		inputVehicleNumber.sendKeys(carNumberInput);
		Thread.sleep(500);
		inputCancelBtn.click();
		//String carNum = (carNumberInput+"R").toString();
		inputVehicleNumber.sendKeys(carNumberInput);
		boolean buttonEnabled = saveAndPrintBtn.isEnabled();
		System.out.println("Save and Print Button is Enabled: "+buttonEnabled);
		carType.click();
		buttonEnabled = saveAndPrintBtn.isEnabled();
		System.out.println("Save and Print Button is Enabled: "+buttonEnabled);
		saveAndPrintBtn.click();
		addStubCancelBtn.click();
		Thread.sleep(2000);;
		saveAndPrintBtn.click();
		return carNumberInput;
	}
	
	public String motorcycleNumberCaptureInputs(String MotorcycleNumberInput) throws InterruptedException {

		inputVehicleNumber.sendKeys(MotorcycleNumberInput);
		Thread.sleep(500);
		inputCancelBtn.click();
		//String carNum = (carNumberInput+"R").toString();
		inputVehicleNumber.sendKeys(MotorcycleNumberInput);
		boolean buttonEnabled = saveAndPrintBtn.isEnabled();
		System.out.println("Save and Print Button is Enabled: "+buttonEnabled);
		motorcycleType.click();
		buttonEnabled = saveAndPrintBtn.isEnabled();
		System.out.println("Save and Print Button is Enabled: "+buttonEnabled);
		saveAndPrintBtn.click();
		addStubCancelBtn.click();
		Thread.sleep(2000);;
		saveAndPrintBtn.click();
		return MotorcycleNumberInput;
	}
	public String vehicleNumberInputConfirmation() {
		String carNumberText = addStubvehicleNumber.getText();
		confirmAndAssignBtnParkingStub.click();
		return carNumberText;
		
	}
	public void stubNumberInput(String stubNumber) {
		addParkingStubInputBox.sendKeys(stubNumber);
		addStubAssignAndSaveBtn.click();
		
	}
	public String confirmCapture() {
		waitForWebElementToAppear(confirmCaprure);
		String msg = confirmCaprure.getText();
		return msg;
	}
	public VehicleNumberSearch doneCapture() {
		waitForElementToBeCklicable(capturedOK);
		capturedOK.click();
		VehicleNumberSearch search = new VehicleNumberSearch(driver);
		return search;
	}

}
