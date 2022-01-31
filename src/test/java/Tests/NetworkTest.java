package Tests;

import Pages.BasePage;
import Pages.Strings;
import org.testng.annotations.Test;

public class NetworkTest extends BaseTest {

    /**
     * Test connect to social networks Facebook; Twitter; Instagram; TikTok
     *
     * Steps:
     * 1.Navigate to https://www.knjizare-vulkan.rs
     * 2.In footer in the right corner click button icon FACEBOOK
     * 3.In footer in the right corner click button icon TWITTER
     * 4.In footer in the right corner click button icon INSTAGRAM
     * 5.In footer in the right corner click button icon TIKTOK
     *
     * Expected results:
     * 2.Verify that user open FACEBOOK URL
     * 3.Verify that user open TWITTER URL
     * 4.Verify that user open INSTAGRAM URL
     * 5.Verify that user open TIKTOK URL
     *
     */

    @Test

    public void connectToSocialNetworksTests() {
        driver = openChromeDriver();
        try {

            //povezivanje na Facebook
            print("1.Navigate to https://www.knjizare-vulkan.rs");
            BasePage basePage = new BasePage(driver);
            basePage.clickNetworkFacebook();
            basePage.sleep();
            print("2.Verify that user open FACEBOOK URL");
            assert isCurrentURLEqualTo(Strings.NETWORK_FACEBOOK) : "ERROR." + "Not is open Facebook page.";

            //povezivanje na TwitterNot is a
            basePage.clickNetworkTwitter();
            basePage.sleep();
            print("3.Verify that user open TWITTER URL");
            assert isCurrentURLEqualTo(Strings.NETWORK_TWITTER) : "ERROR." + "Not is open Twitter page.";

            //povezivanje na Instagram
            basePage.clickNetworkInstagram();
            basePage.sleep();
            print("4.Verify that user open INSTAGRAM URL");
            assert isCurrentURLEqualTo(Strings.NETWORK_INSTAGRAM) : "ERROR." + "Not is open Instagram page.";

            //povezivanje na Tiktok
            basePage.clickNetworkTiktok();
            basePage.sleep();
            print("5.Verify that user open TIKTOK URL");
            assert isCurrentURLEqualTo(Strings.NETWORK_TIKTOK) : "ERROR." + "Not is open Tiktok page.";


        } finally {
//            driver.quit();
        }
    }


//    /**
//     * Test in connect to social network Facebook
//     *
//     * Steps:
//     *
//     * Expected results:
//     *
//     */
//
//    @Test
//
//    public void connectToSocialNetworkFacebook() {
//        driver = openChromeDriver();
//        try {
//            print("1.Navigate to https://www.knjizare-vulkan.rs");
//            BasePage basePage = new BasePage(driver);
//            basePage.clickNetworkFacebook();
//            basePage.sleep();
//            assert isCurrentURLEqualTo(Strings.NETWORK_FACEBOOK) : "ERROR." + "Not is open Facebook page.";
//        }finally {
//            driver.quit();
//        }
//    }
//
//    /**
//     * Test in connect to social network Twitter
//     *
//     * Steps:
//     *
//     * Expected results:
//     *
//     */
//
//    @Test
//
//    public void connectToSocialNetworkTwitter () {
//        driver=openChromeDriver();
//        try {
//            print("1.Navigate to https://www.knjizare-vulkan.rs");
//            BasePage basePage=new BasePage(driver);
//            basePage.clickNetworkTwitter();
//            assert isCurrentURLEqualTo(Strings.NETWORK_TWITTER):"ERROR." + "Not is open Facebook page.";
//
//        }finally {
////            driver.quit();
//        }
//    }
//
//    /**
//     * Test in connect to social network Instagram
//     *
//     * Steps:
//     *
//     * Expected results:
//     *
//     */
//
//    @Test
//
//    public void connectToSocialNetworkInstagram(){
//        driver=openChromeDriver();
//        try {
//            print("1.Navigate to https://www.knjizare-vulkan.rs");
//            BasePage basePage=new BasePage(driver);
//            basePage.clickNetworkInstagram();
//            assert isCurrentURLEqualTo(Strings.NETWORK_INSTAGRAM):"ERROR." + "Not is open Twitter page.";
//
//        }finally {
////            driver.quit();
//        }
//    }
//
//    /**
//     * Test in connect to social network TikTok
//     *
//     * Steps:
//     *
//     * Expected results:
//     *
//     */
//
//    @Test
//
//    public void connectToSocialNetworkTiktok(){
//        driver=openChromeDriver();
//        try {
//            print("1.Navigate to https://www.knjizare-vulkan.rs");
//            BasePage basePage=new BasePage(driver);
//            basePage.clickNetworkTiktok();
//            assert isCurrentURLEqualTo(Strings.NETWORK_TIKTOK):"ERROR." + "Not is open Tiktok page.";
//
//        }finally {
////            driver.quit();
//        }
//    }
}
