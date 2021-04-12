package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;
import pageUIs.UserLoginPUI;

public class UserLoginPO extends AbstractPage {
    WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginButton() {
        waitForElementClickable(driver, UserLoginPUI.LOGIN_BUTTON);
        clickOnElement(driver, UserLoginPUI.LOGIN_BUTTON);
    }

    public String getTextOfEmailErrorMessage() {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPUI.EMAIL_ERROR_MESSAGE);
    }
}
