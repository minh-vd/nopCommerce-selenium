package pageUIs;

public class CartPUI {
    public static final String DYNAMIC_PRODUCT_NAME_IN_LIST = "//a[@class='product-name' and text()='%s']";
    public static final String DYNAMIC_EDIT_LINK_BY_PRODUCT_NAME = "//a[@class='product-name' and text()='%s']/following-sibling::div[@class='edit-item']/a";
    public static final String DYNAMIC_REMOVE_ICON_BY_PRODUCT_NAME = "//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
    public static final String DYNAMIC_INPUT_QUANTITY_TEXT_BOX_BY_PRODUCT_NAME = "//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
    public static final String DYNAMIC_PRODUCT_SUBTOTAL_PRICE_BY_NAME = "//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='subtotal']/span";

    public static final String NO_PRODUCT_IN_CART_MESSAGE = "//div[@class='order-summary-content']/div[@class='no-data']";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[text()='Update shopping cart']";
}
