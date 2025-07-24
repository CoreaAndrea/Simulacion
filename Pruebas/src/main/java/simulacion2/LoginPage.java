package simulacion2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
	 private WebDriver driver;
	 private WebDriverWait wait;

	 private LoginPage(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 }

	 public static LoginPage create(WebDriver driver) {
	     return new LoginPage(driver);
	 }

	 public void abrirPagina() {
	     driver.get("https://advantageonlineshopping.com/#/");
	 }

	 public void login(String usuario, String contrasena) {
	     WebElement loguearse = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
	     loguearse.click();

	     WebElement campoUsuario = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
	     campoUsuario.sendKeys(usuario);

	     WebElement campoContrasena = driver.findElement(By.name("password"));
	     campoContrasena.sendKeys(contrasena);

	     wait.until(d -> d.findElement(By.id("sign_in_btn")).isEnabled());
	     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

	     driver.findElement(By.id("sign_in_btn")).click();
	     
	     
	 }
}
