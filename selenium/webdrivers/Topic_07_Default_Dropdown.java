package webdrivers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	Select select;
	Random rand = new Random();

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
	public void TC_01_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		var numRand = rand.nextInt(999999);
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Luyen" +numRand);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Tao");
		
		driver.findElement(By.cssSelector("input#Email")).sendKeys("taoluyen"+numRand+"@gmail.com");
		
		// thao tác với dropdown
		// xác định dropdown nào
		
		var selectElementDay = 	driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
		
		select = new Select(selectElementDay);
		select.selectByVisibleText("2");
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "2");
		
		
		var selectElementMonth = driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
		select = new Select(selectElementMonth);
		select.selectByVisibleText("January");
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "January");
		
		
		var selectElementYear = driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));
		select = new Select(selectElementYear);
		select.selectByVisibleText("1960");
		//	Assert.assertEquals(select.getFirstSelectedOption().getText(), "1960");
		
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456a@!");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456a@!");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		driver.findElement(By.cssSelector(".page-body > div.result")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector(".page-body > div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
	
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Luyen" +numRand);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Tao");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), "taoluyen"+numRand+"@gmail.com");
		
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "2");
		
		
	}

	@Test
	public void TC_02_Dropdown() {
		
		driver.get("https://rode.com/en/support/where-to-buy");
		
		select = new Select(driver.findElement(By.cssSelector("select#country")));
		
		select.selectByVisibleText("Vietnam");
		SleepInSecond(3);
		
		List<WebElement> listItem = driver.findElements(By.cssSelector("div#map h4"));
		
		for(WebElement item:listItem)
		{
			System.out.println(item.getText());
		}
	 
		
		
	}

	@Test
	public void TC_03_()  {
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
}
