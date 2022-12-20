package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:deviceId","a958ce14");
        cap.setCapability("appPackage","com.android.mms");
        cap.setCapability("appActivity",".ui.ConversationList");
        cap.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, cap);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sendMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[2]")));
        MobileElement addButton= driver.findElementByXPath("//android.widget.Button[2]");
        addButton.click();

       /* wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("compose_recipients_contacts")));
        MobileElement toContact=driver.findElementById("compose_recipients_contacts");
        toContact.sendKeys("9665582989");
        toContact.sendKeys(Keys.ENTER);*/
        String contactBoxLocator = "resourceId(\"com.android.mms:id/compose_recipients_contacts\")";

        // Enter your own phone number
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@content-desc=\"To\"]")));
        driver.findElement(MobileBy.xpath("//android.widget.EditText[@content-desc=\"To\"]")).sendKeys("9665582989");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));


        MobileElement enterMessage=driver.findElementById("embedded_text_editor");
        enterMessage.sendKeys("Hello from Appium");

        MobileElement sendButton=driver.findElementById("send_button");
        sendButton.click();

        // Wait for message to show
        //String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("text_view")));

        // Assertion
        String sentMessageText = driver.findElementById("text_view").getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");

}

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
