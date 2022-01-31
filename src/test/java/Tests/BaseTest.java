package Tests;

import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sun.awt.windows.WPrinterJob;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    WebDriver driver = null;

    public WebDriver openChromeDriver() {
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_PAGE_URL);
        return driver;

    }

    //print metoda
    public void print(String text) {
        System.out.println (text);
    }

    public boolean isCurrentURLEqualTo (String expectedURL){
        print("isCurrentURLEqualTo ( " + expectedURL + " ) ");
        String currentURL = driver.getCurrentUrl();
        print( " User is on " + currentURL );
        boolean b = currentURL.equals(expectedURL);
        return b;
    }

}
