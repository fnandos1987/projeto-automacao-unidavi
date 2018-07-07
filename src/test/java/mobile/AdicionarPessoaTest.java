/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import suporte.BaseTestMobile;

/**
 *
 * @author fernando.schwambach
 */
public class AdicionarPessoaTest extends BaseTestMobile {

    @Test
    public void adicionarPessoaComSucesso() throws MalformedURLException {
        driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).click();

        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).sendKeys("Steve Rodgers");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).sendKeys("EUA");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).sendKeys("Save the World");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Steve Rodgers");

        assertEquals(driver.findElement(By.id("android:id/text1")).getText(), "Steve Rodgers");
    }

}
