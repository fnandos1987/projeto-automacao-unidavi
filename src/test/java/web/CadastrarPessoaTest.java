/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import suporte.BaseTestWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author fernando.schwambach
 */
public class CadastrarPessoaTest extends BaseTestWeb {

    @Test
    public void cadastrarPessoa() {       
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("adicionar")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-btn.w3-teal")));
        driver.findElement(By.id("nome")).sendKeys("Tony Stark");
        driver.findElement(By.name("endereco")).sendKeys("EUA");
        driver.findElement(By.id("hobbies")).sendKeys("Save the world");
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        String dadosPagina = driver.getPageSource();
        assertTrue(dadosPagina.contains("Tony Stark"));
        assertTrue(dadosPagina.contains("EUA"));
        assertTrue(dadosPagina.contains("Save the world"));
    }
}
