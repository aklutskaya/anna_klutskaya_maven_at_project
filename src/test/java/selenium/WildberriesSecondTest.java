package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WildberriesSecondTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://www.wildberries.by/");

        driver.findElement(By.xpath("//button[@class='search-component-button search-component-icon-catalog']")).click();
        WebElement scrollMenu = driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Канцтовары')]"));
        new Actions(driver).scrollToElement(scrollMenu).perform();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Зоотовары')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Аквариумистика')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item'][contains(string(),'Декорации, растения')]")).click();

//        Запомнить сколько товаров на странице

        String prodAmount = driver.findElement(By.cssSelector(".total-goods")).getText();
        System.out.println("Prod Amount: " + prodAmount);

//        Отфильтровать Грунт, цена до 100, Тип Галька, Упаковка Мешок

        driver.findElement(By.xpath("//div[@class='filter-more']")).click();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'Грунт')]")).click();
        WebElement scroll = driver.findElement(By.xpath("//div[@class='filter__header'][contains(string(),'Упаковка')]"));
        new Actions(driver).scrollToElement(scroll).perform();

        WebElement minPrice = driver.findElement(By.xpath("//input[@data-tag='inputMin']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='0'", minPrice);

        WebElement maxPrice = driver.findElement(By.cssSelector(".filter.filter--price .input:nth-child(2) input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='100'", maxPrice);

        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'Галька')]")).click();
        WebElement scrollDown = driver.findElement(By.xpath("//div[@class='filter is-folded'][4]/button"));
        new Actions(driver).scrollToElement(scrollDown).perform();
        driver.findElement(By.xpath("//div[@class='filter__item '][contains(string(),'Мешок')]")).click();
        driver.findElement(By.xpath("//button[@class='filters-sidebar__close']")).click();

        driver.findElement(By.xpath("//div[@class='chip chip--reset-button']")).click();

        String prodAmountAfterReset = driver.findElement(By.cssSelector(".total-goods")).getText();
        System.out.println("Total goods after reset: " + prodAmountAfterReset);
        driver.quit();
    }
}
