package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps extends BaseClass{

    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
        public void loginPage() {

            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //Open browser
            driver.get("https://www.training-support.net/selenium/login-form");
        }

        @When("^User enters username and password$")
        public void enterCredentials() {
            //Enter username
            driver.findElement(By.id("username")).sendKeys("admin");
            //Enter password
            driver.findElement(By.id("password")).sendKeys("password");
            //Click Login
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }

        @Then("^Read the page title and confirmation message$")
        public void readTitleAndHeading() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

            //Read the page title and heading
            String pageTitle = driver.getTitle();
            String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

            //Print the page title and heading
            System.out.println("Page title is: " + pageTitle);
            System.out.println("Login message is: " + confirmMessage);
        }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String uname, String pwd) {
        //Enter username
        driver.findElement(By.id("username")).sendKeys(uname);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(pwd);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("Closes the browser")
    public void closesTheBrowser() {
        driver.close();
    }
}
