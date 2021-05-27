package com.apec.utils;


import com.apec.pages.HomePage;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver driver;
    static NgWebDriver NgWebDriver;
    static  JavascriptExecutor jsDriver;

    public static LocalDate date;
    public static LocalTime tps;
    public static String value_tps = getTime();
    public static String value_date = getDate();
    static String os = System.getProperty("os.name");
    static String path;
    static ExcelManager excel = new ExcelManager();


    public static void setupDriver(){
        if (os.startsWith("W")){
            path = (System.getProperty("user.dir")+"\\src\\test\\resources\\webDrivers\\chromedriver.exe");
        } else {
            path = (System.getProperty("user.dir")+"/src/test/resources/webDrivers/chromedriver");
        }


        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-blink-features");
        options.addArguments("incognito");
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public static void navigateToHomePage(){
        driver.get("https://www.apec.fr/");
    }


    public static void attente(int temps) throws InterruptedException {
        int sec = temps * 1000;
        Thread.sleep(sec);
    }

    public static void closeDriver(WebDriver driver){
        driver.quit();
    }
    public static String getDate(){
        date = LocalDate.now();
        value_date = date.toString();
        return value_date;
    }

    public static String getTime(){
        tps = LocalTime.now();
        value_tps = tps.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return value_tps;
    }

    public static void testCorrections(String bug_statut, String message){
        Assert.assertEquals(bug_statut,"OK", message);
    }
    public static void coockieHandle() throws InterruptedException {
    if (HomePage.cookieModal.isDisplayed())
        HomePage.acceptCookie.click();

    }

    public static void connexion(String email, String password) throws InterruptedException {


    }

    public static void writeResultInFile(String NUMBUG, String bug_statut) throws IOException {
        value_date = getDate();
        value_tps = getTime();
        excel.excelWriting(NUMBUG,bug_statut, value_date, value_tps);

    }


    public static boolean areElementsOverlapping(WebElement element1, WebElement element2) {
        Rectangle r1 = element1.getRect();
        Point topRight1 = r1.getPoint().moveBy(r1.getWidth(), 0);
        Point bottomLeft1 = r1.getPoint().moveBy(0, r1.getHeight());

        Rectangle r2 = element2.getRect();
        Point topRight2 = r2.getPoint().moveBy(r2.getWidth(), 0);
        Point bottomLeft2 = r2.getPoint().moveBy(0, r2.getHeight());

        if (topRight1.getY() > bottomLeft2.getY()
                || bottomLeft1.getY() < topRight2.getY()) {
            return false;
        }
        if (topRight1.getX() < bottomLeft2.getX()
                || bottomLeft1.getX() > topRight2.getX()) {
            return false;
        }
        return true;
    }
    public static void setBrowserSize(int width,int height) {
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(width, height));
    }

}
