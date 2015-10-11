package com.lukaville.hw1.util;

import java.util.Locale;

import pl.allegro.finance.tradukisto.ValueConverters;

/**
 * Created by nickolay on 11.10.15.
 */

public class NumberUtils {
    private static final ValueConverters sConverter = initConverter();

    private static ValueConverters initConverter() {
        String currentLanguage = Locale.getDefault().getLanguage();
        switch (currentLanguage) {
            case "ru":
                return ValueConverters.RUSSIAN_INTEGER;
            case "po":
                return ValueConverters.POLISH_INTEGER;
            case "cz":
                return ValueConverters.CZECH_INTEGER;
            case "de":
                return ValueConverters.GERMAN_INTEGER;
            default:
                return ValueConverters.ENGLISH_INTEGER;
        }
    }

    public static String numberToText(int number) {
        return sConverter.asWords(number);
    }
}
