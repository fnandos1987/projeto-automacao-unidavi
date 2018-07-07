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
public class TelaEditarPO {

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_nome")
    MobileElement campoNome;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_endereco")
    MobileElement campoEndereco;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_hobbies")
    MobileElement campoHobbies;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/button")
    MobileElement botaoSalvar;

    public TelaEditarPO(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clicarEmSalvar() {
        botaoSalvar.click();
    }

    public String retornarValorCampoNome(){
        return campoNome.getAttribute("text");
    }

    public String retornarValorCampoEndereco(){
        return campoEndereco.getAttribute("text");
    }

    public String retornarValorCampoHobbies(){
        return campoHobbies.getAttribute("text");
    }

}
