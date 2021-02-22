package Com;

import cucumber.junit.Cucumber; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNGTests {
	WebDriver driver ; 
	
	@BeforeClass
	public void login () {
	String projectPath=System.getProperty("user.dir");
	//System.out.println("Project path is: " +projectPath);
	System.setProperty("webdriver.chrome.driver","C:\\Users\\training\\eclipse-workspace\\Grup1\\src\\main\\resources\\chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Driver Open");
	}
	@Test
	public void validateLogin () throws InterruptedException {
	driver.navigate().to("http://demo.guru99.com/V4/");
	System.out.println("validate login page");
	driver.findElement(By.name("uid")).sendKeys("mngr308726");;
	driver.findElement(By.name("password")).sendKeys("Yduzypy");
	Thread.sleep(4000);
	driver.findElement(By.name("btnLogin")).click();
	Thread.sleep(4000);
	System.out.println("validate Navigation");
	driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
	Thread.sleep(5000);
	System.out.println("validate Logout");
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	driver.switchTo().alert().accept();
	}
	@AfterClass
	public void Navigation () {
	driver.close();
	System.out.println("Logout Successfully");
	}
}
