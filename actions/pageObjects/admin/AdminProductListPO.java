package pageObjects.admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageUIs.admin.AdminLoginPUI;

public class AdminProductListPO extends AbstractPage {
    WebDriver driver;

    public AdminProductListPO(WebDriver driver) {
        this.driver = driver;
    }
}
