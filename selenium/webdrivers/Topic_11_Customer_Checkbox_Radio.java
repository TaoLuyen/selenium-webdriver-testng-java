package webdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Customer_Checkbox_Radio {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		jsExecutor = (JavascriptExecutor) driver;
		
	}

	@Test
	public void TC_01_Custom_Checkbox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		// case 1 
		// thẻ input: bị ẩn nên ko click được
		// thẻ input dùng để verify được
		
		// click
		//driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span/input")).click();
		SleepInSecond(3);
		//verify
		//Assert.assertTrue(	driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span/input")).isSelected());
		
		// Case 2
		// Ko dùng thẻ input để click - thay thế bằng thẻ đang đại diện cho checkboc là thẻ span
		// thẻ span này lại ko verify được
		//driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span")).click();
		
		//verify
		//Assert.assertTrue(	driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span")).isSelected());
				
		// Case 3 
		// thẻ span để click
		// thẻ input để verify
		//driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span")).click();
		//verify
		//Assert.assertTrue(	driver.findElement(By.xpath("//span[text()='Checked']/preceding-sibling::span/input")).isSelected());
			
		// Case 4: Work around
		// thẻ input để click + verify
		// hàm click() của WebElement ko click vào element bị ẩn được
		// Hàm click() của javascript thì ko quan tâm bị ẩn hay ko
		By checkedCheckbox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckbox));
		SleepInSecond(3);
		Assert.assertTrue(	driver.findElement(checkedCheckbox).isSelected());
//		var checkedCheckboxSame = $x("//span[text()='Checked']/preceding-sibling::span/input")[0];
//		checkedCheckboxSame.click();
		
		
		
	}

	@Test
	public void TC_02_Custom_Radio() {
		driver.get("https://material.angular.io/components/radio/examples");
		
		By checkedRadio = By.xpath("//span[contains(text(),'Spring')]/preceding-sibling::span/input");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedRadio));
		SleepInSecond(3);
		Assert.assertTrue(	driver.findElement(checkedRadio).isSelected());
	}

	@Test
	public void TC_03_VNDirect()  {
		driver.get("https://account-v2.vndirect.com.vn/");
		SleepInSecond(3);
		By checkedCheckbox = By.xpath("//input[@name='acceptTerms']");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckbox));
	
		
	}
	@Test
	public void TC_04_Google()  {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		SleepInSecond(3);
//		By canThoRadio = By.xpath("//div[@aria-label='Đà Nẵng']");
		
//		driver.findElement(canThoRadio).getAttribute("aria-checked");
//		
//		Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "false");
//		jsExecutor.executeScript("arguments[0].click();", driver.findElement(canThoRadio));
//		
//		Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "true");
//		
		checkToRadio("//div[@aria-label='Đà Nẵng']");
		
		// có thể verify kiểu này
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Đà Nẵng' and @aria-checked='true']")).isDisplayed());
		
		checkToCheckbox("//div[@aria-label='Mì Quảng']");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Mì Quảng' and @aria-checked='true']")).isDisplayed());
		
	}

	public void checkToRadio(String xpathLocator)
	{
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		if(element.getAttribute("aria-checked").equals("false"))
		{
			jsExecutor.executeScript("arguments[0].click();",element);
		}
		Assert.assertEquals(element.getAttribute("aria-checked"), "true");
		
		
	}
	
	public void uncheckToCheckbox(String xpathLocator)
	{
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		if(element.getAttribute("aria-checked").equals("true"))
		{
			element.click();
		}
		Assert.assertEquals(element.getAttribute("aria-checked"), "false");
	}
	
	public void checkToCheckbox(String xpathLocator)
	{
		WebElement element = driver.findElement(By.xpath(xpathLocator));
		if(element.getAttribute("aria-checked").equals("false"))
		{
			element.click();	
		}
		Assert.assertEquals(element.getAttribute("aria-checked"), "true");		
	}
	
	@AfterClass
	public void afterClass() {
	//	driver.quit();
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
