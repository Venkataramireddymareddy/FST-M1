package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");


    }

    @Test
    public void aasetup(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void activity6Method(){
        //search directory menu
        WebElement directoryMenu= driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
        if (directoryMenu.isDisplayed()){
            System.out.println("Option is visible");
            if (directoryMenu.isEnabled()){
                System.out.println("Option is clickable");
                directoryMenu.click();
                directoryMenu.click();
            }
            else{
                System.out.println("Directory option is not be clickable");
            }
        }else{
            System.out.println("Directory option is not visible");
        }

        //heading of the page
        WebElement heading=driver.findElement(By.xpath("//div[@class='head']/h1"));
        String headingText=heading.getText();
        Assert.assertEquals(headingText,"Search Directory");
    }

    @AfterClass
    public void afterMethod(){
       driver.close();
    }

}

