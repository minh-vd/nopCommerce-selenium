package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPUI;
import pageUIs.UserRegisterResultPUI;

public class SearchPO extends AbstractPage {
    WebDriver driver;

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        waitForElementClickable(driver, SearchPUI.SEARCH_BUTTON);
        clickOnElement(driver, SearchPUI.SEARCH_BUTTON);
    }

    public String getTextOfSearchWarningMessage() {
        waitForElementVisible(driver, SearchPUI.SEARCH_WARNING_MESSAGE);
        return getElementText(driver, SearchPUI.SEARCH_WARNING_MESSAGE);
    }

    public String getTextOfSearchNoResultMessage() {
        waitForElementVisible(driver, SearchPUI.SEARCH_NO_RESULT_MESSAGE);
        return getElementText(driver, SearchPUI.SEARCH_NO_RESULT_MESSAGE);
    }
}
