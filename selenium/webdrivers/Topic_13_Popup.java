package webdrivers;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Popup {
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

	//@Test
	public void TC_01_Fixed_Popup() {
		driver.get("https://ngoaingu24h.vn/");
		SleepInSecond(5);
		By popup = By.xpath("//div[@id='modal-login-v1'][1]");
		var checkSignInPopup = driver.findElement(popup);
		if(!checkSignInPopup.isDisplayed())
		{
			 driver.findElement(By.xpath("//div[@id='button-login-dialog']/button[@class='login_ icon-before']")).click();
			 
			 Assert.assertEquals(driver.findElement(popup).isDisplayed(), true);
			
			 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("automationfc");
			 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("automationfc");
			 
			 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-login-v1")).click();
			 SleepInSecond(2);
			 
			 Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
		}
	}

	//@Test
	public void TC_02_Tiki() {
		driver.get("https://tiki.vn/");
		SleepInSecond(3);
		
		System.out.println("Start: " + getDateTimeNow());
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']")).size(), 0);
		System.out.println("End: " + getDateTimeNow());
		// click vào dang nhap
		driver.findElement(By.xpath("//span[contains(text(),'Đăng Nhập')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']")).isDisplayed());
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//div[@class='heading']//h4")).getText(), "Xin chào,");
		
		driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//p[@class='login-with-email']")).click();
		
		driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//input[@name='email']")).clear();
		
		driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//input[@placeholder='Mật khẩu']")).clear();
		
		driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//button[text()='Đăng nhập']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//input[@name='email']//parent::div/following-sibling::span[@class='error-mess'][1]")).getText(), "Email không được để trống");

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//input[@placeholder='Mật khẩu']//parent::div/following-sibling::span[@class='error-mess'][1]")).getText(), "Mật khẩu không được để trống");

		
		driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']//img[@class='close-img']")).click();
		
		System.out.println("Start: " + getDateTimeNow());
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']")).size(), 0);
		System.out.println("End: " + getDateTimeNow());
		
	}
	
	
	

	@Test
	public void TC_03_Facebook()  {
		driver.get("https://www.facebook.com/");
		SleepInSecond(2);
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sign Up']")).isDisplayed(), true);
		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div/preceding-sibling::img")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']")).size(), 0);
		
	}
	
	@Test
	public void TC_04_Facebook()  {
		driver.get("https://www.facebook.com/");
		SleepInSecond(5);
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
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
	
	// Hàm Sleep cứng (static wait)
	public String getDateTimeNow() {
		
		java.util.Date date = new java.util.Date();
		//Date date = new Date(System.currentTimeMillis());
		
		return date.toString();
		
	}
}
