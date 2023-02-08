package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;





public class StepDefination {

	WebDriver driver;
	
	
	@Given("User must be in home page by clicking on url {string}")
	public void user_must_be_in_home_page_by_clicking_on_url(String string) {
	    WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();
	    driver.get(string);
	    
	}

	@When("User clicks on sign up button")
	public void user_clicks_on_sign_up_button() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button")).click();
	}

	
	@Then("Sign up dialogue box should be displayed")
	public void sign_up_dialogue_box_should_be_displayed() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  boolean result = driver.findElement(By.id("join-neu-overlay-title")).isDisplayed();
	  //System.out.println(result);

	  Assert.assertTrue(result);


}
}
