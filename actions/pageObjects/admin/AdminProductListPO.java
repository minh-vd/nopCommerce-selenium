package pageObjects.admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageUIs.admin.AdminLoginPUI;
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
}
