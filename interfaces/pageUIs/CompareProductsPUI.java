package pageUIs;

public class CompareProductsPUI {
    public static final String CLEAR_LIST_BUTTON = "//a[@class='clear-list']";
    public static final String NO_DATA_MESSAGE = "//div[@class='no-data']";

    // Dynamic Locator
    public static final String DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME_PRODUCT_PRICE_COLUMN_INDEX = "//a[text()='%s']/ancestor::tr/following-sibling::tr/td[text()='%s']/parent::tr/preceding-sibling::tr[@class='remove-product']/td[2]";
    public static final String DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME = "//a[text()='%s']/parent::td/preceding-sibling::td";
    public static final String DYNAMIC_PRODUCT_BY_PRODUCT_NAME_AND_PRODUCT_PRICE = "//a[text()='%s']/ancestor::tr/following-sibling::tr/td[text()='%s']";
}
