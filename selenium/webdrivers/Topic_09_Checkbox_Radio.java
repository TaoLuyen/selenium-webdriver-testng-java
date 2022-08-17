package webdrivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Topic_09_Checkbox_Radio {
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
	public void TC_01_Jotform() {
		
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		//driver.findElement(By.xpath("//input[@value='Cancer']")).click();
		//driver.findElement(By.xpath("//input[@value='Fainting Spells']")).click();
		
		checkToCheckboxOrRadio("//input[@value='Cancer']");
		checkToCheckboxOrRadio("//input[@value='Fainting Spells']");
		
		Assert.assertTrue(isElementSelected("//input[@value='Cancer']"));
		Assert.assertTrue(isElementSelected("//input[@value='Fainting Spells']"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Fainting Spells']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cancer']")).isSelected());
		
		driver.findElement(By.xpath("//input[@value='5+ days']")).click();
		driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).click();
			
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).isSelected());
			
		driver.findElement(By.xpath("//input[@value='5+ days']")).click();
		driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).isSelected());
		
	}

	@Test
	public void TC_02_Jotform_Check_All() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		// dùng vòng lặp duyệt qua và click chọn
		
		for(WebElement checkbox: allCheckboxes)
		{
			checkToCheckboxOrRadio(checkbox);
			SleepInMilis(200);
		}
		
		// check chọn tất cả
		for(WebElement checkbox: allCheckboxes)
		{
		 Assert.assertTrue(isElementSelected(checkbox));
		}
		
		// bỏ chọn
		for(WebElement checkbox: allCheckboxes)
		{
			uncheckToCheckboxOrRadio(checkbox);
			SleepInMilis(200);
		}
		
		// check chọn tất cả
		for(WebElement checkbox: allCheckboxes)
		{
		 Assert.assertFalse(isElementSelected(checkbox));
		}
 	}

	@Test
	public void TC_03_Select_All()  {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		SleepInSecond(5);
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='example']//input[@type='checkbox']"));
		
		for(WebElement checkbox: checkboxes)
		{
			checkToCheckboxOrRadio(checkbox);
			SleepInMilis(200);
		}
		
		for(WebElement checkbox: checkboxes)
		{
			uncheckToCheckboxOrRadio(checkbox);
			SleepInMilis(200);
		}
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public void checkToCheckboxOrRadio(String xpathLocator)
	{
		if(!driver.findElement(By.xpath(xpathLocator)).isSelected())
		{
			driver.findElement(By.xpath(xpathLocator)).click();
		}
	}
	
	
	
	public void uncheckToCheckboxOrRadio(String xpathLocator)
	{
		if(driver.findElement(By.xpath(xpathLocator)).isSelected())
		{
			driver.findElement(By.xpath(xpathLocator)).click();
		}
	}
	public boolean isElementSelected(String xpathLocator)
	{
		return	driver.findElement(By.xpath(xpathLocator)).isSelected();
	}
	
	public void checkToCheckboxOrRadio(WebElement element)
	{
		if(!element.isSelected() && element.isEnabled())
		{
			element.click();
			Assert.assertTrue(isElementSelected(element));
		}
	}
	
	public boolean isElementSelected(WebElement element)
	{
		return element.isSelected();
	}
	
	public void uncheckToCheckboxOrRadio(WebElement element)
	{
		if(element.isSelected() && element.isEnabled())
		{
			element.click();
			Assert.assertFalse(isElementSelected(element));
		}
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
		public void SleepInMilis(long timeMilis) {
			try {
				Thread.sleep(timeMilis); // s
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
