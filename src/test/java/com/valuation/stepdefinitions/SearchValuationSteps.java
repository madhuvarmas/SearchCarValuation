package com.valuation.stepdefinitions;

import com.valuation.base.WebDriverBase;
import com.valuation.pageobject.AboutACarPage;
import com.valuation.pageobject.ValuationDetailsPage;
import com.valuation.pageobject.ValueACarPage;
import com.valuation.util.FileReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class SearchValuationSteps extends WebDriverBase {

    private List<String> registrationNumbers;
    private ValueACarPage valueACarPage;
    private AboutACarPage aboutACarPage;
    private ValuationDetailsPage valuationDetailsPage;
    private Map<String, List<String>> carDetailsMap;


    @Before
    public void setup(){
        WebDriverBase.initialBrowser();
    }

    @Given("Read the input text file (.*) with registration number")
    public void readsTheInputTextFile(String inputFileName) throws IOException {
        registrationNumbers = FileReader.getRegistrationNumbers(inputFileName);
    }


    @When("Navigate to website and start car valuation")
    public void navigateToWebsiteAndStartCarValuation() {
        carDetailsMap = new HashMap<String, List<String>>();
        valueACarPage = new ValueACarPage();
        aboutACarPage = new AboutACarPage();
        valuationDetailsPage = new ValuationDetailsPage();
        boolean allowCookiesFlag = false;

        for(String carRegistrationNumber:registrationNumbers) {
            List<String> carDetails = new ArrayList<String>();
            aboutACarPage = valueACarPage.sendRegistrationNumber(carRegistrationNumber, allowCookiesFlag);

            carDetails.add(aboutACarPage.getRegistrationNumber());
            carDetails.add(aboutACarPage.getMake());
            carDetails.add(aboutACarPage.getModel());

            carDetailsMap.put(carRegistrationNumber, carDetails);

            valuationDetailsPage = aboutACarPage.aboutCarDetails();
            valueACarPage = valuationDetailsPage.getHomePage();

            allowCookiesFlag = true;
        }
    }

    @Then("Compare the details in output text file (.*)")
    public void compareTheDetailsInOutputTextFile(String outfileName) throws IOException {
        Map<String,List<String>> expectedDetails = FileReader.getExpectedDetails(outfileName);
        for (Map.Entry<String, List<String>> entry : expectedDetails.entrySet()) {
            System.out.println("Expected Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        for (Map.Entry<String, List<String>> entry : carDetailsMap.entrySet()) {
            System.out.println("Actual Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        assertFalse(carDetailsMap.equals(expectedDetails));
    }


    @After
    public void tearDown(){
        WebDriverBase.close();
    }

}

