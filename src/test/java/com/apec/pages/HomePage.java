package com.apec.pages;

import com.apec.utils.BaseClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BaseClass {

    public static String bugStatus ="KO";
    public static String urlContactezNousHomePage;

    @FindBy(xpath = "//body/div[@id='onetrust-consent-sdk']/div[@id='onetrust-banner-sdk']/div[1]/div[1]/div[1]")
    public static WebElement cookieModal;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public static WebElement acceptCookie;

    @FindBy(xpath = "//a[contains(text(),'Site corporate')]")
    public static WebElement siteCorporateLink;

    @FindBy(xpath = "//a[contains(text(),'Contactez-nous')]")
    public static WebElement contactezNousLink;

    @FindBy(xpath ="//body/main[1]/section[1]/div[2]/div[1]/a[1]/img[1]")
    public static WebElement monConseilEnEvolutionProfessionelleButton;

    @FindBy(xpath = "//span[contains(text(),'Vous êtes RECRUTEUR')]")
    public static WebElement vousEtesRecruteurButton;

    @FindBy(xpath = "//header/nav[1]/div[1]/ul[1]/li[2]/a[1]")
    public static WebElement monEspaceButton;

    @FindBy(xpath = "//input[@id='emailid']")
    public static WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    public static WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(),'Se connecter')]")
    public static WebElement connexionButton;

    @FindBy(xpath = "/html[1]/body[1]/header[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]")
    public static WebElement deconnexionButton;

    @FindBy(xpath = "//header/nav[1]/div[1]/ul[1]/li[1]/a[1]")
    public static WebElement monCentreButton;

    public static void clickOnSiteCorporateLink() {
        urlContactezNousHomePage = HomePage.contactezNousLink.getAttribute("href");
        driver.navigate().to(siteCorporateLink.getAttribute("href"));
    }
    public static void verifictionBug604() throws IOException {
       boolean testResult = areElementsOverlapping(monConseilEnEvolutionProfessionelleButton,vousEtesRecruteurButton);
       if (testResult){
           bugStatus = "KO";
           System.out.println("❌ "+bugStatus+" Les boutons se supperposent toujours bug non corrige");
       }
       else {
           bugStatus = "OK";
           System.out.println("✅ "+bugStatus+" Les boutons ne se supperposent plus bug corrige");
       }
       writeResultInFile("604",bugStatus);

    }

    public static void loginToApec(String email,  String password) throws IOException, InterruptedException {
        monEspaceButton.click();
        attente(2);
        emailField.sendKeys(email);
        attente(2);
        passwordField.sendKeys(password);
        attente(2);
        connexionButton.click();
        attente(3);
    }
    public static void logoutFromApec() throws IOException{
        try{
        deconnexionButton.click();
    }catch (Exception e){
        System.out.println("Le script n'a pas pu deconnecter le compte");
    }
    }

    public static void clickOnMonCentre() throws IOException{
        driver.navigate().to(monCentreButton.getAttribute("href"));
    }



}
