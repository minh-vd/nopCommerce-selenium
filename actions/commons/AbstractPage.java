package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageUIs.AbstractPageUI;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
    private WebElement element;
    private List<WebElement> elements;
    private Actions action;
    private Select select;

    protected final Log log;

    protected AbstractPage() {
        log = LogFactory.getLog(getClass());
    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void forwardToNextPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(WebDriver driver, String inputData) {
        driver.switchTo().alert().sendKeys(inputData);
    }

    public void waitForAlertToBePresent(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    // Switch to new window in case there are only two windows
    public void switchToAnotherWindow(WebDriver driver, String currentWindowId) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindowId)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            String currentPageTitle = driver.getTitle();
            if (currentPageTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsExceptCurrentOne(WebDriver driver, String currentWindowId) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindowId)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindowId);
    }

    public By getByXPath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    public WebElement getElementByXPath(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXPath(xpathLocator));
    }

    public List<WebElement> getElementsByXPath(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXPath(xpathLocator));
    }

    public String getDynamicXPathLocator(String xpathLocator, String... dynamicXPathValues) {
        xpathLocator = String.format(xpathLocator, (Object[]) dynamicXPathValues);
        return xpathLocator;
    }

    public void clickOnElement(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        element.click();
    }

    public void clickOnElement(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        element.click();
    }

    public void sendKeysToElement(WebDriver driver, String xpathLocator, String inputData) {
        element = getElementByXPath(driver, xpathLocator);
        element.clear();
        element.sendKeys(inputData);
    }

    public void sendKeysToElement(WebDriver driver, String xpathLocator, String inputData, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        element.clear();
        element.sendKeys(inputData);
    }

    // Default Dropdown
    public void selectItemInDefaultDropdown(WebDriver driver, String selectXPathLocator, String itemValue) {
        WebElement selectElement = getElementByXPath(driver, selectXPathLocator);
        select = new Select(selectElement);
        select.selectByVisibleText(itemValue);
    }

    public String getSelectedTextInDefaultDropdown(WebDriver driver, String selectXPathLocator) {
        WebElement selectElement = getElementByXPath(driver, selectXPathLocator);
        select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String selectXPathLocator) {
        WebElement selectElement = getElementByXPath(driver, selectXPathLocator);
        select = new Select(selectElement);
        return select.isMultiple();
    }

    // Custom Dropdown
    public void selectItemInCustomDropdown(WebDriver driver, String dropdownLocator, String allChildItemsLocator, String expectedItem) {
        getElementByXPath(driver, dropdownLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXPath(allChildItemsLocator)));

        List<WebElement> allChildItems = getElementsByXPath(driver, allChildItemsLocator);

        for (WebElement item : allChildItems) {
            if (item.getText().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getElementAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
        element = getElementByXPath(driver, xpathLocator);
        return element.getAttribute(attributeName);
    }

    public String getElementAttributeValue(WebDriver driver, String xpathLocator, String attributeName, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        return element.getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        return element.getText();
    }

    public String getElementText(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        return element.getText();
    }

    public String getElementTextByElement(WebElement element) {
        return element.getText();
    }

    public int getElementSize(WebDriver driver, String xpathLocator) {
        List<WebElement> elements = getElementsByXPath(driver, xpathLocator);
        return elements.size();
    }

    public int getElementSize(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        List<WebElement> elements = getElementsByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        return elements.size();
    }

    public void checkOnCheckbox(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkOnCheckbox(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckCheckbox(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckCheckbox(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        boolean isDisplayedFlag = true;
        try {
            element = getElementByXPath(driver, xpathLocator);
            if (element.isDisplayed()) {
                return isDisplayedFlag;
            }
        } catch (Exception e) {
            isDisplayedFlag = false;
        }
        return isDisplayedFlag;
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        return element.isDisplayed();
    }

    public boolean isElementNotDisplayed(WebDriver driver, String xpathLocator) {
        overrideImplicitWaitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        elements = getElementsByXPath(driver, xpathLocator);
        overrideImplicitWaitTimeout(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementNotDisplayed(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        overrideImplicitWaitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        elements = getElementsByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        overrideImplicitWaitTimeout(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        return element.isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        return element.isSelected();
    }

    public void switchToFrame(WebDriver driver, String xpathLocator) {
        WebElement elementFrame = getElementByXPath(driver, xpathLocator);
        driver.switchTo().frame(elementFrame);
    }

    public void switchToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickOnElement(WebDriver driver, String xpathLocator) {
        action = new Actions(driver);
        action.doubleClick(getElementByXPath(driver, xpathLocator)).perform();
    }

    public void hoverMouseOnElement(WebDriver driver, String xpathLocator) {
        action = new Actions(driver);
        action.moveToElement(getElementByXPath(driver, xpathLocator)).perform();
    }

    public void hoverMouseOnElement(WebDriver driver, String xpathLocator, String dynamicXPathValues) {
        action = new Actions(driver);
        action.moveToElement(getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues))).perform();
    }

    public void rightClickOnElement(WebDriver driver, String xpathLocator) {
        action = new Actions(driver);
        action.contextClick(getElementByXPath(driver, xpathLocator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceXPathLocator, String targetXPathLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElementByXPath(driver, sourceXPathLocator), getElementByXPath(driver, targetXPathLocator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElementByXPath(driver, xpathLocator), key).perform();
    }

    public Object executeJavascript(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerTextUsingJS(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerTextUsingJS(WebDriver driver, String expectedText) {
        jsExecutor = (JavascriptExecutor) driver;
        String actualText = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + expectedText + "')[0]");
        return actualText.equals(expectedText);
    }

    public void scrollToPageBottomUsingJS(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlUsingJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElementUsingJS(WebDriver driver, String xpathLocator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickOnElementUsingJS(WebDriver driver, String xpathLocator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElementUsingJS(WebDriver driver, String xpathLocator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElementUsingJS(WebDriver driver, String xpathLocator, String dynamicXPathValues) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendKeysToElementUsingJS(WebDriver driver, String xpathLocator, String inputData) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + inputData + "')", element);
    }

    public void removeAttributeInDomUsingJS(WebDriver driver, String xpathLocator, String attributeToRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeToRemove + "');", element);
    }

    // Need to recheck NOT that usable
    public boolean waitForJQueryAndJSLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = getElementByXPath(driver, xpathLocator);
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (status) {
            return true;
        }
        return false;
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
        } catch (Exception e) {
            log.debug("Element NOT exist");
        }
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXPath(getDynamicXPathLocator(xpathLocator, dynamicXPathValues))));
    }

    public void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(xpathLocator)));
    }

    public void overrideImplicitWaitTimeout(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideImplicitWaitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(xpathLocator)));
        overrideImplicitWaitTimeout(driver, GlobalConstants.LONG_TIMEOUT);
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideImplicitWaitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(getDynamicXPathLocator(xpathLocator, dynamicXPathValues))));
        overrideImplicitWaitTimeout(driver, GlobalConstants.LONG_TIMEOUT);
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXPath(xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXPath(getDynamicXPathLocator(xpathLocator, dynamicXPathValues))));
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*public void waitForAnyAdminPageFinishedLoading(WebDriver driver) {
        waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
    }*/

    public int countNumberOfElementsLocatedByXPath(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        return getElementsByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues)).size();
    }

    public boolean isStringDataSortedBy(WebDriver driver, String xpathLocator, String sortType) {
        ArrayList<String> actualList = new ArrayList<>();

        List<WebElement> elementList = getElementsByXPath(driver, xpathLocator);

        for (WebElement eachElement : elementList) {
            actualList.add(getElementTextByElement(eachElement));
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String eachItem : actualList) {
            sortedList.add(eachItem);
        }

        if (sortType.equals("ASC")) {
            Collections.sort(sortedList);
        } else if (sortType.equals("DESC")) {
            Collections.sort(sortedList);
            Collections.reverse(sortedList);
        }

        return actualList.equals(sortedList);
    }

    public boolean isFloatDataSortedBy(WebDriver driver, String xpathLocator, String sortType) {
        ArrayList<Float> actualList = new ArrayList<>();

        List<WebElement> elementList = getElementsByXPath(driver, xpathLocator);

        for (WebElement eachElement : elementList) {
            actualList.add(Float.parseFloat(getElementTextByElement(eachElement).replace("$", "").replace(",", "").trim()));
        }

        ArrayList<Float> sortedList = new ArrayList<>();
        for (Float eachItem : actualList) {
            sortedList.add(eachItem);
        }

        if (sortType.equals("ASC")) {
            Collections.sort(sortedList);
        } else if (sortType.equals("DESC")) {
            Collections.sort(sortedList);
            Collections.reverse(sortedList);
        }

        return actualList.equals(sortedList);
    }

    public void uploadFileByPanelId(WebDriver driver, String panelId, String... fileNames) {
        String uploadFolderPath = GlobalConstants.UPLOAD_FOLDER;
        String fullFilePath = "";
        for (String file : fileNames) {
            fullFilePath = fullFilePath + uploadFolderPath + file + "\n";
        }
        fullFilePath = fullFilePath.trim();

        //sendkeyToElement(driver, AbstractPageUI.DYNAMIC_UPLOAD_FILES_INPUT_BY_PANEL_ID, fullFilePath, panelId);

        getElementByXPath(driver, getDynamicXPathLocator(AbstractPageUI.DYNAMIC_UPLOAD_FILES_INPUT_BY_PANEL_ID, panelId)).sendKeys(fullFilePath);
    }

    public int getRandomIntegerNumber(int upperbound) {
        Random rand = new Random();
        return rand.nextInt(upperbound) + 1;
    }

    /*public void clickToExpandPanelByPanelId(WebDriver driver, String panelId) {
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_EXPAND_ICON_FIND_BY_PANEL_ID, panelId);
        String iconClassValue = getElementAttributeValue(driver, AbstractPageUI.DYNAMIC_EXPAND_ICON_FIND_BY_PANEL_ID, "class", panelId);
        if (iconClassValue.contains("plus")) {
            clickOnElement(driver, AbstractPageUI.DYNAMIC_EXPAND_ICON_FIND_BY_PANEL_ID, panelId);
        }
    }

    public void clickOnRadioButtonById(WebDriver driver, String radioButtonId) {
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonId);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonId);
    }

    public void clickOnButtonByValue(WebDriver driver, String buttonValue){
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
    }*/

    /* ---------- FOR THIS PROJECT ONLY ---------- */
    public void inputIntoTextBoxByID(WebDriver driver, String textBoxID, String inputData) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        sendKeysToElement(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, inputData, textBoxID);
    }

    public String getValueTextFromTextBoxByID(WebDriver driver, String textBoxID) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        return getElementAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, "value", textBoxID);
    }

    public UserHomePO clickOnLogoutLinkAtTopBar(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.LOG_OUT_LINK_AT_TOP_BAR);
        clickOnElement(driver, AbstractPageUI.LOG_OUT_LINK_AT_TOP_BAR);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public MyAccountPO clickOnMyAccountLinkAtTopBar(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
        clickOnElement(driver, AbstractPageUI.MY_ACCOUNT_LINK_AT_TOP_BAR);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    public void clickOnDynamicLinkAtFooterByText(WebDriver driver, String linkText) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_AT_FOOTER_BY_TEXT, linkText);
        scrollToElementUsingJS(driver, AbstractPageUI.DYNAMIC_LINK_AT_FOOTER_BY_TEXT, linkText);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_LINK_AT_FOOTER_BY_TEXT, linkText);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void hoverMouseOnDynamicHeaderMenuByText(WebDriver driver, String headerMenuText) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_HEADER_MENU_BY_TEXT, headerMenuText);
        hoverMouseOnElement(driver, AbstractPageUI.DYNAMIC_HEADER_MENU_BY_TEXT, headerMenuText);
    }

    public ProductListPO clickOnDynamicHeaderSubmenuByText(WebDriver driver, String headerSubmenuText) {
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_HEADER_SUBMENU_BY_TEXT, headerSubmenuText);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_HEADER_SUBMENU_BY_TEXT, headerSubmenuText);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductListPage(driver);
    }

    public String getNotificationBarMessage(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.NOTIFICATION_BAR_CONTENT_TEXT);
        return getElementText(driver, AbstractPageUI.NOTIFICATION_BAR_CONTENT_TEXT);
    }

    public UserHomePO clickOnLogo(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.LOGO);
        clickOnElement(driver, AbstractPageUI.LOGO);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public void clickOnCloseNotificationBarIcon(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.NOTIFICATION_BAR_CLOSE_BUTTON);
        clickOnElement(driver, AbstractPageUI.NOTIFICATION_BAR_CLOSE_BUTTON);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void hoverOnDynamicHeaderLinkByText(WebDriver driver, String headerLinkText) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_HEADER_LINK_BY_TEXT, headerLinkText);
        hoverMouseOnElement(driver, AbstractPageUI.DYNAMIC_HEADER_LINK_BY_TEXT, headerLinkText);
    }

    public String getMiniShoppingCartCountProductText(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.MINI_SHOPPING_CART_COUNT_NUMBER_OF_PRODUCT_TEXT);
        return getElementText(driver, AbstractPageUI.MINI_SHOPPING_CART_COUNT_NUMBER_OF_PRODUCT_TEXT);
    }

    public boolean isMiniShoppingCartProductDisplayed(WebDriver driver, String productName, String productPrice, String productQuantity, String... productAttributes) {
        boolean isDisplayedFlag = true;

        waitForElementVisible(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_ATTRIBUTE_BY_PRODUCT_NAME, productName);
        String actualProductAttribute = getElementText(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_ATTRIBUTE_BY_PRODUCT_NAME, productName).trim().replace("\n", " ");
        log.info(actualProductAttribute);
        String expectedProductAttribute = "";
        for (String eachProductAttribute : productAttributes) {
            expectedProductAttribute += eachProductAttribute + " ";
        }
        log.info(expectedProductAttribute);
        if (!actualProductAttribute.equals(expectedProductAttribute.trim())) {
            isDisplayedFlag = false;
        }

        waitForElementVisible(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME, productName);
        if (!getElementText(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME, productName).equals(productPrice)) {
            isDisplayedFlag = false;
        }

        waitForElementVisible(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_QUANTITY_BY_PRODUCT_NAME, productName);
        if (!getElementText(driver, AbstractPageUI.MINI_SHOPPING_CART_DYNAMIC_PRODUCT_QUANTITY_BY_PRODUCT_NAME, productName).equals(productQuantity)) {
            isDisplayedFlag = false;
        }

        return isDisplayedFlag;
    }

    public String getMiniShoppingCartSubTotalPrice(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.MINI_SHOPPING_CART_SUB_TOTAL_PRICE_TEXT);
        return getElementText(driver, AbstractPageUI.MINI_SHOPPING_CART_SUB_TOTAL_PRICE_TEXT);
    }

    public void clickOnDynamicHeaderLinkByText(WebDriver driver, String headerLinkText) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_HEADER_LINK_BY_TEXT, headerLinkText);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_HEADER_LINK_BY_TEXT, headerLinkText);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public void inputIntoHeaderSearchTextBox(WebDriver driver, String inputData) {
        waitForElementVisible(driver, AbstractPageUI.SEARCH_TEXT_BOX);
        sendKeysToElement(driver, AbstractPageUI.SEARCH_TEXT_BOX, inputData);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
    }

    public ProductDetailPO clickOnProductFromSearchSuggestionByName(WebDriver driver, String productName) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_FROM_SEARCH_SUGGESTION_BY_NAME, productName);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_FROM_SEARCH_SUGGESTION_BY_NAME, productName);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductDetailPage(driver);
    }
}
