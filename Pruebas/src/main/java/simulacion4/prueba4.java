package simulacion4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class prueba4 {
	
	@Before
    public void setUp() {
        
    }

    @Test
    public void pruebaTablet() throws InterruptedException {
        TabletPage tabletPage = PruebaFactory.crearPruebaTablet();
        tabletPage.abrirCategoriaTablets();
        Thread.sleep(2000); 
        tabletPage.seleccionarProductoTablet();
        tabletPage.seleccionarColorYAgregarAlCarrito();
    }

    @After
    public void cerrar() {
        DriverSingleton.closeDriver();
    }


}

