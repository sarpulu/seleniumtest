package com.funnywebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkBanner {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximising browser window
        driver.manage().window().maximize();
    }

    @Test
    public void checkText(){

        String url = "http://localhost:3000";
        driver.get(url);
        System.out.println("navigated to url");

        WebElement SBCMessage = driver.findElement(By.className("SBC"));
        String SBCExpectedMessage = "SBC NEWS";
        String SBCActualMessage = SBCMessage.getText();
        Assert.assertTrue(SBCActualMessage.contains(SBCExpectedMessage),"Error SBC header doesn't match");

        WebElement BNMessage = driver.findElement(By.className("BN"));
        String BNExpectedMessage = "BREAKING NEWS!!!";
        String BNActualMessage = BNMessage.getText();
        Assert.assertTrue(BNActualMessage.contains(BNExpectedMessage),"Error Breaking News banner doesn't match");

    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        // close browser
        driver.quit();
    }




}
