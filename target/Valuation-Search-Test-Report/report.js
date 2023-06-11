$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("target/test-classes/com.valuation.test/SearchValuation.feature");
formatter.feature({
  "name": "Search car valuation on website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Reads the input file and verify car search details",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Read the input text file \u003cINPUT_FILE\u003e with registration number",
  "keyword": "Given "
});
formatter.step({
  "name": "Navigate to website and start car valuation",
  "keyword": "When "
});
formatter.step({
  "name": "Compare the details in output text file \u003cOUTPUT_FILE\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "INPUT_FILE",
        "OUTPUT_FILE"
      ]
    },
    {
      "cells": [
        "car_input.txt",
        "car_output.txt"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Reads the input file and verify car search details",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Read the input text file car_input.txt with registration number",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchValuationSteps.readsTheInputTextFile(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to website and start car valuation",
  "keyword": "When "
});
formatter.match({
  "location": "SearchValuationSteps.navigateToWebsiteAndStartCarValuation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Compare the details in output text file car_output.txt",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchValuationSteps.compareTheDetailsInOutputTextFile(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});