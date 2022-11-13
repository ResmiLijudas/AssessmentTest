package riseproject.testproject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base {
	
	WebDriver driver;
	
	public Base(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement Loginbtn;
	
	@FindBy(xpath="//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")
	WebElement actual;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement item1;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement item2;
	
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement item3;
	
	@FindBy(xpath="//span[text()='3']")
	WebElement total;
	
	
		
	
	public void loginVerifications(String uname, String pwd) {
		Username.clear();
		Username.sendKeys(uname);
		
		password.clear();
		password.sendKeys(pwd);
		
		Loginbtn.click();
		
		
	}
	public boolean verifySignInPageErrorMessage() {
		
		String pageText = actual.getText();
		String expectedPageText = "Epic sadface: Username and password do not match any user in this service";
		return pageText.contains(expectedPageText);
	}
	
	
	public void addToCart() {
		item1.click();
		item2.click();
		item3.click();
		
	}
	
	
	public boolean verifyItemcount() {
		String pageText ="3";
		return total.getText().contains(pageText);
	}
	
	
	
	
	
}
