package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {//representa a pagina de listagem dos usuarios
	
	private WebDriver driver;//atributo da classe

	public UsuariosPage(WebDriver driver) {//construtor
	        this.driver = driver;//para instanciar essa classe preciso passar webdriver
	}
	
	
	public void visita() {
		  driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
		  // antigo: driver.get("http://localhost:8080/usuarios");
		}
	
	
	 public NovoUsuarioPage novo() { //deve devolver a nova pagina direcionada trocar void por UsuarioPage
	        // clica no link de novo usuario
	        driver.findElement(By.linkText("Novo Usuário")).click();
	        // retorna a classe que representa a nova pagina
	        return new NovoUsuarioPage(driver);
	 }
	 
	 
	 public boolean existeNaListagem(String nome, String email) {
		 
	        // verifica se ambos existem na listagem
	        return driver.getPageSource().contains(nome) && 
	                driver.getPageSource().contains(email);
	 }
	 public void deletaUsuarioNaPosicao(int posicao) {
		 
	       driver.findElements(By.tagName("button")).get(posicao-1).click();
	       // pega o alert que está aberto
	       Alert alert = driver.switchTo().alert();
	       // confirma
	       alert.accept();
	  }
	 public AlteraUsuarioPage altera(int posicao) {
	        driver.findElements(By.linkText("editar")).get(posicao-1).click();
	        return new AlteraUsuarioPage(driver);
	 }

}
