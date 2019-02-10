package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {
	private WebDriver driver;
	
	public DetalhesDoLeilaoPage (WebDriver driver) {
		this.driver = driver;
	}
	  public void lance(String usuario, double valor) {
		  
	        WebElement txtValor = driver.findElement(By.name("lance.valor"));
	        Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));

	        cbUsuario.selectByVisibleText(usuario);
	        txtValor.sendKeys(String.valueOf(valor));

	        driver.findElement(By.id("btnDarLance")).click();//para ajax é preferivel usar botão
	    }
	  
	  //como requisição é ajax temos que esperar, não usar dessa maneira:
	   //public boolean existeLance(String usuario, double valor) {
	     //   return driver.getPageSource().contains(usuario)
	       //         && driver.getPageSource().contains(String.valueOf(valor));
	   //}
	  
	  public boolean existeLance(String usuario, double valor) {
	        
			Boolean temUsuario =
	                new WebDriverWait(driver, 10)//segundos que tem que esperar
	                    .until(ExpectedConditions.textToBePresentInElementLocated(By.id("lancesDados"), usuario));
	        			//metodo until recebe condição que espera que aconteça no tempo de 10s
	        			//neste caso é esperado que apareça algum texto
	        			//recebe os parametros: obj que recebe o texto e o texto -> texto vai aparecer na tabela lance dados
	        
	        if(temUsuario) return driver.getPageSource().contains(String.valueOf(valor));
	        //se tem usuario, busco  valor
	        
	        return false;//caso contrario retornamos falso
	    }

}
