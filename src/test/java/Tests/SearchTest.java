package Tests;

import Pages.BasePage;
import Pages.SearchPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static Pages.Strings.KNJIGA_ZA_DECU;

public class SearchTest extends BaseTest {

    /**
     *
     * Search childrens book test
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click on search button on the homepage
     * 3.In search text enter name book, and press search
     * 4."Kisni oblak" is the name book to be found as a search results
     *
     * Expected results:
     *4.Verify that the user is navigated to the  KNJIGA ZA DECU Url
     */

    @Test

    public void searchChildrensBookTest() {
        driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click on search button");
            basePage.clickPretragaButton();

            print("3.Enter in the item name.");
            basePage.clickTextZaPretragu("KIŠNI OBLAK");

            print("4.Verify that the user is navigated to the  KNJIGA ZA DECU ");
            assert isCurrentURLEqualTo(KNJIGA_ZA_DECU) : "Error.Expected URL is not open";


        } finally {
//            driver.quit();
        }
    }

    /**
     *
     * Test search book name
     *
     *Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click on search button on the homepage
     * 3.In search text enter name book, and press search
     * 4.Results is 4 book, clickin on "Carobne price"
     * 5.Book name "Carobne price" is present, we use the confirmation Url
     *
     * Expected results:
     * 5.Verify that the user is navigated, and open to the CAROBNE PRICE URL
     */

    @Test
    public void searchBookName(){
        driver=openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);

            print("2.Click on search button");
            basePage.clickPretragaButton();

            print("3.Enter in the item name and press enter");
            SearchPage searchPage =basePage.clickTextZaPretragu(Strings.PRICE);

            print("4.Click on CAROBNE PRICE from the displayed search results list");
            searchPage.clickOnBook(Strings.PRICE);

            print("5.Verify that the user is navigated and open to the CAROBNE PRICE URL ");
            assert isCurrentURLEqualTo(Strings.CAROBNE_PRICE_URL):"ERROR.";

        }finally {
            }
//            driver.quit();
        }

}






