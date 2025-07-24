package simulacion6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class prueba6 {
	private static WebDriver driver;
    private static Filtrospage filtrosPage;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get("https://advantageonlineshopping.com/#/");
        filtrosPage = crearFiltrosPage(driver);
    }

    
    public static Filtrospage crearFiltrosPage(WebDriver driver) {
        return new Filtrospage(driver);
    }

    @Test
    public void aplicarFiltros() throws InterruptedException {
        filtrosPage.abrirCategoriaSpeakers();
        filtrosPage.aplicarFiltroPrecio();
        filtrosPage.aplicarFiltroCompatibilidad();
        filtrosPage.aplicarFiltroManufacturer();
        filtrosPage.aplicarFiltroWeight();
        filtrosPage.aplicarFiltroWirelessTech();
        filtrosPage.aplicarFiltroColor();
        //aqui hace la validacion
        filtrosPage.validarProductosFiltrados();
    }

    @After
    public void cerrar() {
        DriverSingleton.cerrarDriver();
    }
}