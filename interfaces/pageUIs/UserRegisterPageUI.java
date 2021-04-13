package pageUIs;

public class UserRegisterPageUI {
    public static final String REGISTER_BUTTON = "//button[@id='register-button']";
    public static final String PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_FIRST_PART = "//span[@id='Password-error']/p";
    public static final String PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_SECOND_PART = "//span[@id='Password-error']/ul/li";
    public static final String GENDER_MALE_CHECKBOX = "//input[@id='gender-male']";
    public static final String DAY_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String MONTH_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String YEAR_OF_BIRTH_DROPDOWN = "//select[@name='DateOfBirthYear']";
    public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']";

    // Dynamic Locator
    public static final String DYNAMIC_REQUIRED_ERROR_MESSAGE_BY_FIELD_NAME = "//span[@id='%s-error']";
    public static final String DYNAMIC_INPUT_FIELD_BY_FIELD_NAME = "//input[@id='%s']";
}
