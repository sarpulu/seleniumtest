package com.funnywebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class formTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximising browser window
        driver.manage().window().maximize();
    }
    @Test
    public void formClick(){

        String url = "http://localhost:3000";
        driver.get(url);
        System.out.println("navigated to url");

        driver.findElement(By.name("nuke")).click();
        driver.findElement(By.name("nothing")).click();
        driver.findElement(By.name("Something")).click();


//
//       driver.findElement(By.id("formbutton")).click();

        driver.findElement(By.xpath("//*[text()='Submit']")).click();
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
