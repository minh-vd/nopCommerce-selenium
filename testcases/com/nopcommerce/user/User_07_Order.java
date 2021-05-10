package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class User_07_Order extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    ProductListPO productListPage;
    ProductDetailPO productDetailPage;
    CartPO cartPage;
    CheckoutPO checkoutPage;
    MyAccountPO myAccountPage;
    OrderDetailPO orderDetailPage;

    String productName = "Build your own computer";

    String billingFirstName = "Auto B";
    String billingLastName = "Test B";
    String billingEmail = "b+" + getRandomNumberByDateTime() + "@mail.com";
    String billingCountry = "Viet Nam";
    String billingState = "Other";
    String billingCity = "HN";
    String billingAddress1 = "1B Hao Nam";
    String billingZipCode = "00001";
    String billingPhone = "0123456789";

    String shippingFirstName = "Auto S";
    String shippingLastName = "Test S";
    String shippingEmail = "s+" + getRandomNumberByDateTime() + "@mail.com";
    String shippingCountry = "Viet Nam";
    String shippingState = "Other";
    String shippingCity = "HN";
    String shippingAddress1 = "1S Hao Nam";
    String shippingZipCode = "00002";
    String shippingPhone = "0987654321";

    LocalDate currentCentralTimeDate = LocalDate.now(ZoneId.of("America/Chicago"));
    String expectedDate = currentCentralTimeDate.format(DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy"));

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on Login Link");
        userLoginPage = userHomePage.clickOnLoginLink();

        log.info("Pre-Condition - Step: Input Email");
        userLoginPage.inputIntoEmailField(Common_01_Register.email);

        log.info("Pre-Condition - Step: Input Password");
        userLoginPage.inputIntoPasswordField(Common_01_Register.password);

        log.info("Pre-Condition - Step: Click on Login button");
        userHomePage = userLoginPage.clickOnLoginButton();
    }

    @Test
    public void Order_01_Add_Product_To_Cart() {
        log.info("Order 01 - Add Product To Cart - Step: Hover on Computers top menu");
        userHomePage.hoverMouseOnDynamicHeaderMenuByText(driver, "Computers");

        log.info("Order 01 - Add Product To Cart - Step: Click on Desktops sub menu");
        productListPage = userHomePage.clickOnDynamicHeaderSubmenuByText(driver, "Desktops");

        log.info("Order 01 - Add Product To Cart - Step: Click on \"Build your own Computer\" product");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductName("Build your own computer");

        log.info("Order 01 - Add Product To Cart - Step: Select \"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\" Processor option");
        productDetailPage.selectProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"8GB [+$60.00]\" RAM option");
        productDetailPage.selectRam("8GB [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"400 GB [+$100.00]\" HDD option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("HDD","400 GB [+$100.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Vista Premium [+$60.00]\" OS option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("OS", "Vista Premium [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Microsoft Office [+$50.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Microsoft Office [+$50.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Acrobat Reader [+$10.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Acrobat Reader [+$10.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Total Commander [+$5.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Total Commander [+$5.00]");

        log.info("Order 01 - Add Product To Cart - Step: Click on <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 01 - Add Product To Cart - Step: Verify Add to Cart success message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 01 - Add Product To Cart - Step: Hover on Shopping Cart on Header link");
        productDetailPage.hoverOnDynamicHeaderLinkByText(driver, "Shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Count Product text \"There are 1 item(s) in your cart.\"");
        verifyEquals(productDetailPage.getMiniShoppingCartCountProductText(driver), "1 item(s)");

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Product Info");
        verifyTrue(productDetailPage.isMiniShoppingCartProductDisplayed(driver, "Build your own computer", "$1,500.00", "1", "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "RAM: 8GB [+$60.00]", "HDD: 400 GB [+$100.00]", "OS: Vista Premium [+$60.00]", "Software: Microsoft Office [+$50.00]", "Software: Acrobat Reader [+$10.00]", "Software: Total Commander [+$5.00]"));

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Sub-Total Price");
        verifyEquals(productDetailPage.getMiniShoppingCartSubTotalPrice(driver), "$1,500.00");
    }

    @Test
    public void Order_02_Edit_Product_In_Cart() {
        log.info("Order 02 - Edit Product In Cart - Step: Click on Shopping Cart on Header Link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 02 - Edit Product In Cart - Step: Click on Edit link");
        productDetailPage = cartPage.clickOnDynamicEditLinkByProductName("Build your own computer");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"2.2 GHz Intel Pentium Dual-Core E2200\" Processor option");
        productDetailPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"4GB [+$20.00]\" RAM option");
        productDetailPage.selectRam("4GB [+$20.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"320 GB\" HDD option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("HDD", "320 GB");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"Vista Home [+$50.00]\" OS option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("OS", "Vista Home [+$50.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Uncheck \"Acrobat Reader [+$10.00]\" Software option");
        productDetailPage.uncheckOnDynamicCheckboxByGroupLabelAndText("Software", "Acrobat Reader [+$10.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Uncheck \"Total Commander [+$5.00]\" Software option");
        productDetailPage.uncheckOnDynamicCheckboxByGroupLabelAndText("Software", "Total Commander [+$5.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Input 2 into Quantity text box");
        productDetailPage.inputIntoQuantityTextBox("2");

        log.info("Order 02 - Edit Product In Cart - Step: Verify Product Price = \"$1,320.00\"");
        verifyEquals(productDetailPage.getProductPrice(), "$1,320.00");

        log.info("Order 02 - Edit Product In Cart - Step: Click on <Update> button");
        productDetailPage.clickOnUpdateButton();

        log.info("Order 02 - Edit Product In Cart - Step: Verify Add to Cart success message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your shopping cart");

        log.info("Order 02 - Edit Product In Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 02 - Edit Product In Cart - Step: Hover on Shopping Cart on Header link");
        productDetailPage.hoverOnDynamicHeaderLinkByText(driver, "Shopping cart");

        log.info("Order 02 - Edit Product In Cart - Step: Verify Mini Shopping Cart - Product Info");
        verifyTrue(productDetailPage.isMiniShoppingCartProductDisplayed(driver, "Build your own computer", "$1,320.00", "2", "Processor: 2.2 GHz Intel Pentium Dual-Core E2200", "RAM: 4GB [+$20.00]", "HDD: 320 GB", "OS: Vista Home [+$50.00]", "Software: Microsoft Office [+$50.00]"));

        log.info("Order 02 - Edit Product In Cart - Step: Verify Mini Shopping Cart - Sub-Total Price");
        verifyEquals(productDetailPage.getMiniShoppingCartSubTotalPrice(driver), "$2,640.00");
    }

    @Test
    public void Order_03_Remove_Product_From_Cart() {
        log.info("Order 03 - Remove Product From Cart - Step: Click on Shopping Cart on Header Link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 03 - Remove Product From Cart - Step: Click on Remove Icon of Product \"" + productName + "\"");
        cartPage.clickOnDynamicRemoveIconByProductName(productName);

        log.info("Order 03 - Remove Product From Cart - Step: Verify No Data message");
        verifyEquals(cartPage.getNoDataMessage(), "Your Shopping Cart is empty!");

        log.info("Order 03 - Remove Product From Cart - Step: Verify Product \"" + productName + "\" is NOT displayed");
        verifyTrue(cartPage.isAddedProductNotDisplayed(productName));
    }

    @Test
    public void Order_04_Update_Shopping_Cart() {
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        log.info("Order 04 - Update Shopping Cart - Step: Input Product Name \"" + productName + "\" into Header Search text box");
        cartPage.inputIntoHeaderSearchTextBox(driver, productName);

        log.info("Order 04 - Update Shopping Cart - Step: Click Product \"" + productName + "\" from Search suggestion");
        productDetailPage = cartPage.clickOnProductFromSearchSuggestionByName(driver, productName);

        log.info("Order 04 - Update Shopping Cart - Step: Click <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 04 - Update Shopping Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 04 - Update Shopping Cart - Step: Click on Shopping Cart on Header Link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 04 - Update Shopping Cart - Step: Input \"5\" into Quantity text box");
        cartPage.inputIntoDynamicQuantityTextBoxByProductName(productName, "5");

        log.info("Order 04 - Update Shopping Cart - Step: Click <Update shopping cart> button");
        cartPage.clickOnUpdateShoppingCartButton();

        log.info("Order 04 - Update Shopping Cart - Step: Verify Product Subtotal Price is increased to \"$2,500.00\"");
        verifyEquals(cartPage.getProductSubtotalPriceByName(productName), "$2,500.00");
        
        log.info("Order 04 - Update Shopping Cart - Step: Remove Product \"" + productName + "\" from Shopping Cart");
        cartPage.clickOnDynamicRemoveIconByProductName(productName);
    }

    @Test
    public void Order_05_Checkout_With_Cheque_Payment_Method() {
        productName = "Apple MacBook Pro 13-inch";
        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Input Product Name \"" + productName + "\" into Header Search text box");
        cartPage.inputIntoHeaderSearchTextBox(driver, productName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Click Product \"" + productName + "\" from Search suggestion");
        productDetailPage = cartPage.clickOnProductFromSearchSuggestionByName(driver, productName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Click <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Click on Shopping Cart on Header Link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Select \"No\" Gift wrapping option");
        cartPage.selectGiftWrapping("No");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Check on Agree to ToS checkbox");
        cartPage.checkOnAgreeToTermOfServiceCheckbox();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Click on <CHECKOUT> button");
        checkoutPage = cartPage.clickOnCheckoutButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Uncheck on \"Ship to the same address\" option");
        checkoutPage.uncheckOnShipToSameAddressOption();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingFirstName + "\" into First Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_FirstName", billingFirstName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingLastName + "\" into Last Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_LastName", billingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingEmail + "\" into Email text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_Email", billingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Select \"" + billingCountry + "\" Country");
        checkoutPage.selectBillingCountry(billingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Select \"" + billingState + "\" State");
        checkoutPage.selectBillingState(billingState);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingCity + "\" into City text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_City", billingCity);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingAddress1 + "\" into Address 1 text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_Address1", billingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingZipCode + "\" into Zip/postal code text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_ZipPostalCode", billingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Input \"" + billingPhone + "\" into Phone number text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_PhoneNumber", billingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Billing Address Step: Click <CONTINUE> button");
        checkoutPage.clickOnBillingAddressStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Select \"New Address\" option");
        checkoutPage.selectShippingAddressOption("New Address");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingFirstName + "\" into First Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_FirstName", shippingFirstName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingLastName + "\" into Last Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_LastName", shippingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingEmail + "\" into Email text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_Email", shippingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Select \"" + shippingCountry + "\" Country");
        checkoutPage.selectShippingCountry(shippingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Select \"" + shippingState + "\" State");
        checkoutPage.selectShippingState(shippingState);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingCity + "\" into City text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_City", shippingCity);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingAddress1 + "\" into Address 1 text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_Address1", shippingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingZipCode + "\" into Zip/postal code text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_ZipPostalCode", shippingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Input \"" + shippingPhone + "\" into Phone number text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_PhoneNumber", shippingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Address Step: Click <CONTINUE> button");
        checkoutPage.clickOnShippingAddressStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Shipping Method Step: Click <CONTINUE> button");
        checkoutPage.clickOnShippingMethodStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Payment Method Step: Click <CONTINUE> button");
        checkoutPage.clickOnPaymentMethodStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Payment Information Step: Click <CONTINUE> button");
        checkoutPage.clickOnPaymentInformationStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address Name");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("name"), billingFirstName + " " + billingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address Email");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("email"), "Email: " + billingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address Phone");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("phone"), "Phone: " + billingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address Address1");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("address1"), billingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address City and Zip Postal Code");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("city-state-zip"), billingCity + "," + billingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Billing Address Country");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("country"), billingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Payment Method");
        verifyEquals(checkoutPage.getConfirmOrderStepPaymentMethod(), "Check / Money Order");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address Name");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("name"), shippingFirstName + " " + shippingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address Email");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("email"), "Email: " + shippingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address Phone");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("phone"), "Phone: " + shippingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address Address1");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("address1"), shippingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address City and Zip Postal Code");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("city-state-zip"), shippingCity + "," + shippingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Address Country");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("country"), shippingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Method");
        verifyEquals(checkoutPage.getConfirmOrderStepShippingMethod(), "Ground");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Product Info in Shopping Cart");
        verifyTrue(checkoutPage.isProductDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2", "$3,600.00"));

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Gift wrapping option");
        verifyEquals(checkoutPage.getConfirmOrderStepGiftWrappingOption(), "Gift wrapping: No");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Sub-total Price");
        verifyEquals(checkoutPage.getConfirmOrderStepSubTotalPrice(), "$3,600.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Shipping Fee");
        verifyEquals(checkoutPage.getConfirmOrderStepShippingFee(), "$0.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Tax Price");
        verifyEquals(checkoutPage.getConfirmOrderStepTaxPrice(), "$0.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Verify Total Price");
        verifyEquals(checkoutPage.getConfirmOrderStepTotalPrice(), "$3,600.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Confirm Order Step: Click <CONTINUE> button");
        checkoutPage.clickOnConfirmOrderStepContinueButton();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Thank You page: Verify Success message");
        verifyEquals(checkoutPage.getThankYouPageSuccessMessage(), "Your order has been successfully processed!");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Thank You page: Verify Order Number is displayed");
        verifyTrue(checkoutPage.isOrderNumberDisplayed());

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Thank You page: Get Order Number");
        String orderNumber = checkoutPage.getOrderNumber();

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Thank You page: Click on \"My account\" link on Header link");
        checkoutPage.clickOnDynamicHeaderLinkByClassName(driver, "ico-account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: My Account page: Click on \"Order\" menu");
        myAccountPage.clickOnDynamicLeftMenuLinkByClassName("customer-orders");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: My Account page: Verify Order Number");
        verifyEquals(myAccountPage.getFirstOrderNumber(), orderNumber);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: My Account page: Click on Order Detail");
        orderDetailPage = myAccountPage.clickOnDynamicOrderDetailByOrderNumber(orderNumber);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Order Number");
        verifyEquals(orderDetailPage.getOrderNumber(), orderNumber);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Order Date");
        verifyEquals(orderDetailPage.getOrderDate(), expectedDate);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Order Status");
        verifyEquals(orderDetailPage.getOrderStatus(), "Pending");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Order Total");
        verifyEquals(orderDetailPage.getOrderTotal(), "$3,600.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address Name");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("name"), billingFirstName + " " + billingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address Email");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("email"), "Email: " + billingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address Phone");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("phone"), "Phone: " + billingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address Address1");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("address1"), billingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address City and Zip Postal Code");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("city-state-zip"), billingCity + "," + billingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Billing Address Country");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("country"), billingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Payment Method");
        verifyEquals(orderDetailPage.getPaymentMethod(), "Check / Money Order");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address Name");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("name"), shippingFirstName + " " + shippingLastName);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address Email");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("email"), "Email: " + shippingEmail);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address Phone");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("phone"), "Phone: " + shippingPhone);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address Address1");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("address1"), shippingAddress1);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address City and Zip Postal Code");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("city-state-zip"), shippingCity + "," + shippingZipCode);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Address Country");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("country"), shippingCountry);

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Method");
        verifyEquals(orderDetailPage.getShippingMethod(), "Ground");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Product Info in Shopping Cart");
        verifyTrue(orderDetailPage.isProductDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2", "$3,600.00"));

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Gift wrapping option");
        verifyEquals(orderDetailPage.getGiftWrappingOption(), "No");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Sub-total Price");
        verifyEquals(orderDetailPage.getSubTotalPrice(), "$3,600.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Shipping Fee");
        verifyEquals(orderDetailPage.getShippingFee(), "$0.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Tax Price");
        verifyEquals(orderDetailPage.getTaxPrice(), "$0.00");

        log.info("Order 05 - Checkout With Cheque Payment Method - Step: Order Detail page: Verify Total Price");
        verifyEquals(orderDetailPage.getTotalPrice(), "$3,600.00");
    }

    @Test
    public void Order_06_Checkout_With_Credit_Card_Payment_Method() {
        productName = "Apple MacBook Pro 13-inch";
        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Input Product Name \"" + productName + "\" into Header Search text box");
        orderDetailPage.inputIntoHeaderSearchTextBox(driver, productName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Click Product \"" + productName + "\" from Search suggestion");
        productDetailPage = orderDetailPage.clickOnProductFromSearchSuggestionByName(driver, productName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Click <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Click on Shopping Cart on Header Link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Select \"No\" Gift wrapping option");
        cartPage.selectGiftWrapping("No");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Check on Agree to ToS checkbox");
        cartPage.checkOnAgreeToTermOfServiceCheckbox();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Click on <CHECKOUT> button");
        checkoutPage = cartPage.clickOnCheckoutButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Uncheck on \"Ship to the same address\" option");
        checkoutPage.uncheckOnShipToSameAddressOption();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Select \"New Address\" option");
        checkoutPage.selectBillingAddressOption("New Address");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingFirstName + "\" into First Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_FirstName", billingFirstName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingLastName + "\" into Last Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_LastName", billingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingEmail + "\" into Email text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_Email", billingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Select \"" + billingCountry + "\" Country");
        checkoutPage.selectBillingCountry(billingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Select \"" + billingState + "\" State");
        checkoutPage.selectBillingState(billingState);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingCity + "\" into City text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_City", billingCity);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingAddress1 + "\" into Address 1 text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_Address1", billingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingZipCode + "\" into Zip/postal code text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_ZipPostalCode", billingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Input \"" + billingPhone + "\" into Phone number text box");
        checkoutPage.inputIntoTextBoxByID(driver, "BillingNewAddress_PhoneNumber", billingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Billing Address Step: Click <CONTINUE> button");
        checkoutPage.clickOnBillingAddressStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Select \"New Address\" option");
        checkoutPage.selectShippingAddressOption("New Address");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingFirstName + "\" into First Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_FirstName", shippingFirstName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingLastName + "\" into Last Name text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_LastName", shippingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingEmail + "\" into Email text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_Email", shippingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Select \"" + shippingCountry + "\" Country");
        checkoutPage.selectShippingCountry(shippingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Select \"" + shippingState + "\" State");
        checkoutPage.selectShippingState(shippingState);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingCity + "\" into City text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_City", shippingCity);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingAddress1 + "\" into Address 1 text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_Address1", shippingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingZipCode + "\" into Zip/postal code text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_ZipPostalCode", shippingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Input \"" + shippingPhone + "\" into Phone number text box");
        checkoutPage.inputIntoTextBoxByID(driver, "ShippingNewAddress_PhoneNumber", shippingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Address Step: Click <CONTINUE> button");
        checkoutPage.clickOnShippingAddressStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Shipping Method Step: Click <CONTINUE> button");
        checkoutPage.clickOnShippingMethodStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Method Step: Select \"Credit Card\" option");
        checkoutPage.checkOnDynamicPaymentMethodCheckboxByLabel("Credit Card");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Method Step: Click <CONTINUE> button");
        checkoutPage.clickOnPaymentMethodStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Select Credit Card type = \"Visa\"");
        checkoutPage.selectCreditCardType("Visa");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Input into \"Cardholder name\" text box");
        checkoutPage.inputIntoTextBoxByID(driver, "CardholderName", "MINH");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Input into \"Card number\" text box");
        checkoutPage.inputIntoTextBoxByID(driver, "CardNumber", "4111111111111111");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Select \"Expiration date\" - Select Year");
        checkoutPage.selectExpirationYear("2030");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Input into \"Card code\" text box");
        checkoutPage.inputIntoTextBoxByID(driver, "CardCode", "123");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Payment Information Step: Click <CONTINUE> button");
        checkoutPage.clickOnPaymentInformationStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address Name");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("name"), billingFirstName + " " + billingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address Email");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("email"), "Email: " + billingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address Phone");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("phone"), "Phone: " + billingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address Address1");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("address1"), billingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address City and Zip Postal Code");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("city-state-zip"), billingCity + "," + billingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Billing Address Country");
        verifyEquals(checkoutPage.getTextOfDynamicBillingAddressInfoFieldByClass("country"), billingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Payment Method");
        verifyEquals(checkoutPage.getConfirmOrderStepPaymentMethod(), "Credit Card");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address Name");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("name"), shippingFirstName + " " + shippingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address Email");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("email"), "Email: " + shippingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address Phone");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("phone"), "Phone: " + shippingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address Address1");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("address1"), shippingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address City and Zip Postal Code");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("city-state-zip"), shippingCity + "," + shippingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Address Country");
        verifyEquals(checkoutPage.getTextOfDynamicShippingAddressInfoFieldByClass("country"), shippingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Method");
        verifyEquals(checkoutPage.getConfirmOrderStepShippingMethod(), "Ground");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Product Info in Shopping Cart");
        verifyTrue(checkoutPage.isProductDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2", "$3,600.00"));

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Gift wrapping option");
        verifyEquals(checkoutPage.getConfirmOrderStepGiftWrappingOption(), "Gift wrapping: No");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Sub-total Price");
        verifyEquals(checkoutPage.getConfirmOrderStepSubTotalPrice(), "$3,600.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Shipping Fee");
        verifyEquals(checkoutPage.getConfirmOrderStepShippingFee(), "$0.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Tax Price");
        verifyEquals(checkoutPage.getConfirmOrderStepTaxPrice(), "$0.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Verify Total Price");
        verifyEquals(checkoutPage.getConfirmOrderStepTotalPrice(), "$3,600.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Confirm Order Step: Click <CONTINUE> button");
        checkoutPage.clickOnConfirmOrderStepContinueButton();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Thank You page: Verify Success message");
        verifyEquals(checkoutPage.getThankYouPageSuccessMessage(), "Your order has been successfully processed!");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Thank You page: Verify Order Number is displayed");
        verifyTrue(checkoutPage.isOrderNumberDisplayed());

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Thank You page: Get Order Number");
        String orderNumber = checkoutPage.getOrderNumber();

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Thank You page: Click on \"My account\" link on Header link");
        checkoutPage.clickOnDynamicHeaderLinkByClassName(driver, "ico-account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: My Account page: Click on \"Order\" menu");
        myAccountPage.clickOnDynamicLeftMenuLinkByClassName("customer-orders");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: My Account page: Verify Order Number");
        verifyEquals(myAccountPage.getFirstOrderNumber(), orderNumber);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: My Account page: Click on Order Detail");
        orderDetailPage = myAccountPage.clickOnDynamicOrderDetailByOrderNumber(orderNumber);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Order Number");
        verifyEquals(orderDetailPage.getOrderNumber(), orderNumber);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Order Date");
        verifyEquals(orderDetailPage.getOrderDate(), expectedDate);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Order Status");
        verifyEquals(orderDetailPage.getOrderStatus(), "Pending");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Order Total");
        verifyEquals(orderDetailPage.getOrderTotal(), "$3,600.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address Name");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("name"), billingFirstName + " " + billingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address Email");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("email"), "Email: " + billingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address Phone");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("phone"), "Phone: " + billingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address Address1");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("address1"), billingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address City and Zip Postal Code");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("city-state-zip"), billingCity + "," + billingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Billing Address Country");
        verifyEquals(orderDetailPage.getTextOfDynamicBillingAddressInfoFieldByClass("country"), billingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Payment Method");
        verifyEquals(orderDetailPage.getPaymentMethod(), "Credit Card");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address Name");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("name"), shippingFirstName + " " + shippingLastName);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address Email");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("email"), "Email: " + shippingEmail);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address Phone");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("phone"), "Phone: " + shippingPhone);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address Address1");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("address1"), shippingAddress1);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address City and Zip Postal Code");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("city-state-zip"), shippingCity + "," + shippingZipCode);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Address Country");
        verifyEquals(orderDetailPage.getTextOfDynamicShippingAddressInfoFieldByClass("country"), shippingCountry);

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Method");
        verifyEquals(orderDetailPage.getShippingMethod(), "Ground");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Product Info in Shopping Cart");
        verifyTrue(orderDetailPage.isProductDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2", "$3,600.00"));

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Gift wrapping option");
        verifyEquals(orderDetailPage.getGiftWrappingOption(), "No");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Sub-total Price");
        verifyEquals(orderDetailPage.getSubTotalPrice(), "$3,600.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Shipping Fee");
        verifyEquals(orderDetailPage.getShippingFee(), "$0.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Tax Price");
        verifyEquals(orderDetailPage.getTaxPrice(), "$0.00");

        log.info("Order 06 - Checkout With Credit Card Payment Method - Step: Order Detail page: Verify Total Price");
        verifyEquals(orderDetailPage.getTotalPrice(), "$3,600.00");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
