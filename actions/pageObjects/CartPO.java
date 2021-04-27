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
}
