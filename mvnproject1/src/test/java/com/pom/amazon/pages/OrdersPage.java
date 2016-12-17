package com.pom.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
public WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//*[@id='orderTypeMenuContainer']/ul/li[4]/span/a")
	public  WebElement digitalorders;
	
	@FindBy(xpath="//*[@id='orderTypeMenuContainer']/ul/li[2]/span/a")
	public WebElement orders;
	
	
	public void clickonDigitalOrders()
	{
		digitalorders.click();
		//signIn.click();
		//return PageFactory.initElements(driver, OrdersPage.class);
	}
	
	public LoginPage clickonOrders()
	{
		orders.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	}


