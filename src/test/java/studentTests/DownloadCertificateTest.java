package studentTests;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.EnrolmentPage;
import pageObject.FeedbackForm;
import pageObject.HomePage;

public class DownloadCertificateTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public EnrolmentPage enrolmentPage;

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void enrollIntoCourse() throws InterruptedException {
		driver.get(prop.getProperty("studentUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("buserName");
		String password = prop.getProperty("bpswd");
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
		enrolmentPage = new EnrolmentPage(driver);
		String actualTitle = prop.getProperty("dammycname");
		String expectedTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			enrolmentPage.enrollMeBtn().click();
			log.info("clicked on Enrol me button");

		} else {
			log.info("user is already enrolled to that course");
			

			List<WebElement> incompletedTasks = enrolmentPage.getIncompletedTasks();
			if (incompletedTasks.size() == 0) {
				enrolmentPage.getCertificateSection().click();
				enrolmentPage.getCertificate().click();
				enrolmentPage.downloadCertificate().click();
				Thread.sleep(3000);
				log.info("certificate downloaded");

			}

		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed");
	}
}
