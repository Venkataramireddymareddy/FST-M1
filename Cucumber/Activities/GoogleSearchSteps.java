package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSteps extends BaseClass {


    @Given("^User is on Google Home Page$")
    public void navigateToGoogle() {

        //Open the browser
        driver.get("https://www.google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER(){
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void showSearchResults(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

}
