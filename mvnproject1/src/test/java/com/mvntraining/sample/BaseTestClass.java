/**
 * 
 */
package com.mvntraining.sample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.amazon.pages.AddtoCartPage;
import com.pom.amazon.pages.FirstPageofAmazon;
import com.pom.amazon.pages.HomePage;
import com.pom.amazon.pages.LoginPage;
import com.pom.amazon.pages.OrdersPage;
import com.pom.amazon.pages.ProductOverviewPage;
import com.pom.amazon.pages.ProductPage;
import com.pom.amazon.testutils.Base.Lo4jconfigurationclass;


/**
 * @author Jega
 *
 */
public class BaseTestClass {
	
	public WebDriver driver;
	private FirstPageofAmazon fpa ;
	private LoginPage lp;
	private HomePage hp;
	private ProductPage pp;
	private ProductOverviewPage pop;
	private AddtoCartPage addtocartpage;
	private OrdersPage order;
	
	//public static Logger Log = Logger.getLogger(Lo4jconfigurationclass.class);
	public static Logger log = Logger.getLogger(BaseTestClass.class);
	//DOMConfigurator.configure("log4j.xml");
	
	@BeforeClass
	public static void log4jconfig()
	{
		 DOMConfigurator.configure("G:\\MavenProjects\\mvnproject1\\src\\test\\Resource\\log4j.xml");
	}
	
	
	@Before
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
	   
	}
	
	
	@Test
	//verifying the Amazon url title
	public void verifytitle()
	{
		 String actual;
		 actual = driver.getTitle();
		 System.out.println("Amazon URL title is :" +actual);
		 log.info("The Amazon title is verified");
		
		 assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
		 System.out.println("Amazon url Test case executed properly");
		 log.info("Amazon URL Testes case Executed properly");
		 System.out.println("Amazon Url title test case is pass");
	}
	
	
	@Test
    // scenario 1 : Verify error message when clicking next button without entering email id
	// Test Amazon login error message validations
	public void verifyErrmsgEmailEmpty()
	{
		//Check the login Page is displayed
		String errorMessage="";
	//	WebElement error="errmsgEmailempty";
		//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("First Page of Amazon page is opened");
	    lp= fpa.clickonSignin();
		System.out.println("Login Page is displayed");
			
		// Email value is null and valid password
		lp.email.sendKeys("");
		lp.password("developer115");
		lp.signInbutton();
		
		// Error message check
		//error =errmsgEmailempty;
	    WebElement error = lp.getError();
		System.out.println(error);
       //errorMessage =error.getText();
		errorMessage=lp.getErrormsg();
        System.out.println("Error message from UI is : "+errorMessage);
        
        // function call
        lp.errorEmailMessageVerification(error,errorMessage);
        System.out.println("");
		
	}
	
	@Test
	// scenario 2 : Verify error message when entering invalid email id
	public void verifyErrmsgEmailInvalid()
	{
		//Check the login Page is displayed
		String errorMessage="";
	//	FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("First Page of Amazon page is opened");
		lp = fpa.clickonSignin();
		System.out.println("Login Page is displayed");
			
		// Email value is null and valid password
		lp.email.sendKeys("ff");
		lp.password("developer115");
		lp.signInbutton();
		
		// Error message check
		// WebElement error =lp.errmsgEmailinvalid2;
		//error =errmsgEmailinvalid2;
	   // errorMessage =error.getText();
        System.out.println("When Email is Invalid the Error message from UI is : "+errorMessage);
        
        // function call
     //   lp.errorEmailMessageVerification(error, errorMessage);
        Assert.assertTrue("Error message is not displayed while trying to login without email id", lp.errmsgEmailinvalid2.isDisplayed());
        System.out.println("Error message is displayed while trying to login without email id");
        
        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your email or mobile phone number", errorMessage);
        System.out.println("Verified the expected error messaeg in UI for Email");
        System.out.println("");
			
	}
	
	
	
	@Test
	 // Scenario 3 : Verifying error message when password is null
	public void verifyErrmsgPwdEmpty()
	{
		//Check the login Page is displayed
		String errorMessage="";
		//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("First Page of Amazon page is opened");
		lp = fpa.clickonSignin();
		System.out.println("Login Page is displayed");
			
		// Valid Email and Password value is null
		lp.email.sendKeys("nirmalamsc007@gmail.com");
		lp.password("");
		lp.signInbutton();
		
		// Error message check
		//WebElement error =lp.errmsgPasswordempty;
	  //  errorMessage =error.getText();
      //  System.out.println("When Email is Invalid the Error message from UI is : "+errorMessage);
        
        // function call
      //  lp.errorPasswordMessageVerification(error, errorMessage);
		 Assert.assertTrue("Error message is not displayed while trying to login without password", lp.errmsgPasswordempty.isDisplayed());
	        System.out.println("Error message is displayed while trying to login without password");
	        
	        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your password", errorMessage);
	        System.out.println("Verified the expected error messaeg in UI for Password");
        System.out.println("");
			
	}
	
	@Test
	// scenario 2 : Verify error message when entering invalid Password id
	public void verifyErrmsgPasswordInvalid()
	{
		//Check the login Page is displayed
		String errorMessage="";
		//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("First Page of Amazon page is opened");
		lp = fpa.clickonSignin();
		System.out.println("Login Page is displayed");
			
		// Email value is null and valid password
		lp.email.sendKeys("nirmalamsc007@gmail.com");
		lp.password("de115");
		lp.signInbutton();
		
		// Error message check
	//	WebElement error =lp.errmsgEmailinvalid2;
	 //   errorMessage =error.getText();
     //   System.out.println("When Email is Invalid the Error message from UI is : "+errorMessage);
        
        // function call
      //  lp.errorEmailMessageVerification(error, errorMessage);
		 Assert.assertTrue("Error message is not displayed while trying to login without password", lp.errmsgEmailinvalid2.isDisplayed());
	        System.out.println("Error message is displayed while trying to login without password");
	        
	        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your password", errorMessage);
	        System.out.println("Verified the expected error messaeg in UI for Password");
        System.out.println("");
			
	}
	
    
	
	@Test
	// scenario 4 : Verify successful login
	public void verifySuccessfullLogin()
	{
		//Check the login Page is displayed
		String errorMessage="";
		//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("First Page of Amazon page is opened");
		lp = fpa.clickonSignin();
		System.out.println("Login Page is displayed");
			
		// valid Email and password
		lp.email.sendKeys("nirmalamsc007@gmail.com");
		lp.password("developer115");
		lp.signInbutton();
		
		
		 hp=lp.gotoHomePage();
		System.out.println("Successfully Home Page is  displayed");
	}
	
	
	@Test
	// search the item "Pants" and add to the cart
	public void addtocartitem()
	{
		//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
		System.out.println("test Passed");
		lp = fpa.clickonSignin();
		System.out.println("tEst passed");
	    hp =lp.gotoHomePage();
		pp = hp.gotoProductpage();
		pop = pp.gotoProductOverviewPage();
	    addtocartpage = pop.gotoAddtocartpage();
		addtocartpage.signout();
	}
	
	@Test
		// click on the "Digital Orders" tab via Orders tab in FirstPageOfAmazon
		public void ordersview()
		{
			//FirstPageofAmazon fpa = PageFactory.initElements(driver, FirstPageofAmazon.class);
			System.out.println("First Page of Amazon is displayed");
			//fpa.clickonOrders();
			lp = fpa.clickonOrders();
			System.out.println("The Login Page is displayed");
			order = lp.gotoOrdersPage();
			order.clickonDigitalOrders();
			System.out.println("DigitalOrder test case is executed");
			
		}

	 public void errorEmailMessageVerification(WebElement error, String errorMessage)
	    {
	        Assert.assertTrue("Error message is not displayed while trying to login without email id", error.isDisplayed());
	        System.out.println("Error message is displayed while trying to login without email id");
	        
	        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your email or mobile phone number", errorMessage);
	        System.out.println("Verified the expected error messaeg in UI for Email");
	        
	    }
	    
	    public void errorPasswordMessageVerification(WebElement error, String errorMessage)
	    {
	        Assert.assertTrue("Error message is not displayed while trying to login without password", error.isDisplayed());
	        System.out.println("Error message is displayed while trying to login without password");
	        
	        Assert.assertEquals("Mismatch in error messages displayed in ui and expected","Enter your password", errorMessage);
	        System.out.println("Verified the expected error messaeg in UI for Password");
	        
	    }

//
	@After
	//Closing the browser
	public void teardouwn()
	{
		driver.quit();
	}
	}
	


