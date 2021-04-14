package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.AbstractPageUI;
import pageUIs.UserHomePageUI;

public class UserHomePO extends AbstractPage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickOnRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickOnElement(driver, UserHomePageUI.REGISTER_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPO clickOnLoginLink() {
        waitForElementClickable(driver, AbstractPageUI.LOGIN_LINK_AT_TOP_BAR);
        clickOnElement(driver, AbstractPageUI.LOGIN_LINK_AT_TOP_BAR);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
        return isElementDisplayed(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
    }

    public MyAccountPO clickOnMyAccountLink() {
        waitForElementClickable(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
        clickOnElement(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
