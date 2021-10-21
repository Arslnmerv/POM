package tests.smokeTest;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLogintest {

    @Test
    public void test () throws InterruptedException {
//        Bir test method olustur positiveLoginTest()
//        https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();

//        login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

//        test data username: manager ,
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

//         test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        Thread.sleep(2000);

//         Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}