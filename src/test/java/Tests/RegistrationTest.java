package Tests;

import Pages.BasePage;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{


    /**
     *
     * Registration test with valid credential
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.In header right corner click button Registrujte se
     * 3.In modal Prijavite se enter valid credential
     * 4.Click in modal  button Prijava
     *
     * Expected results:
     * 4. Verify that registration is not possible, clickin button "Nisam robot"(reCapha) open is "Uslovi,Privatnost"
     */

    @Test

    public void testWithValidCredntialForRegistracija(){
        driver=openChromeDriver();
        try {

            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage=new BasePage(driver);
            print("2.Click Registrujte se");
            basePage.clickRegistrujteSeButton();

            RegistrationPage registrationPage=new RegistrationPage(driver);
            print("3.Enter valid credential for registration");
            registrationPage.clickPrijavaRegistrujteSe();
            registrationPage.enterImeKorisnika();
            registrationPage.enterPrezimeKorisnika();
            registrationPage.enterEmailKorisnika();
            registrationPage.enterTelefonKorisnika();
//            registrationPage.enterDrzavaKorisnika();
            registrationPage.enterGradKorisnika();
            registrationPage.enterUlicaKorisnika();
            registrationPage.enterKucniBrojKorisnika();
            registrationPage.enterPostanskiBroj();
            registrationPage.enterLozinkaKorisnika();
            registrationPage.enterPonoviteLozinkuKorisnika();
            registrationPage.clickDaImamViseOd15Godina();
            registrationPage.clickZenskiPol();
            registrationPage.clickReCapchaClick();
            registrationPage.clickSlazemSeSaUslovimaKorisnika();
            registrationPage.sleep();

            //potvrda da se registruje
            print("4.Verify confirm registration,a message abaout the started registration");
            registrationPage.clickRegistracijaButton();
            registrationPage.setPorukaUspesneRegistracije();
            registrationPage.closeDugmeUspesneregistracije();

        }finally {
//            driver.quit();
        }
    }

}
