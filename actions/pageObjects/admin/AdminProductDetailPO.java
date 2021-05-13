package pageObjects.admin;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminProductDetailPUI;
import pageUIs.admin.AdminProductListPUI;

public class AdminProductDetailPO extends AbstractPage {
    WebDriver driver;

    public AdminProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        waitForElementVisible(driver, AdminProductDetailPUI.PRODUCT_NAME_TEXT_BOX);
        return getElementAttributeValue(driver, AdminProductDetailPUI.PRODUCT_NAME_TEXT_BOX, "value");
    }
}
