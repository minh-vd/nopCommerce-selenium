package pageObjects.admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginPUI;

public class AdminHomePO extends AbstractPage {
    WebDriver driver;

    public AdminHomePO(WebDriver driver) {
        this.driver = driver;
    }


}
