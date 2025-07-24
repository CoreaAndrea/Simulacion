package simulacion1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class prueba1 {
	@Before
    public void setUp() {
        DriverManager.getInstancia().getDriver().get("https://advantageonlineshopping.com/#/");
    }

    @Test
    public void Iniciar_sesion() {
    	registroUsuario formulario = new registroUsuario();
        formulario.completarFormulario();
    }

    @After
    public void cerrar() {
        DriverManager.getInstancia().cerrarDriver();
    }


}