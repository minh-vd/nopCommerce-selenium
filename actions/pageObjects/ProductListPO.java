package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductListPUI;

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

    public boolean isProductListSortedBy(String sortType) {
        waitForAllElementsVisible(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST);
        return isStringDataSortedBy(driver, ProductListPUI.PRODUCT_TITLE_IN_LIST, sortType);
    }
}
