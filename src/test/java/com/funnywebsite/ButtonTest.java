package com.funnywebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximising browser window
        driver.manage().window().maximize();
    }

    @Test (priority = 1, enabled = true, groups = {"ButtonTests", "AllTests"})
    public void buttonClick(){

        String url = "http://localhost:3000";
        driver.get(url);
        System.out.println("navigated to url");

        driver.findElement(By.id("subbutton")).click();
        sleep(1000);
        driver.findElement(By.id("subbutton")).click();
        sleep(1000);
        driver.findElement(By.id("subbutton")).click();
        sleep(1000);
        driver.findElement(By.id("subbutton")).click();
        sleep(1000);
        driver.findElement(By.id("subbutton")).click();



        String imgActualSrc= driver.findElement(By.id("laugh")).getAttribute("src");
        String imgExpectedSrc= "http://localhost:3000/nicholas-cage.gif";
        Assert.assertEquals(imgActualSrc,imgExpectedSrc,"the picture is wrong");

        sleep(1000);

    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        // close browser
        driver.quit();
    }



    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
