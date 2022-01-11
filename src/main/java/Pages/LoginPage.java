package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver = null;

    //Web elementi

        @FindBy(xpath = "// form[@class='login_form']")
        WebElement prijavaModal;

    //WebElementi u Modalu Prijava

        @FindBy(id = "login_email")
        WebElement userEmailTextField;

        @FindBy ( id = "login_password")
         WebElement userPasswordTextField;

        @FindBy (xpath = "//button [@class = 'btn btn-success btn-login confirm-loader']")
        WebElement prijavaButton;

        @FindBy (xpath = "//li[@class='item item-username']")
        WebElement profilKorisnika;

        @FindBy (xpath = "//a [ @title= 'Odjava']")
        WebElement odjavaButton;

        @FindBy (xpath = "// div[@class='alert alert-danger']")
        WebElement errorAlertPogresanPassword;

        @FindBy (className= "close ")
        WebElement clickButtonCloseInModalWithInvalidPassword;






        // konstruktor

       public LoginPage (WebDriver driver){
           this.driver=driver;
           PageFactory.initElements(driver,this);
        }
        //metode nad

       public void clickPrijavaModal (){
        isElementPresent ( prijavaModal );
        prijavaModal.click();
    }

        public void enterUserEmailTextField (String text){
            print("Entering text" + text +  "is user Email field");
            assert isElementPresent (userEmailTextField):"Error. Login Modal is not open.";
            userEmailTextField.click();
            userEmailTextField.sendKeys(Strings.VALID_EMAIL);

        }

        public void enterUserPasswordTextField (String text){
            print("Entering text" + text + " in Password field");
            assert isElementPresent ( userPasswordTextField ):"Error. Login Modal is not open.";
            userPasswordTextField.click();
            userPasswordTextField.sendKeys(Strings.VALID_PASSWORD);
        }

//        public void enterUserInvalidPasswordTextField(){
//           assert isElementPresent(userPasswordTextField) :"Error. Login Modal is not open.";
//            userPasswordTextField.click();
//            userPasswordTextField.sendKeys(Strings.INVALID_PASSWORD);
//        }

        public void clikinButtonPrijaviSe (){
           print("clickinPrijaviSe");
           assert isElementPresent(prijavaButton) :"Error. Login Modal is not open.";
           prijavaButton.click();
    }

        public void profilKorisnikaDajeUlogovanNastranici(){
           assert isElementPresent(profilKorisnika):"Error.You are not logged in.";
           profilKorisnika.click();
        }

        public void clickOdjavaButton() {
            assert isElementPresent(odjavaButton) : "Error. You are not logged in.";
            odjavaButton.click();
        }

        public void erorrAlertPrisutan(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript ( "arguments[0].scrollIntoView();", errorAlertPogresanPassword );

            assert isElementPresent(errorAlertPogresanPassword): "Error. Error message is not shown.";
        }

        public void clickButtonCloseInModalWithInvalidPassword(){
           assert isElementPresent(clickButtonCloseInModalWithInvalidPassword):"Error. Error message is not close.";
           clickButtonCloseInModalWithInvalidPassword.click();
        }


}

