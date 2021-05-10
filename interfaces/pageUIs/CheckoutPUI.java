package pageUIs;

public class CheckoutPUI {
    // Dynamic Locator

    // Billing Address Step
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";
    public static final String SELECT_BILLING_ADDRESS_DROPDOWN = "//select[@id='billing-address-select']";
    public static final String NEW_BILLING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String NEW_BILLING_ADDRESS_STEP_SELECT_STATE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
    public static final String BILLING_ADDRESS_STEP_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']/button[text()='Continue']";

    // Shipping Address Step
    public static final String SELECT_SHIPPING_ADDRESS_DROPDOWN = "//select[@id='shipping-address-select']";
    public static final String NEW_SHIPPING_ADDRESS_STEP_SELECT_COUNTRY_DROPDOWN = "//select[@id='ShippingNewAddress_CountryId']";
    public static final String NEW_SHIPPING_ADDRESS_STEP_SELECT_STATE_DROPDOWN = "//select[@id='ShippingNewAddress_StateProvinceId']";
    public static final String SHIPPING_ADDRESS_STEP_CONTINUE_BUTTON = "//div[@id='shipping-buttons-container']/button[text()='Continue']";

    // Shipping Method Step
    public static final String SHIPPING_METHOD_STEP_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']/button[text()='Continue']";
    public static final String DYNAMIC_SHIPPING_METHOD_CHECKBOX_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";

    // Payment Method Step
    public static final String PAYMENT_METHOD_STEP_CONTINUE_BUTTON = "//div[@id='payment-method-buttons-container']/button[text()='Continue']";
    public static final String PAYMENT_METHOD_STEP_DYNAMIC_PAYMENT_METHOD_CHECKBOX_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";

    // Payment Info Step
    public static final String PAYMENT_INFO_STEP_CONTINUE_BUTTON = "//div[@id='payment-info-buttons-container']/button[text()='Continue']";
    public static final String PAYMENT_INFO_STEP_SELECT_CREDIT_CARD_DROPDOWN = "//select[@id='CreditCardType']";
    public static final String PAYMENT_INFO_STEP_SELECT_EXPIRE_YEAR_DROPDOWN = "//select[@id='ExpireYear']";

    // Confirm Order Step
    public static final String CONFIRM_ORDER_STEP_DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME = "//div[@class='billing-info']/ul[@class='info-list']/li[@class='%s']";
    public static final String CONFIRM_ORDER_STEP_DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME = "//div[@class='shipping-info']/ul[@class='info-list']/li[@class='%s']";
    public static final String CONFIRM_ORDER_STEP_PAYMENT_INFO_TEXT = "//div[@class='payment-method-info']//li[@class='payment-method']/span[@class='value']";
    public static final String CONFIRM_ORDER_STEP_SHIPPING_METHOD_INFO_TEXT = "//div[@class='shipping-method-info']//li[@class='shipping-method']/span[@class='value']";
    public static final String CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL = "//span[@class='sku-number' and text()='%s']/parent::td/following-sibling::td/a[@class='product-name' and text()='%s']/parent::td/following-sibling::td/span[@class='product-unit-price' and text()='%s']/parent::td/following-sibling::td/span[@class='product-quantity' and text()='%s']/parent::td/following-sibling::td/span[@class='product-subtotal' and text()='%s']";
    public static final String CONFIRM_ORDER_STEP_GIFT_WRAPPING_OPTION_TEXT = "//div[@class='selected-checkout-attributes']";
    public static final String CONFIRM_ORDER_STEP_ORDER_SUB_TOTAL_PRICE_TEXT = "//tr[@class='order-subtotal']//span[@class='value-summary']";
    public static final String CONFIRM_ORDER_STEP_ORDER_SHIPPING_COST_TEXT = "//tr[@class='shipping-cost']//span[@class='value-summary']";
    public static final String CONFIRM_ORDER_STEP_ORDER_TAX_VALUE_TEXT = "//tr[@class='tax-value']//span[@class='value-summary']";
    public static final String CONFIRM_ORDER_STEP_ORDER_TOTAL_PRICE_TEXT = "//tr[@class='order-total']//span[@class='value-summary']/strong";
    public static final String CONFIRM_ORDER_STEP_CONFIRM_BUTTON = "//div[@id='confirm-order-buttons-container']/button[text()='Confirm']";

    // Thank You Page
    public static final String THANK_YOU_MESSAGE = "//div[@class='section order-completed']/div[@class='title']/strong";
    public static final String THANK_YOU_PAGE_ORDER_NUMBER = "//div[@class='order-number']/strong";
}
