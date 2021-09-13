package adminTests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.AddNewUserPage;
import pageObject.SearchPage;
import pageObject.UsersPage;

public class CreateUserTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("browser is initialized");
		
	}

	@Test
	public void createUser() {
		driver.get(prop.getProperty("adminUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("adminUsername");
		String password = prop.getProperty("adminPswd");
		loginCredentials(username, password);
		log.info("Search page is Displayed");
		SearchPage searchPage = new SearchPage(driver);
		searchPage.userTab().click();
		log.info("Navigated to users tab");
		UsersPage usersPage = new UsersPage(driver);
		usersPage.addNewUser().click();
		log.info("Add new user page is displayed");
		AddNewUserPage addNewUser = new AddNewUserPage(driver);
		addNewUser.getUsername().sendKeys(prop.getProperty("username"));
		addNewUser.clickOnPswd().click();
		addNewUser.getPassword().sendKeys(prop.getProperty("password"));
		addNewUser.getFname().sendKeys(prop.getProperty("fname"));
		addNewUser.getLname().sendKeys(prop.getProperty("lname"));
		addNewUser.getEmail().sendKeys(prop.getProperty("email"));
		scrollBy(566, 1553);
		addNewUser.submitButton().click();
		log.info("New user is successfully created");

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("driver closed");
	}

}
