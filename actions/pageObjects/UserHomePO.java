package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.AbstractPageUI;
import pageUIs.UserHomePUI;

public class UserHomePO extends AbstractPage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickOnRegisterLink() {
        waitForElementClickable(driver, UserHomePUI.REGISTER_LINK);
        clickOnElement(driver, UserHomePUI.REGISTER_LINK);
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


    public ProductDetailPO clickOnTitleOfFirstProductInFeaturedList() {
        scrollToElementUsingJS(driver, UserHomePUI.TITLE_OF_FIRST_PRODUCT_IN_FEATURED_LIST);
        waitForElementClickable(driver, UserHomePUI.TITLE_OF_FIRST_PRODUCT_IN_FEATURED_LIST);
        clickOnElement(driver, UserHomePUI.TITLE_OF_FIRST_PRODUCT_IN_FEATURED_LIST);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }
}
