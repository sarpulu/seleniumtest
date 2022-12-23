package com.funnywebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkMovieHeader {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximising browser window
        driver.manage().window().maximize();
    }

    @Test
    public void checkMovieText(){

        String url = "http://localhost:3000";
        driver.get(url);
        System.out.println("navigated to url");

        WebElement MovieMessage = driver.findElement(By.id("movieoftheyear"));
        String MovieExpectedMessage = "MOVIE OF THE YEAR";
        String MovieActualMessage = MovieMessage.getText();
        Assert.assertTrue(MovieActualMessage.contains(MovieExpectedMessage),"Error Movie header doesn't match");

        WebElement RDJMessage = driver.findElement(By.id("rdj"));
        String RDJExpectedMessage = "Robert Downey Jr. talking about the filming process.";
        String RDJActualMessage = RDJMessage.getText();
        Assert.assertTrue(RDJActualMessage.contains(RDJExpectedMessage),"Error RDJ banner doesn't match");

    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        // close browser
        driver.quit();
    }

}
