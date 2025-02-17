package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://www.jetbrains.com/dataspell/
public class DataSpellPage {
    WebDriver driver;
    @FindBy(css = "a[href='/dataspell/buy/']")
    private WebElement pricingButton;
    @FindBy(css = "button[aria-label=\'Open search\']")
    private WebElement searchButton;
    @FindBy(css = "button[data-test='full-search-button']")
    private WebElement fullSearchButton;
    @FindBy(css = "[placeholder='Ctrl+K for advanced search']")
    private WebElement searchInput;
    @FindBy(css = "[data-test-marker='Developer Tools']")
    private WebElement developerTools;
    @FindBy(xpath = "//*[contains(@data-test, 'main-submenu-column-title')][text()]")
    private List<WebElement> elementsMenu;
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
        searchInput.sendKeys(text);
        System.out.println("Ввод слова в строке поиска");
    }

    public Boolean clickFullSearchButton() {
        System.out.println("Клик на кнопку Advanced search Ctrl+K");
        return fullSearchButton.isDisplayed();
    }

    public boolean clickDeveloperTools() {
        System.out.println("Клик на Developer Tools");
        developerTools.isEnabled();
        developerTools.click();
        return true;
    }

    public boolean menuIsDisplayed(String text) {
        System.out.println(text + " отображается");
        for (WebElement idesMenu : elementsMenu) {
            if (idesMenu.getText().contains(text))
                return true;
        }
        return false;
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
