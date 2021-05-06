package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.WishlistPUI;

public class CheckoutPO extends AbstractPage {
    WebDriver driver;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }
}
