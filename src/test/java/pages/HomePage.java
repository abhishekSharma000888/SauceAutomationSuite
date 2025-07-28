package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String productId = productName.toLowerCase().replaceAll(" ", "-");
        driver.findElement(By.id("add-to-cart-" + productId)).click();
    }

    public CartPage navigateToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }
}
