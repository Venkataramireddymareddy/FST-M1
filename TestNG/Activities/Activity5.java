package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {
    WebDriver driver;

    //BeforeClass Method
    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test (groups = {"HeaderTests"})
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.id("third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }

    @Test (groups = {"HeaderTests"})
    public void HeaderTest2() {
        WebElement header5 = driver.findElement(By.className("green"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[@class='ui olive button']"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest2() {
        WebElement button2 = driver.findElement(By.className("brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    //AfterClassMethod
    @AfterClass(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
