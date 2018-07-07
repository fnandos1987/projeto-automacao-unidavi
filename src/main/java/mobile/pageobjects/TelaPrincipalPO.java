/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author fernando.schwambach
 */
public class TelaPrincipalPO {

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/fab")
    MobileElement botaoAdicionar;

    @AndroidFindBy(id = "android:id/search_button")
    MobileElement botaoLupa;

    @AndroidFindBy(id = "android:id/search_src_text")
    MobileElement campoPesquisa;

    @AndroidFindBy(id = "android:id/text1")
    MobileElement campoListado;

    public TelaPrincipalPO(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clicarEmAdicionar() {
        botaoAdicionar.click();
    }

    public void clicarNaLupa() {
        botaoLupa.click();
    }

    public void clicarNaPessoaFiltrada() {
        campoListado.click();
    }

    public void preencherCampoPesquisa(String texto) {
        campoPesquisa.sendKeys(texto);
    }

    public void pesquisar(String texto) {
        clicarNaLupa();
        preencherCampoPesquisa(texto);
    }

}
