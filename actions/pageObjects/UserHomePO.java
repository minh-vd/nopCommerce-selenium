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


    public ProductDetailPO clickOnTitleOfDynamicProductInFeaturedListByIndex(String indexNumber) {
        scrollToElementUsingJS(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, indexNumber);
        waitForElementClickable(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, indexNumber);
        clickOnElement(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, indexNumber);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public ProductDetailPO clickOnRandomProductTitleInFeaturedList() {
        String randomIndex = Integer.toString(getRandomIntegerNumber(4));
        waitForElementVisible(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, randomIndex);
        scrollToElementUsingJS(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, randomIndex);
        waitForElementClickable(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, randomIndex);
        clickOnElement(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, randomIndex);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public void clickOnDynamicAddToCompareListByProductIndex(String productIndexNumber) {
        waitForElementClickable(driver, UserHomePUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
        scrollToElementUsingJS(driver, UserHomePUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
        clickOnElement(driver, UserHomePUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getDynamicTitleOfProductInFeaturedListByProductIndex(String productIndexNumber) {
        waitForElementVisible(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
        return getElementText(driver, UserHomePUI.DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
    }

    public String getDynamicPriceOfProductInFeaturedListByProductIndex(String productIndexNumber) {
        waitForElementVisible(driver, UserHomePUI.DYNAMIC_PRICE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
        return getElementText(driver, UserHomePUI.DYNAMIC_PRICE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX, productIndexNumber);
    }
}
