package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TimeUtils;

public class BaseHRClass {

	public static Properties prop=new Properties();
	
	public static WebDriver driver;
		
	public BaseHRClass() {
		
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\MANISH\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentVariables\\configure.properties");
		prop.load(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
		
	}
	catch (IOException a) {
		a.printStackTrace();
	}	
	}
	public static void initiate() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String browsername= prop.getProperty("browser");
		
		if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if (browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
			driver = new ChromeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.pagetime));
	driver.get(prop.getProperty("url"));
	}
	
	public static void screenshots(String Filename) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\MANISH\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots"+ Filename+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	}
	

