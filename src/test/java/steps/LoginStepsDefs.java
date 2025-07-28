package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LoginStepsDefs {

    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_login_page(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @And("I click on login")
    public void i_click_login() {
        // Already clicked inside loginPage.login()
    }

    @Then("I should land on the products page")
    public void verify_landing_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
