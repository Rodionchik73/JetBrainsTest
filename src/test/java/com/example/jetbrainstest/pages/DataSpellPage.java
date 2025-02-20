package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// page_url = https://www.jetbrains.com/dataspell/
public class DataSpellPage {
    private final Logger LOG = LoggerFactory.getLogger(DataSpellPage.class);
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

    @Step("Проверка активности кнопки Pricing")
    public Boolean checkPricingButtonClickable() {
        LOG.info("Проверка активности кнопки Pricing");
        return pricingButton.isEnabled();
    }

    @Step("Клик на Developer Tools")
    public boolean clickSearchButton() {
        LOG.info("Клик на Developer Tools");
        return searchButton.isEnabled();
    }

    @Step("Ввод слова в строке поиска")
    public void sendWordInSearchButton(String text) {
        searchButton.click();
        searchInput.sendKeys(text);
        LOG.info("Ввод слова в строке поиска");
    }

    @Step("Клик на кнопку Advanced search Ctrl+K")
    public Boolean clickFullSearchButton() {
        LOG.info("Клик на кнопку Advanced search Ctrl+K");
        return fullSearchButton.isDisplayed();
    }

    @Step("Клик на Developer Tools")
    public boolean clickDeveloperTools() {
        LOG.info("Клик на Developer Tools");
        developerTools.isEnabled();
        developerTools.click();
        return true;
    }

    @Step("Отображение элементов в меню Developer tools")
    public boolean menuIsDisplayed(String text) {
        LOG.info("{} отображается", text);
        for (WebElement idesMenu : elementsMenu) {
            if (idesMenu.getText().contains(text))
                return true;
        }
        return false;
    }

    @Step("Проверка URL страницы после клика на WhatsNew")
    public String whatsNewUrl() {
        LOG.info("Проверка URL страницы после клика на WhatsNew");
        whatsNewButton.click();
        return driver.getCurrentUrl();
    }

    public DataSpellPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
