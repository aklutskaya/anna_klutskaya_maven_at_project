package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demoqa.com/select-menu/");

        WebElement selectElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectElement);
        select.selectByIndex(2);
        driver.quit();
    }
}
