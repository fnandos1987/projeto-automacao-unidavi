/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author fernando.schwambach
 */
public class AdicionarPessoaTest {

    @Test
    public void adicionarPessoaComSucesso() throws MalformedURLException {
        File app = new File("C:\\Users\\19294\\Documents\\NetBeansProjects\\projeto-automacao-unidavi\\app\\pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
        driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).click();

        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).sendKeys("Steve Rodgers");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).sendKeys("EUA");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).sendKeys("Save the World");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Steve Rodgers");

        assertEquals(driver.findElement(By.id("android:id/text1")).getText(), "Steve Rodgers");
        driver.quit();
    }

}
