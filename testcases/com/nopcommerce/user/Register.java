package com.nopcommerce.user;

//import com.nopcommerce.common.Common_01_Register_User;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Register extends AbstractTest {
    WebDriver driver;

    UserHomePO homePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        log.info("Login - Step: Open Home Page");
        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void TC_01_Register() {
        System.out.println("Test Case 01");
    }

    @Test
    public void TC_02_Login() {
        System.out.println("Test Case 02");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
