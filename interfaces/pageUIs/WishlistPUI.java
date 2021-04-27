package pageUIs;

public class WishlistPUI {
    // Dynamic Locator
    public static final String DYNAMIC_PRODUCT_NAME_IN_LIST = "//a[@class='product-name' and text()='%s']";
    public static final String DYNAMIC_CHECKBOX_ADD_TO_CART_BY_PRODUCT_NAME = "//a[@class='product-name' and text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']/input";

    public static final String SHARE_LINK = "//a[@class='share-link']";
    public static final String WISH_LIST_TITLE = "//div[@class='page-title']/h1";
    public static final String ADD_TO_CART_BUTTON = "//button[@name='addtocartbutton']";
}
