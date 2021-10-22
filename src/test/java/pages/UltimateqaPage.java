package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UltimateqaPage {

    WebDriver driver;

    public UltimateqaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user[first_name]")
    public WebElement username;


    @FindBy(xpath = "//input[@value='Sign up']")
    public WebElement signupButton;

    @FindBy (xpath ="//a[@class='dropdown__toggle-button']")
    public WebElement accountIcon;

    @FindBy (linkText = "My Account")
    public WebElement myAccountInIcon;

    @FindBy (id = "user[email]")
    public WebElement emailBoxInMyAccount;

    @FindBy (id = "user[first_name]")
    public WebElement firstNameBoxInMyAccount;

    @FindBy (id = "user[last_name]")
    public WebElement lastNameBoxInMyAccount;

    @FindBy (id = "user[password]")
    public WebElement passwordBoxInMyAccount;

}