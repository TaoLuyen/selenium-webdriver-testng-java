package webdrivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Custom_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	WebDriverWait explicitWait;
	Select select;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().setSize(new Dimension(1366, 768));
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		jsExecutor = (JavascriptExecutor) driver; 
		
	
	}

	//@Test
	public void TC_01_() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		// 1 click vao dropdown de no xổ các option ra
		driver.findElement(By.cssSelector("span#number-button")).click();
		// 2 CHờ cho tất cả các option được hiển ra
		
		/// Lấy ra 1 cái locator đại diện cho tất cả các option
		// presenceOfAllElementsLocatedBy chỉ cần có trong html
		// visible là vừa phải có html vừa phải hiện trên giao diện
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
	
		//3. Duyệt qua từng cái item nếu bằng giá trị mong muốn thì click vào
		// Lưu trữ danh sách element
		 List<WebElement> listItems =	driver.findElements(By.cssSelector("ul#number-menu div"));
		 
		 // dùng vòng lặp
		 // CHọn số 19
		 for (WebElement item : listItems) {
			if(item.getText().equals("19"))
			{
				item.click();
			}
		 }
	 
		 /// Dungf cho number
		 selectItemInCustomDropdown("span#number-button","ul#number-menu div", "7");
		 SleepInSecond(3);
		 selectItemInCustomDropdown("span#number-button","ul#number-menu div", "5");
		 SleepInSecond(3);
		 
		/// Dungf cho speed
		 selectItemInCustomDropdown("span#speed-button","ul#speed-menu div", "Fast");
		 SleepInSecond(3);
		 selectItemInCustomDropdown("span#speed-button","ul#speed-menu div", "Slow");
		 SleepInSecond(3);
		 
		/// Dungf cho title
		 selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div", "Mrs.");
		 SleepInSecond(3);
		 selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div", "Mr.");
		 SleepInSecond(3);
		 
		 
	}

	//@Test
	public void TC_02_Honda() {
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		scrollToElement("div.carousel-item");
		 SleepInSecond(3);
		
		selectItemInCustomDropdown("button#selectize-input","button#selectize-input + div > a.dropdown-item", "CITY G");
		SleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "CITY G") ;
		
		scrollToElement("div.container");
		SleepInSecond(3);
		
		 select = new Select(driver.findElement(By.cssSelector("select#province")));
		 select.selectByVisibleText("An Giang");
		 SleepInSecond(3);
		 
		 Assert.assertEquals(select.getFirstSelectedOption().getText(), "An Giang") ;
			
		 
		 
		 select = new Select(driver.findElement(By.cssSelector("select#registration_fee")));
		 select.selectByVisibleText("Khu vực II");
		 SleepInSecond(3);
		 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Khu vực II") ;
			
		 
	}

	//@Test
	public void TC_03_React()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Elliot Fu");
		SleepInSecond(3);
		
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu") ;
		 
		 selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Justen Kitsune");
			SleepInSecond(3);
			
			 Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune") ;
	}
	
	//@Test
	public void TC_04_VueJS()  {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		SleepInSecond(3);
		
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group > li.dropdown-toggle")).getText(), "First Option") ;
//		 
//		 selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Justen Kitsune");
//			SleepInSecond(3);
//			
//			 Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune") ;
	}
	
	//@Test
	public void TC_05_React_Selectable()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Algeria");
		SleepInSecond(3);
		
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria") ;
		 	}
	
	@Test
	public void TC_06_React_Editable()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		enterItemInCustomDropdown("input.search", "div.menu span.text", "Algeria");
		SleepInSecond(3);
		
		 Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria") ;
		 	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
	
	public void scrollToElement(String cssLocator)
	{
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
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
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem)
	{
		
		// 1 click vao dropdown de no xổ các option ra
		driver.findElement(By.cssSelector(parentLocator)).click();
		// 2 CHờ cho tất cả các option được hiển ra
		
		/// Lấy ra 1 cái locator đại diện cho tất cả các option
		// presenceOfAllElementsLocatedBy chỉ cần có trong html
		// visible là vừa phải có html vừa phải hiện trên giao diện
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
	
		//3. Duyệt qua từng cái item nếu bằng giá trị mong muốn thì click vào
		// Lưu trữ danh sách element
	 List<WebElement> listItems =	driver.findElements(By.cssSelector(childLocator));
	 
	 // dùng vòng lặp
	 // CHọn số 19
	 for (WebElement item : listItems) {
		if(item.getText().equals(textExpectedItem))
		{
			item.click();
		}
	 }
	}
	
	
	public void enterItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem)
	{
		
		// 1 click vao dropdown de no xổ các option ra
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(textExpectedItem);
		// 2 CHờ cho tất cả các option được hiển ra
		SleepInSecond(3);
		/// Lấy ra 1 cái locator đại diện cho tất cả các option
		// presenceOfAllElementsLocatedBy chỉ cần có trong html
		// visible là vừa phải có html vừa phải hiện trên giao diện
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
	
		//3. Duyệt qua từng cái item nếu bằng giá trị mong muốn thì click vào
		// Lưu trữ danh sách element
	 List<WebElement> listItems =	driver.findElements(By.cssSelector(childLocator));
	 
	 // dùng vòng lặp
	 // CHọn số 19
	 for (WebElement item : listItems) {
		if(item.getText().equals(textExpectedItem))
		{
			item.click();
			break;
		}
	 }
	}
	
}
