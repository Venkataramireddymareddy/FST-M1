package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");


    }

    @Test
    public void setup(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void activity3Method(){
        String pageTitle=driver.getTitle();
        System.out.println("Home page is opened");
        System.out.println("HomePage Title is: "+ pageTitle);
        Assert.assertEquals(pageTitle,"OrangeHRM");
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}

