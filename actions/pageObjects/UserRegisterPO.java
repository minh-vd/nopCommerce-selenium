package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickOnElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getTextOfErrorMessageDisplayedAtFieldName(String fieldName) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE_BY_FIELD_NAME, fieldName);
        return getElementText(driver, UserRegisterPageUI.DYNAMIC_REQUIRED_ERROR_MESSAGE_BY_FIELD_NAME, fieldName);
    }

    public void inputIntoField(String fieldName, String inputData) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_INPUT_FIELD_BY_FIELD_NAME, fieldName);
        sendKeysToElement(driver, UserRegisterPageUI.DYNAMIC_INPUT_FIELD_BY_FIELD_NAME, inputData, fieldName);
    }

    public String getTextOfPasswordUnderSixCharactersErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_FIRST_PART);
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_SECOND_PART);
        String actualTextOfErrorMessage = getElementText(driver, UserRegisterPageUI.PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_FIRST_PART) + " " + getElementText(driver, UserRegisterPageUI.PASSWORD_UNDER_6_CHARACTERS_ERROR_MESSAGE_SECOND_PART);
        return actualTextOfErrorMessage;
    }

    public void checkOnGenderMaleCheckbox() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_CHECKBOX);
        checkOnCheckbox(driver, UserRegisterPageUI.GENDER_MALE_CHECKBOX);
    }

    public void selectDayOfBirth(String selectItemValue) {
        waitForElementVisible(driver, UserRegisterPageUI.DAY_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, UserRegisterPageUI.DAY_OF_BIRTH_DROPDOWN, selectItemValue);
    }

    public void selectMonthOfBirth(String selectItemValue) {
        waitForElementVisible(driver, UserRegisterPageUI.MONTH_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, UserRegisterPageUI.MONTH_OF_BIRTH_DROPDOWN, selectItemValue);
    }

    public void selectYearOfBirth(String selectItemValue) {
        waitForElementVisible(driver, UserRegisterPageUI.YEAR_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, UserRegisterPageUI.YEAR_OF_BIRTH_DROPDOWN, selectItemValue);
    }

    public String getTextOfExistingEmailErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }
}
