package testscenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import riseproject.testproject.Base;

public class Loginactions {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void launchbrowser() {
		
        WebDriverManager.chromedriver().setup();
		//Initializing the browser driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		 
	}
	
	
	@Test(priority=1)
	 public void invalidCredentials()
	 {
		Base obj = new Base(driver);
		obj.loginVerifications("invaliduname","invalidpwd");
		Assert.assertTrue(obj.verifySignInPageErrorMessage(),"Invalid Username and Invalid Password ");

		
	
	 }
	@Test(priority=2)
	 public void loginValidunameInvalidpwd()
	 {
		Base obj1 = new Base(driver);
		obj1.loginVerifications("standard_user","invalidpwd");
		Assert.assertTrue(obj1.verifySignInPageErrorMessage(),"Valid Username and Invalid Password ");
	
	 }
	
	@Test(priority=3)
	 public void loginInvalidusernameValidpwd()
	 {
		Base obj3 = new Base(driver);
		obj3.loginVerifications("invaliduname","secret_sauce");
		Assert.assertTrue(obj3.verifySignInPageErrorMessage(),"Invalid Username and Valid Password ");
		
	
	 }
	
	@Test(priority=4)
	 public void loginValidusernameValidpwd()
	 {
		Base obj4 = new Base(driver);
		obj4.loginVerifications("standard_user","secret_sauce");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,"https://www.saucedemo.com/inventory.html" );
	 }
	
	@Test(priority=5)
	
	public void addingToCart()
	{
		Base obj5 = new Base(driver);
		obj5.addToCart();
		Assert.assertTrue(obj5.verifyItemcount(),"Valid item count");
			
	}
	
	
	@AfterTest
	public void discontinueBrowser()
	 {
	    driver.quit();
	 }
		 
	}
	
	
	
	
	
	
	
	
	

