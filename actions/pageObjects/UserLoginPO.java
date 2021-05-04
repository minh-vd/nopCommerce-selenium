package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.UserLoginPUI;

public class UserLoginPO extends AbstractPage {
    WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePO clickOnLoginButton() {
        waitForElementClickable(driver, UserLoginPUI.LOGIN_BUTTON);
        clickOnElement(driver, UserLoginPUI.LOGIN_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getTextOfEmailErrorMessage() {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputIntoEmailField(String inputData) {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_TEXT_BOX);
        sendKeysToElement(driver,UserLoginPUI.EMAIL_TEXT_BOX, inputData);
    }

    public String getTextOfLoginValidationErrorMessage() {
        waitForElementVisible(driver, UserLoginPUI.UNREGISTERED_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPUI.UNREGISTERED_EMAIL_ERROR_MESSAGE).replace("\n", " ");
    }

    public void inputIntoPasswordField(String inputData) {
        waitForElementVisible(driver, UserLoginPUI.PASSWORD_TEXT_BOX);
        sendKeysToElement(driver, UserLoginPUI.PASSWORD_TEXT_BOX, inputData);
    }
}
