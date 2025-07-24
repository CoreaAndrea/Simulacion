package simulacion2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static DriverSingleton instancia;
    private WebDriver driver;

    private DriverSingleton() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
    }

    public static DriverSingleton getInstancia() {
        if (instancia == null) {
            instancia = new DriverSingleton();
        }
        return instancia;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void cerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instancia = null;
        }
    }
}