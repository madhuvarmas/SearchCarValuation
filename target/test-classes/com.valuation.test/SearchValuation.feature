@search
Feature: Search car valuation on website

  Scenario Outline: Reads the input file and verify car search details
    Given Read the input text file <INPUT_FILE> with registration number
    When  Navigate to website and start car valuation
    Then  Compare the details in output text file <OUTPUT_FILE>

    Examples:
      | INPUT_FILE    | OUTPUT_FILE    |
      | car_input.txt | car_output.txt |


