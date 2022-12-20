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

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:deviceId","a958ce14");
        cap.setCapability("appPackage","com.android.contacts");
        cap.setCapability("appActivity",".DialtactsContactsEntryActivity");
        cap.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, cap);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void newContact(){
        // Using resource-id
        driver.findElementByAccessibilityId("Create new contact").click();

        // Using XPath
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Name']")));
       MobileElement name= driver.findElementByXPath("//android.widget.EditText[@text='Name']");
        MobileElement phoneNo= driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        name.sendKeys("test contact");
        phoneNo.sendKeys("9665582989");

        MobileElement saveButton=driver.findElementByXPath("//android.widget.Button[@text='Done']");
        saveButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='test contact']")));

        //find contact
        MobileElement contact=driver.findElementByXPath(
                "//android.widget.TextView[@text='test contact']");
        String contactname= contact.getText();


        // Assertion
        Assert.assertEquals(contactname, "test contact");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
