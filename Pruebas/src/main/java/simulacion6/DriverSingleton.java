package simulacion6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
            driver = new ChromeDriver(co);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void cerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}