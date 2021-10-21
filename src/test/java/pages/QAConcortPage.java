package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage {

    WebDriver driver;

    public QAConcortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy (id = "UserName")
    public WebElement usernameKutusu;

    @FindBy (id = "Password")
    public WebElement passwordKutusu;

    @FindBy (id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy (xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath = "//*[.='Try again please']")
    public WebElement loginFailedYazisi;

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy (className = "hidden-480")
    public WebElement addHotelLink;
    
    @FindBy (id = "Code")
    public WebElement addHotelCodeKutusu;

    @FindBy (id = "IDGroup")
    public WebElement dropdown;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (className = "bootbox-body")
    public WebElement hotelWasInsertedSuccessfullyText;

    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement hotelWasInsertedSuccessfullyTextOkButton;

    public void ConcortHotelLogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(1000);
        qaConcortPage.loginButonu.click();
    }

}
