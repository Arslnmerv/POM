package tests.day17_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class C01_ReadExcel {

    @Test
    public void test() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //10. WorkbookFactory.create(fileInputStream)
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(4);

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(1);


        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //10. WorkbookFactory.create(fileInputStream)
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)


        //12. Row objesi olusturun sheet.getRow(index)


        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);
        System.out.println(cell);

        //secilen hicredeki yazinin Luanda oldugunu test edin
        Assert.assertEquals(cell.toString(), "Luanda");
        Assert.assertEquals(cell.getStringCellValue(), "Luanda");

        //indexi 3 olan satirdaki indexi 2 olan hucredeki yaziyi buyuk harfle yazdirin
        Cell cell1 = workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase(Locale.ROOT));


        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
    }

    @Test
    public void test3() throws IOException {
        //tablodaki 2.sutunu bir liste olarak yazdirin
        List<String> ikinciSutun = new ArrayList<>();
        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);

        //A ile baslayan sehirleri  liste yapip yazdirin
        List<String> aIleBaslayanSehirler = new ArrayList<>();

        for (String w : ikinciSutun) {
            if (w.startsWith("A")) {
                aIleBaslayanSehirler.add(w);
            }
        }
        System.out.println(aIleBaslayanSehirler);

        //eger tum datayi java'da kullanilabilir bir colllection'a cevirmak istesek
        //en uygun yapi map olacaktir, map icin unique degerlere sahip bir sutunu
        //geriye kalan tum sutunlari ise vigulle ayrilan stringler olarak value yapmaliyiz
        //key=Turkey value=Ankara, Turkiye ,Ankara

        Map<String, String> ulkelerMap = new HashMap<>();
        String key = "";
        String value = "";
        for (int i = 0; i < workbook.getSheet("Sayfa1").getLastRowNum(); i++) {


            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ",  " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ",  " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);
        }

        System.out.println(ulkelerMap);

        //java methodlari ve collectionsu kullanarak exceldeki datalari manipule edebilecegimiz java ortamina alabilriz

    }
}
