package com.apec.pages;

import com.apec.utils.BaseClass;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class MonCentrePage extends BaseClass {

    @FindBy(xpath = "//input[@id='searchText']")
    public static WebElement searchField;

    @FindBy(xpath = "//button[@id='searchButton']")
    public static WebElement searchButton;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/apec-carte-centre[1]/div[1]/apec-recherche-centre[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/div[2]/div[1]/a[1]/span[1]")
    public static WebElement gronobleResult;

    @FindBy(xpath = "//a[contains(text(),'PRENEZ RENDEZ-VOUS')]")
    public static WebElement prenezRendezVousButton;

    @FindBy(xpath = "//div[contains(@class,'ng-option-selected')]")
    public static WebElement defaultValue;

    @FindBy(xpath = "//body/main[1]/apec-demande-service[1]/div[1]/div[1]/span[1]")
    public static WebElement loadingSpinner;

    @FindBy(xpath = "/html/body/main/apec-demande-service/apec-rdv-generique/section/div/form/div/div[1]/div/div/div[1]/div/div[2]/ng-select/div/div/div[3]/input")
    public static WebElement selectBox;

    @FindBy(xpath = "/html/body/main/apec-demande-service/apec-rdv-generique/section/div/form/div/div[2]/div/div[2]/p[1]")
    public static WebElement centre;

    public static String bugStatus;


    public static void searchPostalCode(String postalCode) throws InterruptedException {
        searchField.sendKeys(postalCode);
        attente(1);
        searchField.sendKeys(Keys.RETURN);

    }
    public static void chooseGrenoble () throws InterruptedException {

        try{gronobleResult.click();}
        catch(Exception e){
            attente(5);
            try{gronobleResult.click();}
            catch(Exception ex){
                gronobleResult.click();
            }
        }

    }

    public static void clickOnPrenezRendezVousButton(){
        prenezRendezVousButton.click();
    }
    public static boolean checkSpinner(){
       return loadingSpinner.isDisplayed();
    }
    public static List<WebElement> getSelectedText(){
        Select selectObj = new Select(selectBox);
        selectObj.getFirstSelectedOption();
        return selectObj.getAllSelectedOptions();
    }
    public static void handleSpinner(){
        try{
            if (MonCentrePage.checkSpinner()){
                System.out.println("spinner present");
            }
        }catch(Exception e){
            System.out.println("spiner pas present");
        }
    }

    public static void verifictionBug620() throws IOException {
        if(centre.getText().contains("Grenoble")){
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+" Le centre choisi est celui qui est pris en compte par defaut bug corrige");
        }else {
            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" Le centre choisi n'est toujours pas pris en compte par defaut bug non corrige");
        }
        writeResultInFile("620",bugStatus);
    }


}
