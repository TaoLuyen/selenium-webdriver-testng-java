package webdrivers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Button {
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
		
	}

	@Test
	public void TC_01_Fahasa() {
		driver.get("https://www.fahasa.com/customer/account/create");
		SleepInSecond(4);
		driver.findElement(By.cssSelector("#popup-login-tab_list li.popup-login-tab-login a")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
		
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("luyentt6@fpt.com.vn");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("passluyentt6@123");
		
		// driver.switchTo().defaultContent();
		Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
		
		
		String colorRgba = driver.findElement(By.cssSelector("button.fhs-btn-login")).getCssValue("background-color");
		
		System.out.println(colorRgba);
		
		String colorHexa = Color.fromString(colorRgba).asHex().toUpperCase();
		
		Assert.assertEquals(colorHexa, "#C92127");
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_()  {
		SleepInSecond(5);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	
	// Hàm Sleep cứng (static wait)
	public void SleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000); // s
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
