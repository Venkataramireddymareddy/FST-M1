package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPages
{

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

        @Given("^User is on the page$")
        public void openPage() {

            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //Open browser
            driver.get("https://www.training-support.net/selenium/javascript-alerts");
        }

        @When("^User clicks the Simple Alert button$")
        public void openSimpleAlert() {
            driver.findElement(By.xpath("//button[@id='simple']")).click();
        }

        @When("^User clicks the Confirm Alert button$")
        public void openConfirmAlert() {
            driver.findElement(By.xpath("//button[@id='confirm']")).click();
        }

        @When("^User clicks the Prompt Alert button$")
        public void openPromptAlert() {
            driver.findElement(By.xpath("//button[@id='prompt']")).click();
        }

        @Then("^Alert opens$")
        public void switchFocus() {
            alert = driver.switchTo().alert();
        }

        @And("^Read the text from it and print it$")
        public void readAlert() {
            System.out.println("Alert text: " + alert.getText());
        }

        @And("^Close the alert$")
        public void closeAlert() {
            alert.accept();
        }

        @And("^Close the alert with Cancel$")
        public void closeAlertWithCancel() {
            alert.dismiss();
        }

        @And("Write a {string} in it")
        public void writeToAlert(String arg0) {
            alert.sendKeys(arg0);
        }

    @And("Close browser")
    public void closeBrowser() {
        driver.close();
    }
}
