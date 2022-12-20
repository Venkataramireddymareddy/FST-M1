package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
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
    public void activity7Method(){
        //find myInfo option and click on it
        WebElement myInfo= driver.findElement(By.xpath("//b[text()='My Info']"));

        wait.until(ExpectedConditions.elementToBeClickable(myInfo));
        myInfo.click();
        myInfo.click();

        //find qualifications option and click on it
        WebElement qualifications=driver.findElement(By.xpath("(//a[text()='Qualifications'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(qualifications));
        qualifications.click();

        //find add button
        WebElement addButton=driver.findElement(By.xpath("//input[@id='addWorkExperience']"));
        addButton.click();

        //enter company experience details
        WebElement companyname=driver.findElement(By.xpath("//input[@id='experience_employer']"));
        WebElement jobTitle=driver.findElement(By.xpath("//input[@id='experience_jobtitle']"));
        WebElement saveButton=driver.findElement(By.xpath("//input[@id='btnWorkExpSave']"));
        companyname.sendKeys("TCS");
        jobTitle.sendKeys("Automation Quality Analyst");
        saveButton.click();
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}
