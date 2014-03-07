package selenium_mvn_eclipse;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTest {
	
	//THIS TEST THE TITLE OF A WEBSITE. 
	
	@Test //GERSON L SIMPLE WEBSITE TITLE TEST EXAMPLE.
	public void startWebDriver(){
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http:seleniumsimplified.com");
		Assert.assertTrue("title should start differently",
				driver.getTitle().startsWith("Selenium Simplified"));
		
		driver.close();
	}
	@Test
	public void loggIn(){  //DOING A LOG IN IN GMAIL.
		WebDriver driver = new FirefoxDriver();
						
				//driver= webdriver.Firefox() ;	
				driver.get("http://mail.google.com");
				//find_element_by_id("Email");
				WebElement emailid = driver.findElement(By.id("Email"));
				emailid.sendKeys("Gerson.lobos@gmail.com");
				
				WebElement passw=driver.findElement(By.id("Passwd"));
				passw.sendKeys("papalotes");

				WebElement signin=driver.findElement(By.id("signIn"));
				signin.click();

				//Time.sleep(10);
				long end = System.currentTimeMillis() + 10000;
				//driver.switchTo().frame("canvas_frame");
				
				
				//WebElement sentmail= driver.findElement(By.linkText("Sent Mail"));
				//sentmail.click();
				//time.sleep(10);
				//long end2 = System.currentTimeMillis() + 10000;

				//sentmail = driver.findElement(By.linkText("Your Name"));
				//sentmail.click();
				//WebElement lout= driver.findElement(By.linkText("Sign out"));
				//lout.click();
		
	}
	
	@Test
	public void testSearch() {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //driver.quit();
    }
	

}
