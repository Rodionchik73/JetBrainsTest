package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.DataSpellPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataSpellTest extends BaseTest{
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
}
