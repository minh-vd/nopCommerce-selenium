package pageUIs;

public class RecentlyViewedProductsPUI {
    public static final String PRODUCT_TITLE_LIST = "//h2[@class='product-title']/a";

    // Dynamic Locator
    public static final String DYNAMIC_PRODUCT_TITLE_BY_PRODUCT_INDEX = "(//h2[@class='product-title']/a)[%s]";
    public static final String DYNAMIC_PRODUCT_TITLE = "//h2[@class='product-title']/a[text()='%s']";
}
