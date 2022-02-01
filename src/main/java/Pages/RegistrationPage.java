package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    WebDriver driver = null;

    //Web elementi modal Registruj se i u modalu
    @FindBy(xpath ="//form[@class='registration_form']")
    WebElement registracijaModal;

//    @FindBy(id="reg_type_person")
//    WebElement tipKorisnika;

    @FindBy(id="reg_firstname")
    WebElement imeKorisnika;

    @FindBy(id="reg_lastname")
    WebElement prezimeKorisnika;

    @FindBy(id="reg_email")
    WebElement emailKorisnika;

    @FindBy(id="reg_phone")
    WebElement telefonKorisnika;

//    @FindBy(id="reg_country_geo")
//    WebElement drzavaKorisnika;

    @FindBy(id="reg_city")
    WebElement gradKorisnika;

    @FindBy(id="reg_address")
    WebElement ulicaKorisnika;

    @FindBy(id="reg_street_no")
    WebElement kucniBrojKorisnika;

    @FindBy(id="reg_postcode")
    WebElement postanskiBroj;

    @FindBy(id="reg_password")
    WebElement lozinkaKorisnika;

    @FindBy(id="reg_password_repeat")
    WebElement ponoviteLozinkuKorisnika;

    @FindBy(xpath = "//form[@id='registration_modal']//div[@class='form-group form-group-checklabel']/label[@for='reg_age']")
    WebElement daImamViseOd15Godina;

    //Web elementi za radio button

//    @FindBy(id="reg_gender_1")
//    WebElement muskiPol;

    @FindBy(xpath = "//label[@for='reg_gender_2']")
    WebElement zenskiPol;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement iFrame;

    @FindBy(id = "recaptcha-anchor-label")
    WebElement reCapchaClick;

    @FindBy (xpath = "//label[contains(@for,'reg_confirm')]")
    WebElement slazemSeSaUslovimaKorisnika;

    @FindBy(xpath = "//form[@id='registration_modal']//button[@type='submit']")
    WebElement registracijaButton;

    @FindBy(xpath = "//form[@class='registration_form']//div[@class='alert alert-success']")
    WebElement porukaUspesneRegistracije;

    @FindBy(xpath = "//div[@class='modal-content']//form[@id='registration_modal']//button[@class='close']")
    WebElement closeDugme;



    //konstruktor
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //metoda nad WebElementima
    public void clickPrijavaRegistrujteSe (){
        assert isElementPresent ( registracijaModal );
        registracijaModal.click();
    }

//    public void enterTipKorisnika(){
//        assert isElementPresent(tipKorisnika);
//        tipKorisnika.click();
//    }

    public void enterImeKorisnika(){
        assert isElementPresent(imeKorisnika): "ERROR. Registration modal is not open";
        imeKorisnika.click();
        imeKorisnika.sendKeys(Strings.IME_ZA_REGISTRACIJU);
    }

    public void enterPrezimeKorisnika(){
        assert isElementPresent(prezimeKorisnika): "ERROR. Registration modal is not open";
        prezimeKorisnika.click();
        prezimeKorisnika.sendKeys(Strings.PREZIME_ZA_REGISTRACIJU);
    }

    public void enterEmailKorisnika(){
        assert isElementPresent(emailKorisnika): "ERROR. Registration modal is not open";
        emailKorisnika.click();
        emailKorisnika.sendKeys(Strings.EMAIL_ZA_REGISTRACIJU);
    }

    public void enterTelefonKorisnika(){
        assert isElementPresent(telefonKorisnika): "ERROR. Registration modal is not open";
        telefonKorisnika.click();
        telefonKorisnika.sendKeys(Strings.TELEFON_ZA_REGISTRACIJU);
    }

//    public void enterDrzavaKorisnika(){
//        assert isElementPresent(drzavaKorisnika): "ERROR. Registration modal is not open";
//        drzavaKorisnika.click();
//        drzavaKorisnika.sendKeys(Strings.DRZAVA_ZA_REGISTRACIJU);
//    }

    public void enterGradKorisnika(){
        assert isElementPresent(gradKorisnika): "ERROR. Registration modal is not open";
        gradKorisnika.click();
        gradKorisnika.sendKeys(Strings.GRAD_ZA_REGISTRACIJU);
    }

    public void enterUlicaKorisnika(){
        assert isElementPresent(ulicaKorisnika): "ERROR. Registration modal is not open";
        ulicaKorisnika.click();
        ulicaKorisnika.sendKeys(Strings.ULICA_ZA_REGISTRACIJU);
    }

    public void enterKucniBrojKorisnika(){
        assert isElementPresent(kucniBrojKorisnika): "ERROR. Registration modal is not open";
        kucniBrojKorisnika.click();
        kucniBrojKorisnika.sendKeys(Strings.KUCNI_BROJ_ZA_REGISTRACIJU);
    }

    public void enterPostanskiBroj(){
        assert isElementPresent(postanskiBroj): "ERROR. Registration modal is not open";
        postanskiBroj.click();
        postanskiBroj.sendKeys(Strings.POSTANSKI_BROJ_ZA_REGISTRACIJU);
    }

    public void enterLozinkaKorisnika(){
        assert isElementPresent(lozinkaKorisnika): "ERROR. Registration modal is not open";
        lozinkaKorisnika.click();
        lozinkaKorisnika.sendKeys(Strings.LOZINKA_ZA_REGISTRACIJU);
    }

    public void enterPonoviteLozinkuKorisnika(){
        assert isElementPresent(ponoviteLozinkuKorisnika): "ERROR. Registration modal is not open";
        ponoviteLozinkuKorisnika.click();
        ponoviteLozinkuKorisnika.sendKeys(Strings.LOZINKA_ZA_REGISTRACIJU);
    }

    public void clickDaImamViseOd15Godina(){
        assert isElementPresent(daImamViseOd15Godina): "ERROR. Registration modal is not open";
        daImamViseOd15Godina.click();
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();",daImamViseOd15Godina);
//        JavascriptExecutor js1= (JavascriptExecutor) driver;
//        js1.executeScript("argumrnts[0].click();",daImamViseOd15Godina);

    }

    public void clickZenskiPol(){
        assert isElementPresent(zenskiPol): "ERROR. Registration modal is not open";
        zenskiPol.click();
    }


    public void clickReCapchaClick(){
        driver.switchTo().frame(iFrame);
        reCapchaClick.click();
        driver.switchTo().defaultContent();
        return;
    }

    public void clickSlazemSeSaUslovimaKorisnika(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",slazemSeSaUslovimaKorisnika);
        assert isElementPresent(slazemSeSaUslovimaKorisnika):"ERROR. Registration modal is not open";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",slazemSeSaUslovimaKorisnika);
    }

    public void clickRegistracijaButton(){
        assert isElementPresent(registracijaButton):"ERROR. Registration modal is not open";
        registracijaButton.click();
        sleep();
    }

    public void setPorukaUspesneRegistracije(){
        assert isElementPresent(porukaUspesneRegistracije):"ERROR. Registration modal is not open";
    }

    public void closeDugmeUspesneregistracije(){
        assert isElementPresent(closeDugme):"ERROR. Registration modal is not open";
        closeDugme.click();
    }













}
