/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import suporte.BaseTestWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author fernando.schwambach
 */
public class EditarPessoaTest extends BaseTestWeb {

    @Test
    public void editarPessoa() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        driver.findElement(By.id("pesquisar")).sendKeys("Tony Stark");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editar")));
        driver.findElement(By.id("editar")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-btn.w3-teal")));
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("Antony Stark");
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        driver.findElement(By.id("pesquisar")).sendKeys("Antony Stark");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editar")));
        assertEquals(driver.findElement(By.id("nome")).getText(), "Antony Stark");
        assertEquals(driver.findElement(By.id("endereco")).getText(), "EUA");
        assertEquals(driver.findElement(By.id("hobbies")).getText(), "Save the world");
    }

}
