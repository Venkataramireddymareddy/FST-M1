package appiumLiveProject;

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
import java.util.ArrayList;
import java.util.List;

public class Activity2 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:deviceId","a958ce14");
        cap.setCapability("appPackage","com.google.android.keep");
        cap.setCapability("appActivity",".activities.BrowseActivity");
        cap.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, cap);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addNotes(){

            String noteTitle="Note Title";
            String noteDescription="Note description";

            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
            MobileElement addNoteButton= driver.findElementByAccessibilityId("New text note");
            addNoteButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
            //MobileElement addNoteField=driver.findElementById("com.google.android.keep:id/editable_title");
             MobileElement addNoteField=driver.findElementByXPath("//android.widget.EditText[@text='Title']");
            MobileElement noteDesc=driver.findElementByXPath("//android.widget.EditText[@text='Note']");
            addNoteField.sendKeys(noteTitle);
            noteDesc.sendKeys(noteDescription);

            MobileElement backButton=driver.findElementByAccessibilityId("Open navigation drawer");
            backButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
            String noteTitle1=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
            String noteDesc1=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();

            Assert.assertEquals(noteTitle1,noteTitle);
            Assert.assertEquals(noteDesc1,noteDescription);
       }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
