package adminTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Qualicoach.BaseClass;
import pageObject.Dashboard;
import pageObject.ReportDownload;

public class DownloadReportTest extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void downloadReport() throws InterruptedException {
		driver.get(prop.getProperty("dashboardUrl"));
		log.info("Navigated to Login page");
		String username = prop.getProperty("adminUsername");
		String password = prop.getProperty("adminPswd");
		loginCredentials(username, password);
		log.info("Dashboard is displayed");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.getReportName().click();
		log.info("Report name is fetched");
		scrollToEnd();
		ReportDownload reportDownload = new ReportDownload(driver);
		reportDownload.getDownloadType().click();
		log.info("Report is downloaded");
		Thread.sleep(3000);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser closed");
	}

	// *[@id="inst168"]/div[2]/ul/li[3]/div/a
}
