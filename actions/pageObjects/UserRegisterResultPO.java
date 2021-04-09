package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserRegisterPageUI;
import pageUIs.UserRegisterResultPUI;

public class UserRegisterResultPO extends AbstractPage {
    WebDriver driver;

    public UserRegisterResultPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterResultText() {
        waitForElementVisible(driver, UserRegisterResultPUI.REGISTER_RESULT_TEXT);
        return getElementText(driver, UserRegisterResultPUI.REGISTER_RESULT_TEXT);
    }
}
