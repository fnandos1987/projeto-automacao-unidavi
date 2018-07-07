/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author fernando.schwambach
 */
public class RemoverPessoaTest {

    @Test
    public void removerPessoaComSucesso() throws MalformedURLException {
        File app = new File("C:\\Users\\19294\\Documents\\NetBeansProjects\\projeto-automacao-unidavi\\app\\pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

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

        driver.quit();
    }
}
