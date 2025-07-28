package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

import static org.testng.AssertJUnit.assertTrue;

public class AddToCartStepDefs {
    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @When("I add the product {string} to the cart")
    public void i_add_product(String productName) {
        homePage.addProductToCart(productName);
        cartPage = homePage.navigateToCart();
    }

    @Then("the product {string} should be present in the cart")
    public void product_should_be_in_cart(String productName) {
        assertTrue(cartPage.isProductInCart(productName));
    }
}
