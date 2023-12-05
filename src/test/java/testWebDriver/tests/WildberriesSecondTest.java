package testWebDriver.tests;

import org.junit.Before;
import org.junit.Test;

import static testWebDriver.driver.WebDriverInit.driver;

public class WildberriesSecondTest extends BaseTest{

    @Before
    public void openHomePage() {
        driver.get("https://www.wildberries.by");
    }

    @Test
    public void filterAndGetProductsAmount() {

    }




}
