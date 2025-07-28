package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup(){
        driver = DriverFactory.initDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
