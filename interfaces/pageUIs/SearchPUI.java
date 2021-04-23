package pageUIs;

public class SearchPUI {
    public static final String SEARCH_BUTTON = "//div[@class='page search-page']//button[text()='Search']";
    public static final String SEARCH_WARNING_MESSAGE = "//div[@class='warning']";
    public static final String SEARCH_NO_RESULT_MESSAGE = "//div[@class='no-result']";
    public static final String PRODUCT_TITLE_IN_SEARCH_RESULT = "//div[@class='search-results']//h2[@class='product-title']/a";
    public static final String ADVANCED_SEARCH_CHECKBOX = "//input[@id='advs']";
    public static final String SELECT_CATEGORY_DROPDOWN = "//label[text()='Category:']/parent::div/select";
    public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "//label[text()='Automatically search sub categories']/preceding-sibling::input";
    public static final String SELECT_MANUFACTURER_DROPDOWN = "//label[text()='Manufacturer:']/parent::div/select";
}
