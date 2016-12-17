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
public class ProductPage {
	
	public WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='result_0']")
	public WebElement firstitemlink;
	
	
	public ProductOverviewPage gotoProductOverviewPage()
	{
		firstitemlink.click();
		return PageFactory.initElements(driver,ProductOverviewPage.class);
	}
	
}
