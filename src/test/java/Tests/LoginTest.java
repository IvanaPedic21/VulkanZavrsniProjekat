package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.Strings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    /**
     * Login test with valid Email and valid Lozinka
     *
     * Test steps:
     * 1. Navigate to : "https://www.knjizare-vulkan.rs/"
     * 2. In the upper right corner, click the PRIJAVITE SE
     * 3. In the login modal enter valid Email and valid Password
     * 4. Click button PRIJAVA
     * 5. Click button Odjava
     *
     *
     * Expected results:
     * 4.The Korisnik is logged in and profile page
     * 5.The Korisnik is Logout in
     */

    @Test
    public void loginWithValidEmailAndValidPassword() {
        driver = openChromeDriver();
        try {
            print("Navigate to knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);


            print("prijaviteSeButton");
            basePage.clickPrijaviteSeButton();
            print("Enter valid Email and valid Password and click button Prijavite se");

            //logg in valid email and password
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserEmailTextField(Strings.VALID_EMAIL);
            loginPage.enterUserPasswordTextField(Strings.VALID_PASSWORD);


            loginPage.clikinButtonPrijaviSe();
            print("Confirm loggin to the site and verify that the Korisnik in profile is present on this page" + "Odjava");

            loginPage.sleep();

            //da je korisnik ulogovan  i da je na profilu
            loginPage.profilKorisnikaDajeUlogovanNastranici();

            // Odjava sa sajta
            loginPage.clickOdjavaButton();

        } finally {
            driver.quit();
        }
    }
}




//    @Test
//
//    public void loginWithValidEmailAndInvalidPassword(){
//        driver=openChromeDriver();
//        try {
//            print("Navigate to knjizare-vulkan.rs");
//            BasePage basePage = new BasePage(driver);
//
//            print ("prijaviteSeButton");
//            basePage.clickPrijaviteSeButton();
//            print("Enter valid Email and Invalid Password");
//
//        //Logg in valid email and invalid password
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterUserEmailTextField (Strings.VALID_EMAIL);
//            loginPage.enterUserInvalidPasswordTextField();
//
//        // click prijavite se
//            print ("Confirm login to site and verify error alert ");
//            loginPage.clikinButtonPrijaviSe();
//            loginPage.sleep();
//
//        //da li je prisutna error poruka za pogresnu lozniku
//            loginPage.erorrAlertPrisutan();
//
//        //click da zatvorimo modal sa naznakom da su kredencijali pogresni
//            loginPage.clickButtonCloseInModalWithInvalidPassword();
//
//        }finally {
////            driver.quit();
//        }
//    }


