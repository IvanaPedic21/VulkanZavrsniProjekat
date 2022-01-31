package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.Strings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    /**
     * Login test with valid Email and valid Password
     *
     * Test steps:
     * 1. Navigate to : "https://www.knjizare-vulkan.rs/"
     * 2. In header right corner, click in button PRIJAVITE SE
     * 3. In modal for Prijava enter valid Email and Password
     * 4. Clicking button PRIJAVA
     * 5. Clicking button Odjava
     *
     * Expected results:
     * 4. Verify that user is login, and confirmation of this is that it is on the page Profil korisnika
     * 5. Verify user that Logout
     */

    @Test
    public void loginWithValidEmailAndValidPassword() {
        driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click Prijavite Se");
            basePage.clickPrijaviteSeButton();
            print("3.Enter valid Email and valid Password ");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickPrijavaModal();
            loginPage.enterUserEmailTextField(Strings.VALID_EMAIL);
            loginPage.enterUserPasswordTextField(Strings.VALID_LOZINKA);
            loginPage.clikinButtonPrijaviSe();
            loginPage.sleep();

            //da je korisnik ulogovan  i da je na profilu
            print("4.Verify confirm loggin to the site and verify that the Korisnik in profile is present on this page" + "Odjava");
            loginPage.profilKorisnikaDajeUlogovanNastranici();

            // Odjava sa sajta
            print("5.Verify user click in Odjava button");
            loginPage.clickOdjavaButton();

        } finally {
//            driver.quit();
        }
    }

    /**
     * Login test with valid Email and Invalid Password
     *
     * Test steps:
     * 1. Navigate to : "https://www.knjizare-vulkan.rs/"
     * 2. In header right corner, click in button PRIJAVITE SE
     * 3. In modal for Prijava enter valid Email and invalid Password
     * 4. Clicking button PRIJAVA
     *
     *
     * Expected results:
     * 4. Verify that user is not login
     * 5. Error message is present on the page for password
     */


    @Test

    public void loginWithValidEmailAndInvalidPassword() {
        driver = openChromeDriver();
        try {
            print("1. Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click Prijavite Se");
            basePage.clickPrijaviteSeButton();
            print("3.Enter valid Email and Invalid Password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserEmailTextField(Strings.VALID_EMAIL);
            loginPage.enterUserInvalidPasswordTextField();
            print("4.Confirm login to site and verify error alert ");
            loginPage.clikinButtonPrijaviSe();
            loginPage.sleep();

            //da li je prisutna error poruka za pogresnu lozniku
            loginPage.erorrAlertIsPresent();

            //click da zatvorimo modal sa naznakom da su kredencijali pogresni
            loginPage.clickButtonCloseInModalWithInvalidPassword();

        } finally {
//            driver.quit();
        }
    }
}







