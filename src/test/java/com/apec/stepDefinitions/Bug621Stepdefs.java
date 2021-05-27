package com.apec.stepDefinitions;

import com.apec.pages.CorporatePage;
import com.apec.pages.HomePage;
import com.apec.utils.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Bug621Stepdefs extends BaseClass {
    @Given("^User is on Apec home page$")
    public void userIsOnApecHomePage() throws InterruptedException {
        navigateToHomePage();
        attente(1);
        coockieHandle();
        attente(2);

    }

    @And("User clicked on site corporate link")
    public void userClickedOnSiteCorporateLink() throws InterruptedException {
        HomePage.clickOnSiteCorporateLink();
        attente(2);
    }

    @When("user clicked on contactez-nous link")
    public void userClickedOnContactezNousLink() {
        CorporatePage.clickOnContactezNousLink();

    }

    @Then("User should be on contact page")
    public void userShouldBeOnContactPage() {
        CorporatePage.verificationBug621();
    }
}
