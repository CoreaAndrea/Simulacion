package simulacion4;

import org.openqa.selenium.WebDriver;

public class PruebaFactory {
	public static TabletPage crearPruebaTablet() {
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://advantageonlineshopping.com/#/");
        return new TabletPage(driver);
    }

}

