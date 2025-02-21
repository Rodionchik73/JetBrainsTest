package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.DataSpellPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

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
        dataSpellPage.sendWordInSearchButton(input);
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
}

