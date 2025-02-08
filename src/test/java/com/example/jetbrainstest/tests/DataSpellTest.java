package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.DataSpellPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataSpellTest extends BaseTest {
    private DataSpellPage dataSpellPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/dataspell/");
        dataSpellPage = new DataSpellPage(getDriver());
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

    /*в этом тексте почему-то текст не вводится, и показывается на странице аксепт куки, подскажи пожалуйста что не так?*/
    @Test
    @DisplayName("Проверка что отображается кнопка 'Advanced search Ctrl+K' после ввода значения в строку поиска")
    public void advancedSearch() {
        String input = "ai";
        dataSpellPage.sendWordInSearchButton(input);
        assertTrue(dataSpellPage.clickFullSearchButton(), "Кнопка 'Advanced search Ctrl+K' не отображается");
    }

    @Test
    @DisplayName("Проверка, что кнопка Developer Tools активна")
    public void developerToolsButton() {
        assertTrue(dataSpellPage.clickDeveloperTools(), "Кнопка Developer Tools не активна");
    }

    /*как правильнее сделать если я хочу сразу проверить что 4 блока отображается? нужно 4 теста создать? или в одном как-то можно сделать?*/
    @Test
    @DisplayName("После клика на кнопку Developer Tool отображается четыре блока: JETBRAINS IDEs, PLUGINS & SERVICES, .NET & VISUAL STUDIO, LANGUAGES & FRAMEWORKS ")
    public void menuOfDeveloperTools() {
        dataSpellPage.clickDeveloperTools();
        assertTrue(dataSpellPage.jetbrainsIdesMenuIsDisplayed(), "JETBRAINS IDEs не отображается");

    }

    @Test
    @DisplayName("После клика на кнопку Whatsnew переходит на страницу https://www.jetbrains.com/dataspell/whatsnew/")
    public void whatsNewUrl() {
        assertEquals("https://www.jetbrains.com/dataspell/whatsnew/", dataSpellPage.whatsNewUrl(), "Не верная url после клика на Whats new");
    }


}

