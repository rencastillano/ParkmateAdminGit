package encoderapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoderapp.AbstractComponents.AbstractComponent;

public class ProfileSwitch extends AbstractComponent {

	WebDriver driver;
	
	public ProfileSwitch(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Menu icon']")
	WebElement menu;

	@FindBy(xpath = "//h3[@id='role']")
	WebElement profileRole;

	@FindBy(xpath = "//button[text()='Switch Profile']")
	WebElement switchBtnClick;

	@FindBy(xpath = "//button[@class='text-5xl']")
	WebElement closeSwitchPage;

	public String EntryEncoderProfile() throws InterruptedException {

		menu.click();
		String role = profileRole.getText();
		if (role.equals("Entry Encoder")) {
			Thread.sleep(3000);
			closeSwitchPage.click();
		} else {
			switchBtnClick.click();
			Thread.sleep(3000);
			closeSwitchPage.click();
			role=profileRole.getText();

		}

		return role;

	}
	
	public String ExitEncoderProfile() throws InterruptedException {

		waitForElementToBeCklicable(menu);
		menu.click();
		String role = profileRole.getText();
		if (role.equals("Exit Encoder")) {
			Thread.sleep(3000);
			closeSwitchPage.click();
		} else {
			switchBtnClick.click();
			Thread.sleep(3000);
			closeSwitchPage.click();
			role=profileRole.getText();

		}
		
		return role;

	}

}
