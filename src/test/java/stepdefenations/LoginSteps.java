package stepdefenations;

import org.junit.Assert;

import com.driverFactory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private static String  title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String title = loginpage.getLoginPageTitle();
	    System.out.println("Title of the current page is : "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTileName) {
		
	   // Assert.assertTrue(title.contains(expectedTileName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		 Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	loginpage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	   loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginpage.clickOnLogin();
	}

}
