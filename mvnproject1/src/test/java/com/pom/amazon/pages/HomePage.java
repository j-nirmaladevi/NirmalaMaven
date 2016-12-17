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
public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement searchtextbox;
	
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	public WebElement searchimg;
	
	
	public ProductPage gotoProductpage()
	{
		searchtextbox.sendKeys("pants");
		searchimg.click();
		return PageFactory.initElements(driver, ProductPage.class);
	}
	

}
