package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ACME_Login {
	
	WebDriver driver;
	
	
	
	@Given("User must be on Login page by clicking on url {string}")
	public void user_must_be_on_login_page_by_clicking_on_url(String string) {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get(string);
	  
	  
	}

	@When("^Enter (.*) and (.*)$")
	public void enter_username_and_password(String username,String password) throws InterruptedException {
	    driver.findElement(By.id("username")).sendKeys(username);
	    Thread.sleep(2000);
	    driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Click in button")
	public void click_in_button() {
	 driver.findElement(By.id("log-in")).click();
	 
	}

	@Then("ACME home page should be displayed")
	public void acme_home_page_should_be_displayed() {
		String result = driver.getTitle();
		Assert.assertEquals(result,"ACME demo app" );
		driver.close();
	}


}
