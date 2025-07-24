package simulacion3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductosPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public ProductosPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    public void abrirTablet() throws InterruptedException {
        WebElement tabletsCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabletsImg")));
        actions.moveToElement(tabletsCategory).click().perform();
        Thread.sleep(4000);

        WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p/a[contains(text(),'HP Elite x2 1011 G1 Tablet')]")));
        actions.moveToElement(producto).click().perform();
    }

    public String obtenerEspecificacion(String labelTexto) {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//label[@class='attr ng-binding' and normalize-space()='" + labelTexto + "']")));
        WebElement value = label.findElement(By.xpath("following-sibling::label[@class='value ng-binding']"));
        return value.getText();
    }
}
