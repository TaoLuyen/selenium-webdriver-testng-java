package webdrivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	WebElement element;
	// khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.out.println("Path is: " + projectPath);
		System.out.println("Full path is: " + projectPath + "\\browserDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_Browser() {
		// Cacs ham tuwong tac vowis Browser thong qua bien drive
		//** NOTE DUNG NHIEU
		driver.close(); //**
		driver.quit();//**
		 WebElement  loginButton= driver.findElement(By.cssSelector(""));//**
		 
		 List<WebElement> links = driver.findElements(By.cssSelector(""));//**
		 
		 driver.get("https://www.facebook.com/");//**
		 
		 String gamePageUrl = driver.getCurrentUrl();
		 
		 String gamePageTitle = driver.getTitle();
		 
		 String gamePageSource = driver.getPageSource();
		 driver.getWindowHandle(); // 1//**
		 driver.getWindowHandles(); // tat ca//**
		 
		 driver.manage().getCookies(); // cookie framework //**
		 driver.manage().logs().getAvailableLogTypes();
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();//**
		
		// Test GUI
		// font/size/position/ location
		// uu tien la chuc nang truoc
		// uu tien lam giao dien sau
		
		//chờ cho element được tim thây trong khoảng time xx s
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// chờ cho page load thành công sau xx s
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		// chờ cho script thành công vào browser/ element sau xx s
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		
		// back lại trang
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().to("https://www.facebook.com/");
		
		 // Alert/frame(iframe)/window(tab) //**
		driver.switchTo().alert();//**
		driver.switchTo().frame(0);//**
		driver.switchTo().window("");//**
		
	}

	@Test
	public void TC_02_Element() {
		driver.get("https://www.facebook.com/");
		
		// Cac ham tuong tac voi element thong qua cai element
		
		// Có 2 cách khai báo biến
		// Khai báo biến và dùng lại
		/// Dùng đi dùng lại nhiều lần- ít nhất là 2 lần
		
		WebElement emailAddressTextbox = driver.findElement(By.id("email"));
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys("luyen_pand@yahoo.com");
		
		// Dùng trực tiếp - có 1 lần
		
		driver.findElement(By.id("email")).clear();
		
		
		element.clear();
		
		element.sendKeys("text");
		// Nhập vào 1 phím của bàn phím
		element.sendKeys(Keys.ENTER);
		
		
		// trả về giá trị của 1 thuộc tính nào đấy
		element.getAttribute("placeholder");
		// email or phone number
		driver.findElement(By.id("firstname")).getAttribute("value");
		
		// lấy giá trị thuộc tính css
		
	    String propertyName = "";
		element.getCssValue(propertyName);
		element.getCssValue("background-color");
		element.getCssValue("font-size");
		
		// Test GUI/ Location/ point/ rectange (Visualize testing)
		element.getLocation();
		element.getSize();
		element.getRect();
		
		// Chụp hình và attach vào html report
		element.getScreenshotAs(OutputType.FILE);
		
		element.getTagName(); // trả về thẻ của element input/p/div/h2//....
		emailAddressTextbox.getTagName();
		
		// trả về text của 1 element (link/header/message lỗi/message success)
		element.getText();
		
		// trả về giá trị đúng hoặc sai của 1 element có hiển thị hay ko
		// Ví dụ link menu dropdownlist, chỉ khi click vào nó mới hiển thị các li con của nó
		element.isDisplayed();
		
		// có thể thao tác được hay ko
		// có bị disable hay ko/ readonly
		element.isEnabled();
	
		// được chọn hay chưa. dùng trong checkbox, radio, dropdown list
		element.isSelected();
		// Dropdown có thể dùng khác IsSelected dùng với thư viện Select
		
		// CHỉ làm việc được với form(register, login, search/...)
		// submit = ENTER trong field nào đấy
		// submit vào 1 field nào đấy trong form
		element.submit();
		
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
