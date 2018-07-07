package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import suporte.BaseTestMobile;

/**
 *
 * @author fernando.schwambach
 */
public class EditarPessoaTest extends BaseTestMobile {

    @Test
    public void editarPessoaComSucesso() throws MalformedURLException {
        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Steve Rodgers");

        driver.findElement(By.id("android:id/text1")).click();

        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).getAttribute("text"), "Steve Rodgers");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).getAttribute("text"), "EUA");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).getAttribute("text"), "Save the World");

        ((AndroidDriver) driver).pressKey(
                new KeyEvent().withKey(AndroidKey.BACK)
        );

        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).isDisplayed(), true);
    }

}
