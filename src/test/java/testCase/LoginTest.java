package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login;
import pages.ProductPage;

public class LoginTest {
    private WebDriver driver;
    private Login loginPage;
    private ProductPage productPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Lenovo//Desktop//chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new Login(driver);
        productPage = new ProductPage(driver);
        
    }

    @Test
    public void loginAndAddToCartTest() {
    	loginPage.login("standard_user", "secret_sauce");
        productPage.clickAddToCartButton(0);
        productPage.clickShoppingCartBadge();
        // Add your verification code here
    }

    @Test
    public void loginWithoutPassword() {
    	loginPage.loginwithoutPassword("standard_user");
    	boolean avail = loginPage.errorState();
        Assert.assertTrue(avail);
    }

    @Test
    public void verifyTitleForLogin() {
        String actual = loginPage.verifyTitle();
        String expected = "Swag Labs";
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}






	

