package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //This test case will pass
        String pageTitle = driver.getTitle();
        System.out.println("Title is: " + pageTitle);
        Assert.assertEquals(pageTitle, "Target Practice");
    }

    @Test
    public void testCase2() {
        //This test case will Fail
        WebElement blackButton = driver.findElement(By.xpath("//button[contains(@class,'black')]"));
        Assert.assertFalse(blackButton.isDisplayed(),"Black button is available");
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        System.out.println("This test case will be skipped");
    }

    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }

    @AfterClass
    public void afterClass() {
        //Close the browser
        driver.close();
    }

}