package tests.myExercises;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UltimateqaPage;
import utilities.ConfigReader;
import utilities.Driver;


public class M02 {
    /**
     * Part 1:
     * Open "https://courses.ultimateqa.com/users/sign_up"
     * create random and valid first name, last name, email and password, store for later validating
     * fill in account submission form with data above
     * Click on checkbox with id="user[terms]" to agree with terms and conditions
     * click on "Sign up" button
     * go to https://courses.ultimateqa.com/account
     * validate that first name, last name and email you provided earlier is correct
     * <p>
     * Part 2 (Optional)
     * sign out of the website
     * go to "https://courses.ultimateqa.com/users/sign_in"
     * fill in sign in form with your stored email and password
     * click on "Sign in" button
     * validate that message "Signed in successfully." is displayed
     * <p>
     * NOTE:Captcha on this website is un-avoidable,
     * so you will have to solve it by hand to allow script to continue
     **/

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("ultimeqaSignUpUrl"));
        UltimateqaPage ultimateqaPage = new UltimateqaPage();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String passsword = faker.internet().password();
        ultimateqaPage.username.sendKeys(firstName);
        actions.sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(passsword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();
        Thread.sleep(1000);

        actions.click(ultimateqaPage.signupButton).perform();
        Thread.sleep(30000);
        actions.click(ultimateqaPage.accountIcon).perform();
        Thread.sleep(1000);
        actions.click(ultimateqaPage.myAccountInIcon).perform();
        Thread.sleep(3000);

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(ultimateqaPage.emailBoxInMyAccount.getText().contains(email));
//        softAssert.assertTrue(ultimateqaPage.firstNameBoxInMyAccount.getText().contains(firstName));
//        softAssert.assertTrue(ultimateqaPage.lastNameBoxInMyAccount.getText().contains(lastName));
//        softAssert.assertAll();
//

        Driver.closeDriver();

        Driver.getDriver().get(ConfigReader.getProperty("ultimeqaSignInUrl"));
        Thread.sleep(3000);

        ultimateqaPage.emailBoxInMyAccount.sendKeys(email);
        actions.sendKeys(Keys.TAB).perform();
        ultimateqaPage.passwordBoxInMyAccount.sendKeys(passsword);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ENTER).perform();

    }


}
