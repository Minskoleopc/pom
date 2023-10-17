package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.ProductPage;
import utilities.Utils;

public class ProductTest {

	private WebDriver driver;
	private Login loginPage;
	private ProductPage productPage;
	private Utils utils;
	
	 @BeforeTest
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "C://Users//Lenovo//Desktop//chromedriver//chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/v1/");
	        loginPage = new Login(driver);
	        productPage = new ProductPage(driver);
	        loginPage.login("standard_user", "secret_sauce");
	        utils = new Utils(driver);
	        
	    }
	 @Test
	 public void VerifyTitleforProduct() {
		 boolean result = utils.verifyTitle(driver, "Swag Labs");
		 Assert.assertTrue(result);
	 }
	 
	 
	 
	 @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }

}
