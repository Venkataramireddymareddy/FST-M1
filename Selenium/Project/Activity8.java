package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void activity8Method(){
        //find apply leave option and lick on it
        WebElement applyLeave= driver.findElement(By.xpath("(//span[@class='quickLinkText'])[4]"));
        wait.until(ExpectedConditions.visibilityOf(applyLeave));
        applyLeave.click();
        applyLeave.click();
        //find leaveType button
        WebElement leaveType= driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
        Select leaveTypedropDown=new Select(leaveType);
        leaveTypedropDown.selectByIndex(1);

        //find from date and to date
        WebElement fromdate=driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
        WebElement todate=driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
        fromdate.clear();
        fromdate.sendKeys("2022-03-02");
        fromdate.sendKeys(Keys.ENTER);
        todate.clear();
        todate.sendKeys("2022-03-03");
        todate.sendKeys(Keys.ENTER);

        //find apply button
        WebElement applyButton=driver.findElement(By.xpath("//input[@id='applyBtn']"));
        applyButton.click();

        //search and click on My leave button
        WebElement myLeave=driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']"));
        myLeave.click();

        //check leave status
        WebElement leaveStatus= driver.findElement(By.xpath("//a[contains(text(),'Pending')][1]"));
        String leaveStat=leaveStatus.getText();
        System.out.println("Leave Status: "+leaveStat);
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}
