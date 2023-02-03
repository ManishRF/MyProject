package testLayer;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRClass;
import pomPackage.pomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRClass{
	pomLogin Log;
public LoginTest() {
super();
	
}

@BeforeMethod

public void initSetup() {
	initiate();
	Log = new pomLogin();
	screenshots("Login");

}


@Test(priority=1)

public void Title() {
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");}


@DataProvider
public Object[][] details(){
	Object result[][]= ExcelSheet.readdata("Sheet1");
	return result;
	
}
@Test(priority=2,dataProvider="details")
public void Login(String name,String password) throws InterruptedException {
	
	Log.typeusername(name);
	Thread.sleep(3000);
	Log.enterpassword(password);
	//Log.clickbtn();
}



@AfterMethod

public void close() {
	driver.close();
}
}