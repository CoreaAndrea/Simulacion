package simulacion4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class TabletPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public TabletPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    public void abrirCategoriaTablets() {
        WebElement tabletsCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabletsImg")));
        actions.moveToElement(tabletsCategory).click().perform();
    }

    public void seleccionarProductoTablet() {
        WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p/a[contains(text(),'HP Elite x2 1011 G1 Tablet')]")));
        actions.moveToElement(producto).click().perform();
    }

    public void seleccionarColorYAgregarAlCarrito() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Color:']")));

        WebElement colorNegro = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[title='BLACK']")));
        actions.moveToElement(colorNegro).click().perform();

        Thread.sleep(1000); 

        WebElement botonMas = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.plus[increment-value-attr='+']")));
        botonMas.click();

        WebElement botonAgregarCarrito = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@name='save_to_cart']")));
        botonAgregarCarrito.click();
        
        WebElement carritoIcono = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCart")));
        carritoIcono.click();
        
        //validacion
        
        WebElement cantidadLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("td.quantityMobile > label.ng-binding")
            ));
            String cantidadTexto = cantidadLabel.getText().trim();
            assertEquals("2", cantidadTexto);

           
        WebElement colorSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.productColor")
            ));
            String colorSeleccionado = colorSpan.getDomAttribute("title").trim();
            assertEquals("BLACK", colorSeleccionado);


    }
}