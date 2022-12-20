package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");


    }

    @Test
    public void activity2Method(){
        String pageURL=driver.findElement(By.xpath("(//img)[1]")).getAttribute("src");
        System.out.println("URL of header image is:\n "+ pageURL);
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}

