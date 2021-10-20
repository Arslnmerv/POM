package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFaceBook extends TestBase {

    @Test
    public void test() {
        //facebook login sayfasina gidin
       driver.get("https://www.facebook.com");
       FacebookPage facebookPage = new FacebookPage(driver);

        //kullanici adi : techproed
        facebookPage.mailKutusu.sendKeys("techproed");

        //sifre : 12345
        facebookPage.sifreKutusu.sendKeys("12345");
        facebookPage.loginTusu.click();

        //yazdigimizda giris yapamadigimizi test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
    }
}
