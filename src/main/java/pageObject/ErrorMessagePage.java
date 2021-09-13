package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorMessagePage {
	WebDriver driver;

	public ErrorMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@type='submit']")
	WebElement continueBtn;

	public WebElement continueBtn() {
		return continueBtn;
	}
	
	

}
