package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

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
    public void activity5Method(){
        //find myInfo option and click on it
        WebElement myInfo= driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
        myInfo.click();

        //search edit button and click on it
        WebElement editButton= driver.findElement(By.xpath("//input[@id='btnSave']"));
        editButton.click();

        //edit the personal details
        WebElement fname= driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        WebElement lname= driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        WebElement nationality= driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        WebElement dateOfBirth= driver.findElement(By.xpath("//input[@id='personal_DOB']"));
        WebElement gender= driver.findElement(By.xpath("//input[@id='personal_optGender_2']"));

        fname.clear();
        fname.sendKeys("Jagruti");
        lname.clear();
        lname.sendKeys("Badhan");
        gender.click();
        Select nationalityList=new Select(nationality);
        nationalityList.selectByIndex(82);
        dateOfBirth.clear();
        dateOfBirth.sendKeys("1994-05-02");
        dateOfBirth.sendKeys(Keys.ENTER);

        //click on save button
        WebElement saveButton= driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveButton.click();
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }


}
