package simulacion1;

import org.openqa.selenium.WebDriver;

public class Basepage {
	protected WebDriver driver;

    public Basepage() {
        this.driver = DriverManager.getInstancia().getDriver();
    }

}