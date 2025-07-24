package simulacion7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;

public class Prueba7 {
	private WebDriver driver;
    private Productopage pagina;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        pagina = new Productopage(driver);
        pagina.abrirPagina();
    }

    @Test
    public void editarProductoEnCarrito() {
        pagina.agregarYEditarProducto();
        //aqui valida
        String cantidad = pagina.obtenerCantidadProducto();
        assertEquals("2", cantidad);
        System.out.println("Producto editado y guardado nuevamente en el carrito");
    }

    @After
    public void cerrar() {
        DriverFactory.quitDriver();
    }
}
