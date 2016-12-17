/**
 * 
 */
package com.pom.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Jega
 *
 */
public class AddtoCartPage {
	
	public WebDriver driver;
	
	public AddtoCartPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	@FindBy(xpath="//*[@id='desktop-auto-sparkle-multi']/div/div/span/a")
	public WebElement signoutlink;
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	public WebElement searchtextbox;
	
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	public WebElement searchimg;

	public void signout()
	{
		searchtextbox.clear();
		searchtextbox.sendKeys("signout");
		searchimg.click();
		signoutlink.click();
		
	}
	

}
