package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {
	
	private ChromeDriver driver;
	private LeiloesPage leiloes;
	private DetalhesDoLeilaoPage lances;

	@Before
	public void inicializa() {
		this.driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
        
        driver.get("http://localhost:8080/apenas-teste/limpa");
        
        new CriadorDeCenarios(driver)
        .umUsuario("Paulo Henrique", "paulo@henrique.com")
        .umUsuario("José Alberto", "jose@alberto.com")
        .umLeilao("Paulo Henrique", "Geladeira", 100, false);
	}

	    @Test
	    public void deveFazerUmLance() {

	        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

	        lances.lance("José Alberto", 150);

	        assertTrue(lances.existeLance("José Alberto", 150));
	    }
}
