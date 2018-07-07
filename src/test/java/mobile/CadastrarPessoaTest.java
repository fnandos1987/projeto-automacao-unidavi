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
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author 19294
 */
public class CadastrarPessoaTest {

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
    public void cadastrarPessoa() throws MalformedURLException {
        AppiumDriver driver = getAppiumDriver();

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        telaPrincipal.clicarEmAdicionar();

        TelaEditarPO telaEditar = new TelaEditarPO(driver);
        telaEditar.informarValorCampoNome("Clark Kent");
        telaEditar.informarValorCampoEndereco("SmallVille");
        telaEditar.informarValorCampoHobbies("voar");
        telaEditar.clicarEmSalvar();

        telaPrincipal.pesquisar("Clark Kent");
        assertEquals(telaPrincipal.retornarValorPessoaFiltrada(), "Clark Kent");

        driver.quit();
    }

}
