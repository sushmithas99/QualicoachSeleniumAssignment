package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditQuiz {
	WebDriver driver;

	public EditQuiz(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='singlebutton']//input[@value='Edit quiz']")
	WebElement editQuiz;
	
	@FindBy(xpath = "//span[text()='Add']/parent::a")
	WebElement addQuiz;
	
	@FindBy(xpath = "//span[text()='a random question']/parent::a")
	WebElement addRandomQuiz;

	@FindBy(id = "//a[@class='flip_btn']")
	WebElement flipBtn;
	@FindBy(xpath="//span[text()='Users']")
	WebElement users;
	@FindBy(xpath="//a[text()='Enrolment methods']")
	WebElement enrolmentMethod;
	@FindBy(xpath="//*[@class='custom-select urlselect']")
	WebElement addMethod;
	@FindBy(xpath="//input[@name = 'submitbutton']")
	WebElement addMethodBtn;


	public WebElement clickEditQuiz() {
		return editQuiz;
	}
	
	public WebElement clickAddQuiz() {
		return addQuiz;
	}
	
	public WebElement clickRandomQuiz() {
		return addRandomQuiz;
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
}
