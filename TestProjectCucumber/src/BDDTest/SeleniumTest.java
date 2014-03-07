package BDDTest;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.safari.SafariDriver;

class SeleniumTest {

	private WebDriver driver;

	private String baseUrl;

	private String browserName;

	private String browserVersion;

	public void setUp() throws Exception {

	//driver = new HtmlUnitDriver();

	driver = new FirefoxDriver();

	//driver = new ChromeDriver();

	//driver = new  InternetExplorerDriver ();

	//driver = new  SafariDriver();

	baseUrl = "http://www.dunelm-mill.com/&#8221/";

	//note due to issue in wordpress the URL does not display properly above. The URL should end with a forward slash, then quote marks, then a semi colon.

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

	browserName = caps.getBrowserName();

	browserVersion = caps.getVersion();

	System.out.println("Automated test run. We're running on "+browserName+"" +browserVersion);

	 }

	 public void tearDown() {

	 driver.quit();

	 }

	public void goToHomePage(){

	 driver.get(baseUrl);

	 }
	
}//end class
