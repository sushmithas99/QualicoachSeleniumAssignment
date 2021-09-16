package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewQuiz {
	WebDriver driver;

	public AddNewQuiz(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "item_quiz")
	WebElement quizActivity;

	@FindBy(xpath = "//*[@class='submitbutton']")
	WebElement addBtn;
	@FindBy(id = "id_name")
	WebElement quizName;
	@FindBy(id = "id_submitbutton")
	WebElement submit;
	@FindBy(id = "id_name")
	WebElement questionName;
	@FindBy(id = "id_questiontexteditable")
	WebElement questionText;
	@FindBy(id = "id_answer_0editable")
	WebElement choice1;
	@FindBy(id = "id_answer_1editable")
	WebElement choice2;
	@FindBy(id = "id_answer_2editable")
	WebElement choice3;
	@FindBy(id = "id_answer_3editable")
	WebElement choice4;
	@FindBy(id = "id_fraction_1")
	WebElement grade;
	@FindBy(id = "id_submitbutton")
	WebElement saveChanges;

	public WebElement getQuizActivity() {
		return quizActivity;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getQuizName() {
		return quizName;
	}

	public WebElement submitQuiz() {
		return submit;
	}

	public WebElement getQuestionName() {
		return questionName;
	}

	public WebElement getQuestionText() {
		return questionText;
	}

	public WebElement getChoice1() {
		return choice1;
	}

	public WebElement getChoice2() {
		return choice2;
	}

	public WebElement getChoice3() {
		return choice3;
	}

	public WebElement getChoice4() {
		return choice4;
	}

	public WebElement selectGrade() {
		return grade;
	}

	public WebElement saveChangesBtn() {
		return saveChanges;
	}
}
