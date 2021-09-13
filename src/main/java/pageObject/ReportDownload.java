package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Assignment.Qualicoach.BaseClass;

public class ReportDownload extends BaseClass{
	WebDriver driver;

	String dtype = prop.getProperty("downloadReportType");
	public ReportDownload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	By downloadType = By.xpath("//img[@alt = '"+dtype+"']");
	public WebElement getDownloadType(){
		return driver.findElement( downloadType);
	}
	

}
