package simulacion5;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class CarritoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CarritoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void agregarProductosAlCarrito() throws InterruptedException {
        // Mouse
        wait.until(ExpectedConditions.elementToBeClickable(By.id("miceImg"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'HP Z4000 Wireless Mouse')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart"))).click();

        driver.get("https://advantageonlineshopping.com/#/");

        // Laptop
        wait.until(ExpectedConditions.elementToBeClickable(By.id("laptopsImg"))).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'HP ENVY')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart"))).click();
    }

    public void abrirCarrito() {
        driver.get("https://advantageonlineshopping.com/#/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCart"))).click();
    }

    public void validarProducto(String nombre, String color, String precio) {
        WebElement nombreEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[contains(text(),'" + nombre + "')]")));
        if (nombreEl.isDisplayed()) {
            System.out.println("Nombre del producto visible: " + nombre);
        }

        WebElement colorEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.productColor[title='" + color + "']")));
        if (colorEl.isDisplayed()) {
            System.out.println("Color del producto visible: " + color);
        }

        WebElement precioEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'" + precio + "')]")));
        if (precioEl.isDisplayed()) {
            System.out.println("Precio del producto visible: " + precio);
        }
    }
   
    public void validarProductosEnCarrito() {
        WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[contains(text(),'HP Z4000 WIRELESS MOUSE')]")));
        assertEquals("HP Z4000 WIRELESS MOUSE", nombre.getText().trim());

        WebElement color = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.productColor[title='RED']")));
        assertEquals("RED", color.getDomAttribute("title").trim());

        WebElement precio = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'$9.99')]")));
        assertEquals("$9.99", precio.getText().trim());

    
        WebElement nombreLaptop = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[contains(text(),'HP ENVY - 17T TOUCH LAPTOP')]")));
        assertEquals("HP ENVY - 17T TOUCH LAPTOP", nombreLaptop.getText().trim());

        WebElement colorLaptop = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.productColor[title='GRAY']")));
        assertEquals("GRAY", colorLaptop.getDomAttribute("title").trim());

        WebElement precioLaptop = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'$849.99')]")));
        assertEquals("$849.99", precioLaptop.getText().trim());
    }

}