package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.AbstractPageUI;
import pageUIs.ProductListPUI;
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


    public ProductDetailPO clickOnTitleOfDynamicProductInFeaturedListByIndex(String indexNumber) {
        waitForElementVisible(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, indexNumber);
        scrollToElementUsingJS(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, indexNumber);
        waitForElementClickable(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, indexNumber);
        clickOnElement(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, indexNumber);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public ProductDetailPO clickOnRandomProductTitleInFeaturedList() {
        String randomIndex = Integer.toString(getRandomIntegerNumber(4));
        waitForElementVisible(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, randomIndex);
        scrollToElementUsingJS(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, randomIndex);
        waitForElementClickable(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, randomIndex);
        clickOnElement(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST, randomIndex);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }
}
