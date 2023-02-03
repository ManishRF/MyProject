package pomPackage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRClass;

public class pomLogin extends BaseHRClass {
	
	@FindBy(xpath = "//input[@name='username']") WebElement Username;
@FindBy(xpath="//input[@name='password']") WebElement Password;
@FindBy(xpath="//button[@type='submit']") WebElement Loginbtn;


public pomLogin() {
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public void typeusername(String name) {
	Username.sendKeys(name);
}
public void enterpassword(String pass) {
	Password.sendKeys(pass);
}
public void clickbtn() {
	Loginbtn.click();
}
public String verify() {
	return driver.getTitle();
	
	
}
}
