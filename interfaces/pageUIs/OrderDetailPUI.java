package pageUIs;

public class OrderDetailPUI {
    // Dynamic Locator
    public static final String DYNAMIC_BILLING_ADDRESS_INFO_FIELD_BY_CLASS_NAME = "//div[@class='billing-info']/ul[@class='info-list']/li[@class='%s']";
    public static final String DYNAMIC_SHIPPING_ADDRESS_INFO_FIELD_BY_CLASS_NAME = "//div[@class='shipping-info']/ul[@class='info-list']/li[@class='%s']";
    public static final String CONFIRM_ORDER_STEP_DYNAMIC_PRODUCT_DETAIL = "//span[@class='sku-number' and text()='%s']/parent::td/following-sibling::td[@class='product']//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td/span[@class='product-unit-price' and text()='%s']/parent::td/following-sibling::td/span[@class='product-quantity' and text()='%s']/parent::td/following-sibling::td/span[@class='product-subtotal' and text()='%s']";

    public static final String ORDER_NUMBER = "//div[@class='order-number']/strong";
    public static final String ORDER_DATE = "//li[@class='order-date']";
    public static final String ORDER_STATUS = "//li[@class='order-status']";
    public static final String ORDER_TOTAL = "//li[@class='order-total']/strong";
    public static final String PAYMENT_METHOD = "//li[@class='payment-method']/span[@class='value']";
    public static final String SHIPPING_METHOD = "//li[@class='shipping-method']/span[@class='value']";
    public static final String GIFT_WRAPPING_OPTION = "//div[@class='selected-checkout-attributes']";
    public static final String CART_SUB_TOTAL_PRICE = "//label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
    public static final String CART_SHIPPING_FEE = "//label[text()='Shipping:']/parent::td/following-sibling::td/span";
    public static final String CART_TAX_PRICE = "//label[text()='Tax:']/parent::td/following-sibling::td/span";
    public static final String CART_TOTAL_PRICE = "//label[text()='Order Total:']/parent::td/following-sibling::td/span/strong";
}
