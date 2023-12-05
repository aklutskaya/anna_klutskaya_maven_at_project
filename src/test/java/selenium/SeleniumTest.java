package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {

    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new ChromeDriver();

//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }
}
