package selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class SchoolsTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions make = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1. Перейти на сайт https://www.w3schools.com/java/

        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.cssSelector("#accept-choices")).click();

//        2. Двойным кликом выделить в заголовке слово Tutorial

        WebElement tutorial = driver.findElement(By.xpath("//span[@class='color_h1']"));
        make.doubleClick(tutorial).perform();

//        3. Скопировать используя горячие клавиши Ctrl+c

        make.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

//        4. Перейти на сайт https://google.com

        driver.get(" https://google.com");
        WebElement submitForm = driver.findElement(By.xpath("//button[contains(string(),'Zaakceptuj wszystko')]"));
        submitForm.click();

//        5. Вставить в строку поиска скопированное

        WebElement search = driver.findElement(By.name("q"));
        search.click();
        make.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

//        6. Запустить поиск клавишей Enter

        make.sendKeys(Keys.ENTER).build().perform();

//        7. Убедиться, что каждый из результатов содержит искомое слово

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='search']/div/div/div"));
        String expectedWord = "Tutorial";
        boolean result = searchResults.stream().allMatch(res -> res.getText().contains(expectedWord));
        Assert.assertEquals("All results don't contsins search word: ", true, result);

        driver.quit();
    }
}
