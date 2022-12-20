package StepDefinitions;

import io.cucumber.java.en.And;

public class CloseBrowser extends BaseClass {
    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}
