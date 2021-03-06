package pageUIs;

public class MyAccountPUI {
    public static final String GENDER_FEMALE_CHECKBOX = "//input[@id='gender-female']";
    public static final String DAY_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String MONTH_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String YEAR_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthYear']";
    public static final String SAVE_CUSTOMER_INFO_BUTTON = "//button[@id='save-info-button']";

    public static final String ADD_NEW_ADDRESS_BUTTON = "//button[@class='button-1 add-address-button']";
    public static final String SELECT_COUNTRY_DROPDOWN = "//select[@id='Address_CountryId']";
    public static final String STATE_LOADING_ICON = "//span[@id='states-loading-progress']";
    public static final String SELECT_STATE_PROVINCE_DROPDOWN = "//select[@id='Address_StateProvinceId']";
    public static final String SAVE_NEW_ADDRESS_BUTTON = "//button[@class='button-1 save-address-button']";
    public static final String CHANGE_PASSWORD_BUTTON = "//button[text()='Change password']";
    public static final String NOTIFICATION_BAR_TEXT_CONTENT = "//div[@class='bar-notification success']/p";
    public static final String NOTIFICATION_BAR_CLOSE_BUTTON = "//div[@class='bar-notification success']/span[@class='close']";

    // Review
    public static final String REVIEW_TITLE = "//div[@class='review-title']/strong";
    public static final String REVIEW_CONTENT = "//div[@class='review-text']";

    // Dynamic Locator
    public static final String DYNAMIC_LEFT_MENU_LINK_BY_CLASS_NAME = "//li[contains(@class, '%s')]/a";
    public static final String DYNAMIC_FIELD_OF_ADDRESS_INFO_BY_CLASS_NAME = "//li[@class='%s']";

    // Order
    public static final String ORDER_PAGE_FIRST_ORDER_NUMBER = "(//div[@class='section order-item'])[1]/div[@class='title']/strong";
    public static final String ORDER_PAGE_DYNAMIC_DETAILS_ICON_BY_ORDER_NUMBER = "//strong[text()='Order Number: %s']/ancestor::div[@class='section order-item']/div[@class='buttons']/button[text()='Details']";

}
