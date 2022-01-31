package Tests;

import Pages.BasePage;
import Pages.Strings;
import org.testng.annotations.Test;

public class InformationTest extends BaseTest{

/**
 * Test Informacije O nama; Kontak; Najcesca pitanja; Vulkan klub; Knjizare; Brza dostava knjiga.
 *
 * Test steps:
 * 1.Navigate to https://www.knjizare-vulkan.rs
 * 2.In footer option name Informacije and click button name O nama and verify title page
 * 3.In footer option name Informacije and click button name Kontakt and verify title page
 * 4.In footer option name Informacije and click button name Najcesca pitanja and verify title page
 * 5.In footer option name Informacije and click button name Vulkan klub and verify title page
 * 6.In footer option name Informacije and click button name Knjizare and verify title page
 * 7.In footer option name Informacije and click button name Brza dostava knjiga and verify title page
 *
 * Expected results:
 * 2. Verify that you are on URL: https://www.knjizare-vulkan.rs/o-nama
 * 3. Verify that you are on URL: https://www.knjizare-vulkan.rs/kontakt
 * 4. Verify that you are on URL: https://www.knjizare-vulkan.rs/najcesca-pitanja
 * 5. Verify that you are on URL: https://www.knjizare-vulkan.rs/vulkan-klub-kartica
 * 6. Verify that you are on URL: https://www.knjizare-vulkan.rs/knjizare
 * 7. Verify that you are on URL: https://www.knjizare-vulkan.rs/novosti/1398-glovo-brza-dostava-knjiga
 */

@Test
    public void testInformation(){
        driver=openChromeDriver();
        try {
            // u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov O NAMA
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage=new BasePage(driver);

            print("2.Click button in footer O NAMA and Verify that user open in the footer URL INFORMACIJE/O NAMA");
            basePage.clickTitleONama();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_O_NAMA):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_O_NAMA;


            // u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov KONTAKT
            print("3.Click button in footer KONTAKT and Verify that user open in the footer URL INFORMACIJE/KONTAKT");
            basePage.clickTitleKontakt();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_KONTAKT):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_KONTAKT;


            // u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov NAJČEŠĆA PITANJA
            print("4.Click button in footer NAJČEŠĆA PITANJA and Verify that user open in the footer URL INFORMACIJE/NAJČEŠĆA PITANJA");
            basePage.clickTitleNajcescaPitanja();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_NAJCESCA_PITANJA):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_NAJCESCA_PITANJA;


            // u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov VULKAN KLUB
            print("5.Click button in footer VULKAN KLUB and Verify that user open in the footer URL INFORMACIJE/VULKAN KLUB");
            basePage.clickTitleVulkanKlub();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_VULKAN_KLUB):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_VULKAN_KLUB;
            basePage.sleep();

            // u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov KNJIŽARE
            print("6.Click button in footer KNJIŽARE and Verify that user open in the footer URL INFORMACIJE/KNJIŽARE");
            basePage.clickTitleKnjizareVulkan();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_KNJIZARE_VULKAN):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_KNJIZARE_VULKAN;
            basePage.sleep();

            //u footeru se nalazi opcija INFORMACIJE i tu ide klik za naslov BRZA DOSTAVA KNJIGA
            print("7.Click button in footer BRZA DOSTAVA KNJIGA and Verify that user open in the footer URL INFORMACIJE/BRZA DOSTAVA KNJIGA");
            basePage.clickTitleBrzaDostava();
            assert isCurrentURLEqualTo(Strings.INFORMACIJE_BRZA_DOSTAVA_KNJIGA):"ERROR." + "You should be on the site:" + Strings.INFORMACIJE_BRZA_DOSTAVA_KNJIGA;
            basePage.sleep();


        }finally {
//            driver.quit();
        }
    }

}
