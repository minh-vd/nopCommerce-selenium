package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckoutPUI;

public class CheckoutPO extends AbstractPage {
    WebDriver driver;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void uncheckOnShipToSameAddressOption() {
        waitForElementVisible(driver, CheckoutPUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        uncheckCheckbox(driver, CheckoutPUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void selectBillingCountry(String billingCountry) {
        waitForElementVisible(driver, CheckoutPUI.NEW_BILLING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPUI.NEW_BILLING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN, billingCountry);
    }

    public void selectBillingState(String billingState) {
        waitForElementVisible(driver, CheckoutPUI.NEW_BILLING_ADDRESS_STEP_SELECT_STATE_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPUI.NEW_BILLING_ADDRESS_STEP_SELECT_STATE_DROPDOWN, billingState);
    }

    public void clickOnBillingAddressStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.BILLING_ADDRESS_STEP_CONTINUE_BUTTON);
        clickOnElement(driver, CheckoutPUI.BILLING_ADDRESS_STEP_CONTINUE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void selectShippingAddressOption(String option) {
        waitForElementVisible(driver, CheckoutPUI.SELECT_SHIPPING_ADDRESS_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPUI.SELECT_SHIPPING_ADDRESS_DROPDOWN, option);
    }

    public void selectShippingCountry(String shippingCountry) {
        waitForElementVisible(driver, CheckoutPUI.NEW_SHIPPING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPUI.NEW_SHIPPING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN, shippingCountry);
    }

    public void selectShippingState(String shippingState) {
        waitForElementVisible(driver, CheckoutPUI.NEW_SHIPPING_ADDRESS_STEP_SELECT_STATE_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPUI.NEW_BILLING_ADDRESS_STEP_SELECT_STATE_DROPDOWN, shippingState);
    }

    public void clickOnShippingAddressStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.SHIPPING_ADDRESS_STEP_CONTINUE_BUTTON);
        clickOnElement(driver, CheckoutPUI.SHIPPING_ADDRESS_STEP_CONTINUE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnShippingMethodStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.SHIPPING_METHOD_STEP_CONTINUE_BUTTON);
        clickOnElement(driver, CheckoutPUI.SHIPPING_METHOD_STEP_CONTINUE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnPaymentMethodStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.PAYMENT_METHOD_STEP_CONTINUE_BUTTON);
        clickOnElement(driver, CheckoutPUI.PAYMENT_METHOD_STEP_CONTINUE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnPaymentInformationStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.PAYMENT_INFO_STEP_CONTINUE_BUTTON);
        clickOnElement(driver, CheckoutPUI.PAYMENT_INFO_STEP_CONTINUE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getTextOfDynamicBillingAddressInfoFieldByClass(String className) {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className).trim();
    }

    public String getConfirmOrderStepPaymentMethod() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_PAYMENT_INFO_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_PAYMENT_INFO_TEXT).trim();
    }

    public String getTextOfDynamicShippingAddressInfoFieldByClass(String className) {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME, className).trim();
    }

    public String getConfirmOrderStepShippingMethod() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_SHIPPING_METHOD_INFO_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_SHIPPING_METHOD_INFO_TEXT).trim();
    }

    public boolean isProductDisplayed(String productSku, String productName, String productPrice, String productQuantity, String productSubTotalPrice) {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL, productSku, productName, productPrice, productQuantity, productSubTotalPrice);
        return isElementDisplayed(driver, CheckoutPUI.CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL, productSku, productName, productPrice, productQuantity, productSubTotalPrice);
    }

    public String getConfirmOrderStepGiftWrappingOption() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_GIFT_WRAPPING_OPTION_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_GIFT_WRAPPING_OPTION_TEXT).trim();
    }

    public String getConfirmOrderStepSubTotalPrice() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_SUB_TOTAL_PRICE_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_SUB_TOTAL_PRICE_TEXT);
    }

    public String getConfirmOrderStepShippingFee() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_SHIPPING_COST_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_SHIPPING_COST_TEXT);
    }

    public String getConfirmOrderStepTaxPrice() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_TAX_VALUE_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_TAX_VALUE_TEXT);
    }

    public String getConfirmOrderStepTotalPrice() {
        waitForElementVisible(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_TOTAL_PRICE_TEXT);
        return getElementText(driver, CheckoutPUI.CONFIRM_ORDER_STEP_ORDER_TOTAL_PRICE_TEXT);
    }

    public void clickOnConfirmOrderStepContinueButton() {
        waitForElementClickable(driver, CheckoutPUI.CONFIRM_ORDER_STEP_CONFIRM_BUTTON);
        clickOnElement(driver, CheckoutPUI.CONFIRM_ORDER_STEP_CONFIRM_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getThankYouPageSuccessMessage() {
        waitForElementVisible(driver, CheckoutPUI.THANK_YOU_MESSAGE);
        return getElementText(driver, CheckoutPUI.THANK_YOU_MESSAGE);
    }

    public boolean isOrderNumberDisplayed() {
        waitForElementVisible(driver, CheckoutPUI.THANK_YOU_PAGE_ORDER_NUMBER);
        return isElementDisplayed(driver, CheckoutPUI.THANK_YOU_PAGE_ORDER_NUMBER);
    }

    public String getOrderNumber() {
        waitForElementVisible(driver, CheckoutPUI.THANK_YOU_PAGE_ORDER_NUMBER);
        return getElementText(driver, CheckoutPUI.THANK_YOU_PAGE_ORDER_NUMBER).replace("ORDER NUMBER: ", "");
    }
}
