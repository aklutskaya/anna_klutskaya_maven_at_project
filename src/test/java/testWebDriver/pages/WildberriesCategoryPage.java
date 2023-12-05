package testWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static testWebDriver.driver.WebDriverInit.driver;

public class WildberriesCategoryPage {

    public static final String MIN_PRICE = "//input[@data-tag='inputMin']";
    public static final String MAX_PRICE = ".filter.filter--price .input:nth-child(2) input";
    public static final String CLOSE_FILTER = "//button[@class='filters-sidebar__close']";

    public void filterCategoryByDeliveryAndProd() {
        driver.findElement(By.xpath("//div[@class='filter-more']")).click();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'до 5 дней')]")).click();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'IKEA')]")).click();

    }
    public void filterCategoryByTypeAndPackage() {
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'Галька')]")).click();
        WebElement scrollDown = driver.findElement(By.xpath("//div[@class='filter is-folded'][4]/button"));
        new Actions(driver).scrollToElement(scrollDown).perform();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'Мешок')]")).click();
    }

    public void filterCategoryByPrice() {
        WebElement scroll = driver.findElement(By.xpath("//div[@class='filter__header'][contains(string(),'Материал изделия')]"));
        new Actions(driver).scrollToElement(scroll).perform();
        WebElement minPrice = driver.findElement(By.xpath(MIN_PRICE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='0'", minPrice);
        WebElement maxPrice = driver.findElement(By.cssSelector(MAX_PRICE));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='50'", maxPrice);
    }

    public void filterByPrice() {
        WebElement scroll = driver.findElement(By.xpath("//div[@class='filter__header'][contains(string(),'Упаковка')]"));
        new Actions(driver).scrollToElement(scroll).perform();
        WebElement minPrice = driver.findElement(By.xpath("//input[@data-tag='inputMin']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='0'", minPrice);
        WebElement maxPrice = driver.findElement(By.cssSelector(".filter.filter--price .input:nth-child(2) input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='100'", maxPrice);
    }

    public void closeFilter() {
        driver.findElement(By.xpath(CLOSE_FILTER)).click();
    }

    public void countAmountOfProducts() {
        String prodAmount = driver.findElement(By.cssSelector(".total-goods")).getText();
        System.out.println("Products amount on the page: " + prodAmount);
    }
}
