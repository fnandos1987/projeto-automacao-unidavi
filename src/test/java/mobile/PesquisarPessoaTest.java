/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.net.MalformedURLException;
import mobile.pageobjects.TelaEditarPO;
import mobile.pageobjects.TelaPrincipalPO;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import suporte.BaseTestMobile;

/**
 *
 * @author fernando.schwambach
 */
public class PesquisarPessoaTest extends BaseTestMobile {

    @Test
    public void pesquisarPessoa() throws MalformedURLException {
        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        telaPrincipal.pesquisar("Steve");
        telaPrincipal.clicarNaPessoaFiltrada();

        TelaEditarPO telaEditar = new TelaEditarPO(driver);
        assertEquals(telaEditar.retornarValorCampoNome(), "Steve Rodgers");
        assertEquals(telaEditar.retornarValorCampoEndereco(), "EUA");
        assertEquals(telaEditar.retornarValorCampoHobbies(), "Save the World");
    }

}
