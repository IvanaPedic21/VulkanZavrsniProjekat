package Tests;

import Pages.BasePage;
import Pages.SearchPage;
import Pages.ShoppingPage;
import Pages.Strings;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest{

    /**
     * Add item to shopping cart
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.Click search button
     * 3.Enter in the item name and press enter,and click on CAROBNE PRICE from the displayed search results list
     * 4.Confirm that the user is navigated and open to the CAROBNE PRICE
     * 5.Confirm shopping cart is number 1.
     * 6.Click on the shopping cart icon, and verify that the selected product on page URL.
     * 7.Login user with exsiting user
     * 8.Confirm button Potvrdi  is present
     *
     * Expected results:
     * 4.Verify that the user is navigated and open to the CAROBNE PRICE URL
     * 5.Verify shopping cart is number 1.
     * 7.Verify thah user login
     * 8.Verify button Potvrdi  is present.
     *
     */

    @Test

    public void addItemToShoppingCart(){
        driver = openChromeDriver();
        try {
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);
            print("2.Click on search button");
            basePage.clickPretragaButton();

            print("3.Enter in the item name and press enter,and click on CAROBNE PRICE from the displayed search results list");
            SearchPage searchPage =basePage.clickTextZaPretragu(Strings.PRICE);
            searchPage.clickOnBook(Strings.PRICE);
            print("4.Verify that the user is navigated and open to the CAROBNE PRICE URL ");
            assert isCurrentURLEqualTo(Strings.CAROBNE_PRICE_URL):"ERROR.";

            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.clickButtonAddToCart();
            shoppingPage.sleep();
            print ("5.Verify shopping cart is number 1." );
            String numberItemInShopingCart = shoppingPage.getNumberOfItemInCartFromBadge();
            assert numberItemInShopingCart.equals("1"): "ERROR. Number cart is not 1.";
            shoppingPage.clickPopUp();
            shoppingPage.clickMojaKorpa();
            shoppingPage.sleep();
            print("6.Click on the shopping cart icon, and verify that the selected product on page.");
            assert isCurrentURLEqualTo(Strings.SHOPPING_PAGE):"ERROR." + "Not is open page.";
            shoppingPage.listItemInShoppingCart();
            print("7.In modal login, login with existing user. ");
            shoppingPage.clickPrijavaModalForShopping();
            shoppingPage.prijavaKorisnikaShopping();
            print("8.Verify button Potvrdi shopping is present");
            shoppingPage.buttonPotvrdiKupovinuIsPresent();

        }finally {
//            driver.quit();
        }
    }
}
