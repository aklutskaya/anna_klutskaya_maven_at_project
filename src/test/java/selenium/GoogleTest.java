package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class GoogleTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com/");

        WebElement submitForm = driver.findElement(By.xpath("//button[contains(string(),'Zaakceptuj wszystko')]"));
        submitForm.click();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("погода минск");
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        WebElement widget = driver.findElement(By.xpath("//div[@class='wob_df'][1]"));
        widget.click();
        Locale locale = new Locale("pl");
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        String dayOfWeek = ldt.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);

        WebElement day  = driver.findElement(By.xpath(String.format("//*[contains(@aria-label,'Celsius %s, 12:00')][1]",dayOfWeek)));
        String[] temperature = day.getAttribute("aria-label").split("°");
        System.out.println("Погода на завтра в 12:" + temperature[0]);
        driver.quit();
    }
}
