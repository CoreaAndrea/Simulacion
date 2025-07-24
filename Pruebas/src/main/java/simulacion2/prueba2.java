package simulacion2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class prueba2 {
	private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverSingleton.getInstancia().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = LoginPage.create(driver);
        loginPage.abrirPagina();
    }

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.login("Kiara", "Solead02");
        
        WebElement usuarioVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#menuUserLink > span.hi-user")
            ));

            String textoEsperado = "Kiara";
            String textoReal = usuarioVisible.getText();

            assertEquals(textoEsperado, textoReal);
    }

    @After
    public void cerrar() {
        DriverSingleton.getInstancia().cerrarDriver();
    }
}

