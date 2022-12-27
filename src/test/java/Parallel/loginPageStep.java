package Parallel;

import org.junit.Assert;

import com.ecomm.qa.driversFactory.DriverFactory;
import com.ecomm.qa.pages.loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPageStep {

	loginPage lpage = new loginPage(DriverFactory.getDriver());
	private static String loginPageTitle;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user captures page title")
	public void user_captures_page_title() {
		 loginPageTitle=lpage.pageTitle();
		System.out.println("Title = " + loginPageTitle);  
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
	
		Assert.assertTrue(loginPageTitle.equalsIgnoreCase(expectedPageTitle));   
	}

	@Then("verify logo image is displayed")
	public void verify_logo_image_is_displayed() {
	   Assert.assertTrue(lpage.verifyLogo());  
	}

	@Then("create an account section is displayed")
	public void create_an_account_section_is_displayed() {
	Assert.assertEquals(lpage.verifyCreateAccountSection(), "CREATE AN ACCOUNT");	
		
	}

	@Then("create an account button is enabled")
	public void create_an_account_button_is_enabled() {
		Assert.assertTrue(lpage.verifyCreateAccountButton());
	}

	@Then("already registered section is displayed")
	public void already_registered_section_is_displayed() {
		Assert.assertTrue(lpage.verifySignInSection());
	}

	@Then("sign in button is enabled")
	public void sign_in_button_is_enabled() {
		Assert.assertTrue(lpage.verifySignInButton());
	}

	@Then("forgot password link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(lpage.verifyForgotPasswordLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		lpage.enterEmail(string);
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
	    lpage.enterPassword(string);
	    lpage.clickSIgnInButton();
	}

	
	
}
