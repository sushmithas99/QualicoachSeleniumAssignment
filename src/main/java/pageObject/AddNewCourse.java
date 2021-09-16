package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCourse {
	WebDriver driver;

	public AddNewCourse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_fullname")
	WebElement fullName;
	@FindBy(id = "id_shortname")
	WebElement shortName;
	@FindBy(id = "id_saveanddisplay")
	WebElement saveAndDisplay;

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getShortName() {
		return shortName;
	}

	public WebElement saveAndDisplayBtn() {
		return saveAndDisplay;
	}

}
