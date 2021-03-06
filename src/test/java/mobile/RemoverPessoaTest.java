/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import suporte.BaseTestMobile;

/**
 *
 * @author fernando.schwambach
 */
public class RemoverPessoaTest extends BaseTestMobile {

    @Test
    public void removerPessoaComSucesso() throws MalformedURLException {
        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Steve Rodgers");

        TouchAction action = new TouchAction(driver);
        LongPressOptions longPressOptions = new LongPressOptions();

        longPressOptions.withElement(
                new ElementOption().withElement(driver.findElement(By.id("android:id/text1")))).build();

        action.longPress(longPressOptions).perform();

        assertEquals(driver.findElement(By.id("android:id/message")).getText(), "Deseja remover a pessoa selecionada?");
        driver.findElement(By.id("android:id/button1")).click();

        assertEquals(driver.findElement(By.id("android:id/message")).getText(), "A pessoa foi removida com sucesso!");
        driver.findElement(By.id("android:id/button3")).click();
    }
}
