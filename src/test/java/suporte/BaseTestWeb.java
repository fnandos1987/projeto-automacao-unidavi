/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author fernando.schwambach
 */
public class BaseTestWeb {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void preCondicao() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19294\\Documents\\NetBeansProjects\\selenium\\chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.get("http://livrodeteste.com/otestadortecnico/app");

        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void posCondicao() {
        driver.quit();
    }
}
