package encoderapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoderapp.AbstractComponents.AbstractComponent;

public class VehicleNumberSearch extends AbstractComponent {

	WebDriver driver;

	public VehicleNumberSearch(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='View Parked Vehicles']")
	WebElement viewParkedVehicleTab;
	
	@FindBy(xpath="//button[text()='Capture Vehicle']")
	WebElement captureVehicleTab;
	
	@FindBy(xpath="//input[@type='text' and @name='search']")
	WebElement searchInputBox;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchBtn;
	
	@FindBy(css=".text-3xl")
	WebElement searchResult;
	
	public String parkedVehicleSearchEntryEncoder(String vehicleNumber) {
		
		waitForElementToBeCklicable(viewParkedVehicleTab);
		viewParkedVehicleTab.click();
		searchInputBox.click();
		searchInputBox.sendKeys(vehicleNumber);
		searchBtn.click();
		String searchResultText = searchResult.getText();
		captureVehicleTab.click();
		return searchResultText;
	}
	
	public String parkedVehicleSearchExitEncoder(String vehicleNum) {
	
		searchInputBox.click();
		searchInputBox.sendKeys(vehicleNum);
		searchBtn.click();
		String searchResultText = searchResult.getText();
		return searchResultText;
	}
}
