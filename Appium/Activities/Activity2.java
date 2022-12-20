package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:deviceId","a958ce14");
        cap.setCapability("appPackage","com.android.chrome");
        cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
        cap.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, cap);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testMethod(){

        driver.get("https://www.training-support.net/");
        //locate using class name
        String heading=driver.findElementByClassName("android.widget.TextView").getText();
        System.out.println("Heading :"+heading);

        //locate about us
        driver.findElementByAccessibilityId("About Us").click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='About Us']")));

        // Get heading on About Us page and print it
        String headingNew = driver.findElementByXPath("//android.widget.TextView[@text='About Us']").getText();
        System.out.println("New Heading :"+headingNew);

        // Assertion
        Assert.assertEquals(heading, "Training Support");
        Assert.assertEquals(headingNew, "About Us");



    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
