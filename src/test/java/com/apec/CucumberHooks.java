package com.apec;

import com.apec.pages.*;
import com.apec.utils.BaseClass;
import com.apec.utils.ExcelManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CucumberHooks extends BaseClass {

    @Before
    public void setup(){
        setupDriver();
        System.out.println("voici le driver "+driver);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, CorporatePage.class);
        PageFactory.initElements(driver,MonCentrePage.class);
    }
    @After
    public void teardown() throws IOException {
        closeDriver(driver);
        ExcelManager.formatResult("Verification.xlsx","Data");
//      SendEmail.sendEmailTo("fokourou@zenity.fr");
//        SendEmail.sendEmailTo("israel.mouofopk68@gmail.com");
    }


}