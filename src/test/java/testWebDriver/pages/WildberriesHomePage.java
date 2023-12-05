package testWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static testWebDriver.driver.WebDriverInit.driver;

public class WildberriesHomePage  {

    public void openCategoryFilter() {
        driver.findElement(By.xpath("//button[@class='search-component-button search-component-icon-catalog']")).click();
    }
    public void findAndOpenBoxCategory() {
        driver.findElement(By.xpath("//span[contains(text(), 'Дом')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Гостиная')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item'][contains(string(),'Коробки для хранения')]")).click();
    }

    public void findAndOpenPlantsCategory() {
        WebElement scrollMenu = driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Канцтовары')]"));
        new Actions(driver).scrollToElement(scrollMenu).perform();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Зоотовары')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item has-arrow'][contains(string(),'Аквариумистика')]")).click();
        driver.findElement(By.xpath("//li[@class='menu-item'][contains(string(),'Декорации, растения')]")).click();
    }
}
