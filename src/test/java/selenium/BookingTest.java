package selenium;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BookingTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        Actions make = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.booking.com/");

//        2. Найти отели для города «Париж»,с проживанием на 7 ночей заездом через 3 дня

        WebElement searchField = driver.findElement(By.name("ss"));
        searchField.sendKeys("Париж");

//        driver.findElement(By.xpath("//div[text()='Париж']")).click();

        make.sendKeys(Keys.ENTER).build().perform();
//        driver.findElement(By.xpath("//span[text()='Check-in Date']")).click();
        driver.findElement(By.xpath("//nav[@data-testid='datepicker-tabs']//following-sibling::div/div[2]/table//tr[2]/td[1]")).click();
        driver.findElement(By.xpath("//nav[@data-testid='datepicker-tabs']//following-sibling::div/div[2]/table//tr[2]/td[7]")).click();
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        WebElement guestAmount = driver.findElement
                (By.xpath("//input[@id='group_adults']/following-sibling::div[2]/button[2]"));
        guestAmount.click();
        guestAmount.click();
        WebElement roomAmount = driver.findElement
                (By.xpath("//input[@id='no_rooms']/following-sibling::div[2]/button[2]"));
        roomAmount.click();
        driver.findElement(By.xpath("//div[@data-testid='searchbox-layout-wide']/div/button")).click();

//        3. Отфильтровать отели с рейтингом 5

        WebElement scroll = driver.findElement(By.xpath("//h3[contains(string(),'Bed Preference')]"));
        new Actions(driver).scrollToElement(scroll).perform();
        driver.findElement(By.xpath("//div[@data-filters-item='class:class=5']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver,Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class).until(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-card']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//        Отсортировать по рейтингу начиная с самого низкого и проверить, что у первого в списке он == 5

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']//span[contains(string(),'Property rating (low to high)')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver,Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class).until(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-card']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        List<WebElement> list = driver.findElements(By.xpath("//div[@data-testid='property-card'][1]/div/div[2]//div[@data-testid='rating-stars']/span"));
        int count = (int) list.stream().count();
        Assert.assertEquals("Rating doesn't have 5 stars: ", 5, count);

        driver.quit();
    }
}
