package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;

public class ProductListPO extends AbstractPage {
    WebDriver driver;

    public ProductListPO(WebDriver driver) {
        this.driver = driver;
    }
}
