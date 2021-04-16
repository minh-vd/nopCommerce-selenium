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
    public static final String FOOTER_DYNAMIC_LINK = "//div[@class='footer']//a[text()='%s']";
    public static final String ADMIN_LEFT_MENU_DYNAMIC_LINK = "//span[text()='%s']/parent::a";
    public static final String DYNAMIC_UPLOAD_FILES_INPUT_BY_PANEL_ID = "//div[@id='%s']//input[@type='file']";
    public static final String DYNAMIC_EXPAND_ICON_FIND_BY_PANEL_ID = "//div[@id='%s']//i[contains(@class, 'toggle-icon')]";

    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";

    public static final String DYNAMIC_TEXT_BOX_BY_ID = "//input[@id='%s']";


    public static final String LOGIN_LINK_AT_TOP_BAR = "//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK_AT_TOP_BAR = "//a[@class='ico-account']";
    public static final String LOG_OUT_LINK_AT_TOP_BAR = "//a[@class='ico-logout']";
}
