package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductReviewPUI;

public class ProductReviewPO extends AbstractPage {
    WebDriver driver;

    public ProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputIntoReviewTextTextArea(String inputData) {
        waitForElementVisible(driver, ProductReviewPUI.REVIEW_TEXT_TEXTAREA);
        sendKeysToElement(driver, ProductReviewPUI.REVIEW_TEXT_TEXTAREA, inputData);
    }

    public void clickOnSubmitReviewButton() {
        waitForElementClickable(driver, ProductReviewPUI.SUBMIT_REVIEW_BUTTON);
        clickOnElement(driver, ProductReviewPUI.SUBMIT_REVIEW_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }
}
