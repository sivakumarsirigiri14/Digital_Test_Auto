package com.home.tests.pages;

import com.home.tests.test.configutils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValueMyCarAndAboutMyCarPage {



    private WebDriver driver;

    @FindBy(css = "div>header>h1")
    private WebElement valueMyCar;

    @FindBy(css = ".gihvmi>span")
    private WebElement acceptAll;

    @FindBy(id = "vrm")
    private WebElement vrm;

    @FindBy(css = "form>button[type=submit]>span")
    private WebElement startValuation;

    @FindBy(css = "#main-content>div>div:nth-child(1)>div>h1")
    private WebElement tellUsAboutYourCarTitle;

    @FindBy(css = "div[data-test-id='your-registration-number-summary']>div>div>div:nth-child(2)")
    private WebElement regNumberMakeModel;

    @FindBy(css = "div[data-test-id='your-registration-number-summary']>div>div>div:nth-child(2)>p:nth-child(1)")
    private WebElement regNumber;

    @FindBy(css = "div[data-test-id='your-registration-number-summary']>div>div>div:nth-child(2)>p:nth-child(2), #your-registration-number-form>div>div[role='alert']>span")
    private WebElement regMakeModel;

    @FindBy(css = "#your-registration-number-form>div>div[role='alert']>span")
    private WebElement weCouldNotFoundCar;



    public List<String> vehicleList;

    public ValueMyCarAndAboutMyCarPage(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    public void gotoHomePage() {
        driver.get(ConfigUtils.getWebEndPoint());
    }

    public boolean isValueMyCarDisplayed(){
        return valueMyCar.isDisplayed();
    }

    public void clickOnAcceptAll(){
        if(acceptAll.isDisplayed()){
            acceptAll.click();
        }
    }

    public List<String> enterVehRegNoAndgetCarMakeModelDetails(){
        String vehDetailsAre;
        String makeOrModel=null;
        String model=null;
        String make=null;
        List<String> makeModelDetailsList = new ArrayList<String>();

        for(int i=0;i<vehicleList.size();i++) {

            if(i>0){
                gotoHomePage();
            }
            vrm.sendKeys(vehicleList.get(i));
            clickOnStartValuation();

            try {
                if(regMakeModel.isDisplayed()) {
                    makeOrModel = regMakeModel.getText();
                        make = makeOrModel.split("Make/model: ")[1].split(" ")[0];
                        model = makeOrModel.replace("Make/model: ", "").replace(make, "");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            if(makeOrModel.contains("Make/model:")) {
                vehDetailsAre = vehicleList.get(i).replace(" ","")+ "," + make + "," + model;
            }else{
                vehDetailsAre = vehicleList.get(i).replace(" ","")+ "," + makeOrModel;
            }
            makeModelDetailsList.add(vehDetailsAre);

        }
        return makeModelDetailsList;
    }

    public void clickOnStartValuation(){
        startValuation.click();
    }

    public String getTellusAboutYourCarTitle(){
          return tellUsAboutYourCarTitle.getText();
    };

    public void readFileDataBasedonPatterns(String fileToRead){

        ArrayList<String> vehList = new ArrayList<String>();

        String input = "[A-Z]{2}[0-9]{2}\\s[A-Z]{3}|[A-Z]{2}[0-9]{2}[A-Z]{3}";
        try
        {
            File file=new File(fileToRead);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;
            while((line=br.readLine())!=null)
            {
                Pattern p = Pattern.compile(input);
                Matcher m = p.matcher(line);
                while(m.find()){
                    String b = m.group(0);
                    vehList.add(b);
                }
                vehicleList=vehList;

                sb.append(line);
                sb.append("\n");
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public List<String> readOutPutFileData(String outPutfileToRead){
        ArrayList<String> outPutfileData = new ArrayList<String>();
        try
        {
            File file=new File(outPutfileToRead);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                outPutfileData.add(line);
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return outPutfileData;

    }
}
