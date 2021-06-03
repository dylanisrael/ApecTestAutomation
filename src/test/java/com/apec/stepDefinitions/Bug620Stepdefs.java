package com.apec.stepDefinitions;

import com.apec.pages.HomePage;
import com.apec.pages.MonCentrePage;
import com.apec.utils.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Bug620Stepdefs extends BaseClass {
    @And("^login to Apec with ([^\"]*) and ([^\"]*)$")
    public void loginToApecWithEmailAndPassword(String email, String password) throws IOException, InterruptedException {
        HomePage.loginToApec(email, password);

    }

    @And("User clicked on mon centre")
    public void userClickedOnMonCentre() throws IOException, InterruptedException {
        HomePage.clickOnMonCentre();
        attente(2);
    }

    @And("^User entered ([^\"]*)$")
    public void userEnteredPostalcode(String postalcode) throws IOException, InterruptedException {
        attente(1);
        MonCentrePage.searchPostalCode(postalcode);
    }
    @When("User click on Centre apec grenoble in results")
    public void userClickOnCentreApecGrenobleInResults() throws InterruptedException {
        attente(4);
    MonCentrePage.chooseGrenoble();
    attente(2);
    MonCentrePage.handleSpinner();


    }
    @And("User clicked on Prenez rendez-vous")
    public void userClickedOnPrenezRendezVous() throws InterruptedException {
        attente(1);
        MonCentrePage.clickOnPrenezRendezVousButton();
        attente(5);

    }
    @Then("Appointment center should be stored in memory")
    public void appointmentCenterShouldBeStoredInMemory() throws InterruptedException, IOException {
        attente(1);
    System.out.println("le rendez vous est cale par defaut pour : "+ MonCentrePage.centre.getText());
    MonCentrePage.verifictionBug620();
    attente(10);
    }
    @And("User logout from Apec")
    public void userLogoutFromApec() throws IOException, InterruptedException {
            HomePage.logoutFromApec();
            attente(10);
    }



}
