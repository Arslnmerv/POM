package parallelTest;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testParameterWithXML() throws InterruptedException{

        driver.get("https://gmibank.com/");

        WebElement ilkGirisButonu = driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]"));
        ilkGirisButonu.click();

        WebElement signInButonu = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signInButonu.click();

        WebElement gmibankUsernameKutusu = driver.findElement(By.xpath("//input[@name='username']"));
        gmibankUsernameKutusu.sendKeys("employee32");

        WebElement gmibankUPasswordKutusu = driver.findElement(By.xpath("//input[@name='password']"));
        gmibankUPasswordKutusu.sendKeys("team32team32-");

        WebElement gmiBankSigInOkButonu = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        gmiBankSigInOkButonu.click();

    }
}