/**
 * 
 */
package com.pom.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jega
 *
 */
public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//*[@id='ap_email']")
	public WebElement email;
	
	@FindBy(xpath="//*[@id='ap_password']")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	public WebElement signInbutton;
	
	@FindBy(xpath="//*[@id='a-page']/div[1]/div[3]/div/div/form/div/div/div")
	public WebElement loginframe;
	
	@FindBy(xpath="//*[@id='auth-email-missing-alert']/div/div")
	public WebElement errmsgEmailempty;
	
	@FindBy(xpath="//*[@id='auth-password-missing-alert']/div/div")
	public WebElement errmsgPasswordempty;
	
	@FindBy(xpath="//*[@id='auth-error-message-box']/div/div/ul/li/span")
	public WebElement errmsgEmailinvalid;
	
	@FindBy(xpath="//*[@id='auth-warning-message-box']/div)")
	public WebElement errmsgEmailinvalid1;
	
	@FindBy(xpath="//*[@id='auth-warning-message-box']/div/div/ul/li/span")
	public WebElement errmsgEmailinvalid2;

	//.//*[@id='auth-warning-message-box']/div/div/ul/li/span
	
	public HomePage gotoHomePage()
	{
		System.out.println("Enter the loginpage");
		new Actions(driver).moveToElement(loginframe).build().perform();
		loginframe.click();
		System.out.println("test Passed");
		email.sendKeys("nirmalamsc007@gmail.com");
		password.sendKeys("developer115");
		signInbutton.click();
		return PageFactory.initElements(driver, HomePage.class);
				
	}
	
	public OrdersPage gotoOrdersPage()
	{
		System.out.println("Enter the loginpage");
		new Actions(driver).moveToElement(loginframe).build().perform();
		loginframe.click();
		System.out.println("test Passed");
		email.sendKeys("nirmalamsc007@gmail.com");
		password.sendKeys("developer115");
		signInbutton.click();
		return PageFactory.initElements(driver, OrdersPage.class);
	}

	public void signInbutton() {
		// TODO Auto-generated method stub
		signInbutton.click();
	}

	public void password(String string) {
		// TODO Auto-generated method stub
		password.sendKeys(string);
		
	}
	
	public void email(String string)
	{
		email.sendKeys(string);
	}
	
	 public void errorEmailMessageVerification(WebElement error, String errorMessage)
	    {
	        Assert.assertTrue("Error message is not displayed while trying to login without email id", error.isDisplayed());
	        System.out.println("Error message is displayed while trying to login without email id");
	        
	        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your email or mobile phone number", errorMessage);
	        System.out.println("Verified the expected error messaeg in UI for Email");
	        
	    }
   public String getErrormsg()
    {
    	return errmsgEmailempty.getText();
   }
   
   public WebElement getError()
   {
	   return errmsgEmailempty;
   }
   
   
   
}
