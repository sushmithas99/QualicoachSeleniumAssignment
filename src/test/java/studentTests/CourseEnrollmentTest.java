package studentTests;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import junit.framework.Assert;
import pageObject.EnrolmentPage;
import pageObject.HomePage;

public class CourseEnrollmentTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void enrollIntoCourse() {
		driver.get(prop.getProperty("studentUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginCredentials(username, password);
		log.info("Home page is displayed");
		scrollBy(0, 1600);
		Actions a = new Actions(driver);
		HomePage homePage = new HomePage(driver);
		List<WebElement> courseList = homePage.getcourseList();
		Iterator<WebElement> it = courseList.iterator();
		while (it.hasNext()) {
			WebElement next = it.next();
			a.moveToElement(next).build().perform();
			if (next.getText().equals(prop.getProperty("dammycname"))) {
				next.click();
				break;
			}
		}
		log.info("Perticular course is clicked");
		EnrolmentPage enrolmentPage = new EnrolmentPage(driver);
		String actualTitle = prop.getProperty("dammycname");
		String expectedTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			enrolmentPage.enrollMeBtn().click();
			log.info("clicked on Enrol me button");
			
		}
		else{
			log.info("user is already enrolled to that course");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed");
	}
}
