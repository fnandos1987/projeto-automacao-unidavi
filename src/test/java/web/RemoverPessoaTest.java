/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import suporte.BaseTestWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author fernando.schwambach
 */
public class RemoverPessoaTest extends BaseTestWeb {

    @Test
    public void removerPessoa() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        driver.findElement(By.id("pesquisar")).sendKeys("Antony Stark");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        driver.findElement(By.id("remover")).click();

        Alert alerta = driver.switchTo().alert();
        assertEquals(alerta.getText(), "Deseja realmente remover?");
        alerta.accept();

        driver.findElement(By.id("pesquisar")).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));

        String dadosPagina = driver.getPageSource();
        assertTrue(dadosPagina.contains("Antony Stark"));
        assertTrue(dadosPagina.contains("EUA"));
        assertTrue(dadosPagina.contains("Save the world"));
    }

}
