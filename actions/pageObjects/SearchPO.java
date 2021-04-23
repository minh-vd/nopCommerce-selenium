package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.SearchPUI;
import pageUIs.UserRegisterResultPUI;

import java.util.List;

public class SearchPO extends AbstractPage {
    WebDriver driver;

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        waitForElementClickable(driver, SearchPUI.SEARCH_BUTTON);
        clickOnElement(driver, SearchPUI.SEARCH_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public String getTextOfSearchWarningMessage() {
        waitForElementVisible(driver, SearchPUI.SEARCH_WARNING_MESSAGE);
        return getElementText(driver, SearchPUI.SEARCH_WARNING_MESSAGE);
    }

    public String getTextOfSearchNoResultMessage() {
        waitForElementVisible(driver, SearchPUI.SEARCH_NO_RESULT_MESSAGE);
        scrollToElementUsingJS(driver, SearchPUI.SEARCH_NO_RESULT_MESSAGE);
        return getElementText(driver, SearchPUI.SEARCH_NO_RESULT_MESSAGE);
    }

    public boolean isRelatedProductsDisplayedByKeyword(String keyword) {
        waitForAllElementsVisible(driver, SearchPUI.PRODUCT_TITLE_IN_SEARCH_RESULT);
        boolean isDisplayed = true;
        List<WebElement> allProductsTitle = getElementsByXPath(driver, SearchPUI.PRODUCT_TITLE_IN_SEARCH_RESULT);
        scrollToElementUsingJS(driver, SearchPUI.PRODUCT_TITLE_IN_SEARCH_RESULT);
        for (WebElement eachProductTitle : allProductsTitle) {
            if (!getElementTextByElement(driver, eachProductTitle).contains(keyword)) {
                isDisplayed = false;
                break;
            }
        }
        return isDisplayed;
    }

    public void checkOnAdvancedSearchCheckbox() {
        waitForElementVisible(driver, SearchPUI.ADVANCED_SEARCH_CHECKBOX);
        checkOnCheckbox(driver, SearchPUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectCategory(String selectCategory) {
        waitForElementVisible(driver, SearchPUI.SELECT_CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPUI.SELECT_CATEGORY_DROPDOWN, selectCategory);
    }


    public void uncheckAutomaticallySearchSubCategoriesCheckbox() {
        waitForElementVisible(driver, SearchPUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        uncheckCheckbox(driver, SearchPUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public void checkOnAutomaticallySearchSubCategoriesCheckbox() {
        waitForElementVisible(driver, SearchPUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        checkOnCheckbox(driver, SearchPUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
    }
}
