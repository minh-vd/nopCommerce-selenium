package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.CartPUI;

public class CartPO extends AbstractPage {
    WebDriver driver;

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddedProductDisplayed(String productName) {
        waitForElementVisible(driver, CartPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
        return isElementDisplayed(driver, CartPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
    }

    public ProductDetailPO clickOnDynamicEditLinkByProductName(String productName) {
        waitForElementClickable(driver, CartPUI.DYNAMIC_EDIT_LINK_BY_PRODUCT_NAME, productName);
        clickOnElement(driver, CartPUI.DYNAMIC_EDIT_LINK_BY_PRODUCT_NAME, productName);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public void clickOnDynamicRemoveIconByProductName(String productName) {
        waitForElementClickable(driver, CartPUI.DYNAMIC_REMOVE_ICON_BY_PRODUCT_NAME, productName);
        clickOnElement(driver, CartPUI.DYNAMIC_REMOVE_ICON_BY_PRODUCT_NAME, productName);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getNoDataMessage() {
        waitForElementVisible(driver, CartPUI.NO_PRODUCT_IN_CART_MESSAGE);
        return getElementText(driver, CartPUI.NO_PRODUCT_IN_CART_MESSAGE).trim();
    }

    public boolean isAddedProductNotDisplayed(String productName) {
        waitForElementInvisible(driver, CartPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
        return isElementNotDisplayed(driver, CartPUI.DYNAMIC_PRODUCT_NAME_IN_LIST, productName);
    }

    public void inputIntoDynamicQuantityTextBoxByProductName(String productName, String inputData) {
        waitForElementVisible(driver, CartPUI.DYNAMIC_INPUT_QUANTITY_TEXT_BOX_BY_PRODUCT_NAME, productName);
        sendKeysToElement(driver, CartPUI.DYNAMIC_INPUT_QUANTITY_TEXT_BOX_BY_PRODUCT_NAME, inputData, productName);
    }

    public void clickOnUpdateShoppingCartButton() {
        waitForElementClickable(driver, CartPUI.UPDATE_SHOPPING_CART_BUTTON);
        clickOnElement(driver, CartPUI.UPDATE_SHOPPING_CART_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getProductSubtotalPriceByName(String productName) {
        waitForElementVisible(driver, CartPUI.DYNAMIC_PRODUCT_SUBTOTAL_PRICE_BY_NAME, productName);
        return getElementText(driver, CartPUI.DYNAMIC_PRODUCT_SUBTOTAL_PRICE_BY_NAME, productName);
    }
}
