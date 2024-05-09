package encoderDesktop.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import encoderDesktop.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css=".btn")
	WebElement login;
	
	@FindBy(css="[src$='/icons/SM.svg']")
	WebElement smLogo;
	
	@FindBy (css="[class*='text-base']")
	WebElement errorMsg;
	
	
	public void loginApplication(String userName, String pword) {
		username.sendKeys(userName);
		password.sendKeys(pword,Keys.ENTER);
		//login.click();
		
	}
	
	public boolean successLogin() {
		waitForWebElementToAppear(smLogo);
		return smLogo.isDisplayed();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}
	
}
