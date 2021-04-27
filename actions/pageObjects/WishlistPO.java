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
}
