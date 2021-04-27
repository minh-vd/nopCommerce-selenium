package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.UserRegisterResultPUI;
import pageUIs.WishlistPUI;

public class WishlistPO extends AbstractPage {
    WebDriver driver;

    public WishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddedProductDisplayed(String productName) {
        waitForElementVisible(driver, WishlistPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
        return isElementDisplayed(driver, WishlistPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
    }

    public void clickOnWishlistUrlForSharing() {
        waitForElementClickable(driver, WishlistPUI.SHARE_LINK);
        clickOnElement(driver, WishlistPUI.SHARE_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getWishlistTitle() {
        waitForElementVisible(driver, WishlistPUI.WISH_LIST_TITLE);
        return getElementText(driver, WishlistPUI.WISH_LIST_TITLE);
    }

    public void checkOnCheckboxAddToCartByProductName(String productName) {
        waitForElementVisible(driver, WishlistPUI.DYNAMIC_CHECKBOX_ADD_TO_CART_BY_PRODUCT_NAME, productName);
        checkOnCheckbox(driver, WishlistPUI.DYNAMIC_CHECKBOX_ADD_TO_CART_BY_PRODUCT_NAME, productName);
    }

    public CartPO clickOnAddToCartButton() {
        waitForElementClickable(driver, WishlistPUI.ADD_TO_CART_BUTTON);
        clickOnElement(driver, WishlistPUI.ADD_TO_CART_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getCartPage(driver);
    }

    public boolean isAddedProductNotDisplayed(String productName) {
        waitForElementInvisible(driver, WishlistPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
        return isElementNotDisplayed(driver, WishlistPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
    }

    public void clickOnRemoveIconByProductName(String productName) {
        waitForElementClickable(driver, WishlistPUI.DYNAMIC_REMOVE_ICON_BY_PRODUCT_NAME, productName);
        clickOnElement(driver, WishlistPUI.DYNAMIC_REMOVE_ICON_BY_PRODUCT_NAME, productName);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getTextOfNoDataMessage() {
        waitForElementVisible(driver, WishlistPUI.NO_DATA_MESSAGE);
        return getElementText(driver, WishlistPUI.NO_DATA_MESSAGE);
    }
}
