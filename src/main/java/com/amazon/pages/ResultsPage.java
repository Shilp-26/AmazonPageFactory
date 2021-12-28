package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ResultsPage extends Utility {
    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "//li[@class='a-last']//a[1]")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'2021 Newest Lenovo Flex 5 14.0\" FHD Touchscreen La')]")
    WebElement product;

    public boolean isProductDisplayed(String dealer) {
        boolean myBreak = true;
        boolean isDisplayed = false;
        while (myBreak) {
            for (WebElement e : productsList) {
                if (e.getText().equalsIgnoreCase(dealer)) {
                    System.out.println(e.getText());
                    isDisplayed = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    nextButton.click();
                } else {
                    isDisplayed = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
            }
        }
        driver.navigate().to("https://www.amazon.com/s?k=Laptops&crid=QXAZC4NIHTFJ&sprefix=laptops%2Caps%2C276&ref=nb_sb_noss");
        return isDisplayed;
    }

    public void clickOnProduct() {
        clickOnElement(product);
        CustomListeners.test.log(Status.PASS, "Click on product:  ");
        Reporter.log("Clicking on product: " +  "<br>");
    }
}
