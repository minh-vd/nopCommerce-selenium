package pageUIs.admin;

public class AdminProductListPUI {
    public static final String SEARCH_PRODUCT_BUTTON = "//button[@id='search-products']";

    public static final String DYNAMIC_SEARCHED_PRODUCT_IN_LIST = "//table[@id='products-grid']//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[@class='fas fa-check %s-icon']";
}
