/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.net.MalformedURLException;
import mobile.pageobjects.TelaEditarPO;
import mobile.pageobjects.TelaPrincipalPO;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import suporte.BaseTestMobile;

/**
 *
 * @author 19294
 */
public class CadastrarPessoaTest extends BaseTestMobile {

    @Test
    public void cadastrarPessoa() throws MalformedURLException {

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        telaPrincipal.clicarEmAdicionar();

        TelaEditarPO telaEditar = new TelaEditarPO(driver);
        telaEditar.informarValorCampoNome("Clark Kent");
        telaEditar.informarValorCampoEndereco("SmallVille");
        telaEditar.informarValorCampoHobbies("voar");
        telaEditar.clicarEmSalvar();

        telaPrincipal.pesquisar("Clark Kent");
        assertEquals(telaPrincipal.retornarValorPessoaFiltrada(), "Clark Kent");
    }

}
