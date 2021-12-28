package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'See more')]")
    WebElement productDesc;

    @CacheLookup
    @FindBy(id = "quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement mobileAddToCartMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement laptopAddToCartMessage;

    public void clickOnProductDescription(){
        clickOnElement(productDesc);
    }

    public void selectQty(String qty){
        selectByVisibleTextFromDropDown(quantity,qty);
        CustomListeners.test.log(Status.PASS, "Select Qty: ");
        Reporter.log("Select quantity from dropdown : '" + qty + "' dropdown" + "<br>");
    }

    public void clickOnAddToCartBtn(){
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Clicking on Add to Cart: ");
        Reporter.log("Click on Add to cart button : " + "<br>");
    }

    public void verifyLaptopAddToCartMessage(String message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualString = doGetTextFromElement(laptopAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify product added to cart message : '" + message +  "<br>");
    }

    public void verifyMobileAddToCartMessage(String message)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualString = doGetTextFromElement(mobileAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS, "Verify Add to cart message: ");
        Reporter.log("Verify product added to cart message : " +  "<br>");
    }

}
