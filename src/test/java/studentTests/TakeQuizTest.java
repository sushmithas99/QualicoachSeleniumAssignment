package studentTests;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.EnrolmentPage;
import pageObject.HomePage;

public class TakeQuizTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		
	}

	@Test
	public void takeQuiz() {
		driver.get(prop.getProperty("studentUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		loginCredentials(username, password);
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
		EnrolmentPage enrolmentPage = new EnrolmentPage(driver);
//		List<WebElement> qlinkCount = enrolmentPage.getQuizLink();
//		By quiz = By.xpath("//div[contains(text(),'Quiz')]");
//		List<WebElement> modulelink = enrolmentPage.getModule();
//		By module = By.xpath("//li[@class='allsectionnames']/a[contains(text(),'Module')]");
//		Iterator<WebElement> iterator = qlinkCount.iterator();
		
		
		int i=1;
		
		List<WebElement> quiz = driver.findElements(By.xpath("//div[@class = 'activityname'][contains(text(),'Module"+i+" Quiz')]"));
		Iterator<WebElement> quizIterator = quiz.iterator();
		List<WebElement> module = driver.findElements(By.xpath("//a[@aria-controls = 'collapse"+i+"']"));
		Iterator<WebElement> moduleIterator = quiz.iterator();
		
		
		
		while (moduleIterator.hasNext()) {
			WebElement mnext = moduleIterator.next();
			WebElement next = quizIterator.next();
			mnext.click();
			next.click();
			a.moveToElement(mnext).build().perform();
			System.out.println(driver.findElement(By.xpath("//div[@role='main']//h2")).getText());
			i++;
		}
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}
