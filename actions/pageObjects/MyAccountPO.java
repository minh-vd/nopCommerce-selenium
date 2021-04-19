package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPUI;

public class MyAccountPO extends AbstractPage {
    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOnGenderFemaleCheckbox() {
        waitForElementVisible(driver, MyAccountPUI.GENDER_FEMALE_CHECKBOX);
        checkOnCheckbox(driver, MyAccountPUI.GENDER_FEMALE_CHECKBOX);
    }

    public void selectDayOfBirth(String dayToSelect) {
        waitForElementVisible(driver, MyAccountPUI.DAY_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, MyAccountPUI.DAY_OF_BIRTH_DROPDOWN, dayToSelect);
    }

    public void selectMonthOfBirth(String monthToSelect) {
        waitForElementVisible(driver, MyAccountPUI.MONTH_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, MyAccountPUI.MONTH_OF_BIRTH_DROPDOWN, monthToSelect);
    }

    public void selectYearOfBirth(String yearToSelect) {
        waitForElementVisible(driver, MyAccountPUI.YEAR_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, MyAccountPUI.YEAR_OF_BIRTH_DROPDOWN, yearToSelect);
    }

    public void clickOnSaveButton() {
        waitForElementClickable(driver, MyAccountPUI.SAVE_CUSTOMER_INFO_BUTTON);
        clickOnElement(driver, MyAccountPUI.SAVE_CUSTOMER_INFO_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getDayOfBirth() {
        waitForElementVisible(driver, MyAccountPUI.DAY_OF_BIRTH_DROPDOWN);
        return getSelectedTextInDefaultDropdown(driver, MyAccountPUI.DAY_OF_BIRTH_DROPDOWN);
    }

    public String getMonthOfBirth() {
        waitForElementVisible(driver, MyAccountPUI.MONTH_OF_BIRTH_DROPDOWN);
        return getSelectedTextInDefaultDropdown(driver, MyAccountPUI.MONTH_OF_BIRTH_DROPDOWN);
    }

    public String getYearOfBirth() {
        waitForElementVisible(driver, MyAccountPUI.YEAR_OF_BIRTH_DROPDOWN);
        return getSelectedTextInDefaultDropdown(driver, MyAccountPUI.YEAR_OF_BIRTH_DROPDOWN);
    }

    public void clickOnDynamicLeftMenuLinkByClassName(String className) {
        waitForElementClickable(driver, MyAccountPUI.DYNAMIC_LEFT_MENU_LINK_BY_CLASS_NAME, className);
        clickOnElement(driver, MyAccountPUI.DYNAMIC_LEFT_MENU_LINK_BY_CLASS_NAME, className);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnAddNewAddressButton() {
        waitForElementClickable(driver, MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
        clickOnElement(driver, MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void selectAddressCountry(String country) {
        waitForElementVisible(driver, MyAccountPUI.SELECT_COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, MyAccountPUI.SELECT_COUNTRY_DROPDOWN, country);
    }

    public void selectAddressStateProvince(String state) {
        waitForElementInvisible(driver, MyAccountPUI.STATE_LOADING_ICON);
        waitForElementVisible(driver, MyAccountPUI.SELECT_STATE_PROVINCE_DROPDOWN);
        selectItemInDefaultDropdown(driver, MyAccountPUI.SELECT_STATE_PROVINCE_DROPDOWN, state);
    }

    public void clickOnSaveAddressButton() {
        waitForElementClickable(driver, MyAccountPUI.SAVE_NEW_ADDRESS_BUTTON);
        clickOnElement(driver, MyAccountPUI.SAVE_NEW_ADDRESS_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getTextOfDynamicAddressInfoFieldByClass(String className) {
        waitForElementVisible(driver, MyAccountPUI.DYNAMIC_FIELD_OF_ADDRESS_INFO_BY_CLASS_NAME, className);
        return getElementText(driver, MyAccountPUI.DYNAMIC_FIELD_OF_ADDRESS_INFO_BY_CLASS_NAME, className);
    }

    public void clickOnChangePasswordButton() {
        waitForElementClickable(driver, MyAccountPUI.CHANGE_PASSWORD_BUTTON);
        clickOnElement(driver, MyAccountPUI.CHANGE_PASSWORD_BUTTON);
    }

    public String getTextOfNotificationBar() {
        waitForElementVisible(driver, MyAccountPUI.NOTIFICATION_BAR_TEXT_CONTENT);
        return getElementText(driver, MyAccountPUI.NOTIFICATION_BAR_TEXT_CONTENT);
    }

    public void clickOnCloseButtonOfNotificationBanner() {
        waitForElementClickable(driver, MyAccountPUI.NOTIFICATION_BAR_CLOSE_BUTTON);
        clickOnElement(driver, MyAccountPUI.NOTIFICATION_BAR_CLOSE_BUTTON);
    }

    public String getTextOfReviewTitle() {
        waitForElementVisible(driver, MyAccountPUI.REVIEW_TITLE);
        return getElementText(driver, MyAccountPUI.REVIEW_TITLE);
    }

    public String getTextOfReviewText() {
        waitForElementVisible(driver, MyAccountPUI.REVIEW_CONTENT);
        return getElementText(driver, MyAccountPUI.REVIEW_CONTENT);
    }
}
