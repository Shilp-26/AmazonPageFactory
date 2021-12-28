package com.amazon.testbase;


import com.amazon.propertyreader.PropertyReader;
import com.amazon.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","regression"})
    public void tearDown(){
        closeBrowser();
    }
}
