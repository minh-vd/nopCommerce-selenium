package pageUIs;

public class AbstractPageUI {
    public static final String SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
    public static final String SHIPPING_AND_RETURNS_LINK = "//div[@class='footer']//a[text()='Shipping & returns']";
    public static final String SITEMAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
    public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
    public static final String HEADER_LOGO_HOMEPAGE_LINK = "//div[@class='header-lower']/div[@class='header-logo']/a";
    public static final String HEADER_WISHLIST_LINK = "//div[@class='header-upper']//a[@class='ico-wishlist']";
    public static final String LOADING_ICON = "//div[@id='ajaxBusy']";

    // Dynamic Locator
    public static final String DYNAMIC_LINK_AT_FOOTER_BY_TEXT = "//div[@class='footer']//a[text()='%s']";
    public static final String ADMIN_LEFT_MENU_DYNAMIC_LINK = "//span[text()='%s']/parent::a";
    public static final String DYNAMIC_UPLOAD_FILES_INPUT_BY_PANEL_ID = "//div[@id='%s']//input[@type='file']";
    public static final String DYNAMIC_EXPAND_ICON_FIND_BY_PANEL_ID = "//div[@id='%s']//i[contains(@class, 'toggle-icon')]";

    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";

    public static final String DYNAMIC_TEXT_BOX_BY_ID = "//input[@id='%s']";


    public static final String LOGIN_LINK_AT_TOP_BAR = "//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK_AT_TOP_BAR = "//a[@class='ico-account']";
    public static final String LOG_OUT_LINK_AT_TOP_BAR = "//a[@class='ico-logout']";

    // Header Menu
    public static final String DYNAMIC_HEADER_MENU_BY_TEXT = "//div[@class='header-menu']/ul[@class='top-menu notmobile']//a[text()='%s ']";
    public static final String DYNAMIC_HEADER_SUBMENU_BY_TEXT = "//div[@class='header-menu']/ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[text()='%s ']";
    public static final String LOGO = "//div[@class='header-logo']/a";

    // Notification Bar
    public static final String NOTIFICATION_BAR_CONTENT_TEXT = "//div[@id='bar-notification']//p";
    public static final String NOTIFICATION_BAR_CLOSE_BUTTON = "//div[@id='bar-notification']//span[@class='close']";

    // Header Link
    public static final String DYNAMIC_HEADER_LINK_BY_TEXT = "//div[@class='header-links']//span[text()='%s']";
    public static final String DYNAMIC_HEADER_LINK_BY_CLASS_NAME = "//div[@class='header-links']//a[@class='%s']";

    // Mini Shopping Cart
    public static final String MINI_SHOPPING_CART_COUNT_NUMBER_OF_PRODUCT_TEXT = "//div[@class='mini-shopping-cart']/div[@class='count']/a";
    public static final String MINI_SHOPPING_CART_DYNAMIC_PRODUCT_ATTRIBUTE_BY_PRODUCT_NAME = "//div[@class='mini-shopping-cart']//div[@class='product']/div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='attributes']";
    public static final String MINI_SHOPPING_CART_DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME = "//div[@class='mini-shopping-cart']//div[@class='product']/div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='price']/span";
    public static final String MINI_SHOPPING_CART_DYNAMIC_PRODUCT_QUANTITY_BY_PRODUCT_NAME = "//div[@class='mini-shopping-cart']//div[@class='product']/div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='quantity']/span";
    public static final String MINI_SHOPPING_CART_SUB_TOTAL_PRICE_TEXT = "//div[@class='totals']/strong";

    // Header Search
    public static final String SEARCH_TEXT_BOX = "//input[@placeholder='Search store']";
    public static final String DYNAMIC_PRODUCT_FROM_SEARCH_SUGGESTION_BY_NAME = "//ul[contains(@class, 'ui-autocomplete')]//span[text()='%s']/parent::a";
}
