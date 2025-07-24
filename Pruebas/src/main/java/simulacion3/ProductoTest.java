package simulacion3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class ProductoTest {
	private WebDriver driver;
    private ProductosPage productoPage;

    @Before
    public void setUp() {
        driver = DriverManager.getInstancia().getDriver();
        driver.get("https://advantageonlineshopping.com/#/");
        productoPage = new ProductosPage(driver);
    }

    @Test
    public void info_productos() throws InterruptedException {
        productoPage.abrirTablet();

        String display = productoPage.obtenerEspecificacion("DISPLAY");
        String graphics = productoPage.obtenerEspecificacion("GRAPHICS");
        String memory = productoPage.obtenerEspecificacion("MEMORY");
        String os = productoPage.obtenerEspecificacion("OPERATING SYSTEM");
        String processor = productoPage.obtenerEspecificacion("PROCESSOR");

        System.out.println("Display: " + display);
        System.out.println("Graphics: " + graphics);
        System.out.println("Memory: " + memory);
        System.out.println("OS: " + os);
        System.out.println("Processor: " + processor);
        
        //Aqui se validan 
        assertEquals("Display no coincide", "11.6\" diagonal FHD BrightView eDP ultra-slim LED-backlit touch screen (1920 x 1080)", display);
        assertEquals("Graphics no coincide", "Intel® HD Graphics 5300", graphics);
        assertEquals("Memory no coincide", "8 GB 1600 MHz LPDDR3 SDRAM (onboard)", memory);
        assertEquals("OS no coincide", "Windows 8.1 Pro 64", os.trim());
        assertEquals("Processor no coincide", "Intel® Core™ M-5Y71 with Intel HD Graphics 5300 (1.2 GHz, up to 2.9 GHz with Intel Turbo Boost Technology, 4 MB cache, 2 cores)", processor.trim());
        
    }

    @After
    public void cerrar() {
        DriverManager.getInstancia().cerrarDriver();
    }
}