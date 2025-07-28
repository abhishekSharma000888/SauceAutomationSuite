package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

import static org.testng.Assert.assertTrue;

public class CheckoutStepDefs {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = loginPage.login(username, password);
    }

    @And("I add the product {string} to the cart")
    public void i_add_product_to_cart(String productName) {
        homePage.addProductToCart(productName);
        cartPage = homePage.navigateToCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        checkoutPage = cartPage.proceedToCheckout();
    }

    @And("I enter first name {string}, last name {string}, and zip code {string}")
    public void i_enter_checkout_info(String firstName, String lastName, String zip) {
        checkoutPage.enterUserDetails(firstName, lastName, zip);
    }

    @And("I finish the checkout process")
    public void i_finish_checkout() {
        confirmationPage = checkoutPage.completeCheckout();
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_confirmation(String expectedMessage) {
        assertTrue(confirmationPage.getConfirmationText().contains(expectedMessage));
    }
}
