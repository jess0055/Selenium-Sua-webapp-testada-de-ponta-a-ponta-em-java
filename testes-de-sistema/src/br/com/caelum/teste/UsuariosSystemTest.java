package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsuariosSystemTest {
	
	private WebDriver driver;
	private UsuariosPage usuarios; 

    @Before
    public void inicializa() {
        this.driver = new ChromeDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        this.usuarios = new UsuariosPage(driver);//instanciar usuariosPage
        usuarios.visita(); //pagina de listagem      
    }

	
	@Test //para junit entender teste
	public void deveAdicionarUmUsuario() { 
						 
		usuarios.novo().cadastra("jessica", "j@teste.com");//novo devolve pag de cadastro/cadastra é metodo de NovoUsu..     
		assertTrue(usuarios.existeNaListagem("jessica", "j@teste.com"));
		
	}
	  @Test
	    public void naoDeveAdicionarUmUsuarioSemNome(){
		   
	       NovoUsuarioPage form = usuarios.novo();
	       form.cadastra("", "ronaldo2009@terra.com.br");

	       assertTrue(form.validacaoDeNomeObrigatorio()); //validando tela de cadastro
	    }
	  
	  @Test
	    public void deveDeletarUmUsuario() {
		    
	        usuarios.novo().cadastra("jessica", "j@teste.com");	   		    
	        assertTrue(usuarios.existeNaListagem ("jessica", "j@teste.com"));

	        usuarios.deletaUsuarioNaPosicao(1);
	        assertFalse(usuarios.existeNaListagem("jessica", "j@teste.com"));
	    }
	  
	  @Test
	    public void deveAlterarUmUsuario() {	
		  
		  	usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
	        usuarios.altera(1).para("José da Silva", "jose@silva.com");

	        assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
	        assertTrue(usuarios.existeNaListagem("José da Silva", "jose@silva.com"));
	    }

	@After
	public void encerra() {
		driver.close();
    }
}
