package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assignment.Qualicoach.BaseClass;

public class CourseCategoryManagement extends BaseClass {
	public WebDriver driver;
	
	

	public CourseCategoryManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	String categoryName = prop.getProperty("categoryName");
	String courseName1 = prop.getProperty("fullName");
	String ctId = prop.getProperty("categoryId");
	@FindBy(xpath = "//a[contains(text(),'Create new category')]")
	WebElement createNewCategory;
	
	By category = By.xpath("//a[text()='"+categoryName+"']");
	By categoryId = By.xpath("//span[text()='"+ctId+"']");
	
	@FindBy(xpath = "//a[text()='Create new course']")
	WebElement createNewCourse;
	By courseName = By.xpath("//div[@id='course-listing']//a[text()='"+courseName1+"']");
	@FindBy(linkText = "Edit")
	WebElement edit;

	public WebElement createNewCategory() {
		return createNewCategory;
	}
	
	public WebElement getCategoryName () {
		return driver.findElement(category);
	}
	public WebElement createNewCourse() {
		return createNewCourse;
	}
	public WebElement getCourseName () {
		return driver.findElement(courseName);
	}
	public WebElement editCourse() {
		return edit;
	}
	public WebElement getCategoryId () {
		return driver.findElement(categoryId);
	}
	//span[@class='dimmed idnumber']
	
	//div[@id='course-listing']//a[@class='float-left coursename'][text()='manual Testing']

}
