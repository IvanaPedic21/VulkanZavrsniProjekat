package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    WebDriver driver = null;

    @FindBy (xpath = "//*[@class='row']")
    WebElement searchResultsList;


    // konstruktor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage() {
    }

    //metoda
    public void clickOnBook(String itemName){
        assert isElementPresent(searchResultsList): "ERROR.Search result list not on page";
        List<WebElement> elements = driver.findElements(By.xpath(Strings.XPATH_CAROBNE_PRICE));
        assert elements.size() !=0 : "ERORR. Aray is empty.";
        elements.get(0).click();
    }

    }






