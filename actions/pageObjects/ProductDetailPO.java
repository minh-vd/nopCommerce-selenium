package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewPO clickOnAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        clickOnElement(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductReviewPage(driver);
    }

    public void clickOnAddToWishlistButton() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_TO_WISHLIST_BUTTON);
        clickOnElement(driver, ProductDetailPUI.ADD_TO_WISHLIST_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getProductName() {
        waitForElementVisible(driver, ProductDetailPUI.PRODUCT_NAME_TEXT);
        return getElementText(driver, ProductDetailPUI.PRODUCT_NAME_TEXT);
    }

    public void selectProcessor(String option) {
        waitForElementVisible(driver, ProductDetailPUI.SELECT_PROCESSOR_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductDetailPUI.SELECT_PROCESSOR_DROPDOWN, option);
    }

    public void selectRam(String option) {
        waitForElementVisible(driver, ProductDetailPUI.SELECT_RAM_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductDetailPUI.SELECT_RAM_DROPDOWN, option);
    }

    public void checkOnDynamicCheckboxByGroupLabelAndText(String groupLabel, String option) {
        waitForElementVisible(driver, ProductDetailPUI.DYNAMIC_CHECKBOX_BY_GROUP_LABEL_AND_TEXT, groupLabel, option);
        checkOnCheckbox(driver, ProductDetailPUI.DYNAMIC_CHECKBOX_BY_GROUP_LABEL_AND_TEXT, groupLabel, option);
    }

    public void clickOnAddToCartButton() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_TO_CART_BUTTON);
        clickOnElement(driver, ProductDetailPUI.ADD_TO_CART_BUTTON);
    }

    public void uncheckOnDynamicCheckboxByGroupLabelAndText(String groupLabel, String option) {
        waitForElementVisible(driver, ProductDetailPUI.DYNAMIC_CHECKBOX_BY_GROUP_LABEL_AND_TEXT, groupLabel, option);
        uncheckCheckbox(driver, ProductDetailPUI.DYNAMIC_CHECKBOX_BY_GROUP_LABEL_AND_TEXT, groupLabel, option);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void inputIntoQuantityTextBox(String inputData) {
        waitForElementVisible(driver, ProductDetailPUI.INPUT_QUANTITY_TEXT_BOX);
        sendKeysToElement(driver, ProductDetailPUI.INPUT_QUANTITY_TEXT_BOX, inputData);
    }

    public String getProductPrice() {
        waitForElementVisible(driver, ProductDetailPUI.PRODUCT_PRICE_TEXT);
        return getElementText(driver, ProductDetailPUI.PRODUCT_PRICE_TEXT);
    }

    public void clickOnUpdateButton() {
        waitForElementClickable(driver, ProductDetailPUI.UPDATE_TO_CART_BUTTON);
        clickOnElement(driver, ProductDetailPUI.UPDATE_TO_CART_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }
}
