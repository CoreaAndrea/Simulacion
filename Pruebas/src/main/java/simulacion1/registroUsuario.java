package simulacion1;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class registroUsuario extends Basepage {
	private WebDriverWait wait;

    public registroUsuario() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void completarFormulario() {
        WebElement crearCuenta = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("a.create-new-account"))
        );
        crearCuenta.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("usernameRegisterPage")));

        driver.findElement(By.name("usernameRegisterPage")).sendKeys("Angel");
        driver.findElement(By.name("emailRegisterPage")).sendKeys("Angel@email.com");
        driver.findElement(By.name("passwordRegisterPage")).sendKeys("Solead02");
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Solead02");
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Angel");
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Lopez");
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("88889999");

        Select country = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
        country.selectByVisibleText("Costa Rica");

        driver.findElement(By.name("cityRegisterPage")).sendKeys("San José");
        driver.findElement(By.name("addressRegisterPage")).sendKeys("Calle Falsa 123");
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Cartago");
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("10101");

        WebElement checkbox = driver.findElement(By.name("i_agree"));
        if (!checkbox.isSelected()) checkbox.click();

        driver.findElement(By.id("register_btn")).click();
        WebElement usuarioVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#menuUserLink > span.hi-user")
            ));

            String textoEsperado = "Angel";
            String textoReal = usuarioVisible.getText();

            assertEquals("El nombre de usuario no coincide con el esperado.", textoEsperado, textoReal);
    }
}