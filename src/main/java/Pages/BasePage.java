package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class BasePage {

    WebDriver driver = null;

    //Web elementi zajednicki za sve

    @FindBy(xpath = "//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]")
    WebElement cookieSlazemSeButton;

    @FindBy(xpath = "// a[@class='login-btn']")
    WebElement prijaviteSeButton;

    @FindBy(xpath = "//a [@class = 'register-btn']")
    WebElement registrujteSeButton;

    @FindBy(xpath = "//div[@class = 'header-carthor-total']")
    WebElement korpaZaKupovinuButton;

    @FindBy(xpath = "//i [@class= 'icon fa fa-search']")
    WebElement pretragaButton;

    @FindBy(id = "search-text")
    WebElement textZaPretragu;

//    @FindBy(id = "//a[@title='Početna']")
//    WebElement pocetna;


    //Konstruktor

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        clickSlazemSe();
    }
    public BasePage(){

    }
   //metoda da se cooki ukloni klikom na dugme Slazem se

    public void clickSlazemSe() {
        waitForElement(cookieSlazemSeButton);
        cookieSlazemSeButton.click();
        }

    //Metode nad web elementima

    public void clickPrijaviteSeButton(){
        waitForElement(prijaviteSeButton);
        prijaviteSeButton.click();
    }


    public void clickRegistrujteSeButton(){
        waitForElement(registrujteSeButton);
        registrujteSeButton.click();
    }

    public void clickKorpaZaKupovinuButton(){
        waitForElement(korpaZaKupovinuButton);
        korpaZaKupovinuButton.click();
    }

    public void clickPretragaButton(){
        pretragaButton.click();
    }

    public void clickTextZaPretragu(String text){
        textZaPretragu.sendKeys(text);
        textZaPretragu.sendKeys(Keys.ENTER);
    }


    //print method
    public void print(String text) {
        System.out.println(text);
    }

   //metoda za cekanje
    public void waitForElement (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver , 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


   //metoda da li je neki web element prisutan nas stranici

    public boolean isElementPresent (WebElement element){
        print("isElementPresent");
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        }catch (Exception e){
            print(e.getMessage());
            print("Element is not present");
            return false;
        }
    }
    //Helper metoda

    public void sleep(){
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            print(e.getMessage());
        }
    }

}

