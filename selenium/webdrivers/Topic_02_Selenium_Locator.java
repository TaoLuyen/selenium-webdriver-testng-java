package webdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	// Khai báo 1 biến driver đại diện cho selenium driver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		
		// Set gecko: giao tiếp giữa browser và code
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		//Bật trình duyệt lên
		driver = new FirefoxDriver();
		// set thời gian tìm element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Mở rộng 100% trình duyệt
		driver.manage().window().maximize();
		// Mở app ra
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
		// Element = tagname + attribute name + attribute value	
		
		//Selenium co 8 loai locator. Selenium Locator trong thu vien By(Class)	
		
		// Id
		driver.findElement(By.id("email")).sendKeys("dam@gmail.com");
		
		// <img class="fb_logo _8ilh img"
		// src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="Facebook">
		// Class
		
		driver.findElement(By.className("fb_logo")).isDisplayed();
		// Name
		
		// driver đạo diện cho thư viện của selenium
		// 
		driver.findElement(By.name("email"));
		
		
		// TagName: Tìm xem có bao nhiêu element cùng loại trên page
		
		driver.findElement(By.tagName("a")); // ra 1 cái đầu tiên
		
		driver.findElements(By.tagName("a")); // ra tất cả
		
		// Link text
		driver.findElement(By.linkText("Tiếng Việt"));
		
		// Partial Link Test
		
		driver.findElement(By.partialLinkText("Tiếng Việt")); // ra 1 cái đầu tiên
		driver.findElement(By.partialLinkText("Việt"));
		driver.findElement(By.partialLinkText("Việ"));
		// Css
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("input#email"));
		driver.findElement(By.cssSelector("#email"));
		
		driver.findElement(By.cssSelector("img[class='fb_logo _8ilh img']"));
		driver.findElement(By.cssSelector("img.fb_logo"));
		driver.findElement(By.cssSelector(".fb_logo"));
		
		
		driver.findElement(By.cssSelector("imput[name='email']"));
		
		driver.findElement(By.cssSelector("a"));
		
		// CSS ko làm việc với text(nên nó dùng thằng khác để làm việc với text)
		driver.findElement(By.cssSelector("a[title='Vietnamese']"));
		
		driver.findElement(By.cssSelector("a[onclick*='vi_VN']")); // *= chứa
		
		
		
		// Xpath
		driver.findElement(By.xpath("//imput[@id='email']"));
		
		driver.findElement(By.xpath("//img[contains(@class,'fb_logo')]"));
		
		driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img')]"));
		driver.findElement(By.xpath("//img[starts-with(@class,'fb_logo')]"));
		
		
		driver.findElement(By.xpath("//imput[@name='email']"));
		
		driver.findElement(By.xpath("//a"));
		
		driver.findElement(By.xpath("//a[text()='Tiếng Việt']"));
		
		driver.findElement(By.xpath("//a[contains(text(),'Tiếng')]"));
		driver.findElement(By.xpath("//a[starts-with(text(),'Tiếng')]"));
		
		
		
		
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
}
