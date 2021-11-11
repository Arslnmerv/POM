package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankPage {

    public GMIBankPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@class='svg-inline--fa fa-user fa-w-14 ']")
    public WebElement ilkGirisButonu;

    @FindBy (xpath = "//span[text()='Sign in']")
    public WebElement signInButonu;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameKutusu;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordKutusu;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement ikinciSignInButonu;

    @FindBy (xpath = "//*[text()='employee32 employee32']")
    public WebElement girisOnay;

    @FindBy (xpath = "//span[text()='Sign out']")
    public WebElement signOutButonu;

    @FindBy (id = "entity-menu")
    public WebElement myOperations;

    @FindBy (xpath = "//span[text()='Manage Customers']")
    public WebElement manageCustomers;

    @FindBy (xpath = "(//*[text()='Edit'])[1]")
    public WebElement ilkMusteriEdit;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstNameWebElementi;

    @FindBy (xpath = "//select[@name='country.id']")
    public WebElement countryDropdown;

    @FindBy (xpath = "//span[text()='Save']")
    public WebElement editSaveButonu;

    @FindBy (xpath = "//tbody//tr[1]//td[2]")
    public WebElement ilkMusteriName;

    @FindBy (xpath = "//tbody")
    public WebElement tumBody;



    public void GMIBankLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));
        GMIBankPage gmiBankPage = new GMIBankPage();
        gmiBankPage.ilkGirisButonu.click();
        gmiBankPage.signInButonu.click();

        gmiBankPage.usernameKutusu.sendKeys(ConfigReader.getProperty("GMIBankValidUsername"));
        gmiBankPage.passwordKutusu.sendKeys(ConfigReader.getProperty("GMIBankValidPassword"));

        gmiBankPage.ikinciSignInButonu.click();


    }
}