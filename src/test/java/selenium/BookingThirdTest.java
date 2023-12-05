package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BookingThirdTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        Actions make = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.booking.com/");

        WebElement searchField = driver.findElement(By.name("ss"));
        searchField.sendKeys("Прага");
        driver.findElement(By.xpath("//div[@data-testid='searchbox-layout-wide']/div/button")).click();
        driver.findElement(By.xpath("//nav[@data-testid='datepicker-tabs']//following-sibling::div/div[2]/table//tr[2]/td[1]")).click();
        driver.findElement(By.xpath("//nav[@data-testid='datepicker-tabs']//following-sibling::div/div[2]/table//tr[2]/td[7]")).click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='bayesian_review_score']")).click();

        WebElement firstHotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//a[@data-testid='title-link']"));
        firstHotel.click();
        Thread.sleep(5000);





//        driver.quit();

    }
}
