package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnrolmentPage {
	WebDriver driver;
	

	public EnrolmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_submitbutton")
	WebElement enrollMe;
	@FindBy(xpath = "//div[@class='courseimage']")
	WebElement verify;
	By quiz = By.xpath("//div[@class = 'activityname'][contains(text(),'Quiz')]");
	// @FindBy(xpath = "//div[contains(text(),'Quiz')]")
	// List<WebElement> quiz;
	By module = By.xpath("//li[@class='allsectionnames']/a[contains(text(),'Module')]");
	// @FindBy(xpath =
	// "//li[@class='allsectionnames']/a[contains(text(),'Module')]")
	// List<WebElements> module;
	@FindBy(xpath = "//a[contains(text(),'Badge & Feedback')]")
	WebElement badgeFeedback;

	public WebElement enrollMeBtn() {
		return enrollMe;
	}

	public WebElement verifyEnrolment() {
		return verify;
	}

	public List<WebElement> getQuizLink() {
		return driver.findElements(quiz);
	}

	public List<WebElement> getModule() {
//		i++;
		return driver.findElements(module);
	}

}
