package adminTests;


import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.AddNewCategory;
import pageObject.AddNewCourse;
import pageObject.AddNewQuiz;
import pageObject.AddRandomQuestion;
import pageObject.CourseCategoryManagement;
import pageObject.CoursePage;
import pageObject.Dashboard;
import pageObject.EditQuiz;
import pageObject.ErrorMessagePage;
import pageObject.HomePage;
import pageObject.SearchPage;

public class CreateCourseTest extends BaseClass {
	public WebDriver driver;
	public SearchPage searchPage;
	public CourseCategoryManagement ccm;
	public CoursePage coursePage;
	public AddNewCategory addNewCategory;
	public Select dropDown;
	public AddNewCourse addNewCourse;
	public ErrorMessagePage errorMessagePage;
	public AddNewQuiz addNewQuiz;
	public EditQuiz editQuiz;
	public AddRandomQuestion addRandomQuestion;
	public HomePage homePage;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	

	@Test
	public void createCourse() {
		driver.get(prop.getProperty("adminUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("adminUsername");
		String password = prop.getProperty("adminPswd");
		loginCredentials(username, password);
		log.info("Login successfully");
		courses();
		log.info("Landed to Search Page");
		manageCourseAndCategories();
		log.info("Entered to the Course section");
		newCategory();
		
		createCategory();
		log.info("created new category");
		createNewCourse();
		log.info("created new course");
		errorMessage();
		log.info("navigated to Home page of the application");
		courses();
		manageCourseAndCategories();
		searchCourse();
		log.info("Entered to Quiz page");
//		addNewQuiz();
		log.info("new quiz is created");

	}

	public void courses() {
		searchPage = new SearchPage(driver);
		searchPage.courseTab().click();
	}

	public void manageCourseAndCategories() {
		coursePage = new CoursePage(driver);
		coursePage.manageCourseCategory().click();
	}

	public void newCategory() {
		ccm = new CourseCategoryManagement(driver);
		ccm.createNewCategory().click();
	}

	public void createCategory() {
		addNewCategory = new AddNewCategory(driver);
		dropDown = new Select(addNewCategory.selectParentCategory());
		dropDown.selectByVisibleText("Induction Training");
		addNewCategory.getCategoryName().sendKeys(prop.getProperty("categoryName"));
		addNewCategory.getCategoryId().sendKeys(prop.getProperty("categoryId"));
		scrollBy(0, 500);
		addNewCategory.createCategory().click();
	}

	public void createNewCourse() {
//		List<WebElement> categoryEle = driver.findElements(By.xpath("//a[text()='QualitestCourse']"));
//		Iterator<WebElement> iterator = categoryEle.iterator();
//		while(iterator.hasNext()){
//			
//		}
//		
//		String ctid = prop.getProperty("categoryId");
//		String ctname = prop.getProperty("categoryName");
//		String actualCategoryId = ccm.getCategoryId().getText();
//		String actualCtName = ccm.getCategoryName().getText();
//		if (ctid.equals(actualCategoryId) && ctname.equals(actualCtName)) {
//			ccm.getCategoryName().click();
//		}
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",ccm.getCategoryNameId());
		ccm.getCategoryNameId().click();
		ccm.createNewCourse().click();
		addNewCourse = new AddNewCourse(driver);
		addNewCourse.getFullName().sendKeys(prop.getProperty("fullName"));
		addNewCourse.getShortName().sendKeys(prop.getProperty("shortName"));
//		addNewCourse.courseFormate().click();
//		dropDown = new Select(addNewCourse.selectFormate());
//		dropDown.selectByVisibleText("Single activity format");
//		dropDown = new Select(addNewCourse.selectActivityType());
//		dropDown.selectByVisibleText("Quiz");
		addNewCourse.saveAndDisplayBtn().click();
	}

	public  void errorMessage() {
		if (driver.getTitle().equalsIgnoreCase("Error")) {
			errorMessagePage = new ErrorMessagePage(driver);
			errorMessagePage.continueBtn().click();
			homePage = new HomePage(driver);
			homePage.imageIcon().click();
			homePage.dashboard().click();
			Dashboard dashboard = new Dashboard(driver);
			dashboard.search().click();
		}
	}

	public void searchCourse() {
//		String ctid = prop.getProperty("categoryId");
//		String ctname = prop.getProperty("categoryName");
//		String actualCategoryId = ccm.getCategoryId().getText();
//		String actualCtName = ccm.getCategoryName().getText();
		ccm.getCategoryNameId().click();
		ccm.getCourseName().click();
		scrollBy(0, 700);
		ccm.editCourse().click();
		addNewCourse.saveAndDisplayBtn().click();
		editQuiz = new EditQuiz(driver);
		editQuiz.getFlipButton().click();
		scrollToEnd();
		editQuiz.getUsers().click();
		editQuiz.getEnrolmentMethod().click();
		dropDown = new Select(editQuiz.selectAddMethod());
		dropDown.selectByVisibleText("Self enrolment");
		scrollToEnd();
		editQuiz.addMethodBtn();
	}

//	public void addNewQuiz() {
//		addNewQuiz = new AddNewQuiz(driver);
//		addNewQuiz.getQuizName().sendKeys(prop.getProperty("quizName"));
//		addNewQuiz.submitQuiz().click();
//		editQuiz = new EditQuiz(driver);
//		editQuiz.clickEditQuiz().click();
//		editQuiz.clickAddQuiz().click();
//		editQuiz.clickRandomQuiz().click();
//		addRandomQuestion = new AddRandomQuestion(driver);
//		dropDown = new Select(addRandomQuestion.getNumberOfQuiz());
//		dropDown.selectByValue("4");
//		addRandomQuestion.clickAddRandomQuiz().click();
//
//	}

//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//	}
}
