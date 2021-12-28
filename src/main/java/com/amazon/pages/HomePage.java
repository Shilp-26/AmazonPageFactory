package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id ="twotabsearchtextbox" )
    WebElement searchTab;

    @CacheLookup
    @FindBy(id ="nav-search-submit-button" )
    WebElement searchBtn;

    public void clickOnSearchBtn(){
        clickOnElement(searchBtn);
        CustomListeners.test.log(Status.PASS, "Click on search button:  ");
        Reporter.log("Clicking on search button: " +  "<br>");
    }

    public void searchForProduct(String productName){
        sendTextToElement(searchTab,productName);
        clickOnElement(searchBtn);
        CustomListeners.test.log(Status.PASS,"Enter search text into Search box " + productName);
        Reporter.log("Enter Search text : '" + productName + "' Search box" + "<br>");
    }


}
