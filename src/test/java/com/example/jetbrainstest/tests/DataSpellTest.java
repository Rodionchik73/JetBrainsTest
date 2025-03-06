package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.DataSpellPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MyExtension.class)

public class DataSpellTest extends BaseTest {
    private DataSpellPage dataSpellPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/dataspell/");
        dataSpellPage = new DataSpellPage(getDriver());
        getDriver().findElement(
                By.cssSelector("[aria-label='Close cookies banner']")).click();
    }

    @Test
    @DisplayName("Проверка, что кнопка Pricing активна")
    public void buttonPricing() {
        assertTrue(dataSpellPage.checkPricingButtonClickable(), "Кнопка Pricing не активна");
    }

    @Test
    @DisplayName("Проверка, что значок лупы активен")
    public void searchButton() {
        assertTrue(dataSpellPage.clickSearchButton(), "Кнопка Search не активна");
    }

    @Test
    @DisplayName("Проверка что отображается кнопка 'Advanced search Ctrl+K' после ввода значения в строку поиска")
    public void advancedSearch() {
        String input = "ai";
        assertTrue(dataSpellPage.clickFullSearchButton(), "Кнопка 'Advanced search Ctrl+K' не отображается");
    }

    @Test
    @DisplayName("Проверка, что кнопка Developer Tools активна")
    public void developerToolsButton() {
        assertTrue(dataSpellPage.clickDeveloperTools(), "Кнопка Developer Tools не активна");
    }

    @Test
    @DisplayName("После клика на кнопку Developer Tool отображается четыре блока: " +
            "JETBRAINS IDEs, PLUGINS & SERVICES, .NET & VISUAL STUDIO, LANGUAGES & FRAMEWORKS ")
    public void menuOfDeveloperTools() {
        dataSpellPage.clickDeveloperTools();
        assertAll(() -> assertTrue(dataSpellPage.menuIsDisplayed("JETBRAINS IDEs"), "JETBRAINS IDEs не отображается"),
                () -> assertTrue(dataSpellPage.menuIsDisplayed("PLUGINS & SERVICES"), "PLUGINS & SERVICES не отображается"),
                () -> assertTrue(dataSpellPage.menuIsDisplayed(".NET & VISUAL STUDIO"), ".NET & VISUAL STUDIO не отображается"),
                () -> assertTrue(dataSpellPage.menuIsDisplayed("LANGUAGES & FRAMEWORKS"), "LANGUAGES & FRAMEWORKS не отображается"));
    }

    @Test
    @DisplayName("После клика на кнопку Whatsnew переходит на страницу https://www.jetbrains.com/dataspell/whatsnew/")
    public void whatsNewUrl() {
        assertEquals("https://www.jetbrains.com/dataspell/whatsnew/", dataSpellPage.whatsNewUrl(),
                "Не верная url после клика на Whats new");
    }

    @Test
    @DisplayName("Проверка, что кнопка Store активна")
    public void buttonStore() {
        assertTrue(dataSpellPage.checkStoreButtonClickable(), "Кнопка Store не активна");
    }

    @Test
    @DisplayName("После клика на кнопку Store отображается 'All Products Pack, и переходит на сайт https://www.jetbrains.com/all/")
    public void allProductPackStoreUrl() {
        assertEquals("https://www.jetbrains.com/all/", dataSpellPage.urlStoreButtonLearnMore(),
                "Не верная url после клика на All Products Pack в Store");
    }

    @Test
    @DisplayName("После клика на кнопку Store отображается 6 блоков: " +
            "DEVELOPER TOOLS, SERVICES & PLUGINS, LEARNING TOOLS, TEAM TOOLS, COLLABORATIVE DEVELOPMENT, SALES SUPPORT")
    public void menuOfStore() {
        dataSpellPage.clickStoreButton();
        assertAll(() -> assertTrue(dataSpellPage.menuIsDisplayed("DEVELOPER TOOLS"), "DEVELOPER TOOLS не отображается"),
                () -> assertTrue(dataSpellPage.subMenuIsDisplayed("SERVICES & PLUGINS"), "SERVICES & PLUGINS не отображается"),
                () -> assertTrue(dataSpellPage.subMenuIsDisplayed("LEARNING TOOLS"), "LEARNING TOOLS не отображается"),
                () -> assertTrue(dataSpellPage.menuIsDisplayed("TEAM TOOLS"), "TEAM TOOLS не отображается"),
                () -> assertTrue(dataSpellPage.subMenuIsDisplayed("COLLABORATIVE DEVELOPMENT"), "COLLABORATIVE DEVELOPMENT не отображается"),
                () -> assertTrue(dataSpellPage.menuIsDisplayed("SALES SUPPORT"), "SALES SUPPORT не отображается"));
    }

    @Test
    @DisplayName("После клика на кнопку Store, в меню DEVELOPER TOOLS отображается под меню: " +
            "For Individual Use, For Teams and Organizations, Special offers & programs")
    public void menuOfStoreDeveloperTools() {
        dataSpellPage.clickStoreButton();
        assertAll(() -> assertTrue(dataSpellPage.subItemLinkIsDisplayed("For Individual Use"), "For Individual Use не отображается"),
                () -> assertTrue(dataSpellPage.subItemLinkIsDisplayed("For Teams and Organizations"), "For Teams and Organizations не отображается"),
                () -> assertTrue(dataSpellPage.subItemLinkIsDisplayed("Special offers & programs"), "Special offers & programs не отображается"));
    }

    //не работает
    @Test
    @DisplayName("Проверка названия кнопки Submit")
    public void submitButtonName() {
        String buttonSubmit = "Submit";
        assertEquals(buttonSubmit, dataSpellPage.submitButtonName(), "Кнопка с названием Submit не находится на странице");
    }

    //всплывает доп окно, которое не возможно поймать при автотестe
    @Test
    @DisplayName("Проверка изменения языка на странице на Deutsch")
    public void deutschLanguageButton() {
        String mainWordDeutsch = "Verwandeln Sie Daten mühelos in Erkenntnisse";
        assertEquals(mainWordDeutsch, dataSpellPage.checkDeutschButton(), "Язык страницы не изменился на немецкий");
    }

    @Test
    @DisplayName("Проверка что появляется подсказка 'Это поле обязательно к заполнению' " +
            "и подсвечивается красным при отправке пустого email")
    public void emptyEmailPrompt() {

    }

}

