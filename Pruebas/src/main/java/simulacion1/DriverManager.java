package simulacion1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	private static DriverManager instancia;
    private WebDriver driver;

    private DriverManager() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
    }

    public static DriverManager getInstancia() {
        if (instancia == null) {
            instancia = new DriverManager();
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