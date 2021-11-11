
package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

    public class Test3_GMIBank_Musteri_Olusturma {

        // 1) GMI BANK SAYFASINA GiRiS YAPIN
        @Test
        public void test() throws InterruptedException {
            GMIBankPage gmiBankPage =new GMIBankPage();
            gmiBankPage.GMIBankLogin();

            // 2) "My Operatios" MENUSUNDEN "Manage Customers" TIKLA,
            // iLK MUSTERi EDiT ELEMENTiNE TIKLA

            gmiBankPage.myOperations.click();
            gmiBankPage.manageCustomers.click();
            gmiBankPage.ilkMusteriEdit.click();

            // 3) ACILAM MUSTERi BiLGiLERiNi FAKER KULLANRAK DOLDURUN
            Faker faker = new Faker();
            Actions actions = new Actions(Driver.getDriver());

            gmiBankPage.firstNameWebElementi.clear();
            gmiBankPage.firstNameWebElementi.click();

            String firstName = faker.name().name();

            System.out.println(firstName);

            actions.sendKeys(firstName).sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().nameWithMiddle())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("PhoneNumber"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("MPhoneNumber"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().zipCode())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().fullAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().city())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.idNumber().ssnValid()).perform();

            Select select = new Select(gmiBankPage.countryDropdown);

            select.selectByVisibleText("USA");

            actions.sendKeys(Keys.TAB)
                    .sendKeys(faker.address().state()).perform();

            gmiBankPage.editSaveButonu.click();

            // 4) MUSTERi BiLGiLERiNiN DEGiSTiRiLDiGiNi 2 FARKLI YOLLA TEST EDiN
            // 1. YOL
            Thread.sleep(3000);
            System.out.println(gmiBankPage.ilkMusteriName.getText());
            Assert.assertEquals(firstName, gmiBankPage.ilkMusteriName.getText());

            // 2. YOL

            System.out.println(gmiBankPage.tumBody.getText());
            Assert.assertTrue(gmiBankPage.tumBody.getText().contains(firstName));
        }
    }




