package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;

public class WildberriesTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();

        driver.get("https://www.wildberries.by/");

        driver.findElement(By.xpath("//button[@class='search-component-button search-component-icon-catalog']")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Дом')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Гостиная')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item'][contains(string(),'Коробки для хранения')]")).click();
        driver.findElement(By.xpath("//div[@class='filter-more']")).click();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'до 5 дней')]")).click();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'IKEA')]")).click();
        WebElement scroll = driver.findElement(By.xpath("//div[@class='filter__header'][contains(string(),'Материал изделия')]"));
        new Actions(driver).scrollToElement(scroll).perform();
        WebElement minPrice = driver.findElement(By.xpath("//input[@data-tag='inputMin']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='0'", minPrice);

        WebElement maxPrice = driver.findElement(By.cssSelector(".filter.filter--price .input:nth-child(2) input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='50'", maxPrice);

        driver.findElement(By.xpath("//button[@class='filters-sidebar__close']")).click();
        String prodAmount = driver.findElement(By.cssSelector(".total-goods")).getText();
        System.out.println("Products amount on the page: " + prodAmount);
        driver.quit();

    }
}