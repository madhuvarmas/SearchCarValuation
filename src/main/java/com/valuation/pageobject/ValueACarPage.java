package com.valuation.pageobject;

import com.valuation.base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ValueACarPage extends WebDriverBase {

    @FindBy(id="vrm")
    private WebElement searchText;

    @FindBy(xpath ="//*[@id=\"__next\"]/main/div[2]/div/div/div/article/div[2]/div/form/button")
    private  WebElement valuationButton;

    @FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/button")
    private  WebElement allowCookies;


    public ValueACarPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
    }


    public AboutACarPage sendRegistrationNumber(String number, boolean allowCookiesFlag) {
        searchText.sendKeys(number);
        if (!allowCookiesFlag) {
            allowCookies.click();
        }
        valuationButton.click();
        return new AboutACarPage();
    }


}
