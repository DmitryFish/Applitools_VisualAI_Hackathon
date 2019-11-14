package com.rybalchenko.ApplitoolsHackathon.BaseTests;

import com.rybalchenko.ApplitoolsHackathon.Helpers.BrowsersHelper;
import com.rybalchenko.ApplitoolsHackathon.Pages.HomePage;
import com.rybalchenko.ApplitoolsHackathon.Pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTests {

    public static LoginPage lp;
    public static HomePage hp;
    public static WebDriver driver = BrowsersHelper.getChromeLocalWebDriver();

    @BeforeAll
    public static void setup(){
        setWebDriver(driver);
        initializePages();
    }

    private static void initializePages() {
        lp = page (LoginPage.class);
        hp = page (HomePage.class);
    }

    @AfterAll
    public static void end(){
        WebDriverRunner.getWebDriver().quit();
    }
}
