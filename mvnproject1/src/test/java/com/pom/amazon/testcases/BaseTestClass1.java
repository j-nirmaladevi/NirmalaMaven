/**
 * 
 */
package com.pom.amazon.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.amazon.pages.AddtoCartPage;
import com.pom.amazon.pages.FirstPageofAmazon;
import com.pom.amazon.pages.HomePage;
import com.pom.amazon.pages.LoginPage;
import com.pom.amazon.pages.ProductOverviewPage;
import com.pom.amazon.pages.ProductPage;

/**
 * @author Jega
 *
 */
public class BaseTestClass1 {
	
	public WebDriver driver;
	
	
	@Before
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void addtocartitem()
	{
		FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("test Passed");
		LoginPage lp = fpa.clickonSignin();
		System.out.println("tEst passed");
		HomePage hp =lp.gotoHomePage();
		ProductPage pp = hp.gotoProductpage();
		ProductOverviewPage pop = pp.gotoProductOverviewPage();
		AddtoCartPage addtocartpage = pop.gotoAddtocartpage();
		addtocartpage.signout();
	}
				
	
	
	
	}
	


