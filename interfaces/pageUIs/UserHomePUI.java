package pageUIs;

public class UserHomePUI {
    public static final String REGISTER_LINK = "//a[@class='ico-register']";

    public static final String TITLE_OF_FIRST_PRODUCT_IN_FEATURED_LIST = "(//h2[@class='product-title'])[1]/a";
    public static final String PRODUCT_TITLE_IN_FEATURE_LIST = "//h2[@class='product-title']";

    public static final String DYNAMIC_TITLE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX = "(//h2[@class='product-title'])[%s]/a";
    public static final String DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_IN_FEATURED_LIST_BY_PRODUCT_INDEX = "(//div[@class='product-grid home-page-product-grid']//button[@title='Add to compare list'])[%s]";
    public static final String DYNAMIC_PRICE_OF_PRODUCT_IN_FEATURED_LIST_BY_PRODUCT_INDEX = "(//strong[text()='Featured products']/ancestor::div[@class='product-grid home-page-product-grid']//div[@class='product-item']//div[@class='prices']/span)[%s]";
}
