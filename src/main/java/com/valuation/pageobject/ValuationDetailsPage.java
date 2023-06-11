package com.valuation.pageobject;

import com.valuation.base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ValuationDetailsPage extends WebDriverBase {

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/div/div[2]/div[2]/div/h3")
    private WebElement valuation;

    @FindBy(xpath = "//*[@id=\"__next\"]/header/nav/div/div[1]/a")
    private WebElement homePage;

    @FindBy(xpath="//*[@id=\"__next\"]/header/nav/div/div[2]/ul/li[3]/button")
    private WebElement sellMenu;

    @FindBy(xpath="//*[@id=\"__next\"]/header/nav/div/div[2]/ul/li[3]/div/div/section/div[1]/div/section/div[2]/ul/li/div/p")
    private WebElement valueMyCar;

    public ValuationDetailsPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
    }

    public String getValuation() {
        return valuation.getText();
    }

    public ValueACarPage getHomePage() {
        homePage.click();
        sellMenu.click();
        valueMyCar.click();

        return new ValueACarPage();
    }
}
