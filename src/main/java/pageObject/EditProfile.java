package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfile {
	WebDriver driver;

	public EditProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_firstname")
	WebElement fname;
	@FindBy(id = "id_lastname")
	WebElement lname;
	@FindBy(id = "id_email")
	WebElement email;
	@FindBy(id = "id_city")
	WebElement city;
	@FindBy(id = "id_country")
	WebElement country;
	@FindBy(id = "id_timezone")
	WebElement timeZone;
	@FindBy(linkText = "Optional")
	WebElement expandOptional;
	@FindBy(id = "id_phone1")
	WebElement phnum;
	@FindBy(id = "id_address")
	WebElement address;
	@FindBy(id = "id_submitbutton")
	WebElement updateProfile;

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement selectCountry() {
		return country;
	}

	public WebElement selectTimeZone() {
		return timeZone;
	}

	public WebElement expandOptional() {
		return expandOptional;
	}

	public WebElement getPhNumber() {
		return phnum;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement updateBtn() {
		return updateProfile;
	}

}
