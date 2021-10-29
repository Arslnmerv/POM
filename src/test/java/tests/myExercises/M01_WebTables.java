package tests.myExercises;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class M01_WebTables {
    
    QAConcortPage qaConcortPage = new QAConcortPage();

    //● login() metodun oluşturun ve oturum açın.
    @Test
    public void login() throws InterruptedException {
        //● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager  	○ Password : Manager1!
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage.ConcortHotelLogin();

    }

    @Test(dependsOnMethods = "login")
    public void table() {
        //● table() metodu oluşturun
        //	○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //	○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        System.out.println(qaConcortPage.sutunlarListesi.size());
        for (WebElement w : qaConcortPage.sutunlarListesi) {
            System.out.println(w.getText());
        }

        System.out.println(qaConcortPage.tBodyTumu.getText());

        for (WebElement w : qaConcortPage.basliklarListesi) {
            System.out.println(w.getText());
        }

    }

    @Test(dependsOnMethods = "table")
    public void printRows() {
        //● printRows() metodu oluşturun //tr
        //	○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //	○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //	○ 4.satirdaki(row) elementleri konsolda yazdırın.

        System.out.println(qaConcortPage.satirlarListesi.size());

        for (WebElement w : qaConcortPage.satirlarListesi) {
            System.out.println(w.getText());
        }
        System.out.println(qaConcortPage.dorduncuSatir.getText());


    }

    @Test(dependsOnMethods = "printRows(")
    public void printCells() {
        //● printCells() metodu oluşturun //td
        //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

        System.out.println(qaConcortPage.toplamHucre.size());

        for (WebElement w : qaConcortPage.toplamHucre) {
            System.out.println(w.getText());
        }


    }

    @Test(dependsOnMethods = "printCells")
    public void printColumns() {
        //● printColumns() metodu oluşturun
        //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //	○ 5.column daki elementleri konsolda yazdırın.
        System.out.println(qaConcortPage.sutunlarListesi.size());
        for (WebElement w : qaConcortPage.sutunlarListesi) {
            System.out.println(w.getText());
        }
        for (WebElement w : qaConcortPage.besinciSutunListesi) {
            System.out.println(w.getText());
        }

        Driver.closeDriver();
    }

}
