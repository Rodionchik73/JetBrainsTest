package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

// page_url = https://www.jetbrains.com/dataspell/
public class DataSpellPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataSpellPage.class));
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

    @FindBy(xpath = "//*[contains(@data-test, 'main-submenu-sub-column-title')][text()]")
    private List<WebElement> elementsSubMenu;

    @FindBy(xpath = "//*[contains(@class, '_rs-text-2_19db458_1 _rs-text_hardness_auto_19db458_1 _mainSubmenuItem__title_1ktlvrb_1')][text()]")
    private List<WebElement> elementsSubMenuItemLink;

    @FindBy(css = "[href='/dataspell/whatsnew/']")
    private WebElement whatsNewButton;

    @FindBy(css = "[data-test='main-menu-item']> [aria-label='Store: Open submenu']")
    private WebElement storeButton;

    @FindBy(css = "[href='/all/'][aria-label='Learn more']")
    private WebElement storeButtonLearnMore;

    @FindBy(xpath = "//*[text()='Submit']")
    private WebElement submitButton;

    @FindBy(css = "[data-test='language-picker']")
    private WebElement languagePicker;

    @FindBy(xpath = "//*[contains(@class, 'wt-list-item__content')][text() = 'Deutsch']")
    private WebElement deutschButton;

    @FindBy(xpath = "//*[text() = 'Verwandeln Sie Daten mühelos in Erkenntnisse']")
    private WebElement mainWord;

    public Boolean checkPricingButtonClickable() {
        LOG.info("Проверка активности кнопки Pricing");
        return pricingButton.isEnabled();
    }

    public boolean clickSearchButton() {
        LOG.info("Клик на Developer Tools");
        return searchButton.isEnabled();
    }

    public void sendWordInSearchButton(String text) {
        searchButton.click();
        searchInput.sendKeys(text);
        LOG.info("Ввод слова в строке поиска");
    }

    public Boolean clickFullSearchButton() {
        LOG.info("Клик на кнопку Advanced search Ctrl+K");
        return fullSearchButton.isDisplayed();
    }

    public boolean clickDeveloperTools() {
        LOG.info("Клик на Developer Tools");
        developerTools.isEnabled();
        developerTools.click();
        return true;
    }

    public boolean menuIsDisplayed(String text) {
        LOG.info(text + " отображается");
        for (WebElement idesMenu : elementsMenu) {
            if (idesMenu.getText().contains(text))
                return true;
        }
        return false;
    }

    public boolean subItemLinkIsDisplayed(String text) {
        LOG.info(text + " отображается");
        for (WebElement idesMenu : elementsSubMenuItemLink) {
            if (idesMenu.getText().contains(text))
                return true;
        }
        return false;
    }

    public boolean subMenuIsDisplayed(String text) {
        LOG.info(text + " отображается");
        for (WebElement idesMenu : elementsSubMenu) {
            if (idesMenu.getText().contains(text))
                return true;
        }
        return false;
    }

    public String whatsNewUrl() {
        LOG.info("Проверка URL страницы после клика на WhatsNew");
        whatsNewButton.click();
        return driver.getCurrentUrl();
    }

    public Boolean checkStoreButtonClickable() {
        LOG.info("Проверка активности кнопки Store");
        return storeButton.isEnabled();
    }

    public String urlStoreButtonLearnMore() {
        LOG.info("Проверка URL страницы после клика на All Products Pack в Store");
        storeButton.click();
        storeButtonLearnMore.click();
        return driver.getCurrentUrl();
    }

    public Boolean clickStoreButton() {
        LOG.info("Клик на Store");
        storeButton.click();
        return true;
    }

    public String submitButtonName() {
        LOG.info("Получение названия кнопки Submit");
        return submitButton.getText();
    }

    public String checkDeutschButton() {
        LOG.info("Проверка активности кнопки Deutsch");
        languagePicker.click();
        deutschButton.click();
        return mainWord.getText();
    }

    public DataSpellPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
