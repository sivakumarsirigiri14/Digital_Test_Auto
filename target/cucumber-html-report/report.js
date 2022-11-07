$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featureFiles/GetCarRegFromInputFileAndValidate.feature");
formatter.feature({
  "line": 2,
  "name": "Validate Car Registration numbers",
  "description": "",
  "id": "validate-car-registration-numbers",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@vehicleregistration"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": ": verify to input extracted car Registration numbers from Input file and search in car valuation page and compare output registration, make or model aginst car out file data",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-aginst-car-out-file-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on Value my car page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I extract vehicle registration numbers from \u003cInputfile\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "It should display car registration and make/modle on \"Tell us about your car\" page on entering car reg no and start valuation",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I compare output returned from application with given \u003cOutputFile\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-aginst-car-out-file-data;",
  "rows": [
    {
      "cells": [
        "Inputfile",
        "OutputFile"
      ],
      "line": 12,
      "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-aginst-car-out-file-data;;1"
    },
    {
      "cells": [
        "\"car_input_v1.txt\"",
        "\"car_output_v1.txt\""
      ],
      "line": 13,
      "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-aginst-car-out-file-data;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5337937776,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": ": verify to input extracted car Registration numbers from Input file and search in car valuation page and compare output registration, make or model aginst car out file data",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-aginst-car-out-file-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@vehicleregistration"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on Value my car page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I extract vehicle registration numbers from \"car_input_v1.txt\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "It should display car registration and make/modle on \"Tell us about your car\" page on entering car reg no and start valuation",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I compare output returned from application with given \"car_output_v1.txt\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ValueMyCarAndAboutMyCarSteps.i_am_on_Value_my_car_page()"
});
formatter.result({
  "duration": 2316964531,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car_input_v1.txt",
      "offset": 45
    }
  ],
  "location": "ValueMyCarAndAboutMyCarSteps.i_extract_vehicle_registration_numbers_from(String)"
});
formatter.result({
  "duration": 11842563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tell us about your car",
      "offset": 54
    }
  ],
  "location": "ValueMyCarAndAboutMyCarSteps.it_should_display_car_registration_and_make_modle_on_page_on_entering_car_reg_no_and_start_valuation(String)"
});
formatter.result({
  "duration": 13983225274,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car_output_v1.txt",
      "offset": 55
    }
  ],
  "location": "ValueMyCarAndAboutMyCarSteps.i_compare_output_returned_from_application_with_given(String)"
});
formatter.result({
  "duration": 3108776,
  "status": "passed"
});
formatter.after({
  "duration": 1022274246,
  "status": "passed"
});
});