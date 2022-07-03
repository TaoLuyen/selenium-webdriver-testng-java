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

public class Topic_05_Web_Browser {
	WebDriver driver;
	WebElement element;
	// khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_() {
		// Cacs ham tuwong tac vowis Browser thong qua bien drive
		//** NOTE DUNG NHIEU
		driver.close(); //**
		driver.quit();//**
		 WebElement  loginButton= driver.findElement(By.cssSelector(""));//**
		 
		 List<WebElement> links = driver.findElements(By.cssSelector(""));//**
		 
		 driver.get("https://www.facebook.com/");//**
		 
		 String gamePageUrl = driver.getCurrentUrl();
		 
		 String gamePageTitle = driver.getTitle();
		 
		 String gamePageSource = driver.getPageSource();
		 driver.getWindowHandle(); // 1//**
		 driver.getWindowHandles(); // tat ca//**
		 
		 driver.manage().getCookies(); // cookie framework //**
		 driver.manage().logs().getAvailableLogTypes();
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();//**
		
		// Test GUI
		// font/size/position/ location
		// uu tien la chuc nang truoc
		// uu tien lam giao dien sau
		
		//chờ cho element được tim thây trong khoảng time xx s
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// chờ cho page load thành công sau xx s
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		// chờ cho script thành công vào browser/ element sau xx s
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		
		// back lại trang
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().to("https://www.facebook.com/");
		
		 // Alert/frame(iframe)/window(tab) //**
		driver.switchTo().alert();//**
		driver.switchTo().frame(0);//**
		driver.switchTo().window("");//**
		
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
