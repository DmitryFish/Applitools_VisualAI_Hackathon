package com.rybalchenko.ApplitoolsHackathon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.assertj.core.api.SoftAssertions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @FindBy(xpath = "//div[@class='logged-user-w']")
    public SelenideElement userIcon;

    @FindBy(id = "amount")
    public SelenideElement amountColumn;

    @FindBy(id = "showExpensesChart")
    public SelenideElement compareExpenses;

    @FindBy(xpath = "//button[contains(text(), 'Show data for next year')]")
    public SelenideElement showDataForTheNextYearButton;

    @FindBy(id = "canvas")
    public SelenideElement comparisonChart;

    @FindBy(id = "flashSale")
    public SelenideElement flashSaleGif;

    @FindBy(id = "flashSale2")
    public SelenideElement flashSaleGif2;

    //---Data
    public String [] EbayMarketplaceValues = {"Complete", "Jan 7th", "Ebay Marketplace", "Ecommerce", "- 244.00 USD"};
    public String [] MailChimpServicesValues = {"Pending", "Yesterday", "MailChimp Services", "Software", "- 320.00 USD"};
    public String [] ShopifyProductValues = {"Pending", "Jan 23rd", "Shopify product", "Shopping", "+ 17.99 USD"};
    public String [] TemplatesIncValues = {"Pending", "Jan 9th", "Templates Inc", "Business", "+ 340.00 USD"};
    public String [] StripePaymentProcessingValues = {"Declined", "Jan 19th", "Stripe Payment Processing", "Finance", "+ 952.23 USD"};
    public String [] StarbucksCoffeeValues = {"Complete", "Today", "Starbucks coffee", "Restaurant / Cafe", "+ 1,250.00 USD"};

    //---Methods
    public void checkValueInLine (SoftAssertions softassert, String line, String [] values){
        softassert.assertThat($(By.xpath("//table[@id='transactionsTable']/tbody/tr["+ line +"]/td[1]/span[2]")).getText()).isEqualTo(values[0]);
        softassert.assertThat($(By.xpath("//table[@id='transactionsTable']/tbody/tr["+ line +"]//td[2]/span")).getText()).isEqualTo(values[1]);
        softassert.assertThat($(By.xpath("//table[@id='transactionsTable']/tbody/tr["+ line +"]/td[3]/span")).getText()).isEqualTo(values[2]);
        softassert.assertThat($(By.xpath("//table[@id='transactionsTable']/tbody/tr["+ line +"]/td[4]/a")).getText()).isEqualTo(values[3]);
        softassert.assertThat($(By.xpath("//table[@id='transactionsTable']/tbody/tr["+ line +"]/td[5]/span")).getText()).isEqualTo(values[4]);
    }
}
