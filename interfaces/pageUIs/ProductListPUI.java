package pageUIs;

public class ProductListPUI {
    public static final String SELECT_SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String PRODUCT_TITLE_IN_LIST = "//h2[@class='product-title']/a";
    public static final String PRODUCT_PRICE_IN_LIST = "//div[@class='prices']/span";
    public static final String SELECT_PRODUCT_PAGE_SIZE_DROPDOWN = "//select[@id='products-pagesize']";
    public static final String NEXT_PAGE_ICON = "//li[@class='next-page']";
    public static final String PREVIOUS_PAGE_ICON = "//li[@class='previous-page']";
    public static final String PAGING_SECTION = "//div[@class='pager']";

    // Dynamic Locator
    public static final String DYNAMIC_PRODUCT_TITLE_BY_INDEX = "(//h2[@class='product-title']/a)[%s]";
    public static final String DYNAMIC_PRODUCT_TITLE_BY_PRODUCT_NAME = "//h2[@class='product-title']/a[text()='%s']";
}
