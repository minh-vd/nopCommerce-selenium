package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.CartPUI;
import pageUIs.WishlistPUI;

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
}
