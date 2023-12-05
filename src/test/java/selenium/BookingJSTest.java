package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BookingJSTest {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        Actions make = new Actions(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.booking.com/");
        WebElement searchField = driver.findElement(By.name("ss"));
        searchField.sendKeys("London");
        make.sendKeys(Keys.ENTER).build().perform();

        WebElement tenthHotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]/div"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", tenthHotel);

        File asfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(asfile, new File("pic.png"));

        driver.quit();

    }
}
