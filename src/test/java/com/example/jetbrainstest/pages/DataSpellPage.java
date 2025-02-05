package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/dataspell/
public class DataSpellPage {
    WebDriver driver;

    @FindBy(xpath = "//span/text()[. =\'Pricing\']")
    private WebElement pricingButton;

    public Boolean checkPricingButtonClickable() {
        System.out.println("Проверка активности кнопки Pricing");
        return pricingButton.isEnabled();
    }

    public DataSpellPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
