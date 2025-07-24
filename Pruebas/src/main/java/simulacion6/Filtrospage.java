package simulacion6;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Filtrospage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public Filtrospage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void abrirCategoriaSpeakers() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("speakersImg"))).click();
    }

    public void aplicarFiltroPrecio() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionPrice"))).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        WebElement sliderIzquierdo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".noUi-handle-lower")));
        actions.dragAndDropBy(sliderIzquierdo, -10, 0).perform();

        WebElement sliderDerecho = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".noUi-handle-upper")));
        actions.dragAndDropBy(sliderDerecho, -50, 0).perform();
    }

    public void aplicarFiltroCompatibilidad() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib0"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("compatibility_0"))).click();
    }

    public void aplicarFiltroManufacturer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib1"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("manufacturer_1"))).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
    }

    public void aplicarFiltroWeight() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib2"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("weight_2"))).click();
    }

    public void aplicarFiltroWirelessTech() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib3"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("wireless_technology_1"))).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
    }

    public void aplicarFiltroColor() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionColor"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productsColors414141"))).click();
    }
    public void validarProductosFiltrados() throws InterruptedException {
        Thread.sleep(2000); 

        List<WebElement> productos = driver.findElements(By.cssSelector(".productName"));

        if (!productos.isEmpty()) {
            System.out.println("Productos mostrados luego de aplicar los filtros:");
            for (WebElement producto : productos) {
                System.out.println("- " + producto.getText());
            }
        } else {
            System.out.println("No se encontraron productos luego de aplicar los filtros.");
        }
     }
}

