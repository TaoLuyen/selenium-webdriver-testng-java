package webdrivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_TextBox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	String firstName, lastName, employeeID, editFirstName, editLastName;
	String immigrationNumber, immigrationComment;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Luyen";
		lastName ="Tao";
		editFirstName = "Minh Anh";
		editLastName = "Nguyen";
		
		immigrationNumber ="777777999999";
		immigrationComment ="100 Pham Hung\nNam Tu Liem\nHa Noi";
		
	}

	@Test
	public void TC_01_TextBox_TextArea() {
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	
	driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
	
	driver.findElement(By.cssSelector("input#btnLogin")).click();
	SleepInSecond(5);
	// mo man hinh add employee
	
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
	
	driver.findElement(By.cssSelector("input#firstName")).sendKeys(firstName);
	driver.findElement(By.cssSelector("input#lastName")).sendKeys(lastName);
	
	// luu gia trij employee vao bien
	employeeID = driver.findElement(By.cssSelector("input#employeeId")).getAttribute("value");
	driver.findElement(By.cssSelector("input#btnSave")).click();
	
	// verify assert
	Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
	Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
	Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
	
	
	// verify actual value = expeted value
	
	Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"), firstName);
	Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"), lastName);
	Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"), employeeID);

	driver.findElement(By.cssSelector("input#btnSave")).click();
	SleepInSecond(3);
	
	Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
	Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
	Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
	
	// Edit cac field
	
	driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).clear();
	driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).clear();
	
	driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).sendKeys(editFirstName);
	driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).sendKeys(editLastName);
	
	driver.findElement(By.cssSelector("input#btnSave")).click();
	SleepInSecond(3);
	
	// verify assert
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"), editFirstName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"), editLastName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"), employeeID);

		// Open //a[text()='Immigration']
	driver.findElement(By.xpath("//a[text()='Immigration']")).click();
	driver.findElement(By.cssSelector("input#btnAdd")).click();
	SleepInSecond(3);
	
	// enter to immigration
	driver.findElement(By.cssSelector("input#immigration_number")).sendKeys(immigrationNumber);
	
	driver.findElement(By.cssSelector("textarea#immigration_comments")).sendKeys(immigrationComment);
	SleepInSecond(3);
	
	driver.findElement(By.cssSelector("input#btnSave")).click();
	SleepInSecond(3);
	
	
	driver.findElement(By.xpath("//a[text()='Passport']")).click();
	
	Assert.assertEquals(driver.findElement(By.cssSelector("input#immigration_number")).getAttribute("value"), immigrationNumber);
	Assert.assertEquals(driver.findElement(By.cssSelector("textarea#immigration_comments")).getAttribute("value"), immigrationComment);
	
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
