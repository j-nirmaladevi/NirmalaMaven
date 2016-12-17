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
public class ProductOverviewPage {
	
	public WebDriver driver;
	
	public ProductOverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(xpath="//*[@id='add-to-cart-button']")
	public WebElement addtocartbutton;
	
	public AddtoCartPage gotoAddtocartpage()
	{
		addtocartbutton.click();
		return PageFactory.initElements(driver, AddtoCartPage.class);
	}
	
	
}
