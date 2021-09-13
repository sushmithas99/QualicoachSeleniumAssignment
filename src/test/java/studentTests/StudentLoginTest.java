package studentTests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Assignment.Qualicoach.BaseClass;

public class StudentLoginTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	@Test(dataProvider = "loginCredentials")
	
	public void userLogin(String uname,String pswd) {
		driver.get(prop.getProperty("studentUrl"));
		log.info("Navigated to Login page");
		loginCredentials(uname, pswd);
		log.info("Home Page is displayed ");
		Assert.assertEquals(driver.getTitle(), "Qualicoach");
	}
	
	@DataProvider(name ="loginCredentials")
	public String[][] getData(){
		String data[][] = {{"user01","qwer"},{"user12", "sushmitha12"}};
		return data;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser is closed");
	}
}
