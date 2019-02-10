package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/apenas-teste/limpa");
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");//teste deve criar cenário ue precisa
	}
	
	@Test
	public void deveCadastrarUmLeilao() {
	 leiloes.visita();
     NovoLeilaoPage novoLeilao = leiloes.novo();
     novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

     assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));//preciso cadastrar usuario
	}
}
