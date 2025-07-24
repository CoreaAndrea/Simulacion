package simulacion7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Productopage {
	private WebDriver driver;
    private WebDriverWait wait;

    public Productopage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirPagina() {
        driver.get("https://www.advantageonlineshopping.com/");
    }

    public void agregarYEditarProducto() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("miceImg"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'HP Z4000 Wireless Mouse')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCart"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'edit')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.plus[increment-value-attr='+']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart"))).click();
    }

    public String obtenerCantidadProducto() {
        WebElement cantidadLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("td.quantityMobile > label.ng-binding")));
        return cantidadLabel.getText().trim();
    }
}