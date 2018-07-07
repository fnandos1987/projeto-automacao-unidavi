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
import mobile.pageobjects.TelaEditarPO;
import mobile.pageobjects.TelaPrincipalPO;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 *
 * @author fernando.schwambach
 */
public class PesquisarPessoaTest {

    private AppiumDriver getAppiumDriver() throws MalformedURLException {
        File app = new File("C:\\Users\\19294\\Documents\\NetBeansProjects\\projeto-automacao-unidavi\\app\\pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
    }

    @Test
    public void pesquisarPessoa() throws MalformedURLException {
        AppiumDriver driver = getAppiumDriver();

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        telaPrincipal.pesquisar("Steve");
        telaPrincipal.clicarNaPessoaFiltrada();

        TelaEditarPO telaEditar = new TelaEditarPO(driver);
        assertEquals(telaEditar.retornarValorCampoNome(), "Steve Rodgers");
        assertEquals(telaEditar.retornarValorCampoEndereco(), "EUA");
        assertEquals(telaEditar.retornarValorCampoHobbies(), "Save the World");

        driver.quit();
    }

}
