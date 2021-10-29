package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test (groups = "birinciGrup")
    public void test () {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

       // Driver driver = new Driver();
        //Driver classindan obje uretilemesin istedigimiz icin Driver classi SINGLETON yapiyoruz
        //bunun icin default constructor yerine parametresiz bir constructor olusturup
        //access modifieri private seciyoruz

        //Driver driver = new Driver("ben istedim olmadi");
        //Driver classinda parametreli constructor olmadigi icin kullanamayiz

        Driver.closeDriver();
    }
}
