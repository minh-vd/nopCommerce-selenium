package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckoutPUI;
import pageUIs.OrderDetailPUI;

public class OrderDetailPO extends AbstractPage {
    WebDriver driver;

    public OrderDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderNumber() {
        waitForElementVisible(driver, OrderDetailPUI.ORDER_NUMBER);
        return getElementText(driver, OrderDetailPUI.ORDER_NUMBER).replace("ORDER #", "");
    }

    public String getOrderDate() {
        waitForElementVisible(driver, OrderDetailPUI.ORDER_DATE);
        return getElementText(driver, OrderDetailPUI.ORDER_DATE).replace("Order Date: ", "");
    }

    public String getOrderStatus() {
        waitForElementVisible(driver, OrderDetailPUI.ORDER_STATUS);
        return getElementText(driver, OrderDetailPUI.ORDER_STATUS).replace("Order Status: ", "");
    }

    public String getOrderTotal() {
        waitForElementVisible(driver, OrderDetailPUI.ORDER_TOTAL);
        return getElementText(driver, OrderDetailPUI.ORDER_TOTAL);
    }

    public String getTextOfDynamicBillingAddressInfoFieldByClass(String className) {
        waitForElementVisible(driver, OrderDetailPUI.DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
        return getElementText(driver, OrderDetailPUI.DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
    }

    public String getPaymentMethod() {
        waitForElementVisible(driver, OrderDetailPUI.PAYMENT_METHOD);
        return getElementText(driver, OrderDetailPUI.PAYMENT_METHOD).trim();
    }

    public String getTextOfDynamicShippingAddressInfoFieldByClass(String className) {
        waitForElementVisible(driver, OrderDetailPUI.DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
        return getElementText(driver, OrderDetailPUI.DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
    }

    public String getShippingMethod() {
        waitForElementVisible(driver, OrderDetailPUI.SHIPPING_METHOD);
        return getElementText(driver, OrderDetailPUI.SHIPPING_METHOD).trim();
    }

    public boolean isProductDisplayed(String productSku, String productName, String productPrice, String productQuantity, String productSubTotalPrice) {
        waitForElementVisible(driver, OrderDetailPUI.CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL, productSku, productName, productPrice, productQuantity, productSubTotalPrice);
        return isElementDisplayed(driver, OrderDetailPUI.CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL, productSku, productName, productPrice, productQuantity, productSubTotalPrice);
    }

    public String getGiftWrappingOption() {
        waitForElementVisible(driver, OrderDetailPUI.GIFT_WRAPPING_OPTION);
        return getElementText(driver, OrderDetailPUI.GIFT_WRAPPING_OPTION).replace("Gift wrapping: ", "");
    }

    public String getSubTotalPrice() {
        waitForElementVisible(driver, OrderDetailPUI.CART_SUB_TOTAL_PRICE);
        return getElementText(driver, OrderDetailPUI.CART_SUB_TOTAL_PRICE);
    }

    public String getShippingFee() {
        waitForElementVisible(driver, OrderDetailPUI.CART_SHIPPING_FEE);
        return getElementText(driver, OrderDetailPUI.CART_SHIPPING_FEE);
    }

    public String getTaxPrice() {
        waitForElementVisible(driver, OrderDetailPUI.CART_TAX_PRICE);
        return getElementText(driver, OrderDetailPUI.CART_TAX_PRICE);
    }

    public String getTotalPrice() {
        waitForElementVisible(driver, OrderDetailPUI.CART_TOTAL_PRICE);
        return getElementText(driver, OrderDetailPUI.CART_TOTAL_PRICE);
    }

    public CartPO clickOnReorderButton() {
        waitForElementClickable(driver, OrderDetailPUI.REORDER_BUTTON);
        clickOnElement(driver, OrderDetailPUI.REORDER_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getCartPage(driver);
    }
}
