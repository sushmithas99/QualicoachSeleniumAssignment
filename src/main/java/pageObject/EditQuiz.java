package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assignment.Qualicoach.BaseClass;

public class EditQuiz extends BaseClass {
	WebDriver driver;
	String courseName1 = prop.getProperty("fullName");
	String shortName = prop.getProperty("shortName");
	public EditQuiz(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='singlebutton']//input[@value='Edit quiz']")
	WebElement editQuiz;
	
	@FindBy(xpath = "//span[text()='Add']/parent::a")
	WebElement addQuiz;
	
	@FindBy(xpath = "//span[text()='a new question']/parent::a")
	WebElement newQuestion;
	@FindBy(xpath = "//span[text()='Multiple choice']")
	WebElement multipleChoice;

	
	@FindBy(xpath = "//div[@class='flip_blocks_outer']")
	WebElement flipBtn;
	@FindBy(xpath="//span[text()='Users']")
	WebElement users;
	@FindBy(xpath="//a[text()='Enrolment methods']")
	WebElement enrolmentMethod;
	@FindBy(xpath="//*[@class='custom-select urlselect']")
	WebElement addMethod;
	@FindBy(xpath="//input[@name = 'submitbutton']")
	WebElement addMethodBtn;
	@FindBy(xpath="//div[@class = 'flip_blocks_outer open']")
	WebElement navigationBar;
	By breadCrum = By.xpath("//a[@title='"+courseName1+"']/span[text()='"+shortName+"']");
	@FindBy(xpath="//input[@value='Turn editing on']")
	WebElement editingOn;
	@FindBy(xpath="///*[@class='section-modchooser-text']")
	WebElement addActivity;
	@FindBy(xpath = "//span[text()='Multiple choice']")
	WebElement addMCQBtn;

	public WebElement editQuizBtn() {
		return editQuiz;
	}
	
	public WebElement addQuiz() {
		return addQuiz;
	}
	
	public WebElement getNewQuestion() {
		return newQuestion;
	}
	public WebElement getFlipButton() {
		return flipBtn;
	}
	
	public WebElement getUsers() {
		return users;
	}
	public WebElement getEnrolmentMethod() {
		return enrolmentMethod;
	}
	public WebElement selectAddMethod() {
		return addMethod;
	}
	public WebElement addMethodBtn() {
		return addMethodBtn;
	}
	public WebElement getNavigationBar() {
		return navigationBar;
	}
	public WebElement getBreadcrum() {
		return driver.findElement(breadCrum);
	}
	public WebElement editingOnBtn() {
		return editingOn;
	}
	public WebElement getAddActivity() {
		return addActivity;
	}
	public WebElement getMultiplechoiceOptn() {
		return multipleChoice;
	}
	public WebElement addMCQBtn() {
		return addMCQBtn;
	}
}
