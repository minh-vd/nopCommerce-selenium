package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPUI;
import pageUIs.UserRegisterResultPUI;

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
}
