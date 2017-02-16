package org.brit.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by brit on 1/15/17.
 */

/**
 * Factory for create instance of webdriver
 */
public class DriverFactory {

    /**
     * Factory method to initialization of WebDriver
     * @param type {@link WebDriverType} value
     * @return
     */
     public static WebDriver initDriver(WebDriverType type) {
        switch (type) {
            case FIREFOX:
                // User io.github.bonigarcia.wdm.WebDriverManager for setup Firefox driver automatically
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            case CHROME:
                // User io.github.bonigarcia.wdm.WebDriverManager for setup Chrome driver automatically
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
        }
        return null;
    }
}
