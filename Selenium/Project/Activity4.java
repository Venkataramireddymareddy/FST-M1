package SeleniumLiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");


    }

    @Test(priority = 0)
    public void aasetup(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void activity4Method(){
        //find and click on PIM button
        WebElement pimButton=driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();

        //find and click on add employee button
        WebElement addEmployeeButton= driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();

        //fill in employee details
        String ufirstNmae="Jagruti";
        String uLastName="Badhan";
        WebElement fName= driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lName= driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement addButton= driver.findElement(By.xpath("//input[@id='btnSave']"));
        fName.sendKeys(ufirstNmae);
        lName.sendKeys(uLastName);
        addButton.click();

        //click on employe list
        WebElement employeeList= driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        employeeList.click();

        //search the created employee
        WebElement empName= driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
        empName.sendKeys("Jagruti Badhan");
        WebElement searchButton= driver.findElement(By.xpath("//input[@id='searchBtn']"));
        searchButton.click();

        //validate that the employee is created
        WebElement firstName= driver.findElement(By.xpath("(//table[@id='resultTable'])/tbody/tr/td[3]"));
        WebElement lastName= driver.findElement(By.xpath("(//table[@id='resultTable'])/tbody/tr/td[4]"));
        Assert.assertEquals(firstName.getText(),ufirstNmae);
        Assert.assertEquals(lastName.getText(),uLastName);


    }

    @AfterClass
    public void afterMethod(){
       driver.close();
    }

}

