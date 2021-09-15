package Assignment.Qualicoach;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static Properties prop;

	public WebDriver initializeDriver() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.properties");
			prop.load(fis);
			String browser = prop.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

	public void scrollBy(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	public void scrollToEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0 ,document.body.scrollHeight)");
	}
	public void loginCredentials(String username, String Pswd){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsername().sendKeys(username);
		loginPage.getPassword().sendKeys(Pswd);
		loginPage.loginBtn().click();
	}
	public String getScreenShootPath(String methodName,WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}
}
