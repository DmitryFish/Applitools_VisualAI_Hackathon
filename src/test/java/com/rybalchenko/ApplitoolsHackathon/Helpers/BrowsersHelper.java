package com.rybalchenko.ApplitoolsHackathon.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowsersHelper {

    public static WebDriver getChromeLocalWebDriver () {
        System.setProperty("webdriver.chrome.driver", ".//WebDrivers//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
