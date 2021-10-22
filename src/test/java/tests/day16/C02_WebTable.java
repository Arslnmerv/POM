package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

import java.util.Iterator;

public class C02_WebTable {

    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //●https://qa-environment.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLinki.click();

        //● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        for (WebElement w : qaConcortPage.basliklarListesi) {
            System.out.println(w.getText());
        }
        System.out.println("Tablodaki sutun sayisi = " + qaConcortPage.basliklarListesi.size());
        Thread.sleep(2000);
        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println(qaConcortPage.tBodyTumu.getText());
        Thread.sleep(5000);
        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("HAPPY HOTEL"));

        Iterator var2 = qaConcortPage.basliklarListesi.iterator();

        WebElement each;
        while(var2.hasNext()) {
            each = (WebElement)var2.next();
            System.out.println(each.getText());
        }
        //● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(qaConcortPage.satirlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(qaConcortPage.birinciSatir.getText());

        //eger butun satirlari yazdirmak istersem
        for (int i = 0; i < qaConcortPage.satirlarListesi.size(); i++) {
            System.out.println( i + 1 + " .satir : " + qaConcortPage.satirlarListesi.get(i).getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.

//        for (WebElement w : qaConcortPage.dorduncuSutunListesi) {
//            System.out.println(w.getText());
//        }
        var2 = qaConcortPage.dorduncuSutunListesi.iterator();

        while(var2.hasNext()) {
            each = (WebElement)var2.next();
            System.out.println(each.getText());
        }

        Driver.closeDriver();
    }


}
