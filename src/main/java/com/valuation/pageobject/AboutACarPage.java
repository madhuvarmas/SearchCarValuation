package com.valuation.pageobject;

import com.valuation.base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AboutACarPage extends WebDriverBase {

    @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/div/div/div/div[1]/div[1]/div/div/div[1]/div[2]/p[1]")
    private WebElement registrationNumber;

    @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/div/div/div/div[1]/div[1]/div/div/div[1]/div[2]/p[2]")
    private WebElement makeAndModel;

    @FindBy(xpath="//*[@id=\"form-field-mileage\"]")
    private WebElement mileageText;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/fieldset[1]/div[2]/label[2]/span/span")
    private WebElement noModificationButton;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/fieldset[2]/div[2]/label[2]/span")
    private WebElement noPersonalisedRegButton;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/fieldset[3]/div[2]/label[2]/span")
    private WebElement noOutstandingFinanceButton;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/fieldset[4]/div[2]/label[1]/span[1]")
    private WebElement fullServiceHistory;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/button/span")
    private WebElement nextButton;

    @FindBy(xpath="//*[@id=\"quiz-helper-form\"]/div/fieldset/div[2]/label[2]/span[2]/span[1]")
    private WebElement notAnyHelpButton;

    @FindBy(xpath="//*[@id=\"quiz-helper-form\"]/div/button/span")
    private WebElement helpNextButton;

    @FindBy(xpath="//*[@id=\"your-car-condition-form\"]/div/fieldset/div[2]/label[3]/span/span")
    private WebElement carConditionButton;

    @FindBy(xpath="//*[@id=\"your-car-condition-form\"]/div/button/span")
    private WebElement carConditionNextButton;

    @FindBy(xpath="//*[@id=\"form-field-firstName\"]")
    private WebElement firstName;

    @FindBy(xpath="//*[@id=\"form-field-lastName\"]")
    private WebElement lastName;

    @FindBy(xpath="//*[@id=\"form-field-email\"]")
    private WebElement email;

    @FindBy(xpath="//*[@id=\"form-field-marketingConsentEmail\"]")
    private WebElement promotionBox;

    @FindBy(xpath="//*[@id=\"your-car-details-form\"]/div/button/span")
    private WebElement finalNextButton;

    @FindBy(css="#main-content > div > div:nth-child(2) > div > div > div > div.sc-bqWxrE.eFlfgA > div > button")
    private WebElement seeMyValuationButton;

    @FindBy(id="main-footer")
    private WebElement footer;


    public AboutACarPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
    }

    public ValuationDetailsPage aboutCarDetails() {
        yourCarDetailsSection();
        anyHelpSection();
        carConditionSection();
        tellUsYourselfSection();
        footer.click();
        seeMyValuationButton.click();

        return new ValuationDetailsPage();
    }

    private void tellUsYourselfSection() {
        firstName.sendKeys("Test");
        lastName.sendKeys("Test");
        email.sendKeys("Test.Test@gmail.com");
        promotionBox.click();
        finalNextButton.click();
    }

    private void yourCarDetailsSection() {
        mileageText.sendKeys("100000");
        noModificationButton.click();
        noPersonalisedRegButton.click();
        noOutstandingFinanceButton.click();

        fullServiceHistory.click();
        nextButton.click();
    }
    private void anyHelpSection() {
        notAnyHelpButton.click();
        helpNextButton.click();
    }

    private void carConditionSection() {
        carConditionButton.click();
        carConditionNextButton.click();
    }

    public String getRegistrationNumber() {
        String[] regNumberArray = registrationNumber.getText().split(": ");
        return  regNumberArray[1];
    }
    public String getMake() {
        String[] makeAndModel = getMakeAndModelArray();
        return  makeAndModel[1].substring(0, makeAndModel[1].indexOf(' '));
    }
    public String getModel(){
        String[] makeAndModel = getMakeAndModelArray();
        return  makeAndModel[1].substring(makeAndModel[1].indexOf(' ')+1);
    }

    private String[] getMakeAndModelArray() {
        return makeAndModel.getText().split(": ");
    }

}
