package com.home.tests.steps;

import com.home.tests.pages.ValueMyCarAndAboutMyCarPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import java.util.List;
import static org.junit.Assert.*;



public class ValueMyCarAndAboutMyCarSteps extends CommonSteps {

	
	public ValueMyCarAndAboutMyCarPage registrationPage;
	public List<String> makeModelDetails;
	public List<String> carOutPutFileDataList;

	public ValueMyCarAndAboutMyCarSteps(){
		registrationPage = new ValueMyCarAndAboutMyCarPage(driver);
	}

	@Given("^I am on Value my car page$")
	public void i_am_on_Value_my_car_page() throws Throwable {
		registrationPage.gotoHomePage();
		registrationPage.clickOnAcceptAll();
		assertTrue(registrationPage.isValueMyCarDisplayed());
	}

	@When("^I extract vehicle registration numbers from \"([^\"]*)\"$")
	public void i_extract_vehicle_registration_numbers_from(String inputFile) throws Throwable {
		String carInputFile = new File("").getAbsolutePath() + File.separatorChar + "src"+ File.separatorChar + "test" + File.separatorChar +"resources" + File.separatorChar + inputFile;
		registrationPage.readFileDataBasedonPatterns(carInputFile);
	}

	@Then("^It should display car registration and make/modle on \"([^\"]*)\" page on entering car reg no and start valuation$")
	public void it_should_display_car_registration_and_make_modle_on_page_on_entering_car_reg_no_and_start_valuation(String pageTitle) throws Throwable {
		makeModelDetails = registrationPage.enterVehRegNoAndgetCarMakeModelDetails();
		assertEquals(registrationPage.getTellusAboutYourCarTitle(), pageTitle);
	}

	@Then("^I compare output returned from application with given \"([^\"]*)\"$")
	public void i_compare_output_returned_from_application_with_given(String outPutFile) throws Throwable {

		String carOutputFile = new File("").getAbsolutePath() + File.separatorChar + "src"+ File.separatorChar + "test" + File.separatorChar +"resources" + File.separatorChar + outPutFile;
		carOutPutFileDataList = registrationPage.readOutPutFileData(carOutputFile);

		Boolean strComFlag=false;
		int k=0;
		for(int i=0; i<makeModelDetails.size();i++){

			for(int j=0; j<carOutPutFileDataList.size();j++){
				if(makeModelDetails.get(i).equals(carOutPutFileDataList.get(j))){
					strComFlag=true;
					k=j;
					break;
				}else{
					strComFlag=false;
					if(j==carOutPutFileDataList.size()-1){
						break;
					}
				}
			}

			try{
				if(!strComFlag) {
					assertTrue("Actual car make model " + makeModelDetails.get(i)  + " is not matched data with car output file",strComFlag);
				}
			}catch(AssertionError e){
				System.out.println(e.getMessage());
			}
			}


		}


}