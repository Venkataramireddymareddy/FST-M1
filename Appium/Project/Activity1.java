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

public class Activity1 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:deviceId","a958ce14");
        cap.setCapability("appPackage","com.google.android.apps.tasks");
        cap.setCapability("appActivity",".ui.TaskListsActivity");
        cap.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, cap);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addTask(){

        List<String> list = new ArrayList<>();
        list.add("Complete Activity with Google Tasks");
        list.add("Complete Activity with Google Keep");
        list.add("Complete the second Activity Google Keep");



        for(int i=0;i<list.size();i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
            MobileElement addtaskButton= driver.findElementByAccessibilityId("Create new task");
            addtaskButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
            MobileElement addtaskField=driver.findElementByXPath("//android.widget.EditText[@text='New task']");
            MobileElement saveButton=driver.findElementByXPath("//android.widget.Button[@text='Save']");
            addtaskField.sendKeys(list.get(i));
            saveButton.click();

        }
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));

        // Assertion
        List<MobileElement> taskList=driver.findElementsById("com.google.android.apps.tasks:id/task_name");

        int k= taskList.size()-1;
        for(int j=0;j<taskList.size();j++){

            Assert.assertEquals(taskList.get(k).getText(),list.get(j));
            k--;
        }



    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
