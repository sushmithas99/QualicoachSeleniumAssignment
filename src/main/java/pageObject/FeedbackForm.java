package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import Assignment.Qualicoach.BaseClass;

public class FeedbackForm extends BaseClass {
	WebDriver driver;
	String q1 = prop.getProperty("ques1");
	String q2 = prop.getProperty("ques2");

	public FeedbackForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='alert alert-error alert-block fade in ']")
	WebElement alertMsg;

	@FindBy(xpath = "//a[text()='Answer the questions']")
	WebElement ansQuestion;

	By question1 = By.xpath("//input[@name='multichoice_335[0]' and @value='" + q1 + "']");
	By question2 = By.xpath("//input[@name='multichoice_336[0]' and @value='" + q2 + "']");
	@FindBy(id = "id_savevalues")
	WebElement submitAns;

	public WebElement getAnsQuestionBtn() {
		return ansQuestion;
	}

	public WebElement getQuestion1Ans() {
		return driver.findElement(question1);
	}
	public WebElement getQuestion2Ans() {
		return driver.findElement(question2);
	}
	public WebElement getSubmitAnsBtn() {
		return submitAns;
	}
	public WebElement getAlertMsg() {
		return alertMsg;
	}



}
