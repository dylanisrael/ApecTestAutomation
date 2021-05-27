package com.apec.pages;

import com.apec.utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CorporatePage extends BaseClass {

    static String bugStatus ="KO";

    @FindBy(xpath = "//a[contains(text(),'Contactez-nous')]")
    public static WebElement contactezNousLink;


    public static void clickOnContactezNousLink(){
        contactezNousLink.click();
    }
    public static void verificationBug621(){
        try{
            String urlContactezNousCorporate = contactezNousLink.getAttribute("href");
            if(urlContactezNousCorporate.equals(HomePage.urlContactezNousHomePage)){
                bugStatus ="OK";
                System.out.println("✅ "+bugStatus+" Le click sur contacter renvoi pas vers la page de contact bug corrige ");
            System.out.println("Lien de corporate"+urlContactezNousCorporate);
                System.out.println("Lien de homepage"+HomePage.urlContactezNousHomePage);
            } else{
                bugStatus ="KO";
                System.out.println("❌ "+bugStatus+" Le click sur contacter nous ne renvoi pas vers la page de contact bug non corrige");
                System.out.println("Lien de corporate "+urlContactezNousCorporate);
                System.out.println("Lien de homepage "+HomePage.urlContactezNousHomePage);
            }
            writeResultInFile("621",bugStatus);
        }catch (Exception e){
            System.out.println("Le click sur contacter nous ne renvoi pas vers la page de contact bug non corrige ");
        }
    }

}
