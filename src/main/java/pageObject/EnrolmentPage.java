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
	
	@FindBy(xpath="//div[@class='completioncheck completed']")
	List<WebElement> completedTasks;
	@FindBy(xpath="//div[@class='completioncheck incomplete']")
	List<WebElement> incompletedTasks;
	@FindBy(xpath="//li[@class='allsectionnames']//a[contains(text(),'Certificate')]")
	WebElement certificatesec;
	@FindBy(xpath="//div[contains(text(),'Certificate')]")
	WebElement certificate;
	@FindBy(xpath="//input[@value='Get your custom certificate']")
	WebElement downloadCertificate;
	@FindBy(xpath = "//a[contains(text(),'Badge ')]")
	WebElement badgeFeedback;

	@FindBy(xpath="//div[contains(text(),'Click here to claim')]")
	WebElement badges;
	@FindBy(xpath="//div[contains(text(),'Course Feedback')]")
	WebElement feedback;
	@FindBy(xpath = "//h3[@style='color:black;']")
	WebElement badgeText;
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
	public List<WebElement> getCompletedTasks(){
		return completedTasks;
	}
	public List<WebElement> getIncompletedTasks(){
		return incompletedTasks;
	}
	public WebElement getCertificateSection() {
		return certificatesec;
	}
	public WebElement getCertificate() {
		return certificate;
	}
	public WebElement downloadCertificate() {
		return downloadCertificate;
	}
	public WebElement getBadgesFeedbacSec() {
		return badgeFeedback;
	}
	public WebElement getBadge() {
		return badges;
	}
	public WebElement getFeedbackForm() {
		return feedback;
	}
	public WebElement getBadgeText() {
		return badgeText;
	}
}
