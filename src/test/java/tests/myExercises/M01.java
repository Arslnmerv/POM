package tests.myExercises;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class M01 extends TestBase {

    @Test
    public void test() {
        //  1 - https://www.facebook.com/ adresine gidin
        driver.get(ConfigReader.getProperty("facebookUrl"));

        //  2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //  3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        FacebookPage facebookPage = new FacebookPage(driver);
        Faker faker = new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());
        facebookPage.loginTusu.click();

        //  4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed(), "Facebook account successfully logged in");

    }
}
