/**
 * 
 */
package com.pom.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Jega
 *
 */
public class FirstPageofAmazon {
	
	public WebDriver driver;
	
	public FirstPageofAmazon(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//*[@id='nav-link-accountList']")
	public  WebElement yourAccount;
	
	@FindBy(xpath="//*[@id='nav-flyout-ya-signin']/a/span")
	public WebElement signIn;
	
	@FindBy(xpath=".//*[@id='nav-orders']/span[2]")
	public WebElement orders;
	
	public LoginPage clickonSignin()
	{
		yourAccount.click();
		//signIn.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public LoginPage clickonOrders()
	{
		orders.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	}
	
	
	


