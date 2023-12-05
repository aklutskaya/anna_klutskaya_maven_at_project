package testWebDriver.tests;

import org.junit.Before;
import org.junit.Test;
import testWebDriver.pages.WildberriesCategoryPage;
import testWebDriver.pages.WildberriesHomePage;
import static testWebDriver.driver.WebDriverInit.driver;

public class WildberriesFirstTest extends BaseTest{

    @Before
    public void openHomePage() {
        driver.get("https://www.wildberries.by");
    }

    @Test
    public void filterAndGetProductsAmount() {

        WildberriesHomePage wbHomePage = new WildberriesHomePage();
        WildberriesCategoryPage wbCatPage = new WildberriesCategoryPage();

        wbHomePage.openCategoryFilter();
        wbHomePage.findAndOpenBoxCategory();
        wbCatPage.filterCategoryByDeliveryAndProd();
        wbCatPage.filterCategoryByPrice();
        wbCatPage.closeFilter();
        wbCatPage.countAmountOfProducts();
    }
}