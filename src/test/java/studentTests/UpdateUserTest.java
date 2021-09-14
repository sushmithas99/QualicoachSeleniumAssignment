package studentTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Assignment.Qualicoach.BaseClass;
import pageObject.EditProfile;
import pageObject.HomePage;

public class UpdateUserTest extends BaseClass {
	Select select;
public static Logger log = LogManager.getLogger(BaseClass.class.getName());
public WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info(" Browser is initialized");

	}

	@Test(priority = 1)
	public void updateUserProfile() {
		driver.get(prop.getProperty("studentUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginCredentials(username, password);
		log.info("Dashboard page is displayed");
		HomePage homePage = new HomePage(driver);
		homePage.imageIcon().click();
		homePage.getProfileLink().getEditProfileLink().click();
		log.info("Landed to the edit profile page");
		EditProfile editProfile = new EditProfile(driver);
		editProfile.getFname().clear();
		editProfile.getFname().sendKeys("users");
		editProfile.getLname().clear();
		editProfile.getLname().click();
		editProfile.getLname().sendKeys("s");
		editProfile.getEmail().clear();
		
		editProfile.getCity().sendKeys("bangalore");
		select = new Select(editProfile.selectCountry());
		select.selectByVisibleText("India");
		select = new Select(editProfile.selectTimeZone());
		select.selectByVisibleText("UTC");
		scrollBy(0, 900);
		editProfile.expandOptional().click();
		editProfile.getPhNumber().clear();
		editProfile.getPhNumber().sendKeys("123456789");
		editProfile.getAddress().clear();
		editProfile.getAddress().sendKeys("lag, bangalore");
		editProfile.updateBtn().click();
		log.info("User profile is updated successfully");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed");
	}
}
