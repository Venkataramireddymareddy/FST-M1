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
import java.util.List;

public class Activity9 {
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
    public void activity9Method(){

        //find myInfo option and click on it
        WebElement myInfo= driver.findElement(By.xpath("//b[text()='My Info']"));
        wait.until(ExpectedConditions.elementToBeClickable(myInfo));
        myInfo.click();
        myInfo.click();

        //find emergency contact option and click on it
        WebElement emergencyContact=driver.findElement(By.xpath("//a[text()='Emergency Contacts']"));
        wait.until(ExpectedConditions.elementToBeClickable(emergencyContact));
        emergencyContact.click();

        //find no of rows and columns
        List<WebElement> col=driver.findElements(By.xpath("//table[@id='emgcontact_list']/thead/tr/th"));
        int colSize= col.size();
        System.out.println("No of columns:"+colSize);
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        int rowSize= rows.size();
        System.out.println("No of rows:"+rowSize);

        for(int rowCount=1;rowCount<=rowSize;rowCount++){
            for(int colCount=2;colCount<=colSize;colCount++){
                WebElement ele=driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+rowCount+"]/td["+colCount+"]"));
                System.out.println("Data of["+rowCount+"]"+"["+colCount+"]: "+ele.getText());
            }
        }
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}
