package br.com.caelum.teste;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private WebDriver driver;
	
	public LeiloesPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		  driver.get(new URLDaAplicacao().getUrlBase() + "/leiloes");
		  // antigo: driver.get("http://localhost:8080/usuarios");
		}
	
	
	public NovoLeilaoPage novo () {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}
	
	public boolean existe(String produto, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(produto) &&
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usado ? "Sim" : "Não");// if ternário
	
	}
	public DetalhesDoLeilaoPage detalhes(int posicao) {//recebe posição do link
        List<WebElement> elementos = driver.findElements(By.linkText("exibir"));//lista de elementos retornados
        elementos.get(posicao - 1).click();//em uma lista primero elemeto é zero, por isso -1

        return new DetalhesDoLeilaoPage(driver);
    }
}
