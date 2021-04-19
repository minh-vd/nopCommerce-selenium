package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;
import pageUIs.UserRegisterResultPUI;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewPO clickOnAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        clickOnElement(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductReviewPage(driver);
    }
}
