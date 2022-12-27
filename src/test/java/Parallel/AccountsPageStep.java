package Parallel;

import java.util.List;
import java.util.Map;

import com.ecomm.qa.driversFactory.DriverFactory;
import com.ecomm.qa.pages.AccountsPage;
import com.ecomm.qa.pages.loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountsPageStep {
	
	private loginPage lp = new loginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("user has already logged in to app")
	public void user_has_already_logged_in_to_app(io.cucumber.datatable.DataTable dataTable) {
	 
		List <Map<String,String>> credentialsList = dataTable.asMaps();
		String uname = credentialsList.get(0).get("username");
		String pswd = credentialsList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountspage= lp.performLogin(uname, pswd);
		
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
	    
		accountspage.pageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable SectionsTable) {
		
		List<String> expectedSectionsFeatureList = SectionsTable.asList();
		List<String> actualSectionsList = accountspage.getAccountSectionsList();
		System.out.println(actualSectionsList);
		Assert.assertEquals(expectedSectionsFeatureList, actualSectionsList);
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedCount) {
	  
		Assert.assertTrue(accountspage.getAccountSectionsCount()==expectedCount);
	}

	
}
