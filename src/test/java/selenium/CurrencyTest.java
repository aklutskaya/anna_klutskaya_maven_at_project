package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CurrencyTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions make = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.booking.com/");

        WebElement currency = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));
        make.moveToElement(currency).perform();
        driver.findElement(By.xpath("//div[contains(string(),'Select your currency')]"));

        WebElement language = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        make.moveToElement(language).perform();
        driver.findElement(By.xpath("//div[contains(string(),'Select your language')]"));

        driver.quit();

    }
}
