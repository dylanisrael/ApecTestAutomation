package com.apec.pages;

import com.apec.utils.BaseClass;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MonCentrePage extends BaseClass {

    @FindBy(xpath = "//input[@id='searchText']")
    public static WebElement searchField;

    @FindBy(xpath = "//button[@id='searchButton']")
    public static WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Centre Apec - Grenoble')]")
    public static WebElement gronobleResult;

    @FindBy(xpath = "//a[contains(text(),'PRENEZ RENDEZ-VOUS')]")
    public static WebElement prenezRendezVousButton;

    @FindBy(xpath = "//div[contains(@class,'ng-option-selected')]")
    public static WebElement defaultValue;

    @FindBy(xpath = "//body/main[1]/apec-demande-service[1]/div[1]/div[1]/span[1]")
    public static WebElement loadingSpinner;

    @FindBy(xpath = "//input[@id='']")
    public static WebElement selectBox;


    public static void searchPostalCode(String postalCode) throws InterruptedException {
        searchField.sendKeys(postalCode);
        attente(1);
        searchField.sendKeys(Keys.RETURN);

    }
    public static void chooseGrenoble (){
        gronobleResult.click();
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


}
