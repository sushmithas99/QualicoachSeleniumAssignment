package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assignment.Qualicoach.BaseClass;

public class Dashboard extends BaseClass {
	WebDriver driver;
	String rname = prop.getProperty("reportName");

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	By reportNmae = By.xpath("//a[text()='" + rname + "']");

	public WebElement getReportName() {
		return driver.findElement(reportNmae);
	}

	@FindBy(xpath = "//li[@class = 'dashboard_tabs']//i[@class = 'administration']")
	WebElement search;

	public WebElement search() {
		return search;
	}
}
