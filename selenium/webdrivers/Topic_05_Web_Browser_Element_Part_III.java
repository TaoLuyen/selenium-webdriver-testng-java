package webdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Element_Part_III {
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
	public void TC_01_Is_Displayed() {
		// Có thể nhìn thấy
		// Có kích thước cụ thế
		// phạm vi áp dụng: tất cả các loại element
		driver.get("https://automationfc.github.io/basic-form/index.html");//**
		
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
		if(emailTextbox.isDisplayed())
		{
			emailTextbox.sendKeys("Luyen Tao");
			System.out.println("Email is displayed");
		} else {
			System.out.println("Email is not displayed");
		}
		
		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
		if(ageUnder18Radio.isDisplayed())
		{
			ageUnder18Radio.click();
			System.out.println("Age under 18 radio is displayed");
		} else {
			System.out.println("Age under 18 radio is not displayed");
		}
		
		WebElement eduTextarea = driver.findElement(By.cssSelector("textarea#edu"));
		if(eduTextarea.isDisplayed())
		{
			eduTextarea.sendKeys("Edu textarea");
			System.out.println("Edu textarea is displayed");
		} else {
			System.out.println("Edu textarea is not displayed");
		}
		
		WebElement image5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if(image5.isDisplayed())
		{
			System.out.println("Image 5 is displayed");
		} else {
			System.out.println("Image 5 is not displayed");
		}
	}

//	@Test
	public void TC_02_Enabled() {
		// Có thể tương tác được = enabled = true
		// Không tương tác được với disabled = readonly
		// phạm vi áp dụng: tất cả các loại element
		driver.get("https://automationfc.github.io/basic-form/index.html");//**
		
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
		if(emailTextbox.isEnabled())
		{
			emailTextbox.sendKeys("Luyen Tao");
			System.out.println("Email is enabled");
		} else {
			System.out.println("Email is not enabled");
		}
		
		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
		if(ageUnder18Radio.isEnabled())
		{
			System.out.println("Age under 18 radio is enabled");
		} else {
			System.out.println("Age under 18 radio is not enabled");
		}
	}

	//@Test
	public void TC_03_Is_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");//**
		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
		ageUnder18Radio.click();
		
		if(ageUnder18Radio.isSelected())
		{
			System.out.println("Age under 18 radio is selected");
		} else {
			System.out.println("Age under 18 radio is not selected");
		}
		
		
		WebElement javaCheckbox = driver.findElement(By.cssSelector("input#java"));
		javaCheckbox.click();
		
		if(javaCheckbox.isSelected())
		{
			System.out.println("Java checkbox is selected");
		} else {
			System.out.println("Java checkbox radio is not selected");
		}
		
	}
	
	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");//**
		WebElement emailTxt = driver.findElement(By.cssSelector("input#email"));
		emailTxt.sendKeys("luyentt6@fpt.com.vn");
		//WebElement usernameTxt = driver.findElement(By.cssSelector("input#new_username"));
		//usernameTxt.sendKeys("Tao Luyen");
		SleepInSecond(3);
		WebElement passwordTxt = driver.findElement(By.cssSelector("input#new_password"));
		passwordTxt.sendKeys("aa");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		passwordTxt.clear();
		passwordTxt.sendKeys("AA");
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
		// One number
		passwordTxt.clear();
		passwordTxt.sendKeys("2");
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
	
		
		// One special character
		passwordTxt.clear();
		passwordTxt.sendKeys("!");
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
	
		// 8 characters minimum
		passwordTxt.clear();
		passwordTxt.sendKeys("56489!@1234");
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
	
		
		
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
