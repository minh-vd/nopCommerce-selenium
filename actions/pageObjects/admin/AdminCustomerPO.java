package pageObjects.admin;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageUIs.admin.AdminCustomerPUI;
import pageUIs.admin.AdminProductListPUI;

public class AdminCustomerPO extends AbstractPage {
    WebDriver driver;

    public AdminCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddNewButton() {
        waitForElementClickable(driver, AdminCustomerPUI.ADD_NEW_BUTTON);
        clickOnElement(driver, AdminCustomerPUI.ADD_NEW_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void checkOnGenderCheckbox(String gender) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_GENDER_CHECKBOX_BY_GENDER, gender);
        checkOnCheckbox(driver, AdminCustomerPUI.DYNAMIC_GENDER_CHECKBOX_BY_GENDER, gender);
    }

    public void selectCustomerRoles(String customerRole) {
        waitForElementVisible(driver, AdminCustomerPUI.SELECT_CUSTOMER_ROLES_PARENT_DROPDOWN);
        clickOnElement(driver, AdminCustomerPUI.SELECT_CUSTOMER_ROLES_FIRST_CHILD_DELETE_ICON);
        sleepInSecond(1);
        selectItemInCustomDropdownWithoutScrollIntoView(driver, AdminCustomerPUI.SELECT_CUSTOMER_ROLES_PARENT_DROPDOWN, AdminCustomerPUI.SELECT_CUSTOMER_ROLES_ALL_CHILDREN_OPTION, customerRole);
    }

    public void checkOnActiveCheckbox() {
        waitForElementVisible(driver, AdminCustomerPUI.ACTIVE_CHECKBOX);
        checkOnCheckbox(driver, AdminCustomerPUI.ACTIVE_CHECKBOX);
    }

    public void inputIntoAdminCommentTextArea(String inputData) {
        waitForElementVisible(driver, AdminCustomerPUI.ADMIN_COMMENT_TEXT_AREA);
        sendKeysToElement(driver, AdminCustomerPUI.ADMIN_COMMENT_TEXT_AREA, inputData);
    }

    public void clickOnSaveAndContinueEditButton() {
        waitForElementClickable(driver, AdminCustomerPUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
        clickOnElement(driver, AdminCustomerPUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getAlertMessage() {
        waitForElementVisible(driver, AdminCustomerPUI.ALERT_ELEMENT);
        return getElementText(driver, AdminCustomerPUI.ALERT_ELEMENT).replace("×", "").trim();
    }

    public boolean isGenderCheckboxChecked(String gender) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_GENDER_CHECKBOX_BY_GENDER, gender);
        return isElementSelected(driver, AdminCustomerPUI.DYNAMIC_GENDER_CHECKBOX_BY_GENDER, gender);
    }

    public boolean isCustomerRolesSelected(String customerRole) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_SELECTING_CUSTOMER_ROLE, customerRole);
        return isElementDisplayed(driver, AdminCustomerPUI.DYNAMIC_SELECTING_CUSTOMER_ROLE, customerRole);
    }

    public boolean isActiveCheckboxChecked() {
        waitForElementVisible(driver, AdminCustomerPUI.ACTIVE_CHECKBOX);
        return isElementSelected(driver, AdminCustomerPUI.ACTIVE_CHECKBOX);
    }

    public String getAdminCommentText() {
        waitForElementVisible(driver, AdminCustomerPUI.ADMIN_COMMENT_TEXT_AREA);
        return getElementText(driver, AdminCustomerPUI.ADMIN_COMMENT_TEXT_AREA);
    }

    public void clickOnBackToCustomerListLink() {
        waitForElementClickable(driver, AdminCustomerPUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickOnElement(driver, AdminCustomerPUI.BACK_TO_CUSTOMER_LIST_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnSearchButton() {
        waitForElementClickable(driver, AdminCustomerPUI.SEARCH_BUTTON);
        clickOnElement(driver, AdminCustomerPUI.SEARCH_BUTTON);
        waitForPageOfAdminPortalFinishedLoading(driver);
    }

    public boolean isSearchedCustomerDisplayed(String customerName, String customerRole, String customerCompany, String customerActiveStatus) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_CUSTOMER_DETAIL_IN_LIST, customerName, customerRole, customerCompany, customerActiveStatus);
        return isElementDisplayed(driver, AdminCustomerPUI.DYNAMIC_CUSTOMER_DETAIL_IN_LIST, customerName, customerRole, customerCompany, customerActiveStatus);
    }

    public void clickOnDynamicEditIconByCustomerInfo(String customerName, String customerRole, String customerCompany, String customerActiveStatus) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_EDIT_ICON_BY_CUSTOMER_DETAIL, customerName, customerRole, customerCompany, customerActiveStatus);
        clickOnElement(driver, AdminCustomerPUI.DYNAMIC_EDIT_ICON_BY_CUSTOMER_DETAIL, customerName, customerRole, customerCompany, customerActiveStatus);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnDynamicSectionTitleById(String sectionId) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_SECTION_TITLE_BY_ID, sectionId);
        clickOnElement(driver, AdminCustomerPUI.DYNAMIC_SECTION_TITLE_BY_ID, sectionId);
        sleepInSecond(1);
    }

    public void clickOnAddNewAddressButton() {
        waitForElementClickable(driver, AdminCustomerPUI.ADD_NEW_ADDRESS_BUTTON);
        clickOnElement(driver, AdminCustomerPUI.ADD_NEW_ADDRESS_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void clickOnSaveButton() {
        waitForElementClickable(driver, AdminCustomerPUI.SAVE_BUTTON);
        clickOnElement(driver, AdminCustomerPUI.SAVE_BUTTON);
    }

    public void clickOnBackToCustomerDetailLink() {
        waitForElementClickable(driver, AdminCustomerPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        clickOnElement(driver, AdminCustomerPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public boolean isAddressDisplayed(String addressFirstName, String addressLastName, String addressEmail, String addressPhone, String addressFax, String addressCompany, String address1, String address2, String addressCity, String addressZipCode, String addressCountry) {
        waitForElementVisible(driver, AdminCustomerPUI.DYNAMIC_ADDRESS_FIELD_IN_LIST, addressFirstName, addressLastName, addressEmail, addressPhone, addressFax);
        boolean isDisplayedFlag = false;
        if (getElementText(driver, AdminCustomerPUI.DYNAMIC_ADDRESS_FIELD_IN_LIST, addressFirstName, addressLastName, addressEmail, addressPhone, addressFax).trim().equals(addressCompany + "\n" + address1 + "\n" + address2 + "\n" + addressCity + "," + addressZipCode + "\n" + addressCountry)) {
            isDisplayedFlag = true;
        }
        return isDisplayedFlag;
    }
}
