package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import pageObjects.*;
import pageUIs.AbstractPageUI;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
    private WebElement element;
    private List<WebElement> elements;
    private Actions action;
    private Select select;

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

    public int getElementSize(WebDriver driver, String xpathLocator) {
        List<WebElement> elements = getElementsByXPath(driver, xpathLocator);
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

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        element = getElementByXPath(driver, xpathLocator);
        return element.isDisplayed();
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
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXPath(getDynamicXPathLocator(xpathLocator, dynamicXPathValues))));
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
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(getDynamicXPathLocator(xpathLocator, dynamicXPathValues))));
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

    /*public UserSearchPO openSearchPage(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUI.SEARCH_LINK);
        clickOnElement(driver, AbstractPageUI.SEARCH_LINK);
        return PageGeneratorManager.getUserSearchPage(driver);
    }*/

    /*public void openFooterLinkByPageName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, AbstractPageUI.FOOTER_DYNAMIC_LINK, pageName);
        clickOnElement(driver, AbstractPageUI.FOOTER_DYNAMIC_LINK, pageName);
    }*/

    /*public void waitForAnyAdminPageFinishedLoading(WebDriver driver) {
        waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
    }*/

    public int countNumberOfElementsLocatedByXPath(WebDriver driver, String xpathLocator, String... dynamicXPathValues) {
        return getElementsByXPath(driver, getDynamicXPathLocator(xpathLocator, dynamicXPathValues)).size();
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

    public void inputIntoTextBoxByID(WebDriver driver, String textBoxID, String inputData) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        sendKeysToElement(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, inputData, textBoxID);
    }

    public String getValueTextFromTextBoxByID(WebDriver driver, String textBoxID) {
        waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
        return getElementAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXT_BOX_BY_ID, "value", textBoxID);
    }
}
