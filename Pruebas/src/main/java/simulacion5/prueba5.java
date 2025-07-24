package simulacion5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class prueba5 {
	private static WebDriver driver;
    private static CarritoPage carritoPage;

    @Before
    public void iniciar() {
        driver = DriverSingleton.getDriver();
        driver.get("https://advantageonlineshopping.com/#/");
        carritoPage = crearCarrito(driver);
    }

    
    public static CarritoPage crearCarrito(WebDriver driver) {
        return new CarritoPage(driver);
    }

    @Test
    public void pruebaCarritoCompleta() throws InterruptedException {
    	carritoPage.agregarProductosAlCarrito();
        carritoPage.abrirCarrito();
        carritoPage.validarProductosEnCarrito();
    
    }

    @After
    public void cerrar() {
        DriverSingleton.cerrarDriver();
    }
}
