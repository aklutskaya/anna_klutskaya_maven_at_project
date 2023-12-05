package testWebDriver.tests;

import org.junit.After;
import org.junit.Before;
import testWebDriver.driver.WebDriverInit;

import java.time.Duration;

import static testWebDriver.driver.WebDriverInit.driver;

public class BaseTest {

    @Before
    public void openBrowser() {
        WebDriverInit.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void close() {
        driver.quit();
    }
}
