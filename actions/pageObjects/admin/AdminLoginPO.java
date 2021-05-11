package pageObjects.admin;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageUIs.WishlistPUI;
import pageUIs.admin.AdminLoginPUI;

public class AdminLoginPO extends AbstractPage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminHomePO clickOnLoginButton() {
        waitForElementClickable(driver, AdminLoginPUI.LOGIN_BUTTON);
        clickOnElement(driver, AdminLoginPUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminHomePage(driver);
    }
}
