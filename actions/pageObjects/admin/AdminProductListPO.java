package pageObjects.admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminProductListPUI;

public class AdminProductListPO extends AbstractPage {
    WebDriver driver;

    public AdminProductListPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        waitForElementClickable(driver, AdminProductListPUI.SEARCH_PRODUCT_BUTTON);
        clickOnElement(driver, AdminProductListPUI.SEARCH_PRODUCT_BUTTON);
        waitForPageOfAdminPortalFinishedLoading(driver);
    }

    public boolean isSearchedProductDisplayed(String productName, String productSku, String productPrice, String productStockQuantity, String publishedStatus) {
        waitForElementVisible(driver, AdminProductListPUI.DYNAMIC_SEARCHED_PRODUCT_IN_LIST, productName, productSku, productPrice, productStockQuantity, publishedStatus);
        return isElementDisplayed(driver, AdminProductListPUI.DYNAMIC_SEARCHED_PRODUCT_IN_LIST, productName, productSku, productPrice, productStockQuantity, publishedStatus);
    }

    public void selectCategory(String category) {
        waitForElementVisible(driver, AdminProductListPUI.SELECT_CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminProductListPUI.SELECT_CATEGORY_DROPDOWN, category);
    }

    public void uncheckSearchSubcategoriesCheckbox() {
        waitForElementVisible(driver, AdminProductListPUI.SEARCH_INCLUDE_SUB_CATEGORIES_CHECKBOX);
        uncheckCheckbox(driver, AdminProductListPUI.SEARCH_INCLUDE_SUB_CATEGORIES_CHECKBOX);
    }

    public String getNoDataMessage() {
        waitForElementVisible(driver, AdminProductListPUI.TABLE_NO_DATA_MESSAGE);
        return getElementText(driver, AdminProductListPUI.TABLE_NO_DATA_MESSAGE);
    }

    public void checkOnSearchSubcategoriesCheckbox() {
        waitForElementVisible(driver, AdminProductListPUI.SEARCH_INCLUDE_SUB_CATEGORIES_CHECKBOX);
        checkOnCheckbox(driver, AdminProductListPUI.SEARCH_INCLUDE_SUB_CATEGORIES_CHECKBOX);
    }

    public void selectManufacturer(String manufacturer) {
        waitForElementVisible(driver, AdminProductListPUI.SELECT_MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminProductListPUI.SELECT_MANUFACTURER_DROPDOWN, manufacturer);
    }
}
