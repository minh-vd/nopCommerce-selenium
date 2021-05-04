package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductsPUI;
import pageUIs.WishlistPUI;

public class CompareProductsPO extends AbstractPage {
    WebDriver driver;

    public CompareProductsPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRemoveProductIconDisplayedByNameAndPrice(String productName, String productPrice) {
        int columnIndex = getElementSize(driver, CompareProductsPUI.DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME, productName) + 1;
        waitForElementVisible(driver, CompareProductsPUI.DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME_PRODUCT_PRICE_COLUMN_INDEX, productName, productPrice, Integer.toString(columnIndex));
        return isElementDisplayed(driver, CompareProductsPUI.DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME_PRODUCT_PRICE_COLUMN_INDEX, productName, productPrice, Integer.toString(columnIndex));
    }

    public boolean isClearListButtonDisplayed() {
        waitForElementVisible(driver, CompareProductsPUI.CLEAR_LIST_BUTTON);
        return isElementDisplayed(driver, CompareProductsPUI.CLEAR_LIST_BUTTON);
    }

    public void clickOnClearListButton() {
        waitForElementClickable(driver, CompareProductsPUI.CLEAR_LIST_BUTTON);
        clickOnElement(driver, CompareProductsPUI.CLEAR_LIST_BUTTON);
    }

    public String getTextOfNoDataMessage() {
        waitForElementVisible(driver, CompareProductsPUI.NO_DATA_MESSAGE);
        return getElementText(driver, CompareProductsPUI.NO_DATA_MESSAGE);
    }

    public boolean isProductNotDisplayedByNameAndPrice(String productName, String productPrice) {
        waitForElementInvisible(driver, CompareProductsPUI.DYNAMIC_PRODUCT_BY_PRODUCT_NAME_AND_PRODUCT_PRICE, productName, productPrice);
        return isElementNotDisplayed(driver, CompareProductsPUI.DYNAMIC_PRODUCT_BY_PRODUCT_NAME_AND_PRODUCT_PRICE, productName, productPrice);
    }
}
