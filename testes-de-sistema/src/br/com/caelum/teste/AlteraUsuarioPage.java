package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {

	private WebDriver driver;//atributo da classe

	public AlteraUsuarioPage(WebDriver driver) {//construtor
	        this.driver = driver;//para instanciar essa classe preciso passar webdriver
	}
	
    public UsuariosPage para(String nome, String email) {
        WebElement txtNome = driver.findElement(By.name("usuario.nome"));
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

            txtNome.clear();
            txtEmail.clear();

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);

        txtNome.submit();
        return new UsuariosPage(driver);
    }
}
