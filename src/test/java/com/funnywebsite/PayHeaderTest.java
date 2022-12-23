package com.funnywebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayHeaderTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximising browser window
        driver.manage().window().maximize();
    }

    @Test
    public void checkSBCSubText(){

        String url = "http://localhost:3000";
        driver.get(url);
        System.out.println("navigated to url");

        WebElement SBCMessage = driver.findElement(By.className("payheader"));
        String SBCExpectedMessage = "SBC Subscription Required";
        String SBCActualMessage = SBCMessage.getText();
        Assert.assertTrue(SBCActualMessage.contains(SBCExpectedMessage),"Error SBC Sub header doesn't match");

    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        // close browser
        driver.quit();
    }


}
