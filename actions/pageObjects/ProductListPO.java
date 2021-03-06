package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductListPUI;
import pageUIs.RecentlyViewedProductsPUI;

public class ProductListPO extends AbstractPage {
    WebDriver driver;

    public ProductListPO(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortBy(String selectSort) {
        waitForElementVisible(driver, ProductListPUI.SELECT_SORT_BY_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductListPUI.SELECT_SORT_BY_DROPDOWN, selectSort);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public boolean isProductListSortedByName(String sortType) {
        waitForAllElementsVisible(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST);
        return isStringDataSortedBy(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST, sortType);
    }

    public boolean isProductListSortedByPrice(String sortType) {
        waitForAllElementsVisible(driver, ProductListPUI.PRODUCT_PRICE_IN_LIST);
        return isFloatDataSortedBy(driver, ProductListPUI.PRODUCT_PRICE_IN_LIST, sortType);
    }

    public void selectNumberOfProductsToDisplay(String numberOfProducts) {
        waitForElementVisible(driver, ProductListPUI.SELECT_PRODUCT_PAGE_SIZE_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductListPUI.SELECT_PRODUCT_PAGE_SIZE_DROPDOWN, numberOfProducts);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public boolean isNumberOfProductsDisplayedFewerThan(int number) {
        waitForAllElementsVisible(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST);
        if (getElementSize(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST) <= number) {
            return true;
        } else return false;
    }

    public boolean isNextPageIconDisplayed() {
        waitForElementVisible(driver, ProductListPUI.NEXT_PAGE_ICON);
        return isElementDisplayed(driver, ProductListPUI.NEXT_PAGE_ICON);
    }

    public void clickOnNextPageIcon() {
        waitForElementVisible(driver, ProductListPUI.NEXT_PAGE_ICON);
        clickOnElement(driver, ProductListPUI.NEXT_PAGE_ICON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public boolean isPreviousPageIconDisplayed() {
        waitForElementVisible(driver, ProductListPUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(driver, ProductListPUI.PREVIOUS_PAGE_ICON);
    }

    public boolean isPagingSectionNotDisplayed() {
        waitForElementInvisible(driver, ProductListPUI.PAGING_SECTION);
        return isElementNotDisplayed(driver, ProductListPUI.PAGING_SECTION);
    }

    public ProductDetailPO clickOnDynamicProductTitleByProductIndex(String productIndex) {
        waitForElementVisible(driver, ProductListPUI.DYNAMIC_PRODUCT_TITLE_BY_INDEX, productIndex);
        clickOnElement(driver, ProductListPUI.DYNAMIC_PRODUCT_TITLE_BY_INDEX, productIndex);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public ProductDetailPO clickOnDynamicProductTitleByProductName(String productName) {
        waitForElementClickable(driver, ProductListPUI.DYNAMIC_PRODUCT_TITLE_BY_PRODUCT_NAME, productName);
        clickOnElement(driver, ProductListPUI.DYNAMIC_PRODUCT_TITLE_BY_PRODUCT_NAME, productName);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }
}
