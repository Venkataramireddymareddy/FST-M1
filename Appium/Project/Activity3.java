package appiumLiveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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

public class Activity3 {

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
    public void testToDoListpage(){

        driver.get("https://www.training-support.net/selenium");

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollTextIntoView(\"To-Do List\")")));
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollTextIntoView(\"To-Do List\")")).click();
        driver.findElementByXPath("//android.view.View[contains(@content-desc,'To-Do')]").click();

        //add tasks to the list
        List<String> list = new ArrayList<>();
        list.add("Add tasks to list");
        list.add("Get number of tasks");
        list.add("Clear the list");

        for(int i=0;i<list.size();i++){
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
            MobileElement addTaskBox=driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
            addTaskBox.sendKeys(list.get(i));
            MobileElement addTaskButton= driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']"));
            addTaskButton.click();

        }

        //strike the tasks
       List<MobileElement> tasks=driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");

        for(int j=1;j<tasks.size();j++){
            //String actual=tasks.get(j).getText();
           // String expected=list.get(n);
            //n++;
           // Assert.assertEquals(actual,expected);
            tasks.get(j).click();
        }

        //clear list
        driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]").click();


    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
