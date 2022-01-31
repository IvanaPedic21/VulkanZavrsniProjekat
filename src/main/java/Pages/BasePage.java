package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver = null;

    //Web elementi zajednicki za sve

    @FindBy(xpath="//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]")
    WebElement cookieSlazemSeButton;

    @FindBy(xpath ="//li[@class='item item-login']")
    WebElement prijaviteSeButton;

    @FindBy(xpath ="//a [@class='register-btn']")
    WebElement registrujteSeButton;

    @FindBy(xpath="//div[@class='header-carthor-total']")
    WebElement korpaZaKupovinuButton;

    @FindBy(xpath="//i[@class='icon fa fa-search']")
    WebElement pretragaButton;

    @FindBy(xpath = "//div[@class='autocomplete']/input[@id='search-text']")
    WebElement textZaPretragu;

    @FindBy (xpath = "//a[@title='Facebook']")
    WebElement networkFacebook;

    @FindBy(xpath = "//a[@title='Twitter']")
    WebElement networkTwitter;

    @FindBy (xpath = "//a[@title='Instagram']")
    WebElement networkInstagram;

    @FindBy(xpath = "//a[@title='Tiktok']")
    WebElement networkTiktok;

    @FindBy (xpath = "//a[@title='O nama']")
    WebElement oNama;

    @FindBy(xpath = "//h1")
    WebElement titleONama;

    @FindBy(xpath = "//a[text()='Kontakt']")
    WebElement kontakt;

    @FindBy (xpath = "//h1")
    WebElement titleKontakt;

    @FindBy(xpath = "//a[text()='Najčešća pitanja']")
    WebElement najcescaPitanja;

    @FindBy (xpath = "//div[@class='heading-wrapper']//h1")
    WebElement titleNajcescaPitanja;

    @FindBy (xpath = "//a[text()='Vulkan klub']")
    WebElement vulkanKlub;

    @FindBy(xpath = "//h1")
    WebElement titleVulkanKlub;

    @FindBy(xpath = "//a[text()='Knjižare Vulkan']")
    WebElement knjizareVulkan;

    @FindBy(xpath = "//div[@class='stores-location-sesarch']//h4[text()='Pretražite']")
    WebElement titleKnjizareVulkan;

    @FindBy(xpath = "//a[text()='Brza dostava knjiga']")
    WebElement brzaDostavaKnjiga;



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
   //metoda da se cooki ukloni klikom na dugme Slazem se svaki put kada se udje na stranicu
    public void clickSlazemSe() {
        waitForElement(cookieSlazemSeButton);
        cookieSlazemSeButton.click();
        }

    //Metode nad web elementima
    //prijava za login
    public void clickPrijaviteSeButton(){
        waitForElement(prijaviteSeButton);
        prijaviteSeButton.click();
    }

    //prijava za registraciju
    public void clickRegistrujteSeButton(){
        waitForElement(registrujteSeButton);
        registrujteSeButton.click();
    }

    public void clickKorpaZaKupovinuButton(){
        waitForElement(korpaZaKupovinuButton);
        korpaZaKupovinuButton.click();
    }
    // pretraga u search
    public void clickPretragaButton(){
        pretragaButton.click();
    }

    public SearchPage clickTextZaPretragu(String text){
        textZaPretragu.sendKeys(text);
        textZaPretragu.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }
    // Metode nad elementima za povezivanje na mrezu Faceebook
    public void clickNetworkFacebook(){
        assert isElementPresent(networkFacebook):"ERROR. Button connect with Facebook is not displayed.";

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",networkFacebook);
        networkFacebook.click();

        //mora da se prebaci u novi tab da bi se uradio assert URL u testu

        List<String> tabs=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    // Metode nad elementima za povezivanje na mrezu Twitter
    public void clickNetworkTwitter(){
        //1.ovo je ako hocu sve zajedno
        List<String>tabs1=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(0));

        assert isElementPresent(networkTwitter):"ERROR.Button connect with Twitter is not displayed.";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",networkTwitter);
        networkTwitter.click();

//        //2 ako hocu da je svaki za sebe
//        List<String> tabs=new ArrayList(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));

        //ne gasim stari tab, i ne idem u tab1 nego idem u tab2
        List<String> tabs =new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    // Metode nad elementima za povezivanje na mrezu Instagram
    public void clickNetworkInstagram(){
        //1.ovo je ako hocu sve zajedno
        List<String> tabs1 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(0));
        assert isElementPresent(networkInstagram):"ERROR.Button connect with Instagram is not displayed.e";
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",networkInstagram);
        networkInstagram.click();

//        //2 ako hocu da je svaki za sebe
//        List<String> tabs=new ArrayList(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));

        //ovde dohvatam treci tab
        List<String>tabs=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(3));
    }

    // Metode nad elementima za povezivanje na mrezu TikTok
    public void clickNetworkTiktok(){
        List<String> tabs1=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(0));
        assert isElementPresent(networkTiktok):"ERROR.Button connect with TikTok is not displayed.";
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",networkTiktok);

        networkTiktok.click();
        //tiktok se otvara na glavnoj stranici ne otvara se u novom tabu
    }

    //Metode nad elementima za Informacije klik na O nama
    public void clickTitleONama(){
        assert isElementPresent(oNama):"ERROR. Footer part Informacije/O NAMA does not show.";
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", oNama);
        oNama.click();
        waitForElement(titleONama);
        print("Title page O NAMA is:" + titleONama.getText());
        assert titleONama.getText().equals("KNJIŽARE VULKAN"):"ERROR. Title page is not KNJIŽARE VULKAN.";
    }
    //Metode nad elementima za Informacije klik na Kontakt
    public void clickTitleKontakt(){
        assert isElementPresent(kontakt):"ERROR. Footer part Informacije/KONTAKT does not show.";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", kontakt);
        kontakt.click();
        waitForElement(titleKontakt);
        print("Title page KONTAKT is:" + titleKontakt.getText());
        assert titleKontakt.getText().equals("KONTAKT"):"ERROR. Title page is not KONTAKT.";
    }

    //Metode nad elementima za Informacije klik na Najcesca pitanja
    public void clickTitleNajcescaPitanja(){
        assert isElementPresent(najcescaPitanja):"ERROR. Footer part Informacije/NAJCESCA PITANJA does not show.";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",najcescaPitanja);
        najcescaPitanja.click();
        waitForElement(najcescaPitanja);
        print("Title page NAJCESCA PITANJA is:" + titleNajcescaPitanja.getText());
        assert titleNajcescaPitanja.getText().equals("NAJČEŠĆA PITANJA"):"ERROR. Title page is not NAJČEŠĆA PITANJA.";
    }

    //Metode nad elementima za Informacije klik na Vulkan Klub
    public void clickTitleVulkanKlub(){
        assert isElementPresent(vulkanKlub):"ERROR. Footer part Informacije/VULKAN KLUB does not show.";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", vulkanKlub);
        vulkanKlub.click();
        waitForElement(titleVulkanKlub);
        print("Title page VULKAN KLUB  is:" + titleVulkanKlub.getText());
        assert titleVulkanKlub.getText().equals("VULKAN KLUB KARTICA"):"ERROR. Title page is not VULKAN KLUB KARTICA.";
    }

    //Metode nad elementima za Informacije klik na Knjizare Vulkan
    public  void clickTitleKnjizareVulkan(){
        assert isElementPresent(knjizareVulkan):"ERROR. Footer part Informacije/KNJIŽARE VULKAN does not show.";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",knjizareVulkan);
        knjizareVulkan.click();
        waitForElement(titleKnjizareVulkan);
        print("Title page NAJCESCA PITANJA is:" + titleKnjizareVulkan.getText());
//        assert titleKnjizareVulkan.getText().equals("PRETRAŽITE"):"ERROR. Title page is not PRETRAŽITE.";
    }

    //Metode nad elementima za Informacije klik na Brza dostava
    public void clickTitleBrzaDostava(){
        assert isElementPresent(brzaDostavaKnjiga):"ERROR. Footer part Informacije/BRZA DOSTAVA does not show.";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", brzaDostavaKnjiga);
        brzaDostavaKnjiga.click();
        //asssert je po url u testu jer izlazi glovo aplikacija

    }

    //print method
    public void print(String text) {
        System.out.println(text);
    }

   //metoda za cekanje
    public void waitForElement (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

   //metoda da li je neki WebElement prisutan nas stranici
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


