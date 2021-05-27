package com.apec.stepDefinitions;

import com.apec.pages.HomePage;
import com.apec.utils.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Bug604Stepdefs extends BaseClass {
    @When("^User set windows size with ([^\"]*) and ([^\"]*)$")
    public void userSetWindowsSizeWithWidthAndHeight(int width, int height) throws InterruptedException {
        setBrowserSize(width, height);
        attente(3);
    }

    @Then("Elements are overlapping")
    public void elementsAreOverlapping() throws IOException {
        HomePage.verifictionBug604();
    }
}
