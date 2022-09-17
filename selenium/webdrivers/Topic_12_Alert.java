package webdrivers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Alert alert;
	
	String firefoxAuthenAutoIT = projectPath + "\\autoITScripts\\" + "authen_firefox.exe";
	String chormeAuthenAutoIT = projectPath + "\\autoITScripts\\" + "authen_chorme.exe";
	

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
	public void TC_01_Acept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		var element = driver.findElement(By.xpath("//div[@id='content']//button[text()='Click for JS Alert']"));
element.click();
SleepInSecond(3);

alert = driver.switchTo().alert();


Assert.assertEquals(alert.getText(), "I am a JS Alert");
alert.accept();

Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
	
	
	}

	//@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		var element = driver.findElement(By.xpath("//div[@id='content']//button[text()='Click for JS Confirm']"));
		element.click();
		SleepInSecond(3);

		alert = driver.switchTo().alert();

Assert.assertEquals(alert.getText(), "I am a JS Confirm");
alert.dismiss();
Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");


	}

	//@Test
	public void TC_03_Prompt_Alert()  {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		var element = driver.findElement(By.xpath("//div[@id='content']//button[text()='Click for JS Prompt']"));
		element.click();
		SleepInSecond(3);

		alert = driver.switchTo().alert();

Assert.assertEquals(alert.getText(), "I am a JS prompt");
var textEnter = "luyen";
alert.sendKeys(textEnter);
alert.accept();
Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + textEnter );


	}
	
	//@Test
	public void TC_04_Accept_Alert_Login()  {
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.findElement(By.name("btnLogin")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		alert.accept();
		SleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v4/index.php");
		
		
	}
	
	//@Test
	public void TC_05_Authentication_Alert()  {
		
		// Pass hẳn user/password trên url
		//driver.get("username:password@the-internet.herokuapp.com/basic_auth");
		driver.get("admin:admin@the-internet.herokuapp.com/basic_auth");
		SleepInSecond(3);
Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//p")).getText(), "Congratulations! You must have the proper credentials.");
Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");


	}
	
	//@Test
	public void TC_06_Authentication_Alert()  {
		
		// Pass hẳn user/password trên url
		//driver.get("username:password@the-internet.herokuapp.com/basic_auth");
		driver.get("https://the-internet.herokuapp.com/");
		
		String basicAuthenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		
		driver.get(GetUrlAuthen(basicAuthenUrl, "admin", "admin"));
		SleepInSecond(3);	
		
Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//p")).getText(), "Congratulations! You must have the proper credentials.");
Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");


	}
	
	/// Case ngoại lệ (một số trang ko cho phép điền username, password trên đường link mà bắt nhập dữ liệu authen vào
	/// Dùng AutoIT để handle
	/// Chỉ support cho window (ko support trên MAC/LINUX)
	@Test
	public void TC_07_Exception_Authentication_Alert_AutoIT() throws IOException  {
		
		// bặt script của autoIt lên trước
		// Thực thi 1 file exe
		if(driver.toString().contains("firefox"))
		{
			Runtime.getRuntime().exec(new String[] {firefoxAuthenAutoIT, "admin", "admin"});
		} else {
			Runtime.getRuntime().exec(new String[] {chormeAuthenAutoIT, "admin", "admin"});		
		}
		//SleepInSecond(2);
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
	
		SleepInSecond(5);
		
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//p")).getText(), "Congratulations! You must have the proper credentials.");
	Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");


	}
	

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
	
	public String GetUrlAuthen(String url, String username, String password)
	{
		System.out.println("url: " +  url);
		var test ="";
		var arr = url.split("//");
		
			test = arr[1];
			System.out.println("url: " +  username + ":" + password + "@" + test);
		return username + ":" + password + "@" + test;
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
