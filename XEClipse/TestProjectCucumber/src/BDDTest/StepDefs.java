package BDDTest;
import cucumber.api.PendingException;

import cucumber.api.java.en.*;

public class StepDefs {
	private SeleniumTest script;

	public void setUpWebDriver() throws Exception {

	   script = new SeleniumTest();

	   script.setUp();

	   script.goToHomePage();

	}

	public void tidyUp() {

	script.tearDown();

	}//end tidyUP
	
	
	
	@Given("^I am on the homepage$")
	public void I_am_on_the_homepage() throws Throwable {

	   // Express the Regexp above with the code you wish you had

	   throw new PendingException();

	}

	@When("^I search for pillows$")

	public void I_search_for_pillows() throws Throwable {

	   // Express the Regexp above with the code you wish you had

	   throw new PendingException();

	}

	@Then("^the page title is as expected$")

	public void the_page_title_is_as_expected() throws Throwable {

	// Express the Regexp above with the code you wish you had

	throw new PendingException();

	}
	
	
	
}//end class
