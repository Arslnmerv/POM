package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_E2ETest {

    @Test
    public void test() throws InterruptedException {
        //1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //    a. Username : manager
        //    b. Password  : Manager1!
        //5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotelLink.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        actions.click(qaConcortPage.addHotelCodeKutusu)
                .sendKeys(faker.address().zipCode() + Keys.TAB)
                .sendKeys(faker.name().name() + Keys.TAB)
                .sendKeys(faker.address().cityName() + Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber() + Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).perform();

        actions.click(qaConcortPage.dropdown).perform();
        Select select = new Select(qaConcortPage.dropdown);
        select.selectByValue("1");

        //8. Save butonuna tıklayın.
        qaConcortPage.saveButton.click();

        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(1000);
        Assert.assertTrue(qaConcortPage.hotelWasInsertedSuccessfullyText.isDisplayed(), "“Hotel was inserted successfully” text isn't displayed.");

        //10. OK butonuna tıklayın.
        qaConcortPage.hotelWasInsertedSuccessfullyTextOkButton.click();

        Driver.closeDriver();
    }
}
