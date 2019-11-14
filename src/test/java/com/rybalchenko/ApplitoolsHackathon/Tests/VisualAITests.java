package com.rybalchenko.ApplitoolsHackathon.Tests;

import org.openqa.selenium.*;
import com.applitools.eyes.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.ClassicRunner;
import com.rybalchenko.ApplitoolsHackathon.BaseTests.BaseTests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class VisualAITests extends BaseTests{

    public static BatchInfo batch = new BatchInfo("Visual tests.");
    public Eyes eyes;

    @BeforeEach
    public void setupNew(){
        EyesRunner runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey("gWS5eeXv4nckowxiVTT7w7eT42yhYDeT99qN7wCxKG9Y110");
        eyes.setBatch(batch);
    }

    @AfterEach
    public void close(){
        eyes.closeAsync();
        eyes.abortIfNotClosed();
    }

    @Test
    public void LoginPageUiElementsTest() throws InterruptedException {
        eyes.open(driver, "ApplitoolsHackathon2019", "Login Page Ui Elements Test");

        open(lp.loginPage);
        Thread.sleep(5000);
        eyes.checkWindow("Login Page",true);

        //Check That Elements enabled
        lp.usernameField.shouldBe(enabled);
        lp.passwordField.shouldBe(enabled);
        lp.loginButton.shouldBe(enabled);
        lp.rememberMeCheckbox.shouldBe(enabled);
        lp.twitterIcon.shouldBe(enabled);
        lp.facebookIcon.shouldBe(enabled);
        //lp.linkedinIcon.shouldBe(enabled); //commented for V2
    }

    @Test
    public void DataDrivenTest(){
        eyes.open(driver, "ApplitoolsHackathon2019", "Data-Driven Test");
        open(lp.loginPage);

        lp.usernameField.waitUntil(enabled, 5000);
        lp.loginButton.waitUntil(enabled, 5000).click();
        lp.warningMessage.waitUntil(visible, 5000);
        eyes.checkWindow("Warning: Without Username and Password", true);

        lp.usernameField.sendKeys("TestUser");
        lp.loginButton.click();
        lp.warningMessage.waitUntil(visible, 5000);
        eyes.checkWindow("Warning: Without Password", true);

        lp.usernameField.clear();
        lp.passwordField.waitUntil(enabled, 5000).sendKeys("1234567890");
        lp.loginButton.click();
        lp.warningMessage.waitUntil(visible, 5000);
        eyes.checkWindow("Warning: Without Username", true);

        lp.usernameField.sendKeys("TestUser");
        lp.loginButton.click();
        eyes.checkWindow("Home Page", true);
    }

    @Test
    void TableSortTest() {
        eyes.open(driver, "ApplitoolsHackathon2019", "Table Sort Test");
        open(lp.loginPage);
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        hp.userIcon.waitUntil(visible, 5000);
        eyes.checkWindow("Unsorted Table.", true);

        hp.amountColumn.waitUntil(enabled, 5000).click();
        eyes.checkWindow("Sorted Table.", true);
    }

    @Test
    void CanvasChartTest() {
        eyes.open(driver, "ApplitoolsHackathon2019", "Canvas Chart Test");
        open(lp.loginPage);
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        hp.compareExpenses.waitUntil(enabled, 3000).click();
        hp.comparisonChart.waitUntil(visible, 3000);
        eyes.checkElement(By.id("canvas"));

        hp.showDataForTheNextYearButton.waitUntil(enabled, 3000).click();
        hp.comparisonChart.waitUntil(visible, 3000);
        eyes.checkElement(By.id("canvas"));
    }

    @Test
    void DynamicContentTest() {
        eyes.open(driver, "ApplitoolsHackathon2019", "Dynamic Content Test");
        open("https://demo.applitools.com/hackathon.html?showAd=true");
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        hp.flashSaleGif.waitUntil(visible, 3000);
        eyes.checkWindow("Page with Ads", true);
        eyes.checkElement(By.id("flashSale"));
        eyes.checkElement(By.id("flashSale2"));
    }
}