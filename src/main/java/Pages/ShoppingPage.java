package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingPage extends BasePage {
    WebDriver driver = null;

    @FindBy(xpath = "//button[@id='nb_addToCartButton']")
    WebElement buttonAddtoCart;

    @FindBy(xpath = "//div[@class='block mini-cart mini-cart-simple']//a[@title='Korpa']")
    WebElement popUpCart;

    @FindBy(xpath = "//div[@id='miniCartContent']//a[@title='MOJA KORPA']")
    WebElement mojaKorpa;

    @FindBy(className = "header-carthor-total")
    WebElement numberCartIcon;

    @FindBy(xpath = "//table[@class='table cart-table']")
    WebElement cartTable;

    @FindBy(xpath = "//h3[text()='Prijava']")
    WebElement prijavaForShopping;

    @FindBy (id="login_email")
    WebElement userEmailTextFieldInShopping;

    @FindBy (id="login_password")
    WebElement userPasswordTextFieldInShopping;

    @FindBy (xpath = "//button[@class ='btn btn-success btn-login confirm-loader']")
    WebElement prijavaButtonForShopping;

    @FindBy (xpath = "//button[@id='submit_order_one_page']")
    WebElement potvrdiKupovinuButton;


    //konstruktor
    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //metode
    public void clickButtonAddToCart() {
        assert isElementPresent(buttonAddtoCart) : "ERROR. Add to cart button is not displayed.";
        buttonAddtoCart.click();
    }

    public void clickPopUp(){
        assert isElementPresent(popUpCart);
        popUpCart.isDisplayed();
    }

    public void clickMojaKorpa() {
        assert isElementPresent(mojaKorpa);
        mojaKorpa.click();
    }

    public String getNumberCartIcon() {
        print("getBrojNaIkoniciKorpa");
        return numberCartIcon.getText();
    }

    public void listItemInShoppingCart() {
        List<WebElement> rowsList = cartTable.findElements(By.tagName("tr"));
        List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
            System.out.println();
            columnsList = row.findElements(By.className("cart-product"));
            // columnsList = row.findElements(By.tagName("td"));
            for (WebElement column : columnsList) {
                print(column.getText() + ",");
                print("***************************************");

            }
        }
    }
        public void clickPrijavaModalForShopping () {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", prijavaForShopping);
            assert isElementPresent(prijavaForShopping) : "ERROR. Login,in shopping cart is not possible.";
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].click();", prijavaForShopping);
            sleep();
        }

        public void enterUserEmailTextFieldInShopping(String text){
            print("Entering text" + text +  "is user Email field");
            assert isElementPresent (userEmailTextFieldInShopping):"ERROR. Login Modal is not open.";
            userEmailTextFieldInShopping.click();
            userEmailTextFieldInShopping.sendKeys(Strings.VALID_EMAIL);
        }

    public void enterPasswordTextFieldInShopping(String text){
        print("Entering text" + text +  "is Password field");
        assert isElementPresent (userPasswordTextFieldInShopping):"ERROR. Login Modal is not open.";
        userPasswordTextFieldInShopping.click();
        userPasswordTextFieldInShopping.sendKeys(Strings.VALID_LOZINKA);
    }

    public void clickPrijavaButtonForShopping(){
        print("clickin Prijavi Se");
        assert isElementPresent(prijavaButtonForShopping) :"ERROR. Login Modal is not open.";
        prijavaButtonForShopping.click();
    }

    public void prijavaKorisnikaSopping(){
        this.enterUserEmailTextFieldInShopping(Strings.VALID_EMAIL);
        this.enterPasswordTextFieldInShopping(Strings.VALID_LOZINKA);
        this.clickPrijavaButtonForShopping();
        sleep();
    }

    public void buttonPotvrdiKupovinuIsPresent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", potvrdiKupovinuButton);

        assert isElementPresent(potvrdiKupovinuButton) : "ERROR. Button 'Potvrdi' shopping is not displayed in page.";
    }

    }











