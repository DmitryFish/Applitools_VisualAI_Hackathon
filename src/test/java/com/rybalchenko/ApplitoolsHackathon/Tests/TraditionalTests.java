package com.rybalchenko.ApplitoolsHackathon.Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.assertj.core.api.SoftAssertions;
import com.rybalchenko.ApplitoolsHackathon.BaseTests.BaseTests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

class TraditionalTests extends BaseTests {

    private SoftAssertions softAssertions = new SoftAssertions();

    @AfterEach
    void assertEnd(){
        softAssertions.assertAll();
    }

    @Test
    void LoginPageUiElementsTest() {
        /*
        In 'Hackathon App Version 2' this test catch the following issues:
        Line 36: Invalid form label. Expected: Login Form. Actual: Logout Form.
        Line 43: Invalid inner text in 'Username' field. Expected: Enter your username. Actual: John Smith.
        Line 50: Invalid field label. Expected: Password. Actual: Pwd.
        Line 51: Invalid inner text in 'Password' field. Expected: Enter your password. Actual: ABC$*1@.
        */

        System.out.println("[INFO]: 'Login Page Ui Elements Test' start *****");
        open(lp.loginPage);
        lp.usernameField.waitUntil(exist, 3000).waitUntil(visible, 3000);

        //Check Form Name
        softAssertions.assertThat(lp.formName.getText()).isEqualTo("Login Form");

        //Check Username Field
        System.out.println("[INFO]: Check 'Username' field.");
        softAssertions.assertThat((lp.usernameField).isDisplayed());
        softAssertions.assertThat((lp.usernameField).isEnabled());
        softAssertions.assertThat(lp.usernameFieldLabel.getText()).isEqualTo("Username");
        softAssertions.assertThat(lp.usernameField.getAttribute("placeholder")).isEqualTo("Enter your username");
        softAssertions.assertThat((lp.usernameFieldIcon).isDisplayed());

        //Check Password Field
        System.out.println("[INFO]: Check 'Password' field.");
        softAssertions.assertThat((lp.passwordField).isDisplayed());
        softAssertions.assertThat((lp.passwordField).isEnabled());
        softAssertions.assertThat(lp.passwordFieldLabel.getText()).isEqualTo("Password");
        softAssertions.assertThat(lp.passwordField.getAttribute("placeholder")).isEqualTo("Enter your password");
        softAssertions.assertThat((lp.passwordFieldIcon).isDisplayed());

        //Check Buttons
        System.out.println("[INFO]: Check 'Log In' button.");
        softAssertions.assertThat((lp.loginButton).isDisplayed());
        softAssertions.assertThat((lp.loginButton).isEnabled());
        softAssertions.assertThat(lp.loginButton.getText()).isEqualTo("Log In");

        //Check Checkbox
        System.out.println("[INFO]: Check 'Remember Me' checkbox.");
        softAssertions.assertThat((lp.rememberMeCheckbox).isDisplayed());
        softAssertions.assertThat((lp.rememberMeCheckbox).isEnabled());
        softAssertions.assertThat(lp.rememberMeLabel.getText()).isEqualTo("Remember Me");

        //Check Icons
        System.out.println("[INFO]: Check social network icons.");
        softAssertions.assertThat((lp.linkedinIcon).exists());
        softAssertions.assertThat((lp.twitterIcon).isDisplayed());
        softAssertions.assertThat((lp.twitterIcon).isEnabled());
        softAssertions.assertThat((lp.linkedinIcon).exists());
        softAssertions.assertThat((lp.facebookIcon).isDisplayed());
        softAssertions.assertThat((lp.facebookIcon).isEnabled());
        softAssertions.assertThat((lp.linkedinIcon).exists());
        softAssertions.assertThat((lp.linkedinIcon).isDisplayed());
        softAssertions.assertThat((lp.linkedinIcon).isEnabled());
        System.out.println("[INFO]: 'Login Page Ui Elements Test' ends*****");
    }

    @Test
    void DataDrivenTest(){
        /*
        In 'Hackathon App Version 2' this test catch the following issues:
        Line 92: Invalid message. Expected: Both Username and Password must be present. Actual: Please enter both username and password.
        */
        System.out.println("[INFO]: 'Data-Driven Test' start *****");
        open(lp.loginPage);
        System.out.println("[INFO]: Try to login without Username and Password.");
        lp.usernameField.waitUntil(enabled, 5000);
        lp.loginButton.waitUntil(enabled, 5000).click();
        lp.warningMessage.waitUntil(visible, 5000);
        softAssertions.assertThat((lp.warningMessage).isDisplayed());
        softAssertions.assertThat(lp.warningMessage.getText()).isEqualTo(lp.warningNoUsernameAndPassword);

        System.out.println("[INFO]: Try to login without Password.");
        lp.usernameField.clear();
        lp.usernameField.sendKeys("TestUser");
        lp.loginButton.waitUntil(enabled, 5000).click();
        lp.warningMessage.waitUntil(visible, 5000);
        softAssertions.assertThat((lp.warningMessage).isDisplayed());
        softAssertions.assertThat(lp.warningMessage.getText()).isEqualTo(lp.warningNoPassword);

        System.out.println("[INFO]: Try to login without Username.");
        lp.usernameField.clear();
        lp.passwordField.clear();
        lp.passwordField.sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();
        lp.warningMessage.waitUntil(visible, 5000);
        softAssertions.assertThat((lp.warningMessage).isDisplayed());
        softAssertions.assertThat(lp.warningMessage.getText()).isEqualTo(lp.warningNoUsername);

        System.out.println("[INFO]: Try to login with Username and Password.");
        lp.usernameField.clear();
        lp.usernameField.sendKeys("TestUser");
        lp.passwordField.clear();
        lp.passwordField.sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        hp.userIcon.waitUntil(visible, 5000);
        System.out.println("[INFO]: 'Data-Driven Test' ends*****");
    }

    @Test
    void TableSortTest() {
        /*
        In 'Hackathon App Version 2' this test catch the following issues:
        Lines 144-150: Sorting doesn't work.
        */
        System.out.println("[INFO]: 'Table Sort Test' start *****");
        open(lp.loginPage);
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        System.out.println("[INFO]: Check unsorted Table.");
        hp.userIcon.waitUntil(visible, 5000);
        hp.checkValueInLine(softAssertions, "1", hp.StarbucksCoffeeValues);
        hp.checkValueInLine(softAssertions, "2", hp.StripePaymentProcessingValues);
        hp.checkValueInLine(softAssertions, "3", hp.MailChimpServicesValues);
        hp.checkValueInLine(softAssertions, "4", hp.ShopifyProductValues);
        hp.checkValueInLine(softAssertions, "5", hp.EbayMarketplaceValues);
        hp.checkValueInLine(softAssertions, "6", hp.TemplatesIncValues);

        System.out.println("[INFO]: Check sorted Table.");
        hp.amountColumn.waitUntil(enabled, 5000).click();
        hp.checkValueInLine(softAssertions, "1", hp.MailChimpServicesValues);
        hp.checkValueInLine(softAssertions, "2", hp.EbayMarketplaceValues);
        hp.checkValueInLine(softAssertions, "3", hp.ShopifyProductValues);
        hp.checkValueInLine(softAssertions, "4", hp.TemplatesIncValues);
        hp.checkValueInLine(softAssertions, "5", hp.StripePaymentProcessingValues);
        hp.checkValueInLine(softAssertions, "6", hp.StarbucksCoffeeValues);
        System.out.println("[INFO]: 'Table Sort Test' ends *****");
    }

    @Test
    void CanvasChartTest() {
        System.out.println("[INFO]: 'Canvas Chart Test' start *****");
        open(lp.loginPage);
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        System.out.println("[INFO]: Check Chart.");
        hp.compareExpenses.waitUntil(enabled, 3000).click();
        hp.comparisonChart.waitUntil(visible, 3000);

        hp.showDataForTheNextYearButton.waitUntil(enabled, 3000).click();
        hp.comparisonChart.waitUntil(visible, 3000);

        /*
        Canvas Chart cannot be tested by Traditional Tests.
        */

        System.out.println("[INFO]: 'Canvas Chart Test' ends *****");
    }

    @Test
    void DynamicContentTest() {
        System.out.println("[INFO]: 'Dynamic Content Test' start *****");
        open("https://demo.applitools.com/hackathon.html?showAd=true");
        lp.usernameField.waitUntil(enabled, 3000).sendKeys("TestUser");
        lp.passwordField.waitUntil(enabled, 3000).sendKeys("1234567890");
        lp.loginButton.waitUntil(enabled, 5000).click();

        System.out.println("[INFO]: Check Ads.");
        hp.flashSaleGif.waitUntil(exist, 3000).waitUntil(visible, 3000).waitUntil(enabled, 3000);
        hp.flashSaleGif2.waitUntil(exist, 3000).waitUntil(visible, 3000).waitUntil(enabled, 3000);

        /*
        With Traditional Tests, I can only verify that the ad exists, is visible, and is enabled.
        */

        System.out.println("[INFO]: 'Dynamic Content Test' ends *****");
    }
}