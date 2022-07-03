package webdrivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
		// Tìm FIND trả về 1 cái
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).isDisplayed();
		
		// Khai báo biến sử dụng nhiều lần
		WebElement loginButton = driver.findElement(By.id("email"));
		loginButton.click();
		loginButton.isDisplayed();
		
		// tìm và trả về 1 hoặc nhiều
		 driver.findElements(By.id("email"));
		 driver.findElements(By.id("email")).size();
		 
		 List<WebElement> loginCheckboxes = driver.findElements(By.id("email"));
		 for(int i=0; i < loginCheckboxes.size(); i++)
		 {
			 
		 }
		// Thao tác(Action): clic/ type/ select/ hover....
		
		// Kiểm tra (veryfy/assert): getText/ getAttribute/ getCss
		
		
		// Thao tác vơi email
		
		// Thao tác với password
		
		// Thao tác login
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
