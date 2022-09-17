package webdrivers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Actions {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	Actions action;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}

	//@Test
	public void TC_01_HoverTooltip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		SleepInSecond(3);
		
		System.out.println(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText() + " ahuahuhuhua");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
		
	}

	//@Test
	public void TC_02_HoverToElement() {
		driver.get("http://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"))).perform();
		SleepInSecond(3);
		// element click hoac action click
		// cach 1
		//driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Toys']")).click();
		// cach 2
		action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Toys']"))).perform();
		SleepInSecond(3);
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']")).getText(), "Toys Store");
		
	}

	//@Test
	public void TC_03_HoverToElementFahasa()  {
		driver.get("https://www.fahasa.com/");
		SleepInSecond(3);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='fhs_center_right fhs_mouse_point fhs_dropdown_hover fhs_dropdown_click']"))).perform();
		SleepInSecond(3);
		//action.moveToElement(driver.findElement(By.xpath("//a[@title='Sách Trong Nước']"))).perform();
		
		
	//	SleepInSecond(3);
		action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//ul[@class='nav-links']//a[text()='Chính Trị']"))).perform();
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//li/strong")).getText(), "CHÍNH TRỊ");
		
		
	}

	//@Test
	public void TC_04_ClickAndHoldBlock()  {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		SleepInSecond(3);
		List<WebElement> listNumber = driver.findElements(By.cssSelector("#selectable >li"));
		action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(9)).release().perform();
		
		List<WebElement> listNumberSelected = driver.findElements(By.cssSelector("#selectable >li.ui-selected"));
		
		Assert.assertEquals(listNumberSelected.size(), 6);
		
		
	}
	
	//@Test
	public void TC_05_ClickAndHoldRandom()  {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		SleepInSecond(3);
		List<WebElement> listNumber = driver.findElements(By.cssSelector("#selectable >li"));
		//nhan du phim ctrl
		action.keyDown(Keys.CONTROL).perform();
		action.click(listNumber.get(0))
			.click(listNumber.get(3))
			.click(listNumber.get(4))
			.click(listNumber.get(6))
			.click(listNumber.get(10))
			.perform();
			
		action.keyDown(Keys.CONTROL).perform();
		
		List<WebElement> listNumberSelected = driver.findElements(By.cssSelector("#selectable >li.ui-selected"));
		
		Assert.assertEquals(listNumberSelected.size(), 5);
		
		
	}
	
	

	//@Test
	public void TC_06_DoubleClick()  {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='container']//button[text()='Double click me']")));
		SleepInSecond(3);
		action.doubleClick(driver.findElement(By.xpath("//div[@class='container']//button[text()='Double click me']"))).perform();
		SleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container']//p[@id='demo']")).getText(), "Hello Automation Guys!");
		
	}
	
	//@Test
	public void TC_07_RightClick()  {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		SleepInSecond(3);
		action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
		SleepInSecond(3);
		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-paste context-menu-hover context-menu-visible']")).isDisplayed(), true);
		
		action.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		
		driver.switchTo().alert().accept();
		SleepInSecond(3);
		

		Assert.assertEquals(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed(), false);
		
		
	}
	
	//@Test
	public void TC_07_DragAndDrop_HTML4()  {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		SleepInSecond(3);
		WebElement smallC = driver.findElement(By.cssSelector("div#draggable"));
		WebElement bigC = driver.findElement(By.cssSelector("div#droptarget"));
		action.dragAndDrop(smallC, bigC).perform();
		
		Assert.assertEquals(bigC.getText(), "You did great!");
		
String colorRgba = bigC.getCssValue("background-color");
		
		System.out.println(colorRgba);
		
		String colorHexa = Color.fromString(colorRgba).asHex().toLowerCase();
		
		Assert.assertEquals(colorHexa, "#03a9f4");
	}
	
	
//	@Test
	public void TC_08_DragAndDrop_HTML4()  {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		SleepInSecond(3);
		WebElement smallC = driver.findElement(By.cssSelector("div#draggable"));
		WebElement bigC = driver.findElement(By.cssSelector("div#droptarget"));
		action.dragAndDrop(smallC, bigC).perform();
		
		Assert.assertEquals(bigC.getText(), "You did great!");
		
	}
	
	@Test
	public void TC_09_DragAndDrop_HTML5() throws IOException  {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		SleepInSecond(3);
		
	//	Assert.assertEquals(bigC.getText(), "You did great!");
		
		
		String jsContentFile = getContentFile(projectPath + "/dragAndDrop/drag_and_drop_helper.js");
		String sourceCss = "#column-a";
		String targetCss = "#column-b";
		jsExecutor.executeScript(jsContentFile + "$(\"" + sourceCss + "\").simulateDragDrop({ dropTarget: \"" + targetCss + "\"});");
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
	
	public String getContentFile(String filePath) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(filePath);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}
}
