package pageUIs;

public class ProductDetailPUI {
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']/button";
    public static final String PRODUCT_NAME_TEXT = "//div[@class='product-name']/h1";
    public static final String SELECT_PROCESSOR_DROPDOWN = "(//label[text()=' Processor ']/parent::dt/following-sibling::dd)[1]/select";
    public static final String SELECT_RAM_DROPDOWN = "(//label[text()=' RAM ']/parent::dt/following-sibling::dd)[1]/select";
    public static final String ADD_TO_CART_BUTTON = "//button[text()='Add to cart']";

    // Dynamic Locator
    public static final String DYNAMIC_CHECKBOX_BY_GROUP_LABEL_AND_TEXT = "(//label[text()=' %s ']/parent::dt/following-sibling::dd)[1]//label[text()='%s']/preceding-sibling::input";
}
