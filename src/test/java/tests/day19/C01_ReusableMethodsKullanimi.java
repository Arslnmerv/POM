package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {

    @Test
    public void test() {
        //https://the-internet.herokuapp.com/windows adresine gidelim
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //cllick here'a basalim
        String ilkSayfaHandleDegeri = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleKumesi = Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandleDegeri = "";
        for (String w : windowHandleKumesi) {
            if (!w.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri = w;
            }
        }

        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        //yeni sayfada new window yazisinin ciktiginiz test edelim
        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();
    }

    @Test
    public void testReusableIle () {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        Driver.closeDriver();

    }

}
