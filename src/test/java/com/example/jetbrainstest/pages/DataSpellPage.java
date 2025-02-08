package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/dataspell/
public class DataSpellPage {
    WebDriver driver;

    @FindBy(css = "a[href='/dataspell/buy/']")
    private WebElement pricingButton;

    @FindBy(css = "button[aria-label=\'Open search\']")
    private WebElement searchButton;

    @FindBy(css = "button[data-test='full-search-button']")
    private WebElement fullSearchButton;

    @FindBy(css = "[data-test-marker='Developer Tools']")
    private WebElement developerTools;

    @FindBy(xpath = "//*[contains(@data-test, 'main-submenu-column-title')] [text() = 'JETBRAINS IDEs']")
    private WebElement jetbrainsIdesMenu;

    @FindBy(css = "[href='/dataspell/whatsnew/']")
    private WebElement whatsNewButton;

    public Boolean checkPricingButtonClickable() {
        System.out.println("Проверка активности кнопки Pricing");
        return pricingButton.isEnabled();
    }

    public boolean clickSearchButton() {
        System.out.println("Клик на Developer Tools");
        return searchButton.isEnabled();
    }

    public void sendWordInSearchButton(String text) {
        searchButton.click();
        searchButton.sendKeys(text);
        System.out.println("Ввод слова в строке поиска");
    }

    public Boolean clickFullSearchButton() {
        System.out.println("Клик на кнопку Advanced search Ctrl+K");
        return fullSearchButton.isDisplayed();
    }

    public boolean clickDeveloperTools() {
        System.out.println("Клик на Developer Tools");
        return developerTools.isEnabled();
    }

    public boolean jetbrainsIdesMenuIsDisplayed() {
        System.out.println("JETBRAINS IDEs отображается");
        return jetbrainsIdesMenu.isEnabled();
    }

    public String whatsNewUrl() {
        System.out.println("Проверка URL страницы после клика на WhatsNew");
        whatsNewButton.click();
        return driver.getCurrentUrl();
    }

    public DataSpellPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
