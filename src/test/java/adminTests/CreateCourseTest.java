package adminTests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.AddNewCategory;
import pageObject.AddNewCourse;
import pageObject.AddNewQuiz;
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
	public HomePage homePage;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}
	@Test(dataProvider = "categoryDetails")
	public void createCourse(String ctname,String CtId) {
//		try{
		driver.get(prop.getProperty("adminUrl"));
		log.info("Navigated to Login page");
		String actulTitle = driver.getTitle();
		String expectedTitle = "Qualicoach: Log in to the site";
		if (actulTitle.equalsIgnoreCase(expectedTitle)) {
		String username = prop.getProperty("adminUsername");
		String password = prop.getProperty("adminPswd");
		loginCredentials(username, password);
		log.info("Login successfully");
		}
		searchPage = new SearchPage(driver);
		searchPage.courseTab().click();
		log.info("Landed to Search Page");
		coursePage = new CoursePage(driver);
		coursePage.manageCourseCategory().click();
		log.info("Entered to the Course section");
		ccm = new CourseCategoryManagement(driver);
		ccm.createNewCategory().click();
		addNewCategory = new AddNewCategory(driver);
		dropDown = new Select(addNewCategory.selectParentCategory());
		dropDown.selectByVisibleText("Induction Training");
		addNewCategory.getCategoryName().sendKeys(ctname);
		addNewCategory.getCategoryId().sendKeys(CtId);
		scrollBy(0, 500);
		addNewCategory.createCategory().click();
		Assert.assertEquals(driver.getTitle(), "Course and category management","Category ID is already Present");
		log.info("created new category");
		driver.findElement(By.xpath(
				"//span[text()='" + CtId + "']/parent::div/preceding-sibling::a[contains(text(),'" + ctname + "')]")).click();
		ccm.createNewCourse().click();
		addNewCourse = new AddNewCourse(driver);
		addNewCourse.getFullName().sendKeys(prop.getProperty("fullName"));
		addNewCourse.getShortName().sendKeys(prop.getProperty("shortName"));
		addNewCourse.saveAndDisplayBtn().click();
		log.info("created new course");
		if (driver.getTitle().equalsIgnoreCase("Error")) {
			errorMessagePage = new ErrorMessagePage(driver);
			errorMessagePage.continueBtn().click();
			homePage = new HomePage(driver);
			homePage.imageIcon().click();
			homePage.dashboard().click();
			Dashboard dashboard = new Dashboard(driver);
			dashboard.search().click();
		}
		log.info("navigated to Home page of the application");
		searchPage = new SearchPage(driver);
		searchPage.courseTab().click();
		coursePage = new CoursePage(driver);
		coursePage.manageCourseCategory().click();
		driver.findElement(By.xpath(
				"//span[text()='" + CtId + "']/parent::div/preceding-sibling::a[contains(text(),'" + ctname + "')]")).click();
		ccm.getCourseName().click();
		scrollBy(0, 700);
		ccm.editCourse().click();
		addNewCourse.saveAndDisplayBtn().click();
		editQuiz = new EditQuiz(driver);
		editQuiz.getFlipButton().click();
		editQuiz.getUsers().sendKeys(Keys.PAGE_DOWN);
		editQuiz.getUsers().click();
		editQuiz.getEnrolmentMethod().click();
		dropDown = new Select(editQuiz.selectAddMethod());
		dropDown.selectByVisibleText("Self enrolment");
		scrollToEnd();
		log.debug("click on Addmethod Button");
		editQuiz.addMethodBtn().click();
		log.info("Add method button is clicked");
		editQuiz.getBreadcrum().click();
		log.info("Navigated back to course page");
		log.debug("click on editing Button");
		editQuiz.editingOnBtn().click();
		editQuiz.getAddActivity().click();
		addNewQuiz = new AddNewQuiz(driver);
		log.debug("Select quiz activity");
		addNewQuiz.getQuizActivity().click();
		addNewQuiz.getAddBtn().click();
		log.info("quiz activity is selected");
		addNewQuiz.getQuizName().sendKeys(prop.getProperty("quizName"));
		addNewQuiz.submitQuiz().click();
		editQuiz.editQuizBtn().click();
		editQuiz.addQuiz().click();
		editQuiz.getNewQuestion().click();
		log.debug("Select MCQ");
		editQuiz.getMultiplechoiceOptn().click();
		editQuiz.addMCQBtn().click();
		log.info("MCQ is selected");
		addNewQuiz.getQuestionName().sendKeys(prop.getProperty("questionName"));
		addNewQuiz.getQuestionText().sendKeys(prop.getProperty("questiontext"));
		addNewQuiz.getChoice1().sendKeys(prop.getProperty("choice1"));
		dropDown = new Select(addNewQuiz.selectGrade());
		dropDown.selectByVisibleText("100%");
		addNewQuiz.getChoice2().sendKeys(prop.getProperty("choice2"));
		addNewQuiz.getChoice3().sendKeys(prop.getProperty("choice3"));
		addNewQuiz.getChoice4().sendKeys(prop.getProperty("choice4"));
		log.info("All data entered");
		addNewQuiz.saveChangesBtn().click();
		log.info("One quiz is created");
		
		
//		}
//		catch(Exception e){
//			Assert.assertTrue(false, "No such element found");
//			log.error("Something went wrong in the site");
//		}
//		

	

	}
	@DataProvider(name = "categoryDetails")
	public String[][] getData(){
		String data[][] = {{"SoftwateTesting","7896"},{"QualitestCourse", "1234"}};
		return data;
	}
	

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
