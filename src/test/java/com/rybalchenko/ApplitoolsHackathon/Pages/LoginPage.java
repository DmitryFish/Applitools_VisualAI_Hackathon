package com.rybalchenko.ApplitoolsHackathon.Pages;

import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    //URLs
    public String loginPageVersion1 = "https://demo.applitools.com/hackathon.html";
    public String loginPageVersion2 = "https://demo.applitools.com/hackathonV2.html";
    public String loginPage = loginPageVersion2;

    //Warning Messages
    public String warningNoUsername = "Username must be present";
    public String warningNoPassword = "Password must be present";
    public String warningNoUsernameAndPassword = "Both Username and Password must be present";

    @FindBy(xpath = "//h4[@class='auth-header']")
    public SelenideElement formName;

    @FindBy(id = "username")
    public SelenideElement usernameField;

    @FindBy(xpath = "//div[@class='form-group'][1]//label")
    public SelenideElement usernameFieldLabel;

    @FindBy(xpath = "//div[@class='pre-icon os-icon os-icon-user-male-circle']")
    public SelenideElement usernameFieldIcon;

    @FindBy(xpath = "//input[@placeholder]")
    public SelenideElement usernameFieldInnerText;

    @FindBy(id = "password")
    public SelenideElement passwordField;

    @FindBy(xpath = "//div[@class='form-group'][2]//label")
    public SelenideElement passwordFieldLabel;

    @FindBy(xpath = "//div[@class='pre-icon os-icon os-icon-fingerprint']")
    public SelenideElement passwordFieldIcon;

    @FindBy(id = "log-in")
    public SelenideElement loginButton;

    @FindBy(xpath = "//input[@class='form-check-input']")
    public SelenideElement rememberMeCheckbox;

    @FindBy(xpath = "//label[@class='form-check-label']")
    public SelenideElement rememberMeLabel;

    @FindBy(xpath = "//img[@src='img/social-icons/twitter.png']")
    public SelenideElement twitterIcon;

    @FindBy(xpath = "//img[@src='img/social-icons/facebook.png']")
    public SelenideElement facebookIcon;

    @FindBy(xpath = "//img[@src='img/social-icons/linkedin.png']")
    public SelenideElement linkedinIcon;

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    public SelenideElement warningMessage;
}
