package com.lukaville.hw1.util;

import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by nickolay on 11.10.15.
 */

public class NumberUtils {
    public static final int BASE = 10;
    public static final String WORD_SEPARATOR = " ";

    private static Map<Integer, String> sWords = new HashMap<>();

    static {
        sWords.put(0, "ноль");
        sWords.put(1, "один");
        sWords.put(2, "два");
        sWords.put(3, "три");
        sWords.put(4, "четыре");
        sWords.put(5, "пять");
        sWords.put(6, "шесть");
        sWords.put(7, "семь");
        sWords.put(8, "восемь");
        sWords.put(9, "девять");
        sWords.put(10, "десять");
        sWords.put(11, "одиннадцать");
        sWords.put(12, "двенадцать");
        sWords.put(13, "тринадцать");
        sWords.put(14, "четырнадцать");
        sWords.put(15, "пятнадцать");
        sWords.put(16, "шестнадцать");
        sWords.put(17, "семнадцать");
        sWords.put(18, "восемнадцать");
        sWords.put(19, "девятнадцать");
        sWords.put(20, "двадцать");
        sWords.put(30, "тридцать");
        sWords.put(40, "сорок");
        sWords.put(50, "пятьдесят");
        sWords.put(60, "шестьдесят");
        sWords.put(70, "семьдесят");
        sWords.put(80, "восемьдесят");
        sWords.put(90, "девяносто");
        sWords.put(100, "сто");
        sWords.put(200, "двести");
        sWords.put(300, "триста");
        sWords.put(400, "четыреста");
        sWords.put(500, "пятьсот");
        sWords.put(600, "шестьсот");
        sWords.put(700, "семьсот");
        sWords.put(800, "восемьсот");
        sWords.put(900, "девятьсот");
        sWords.put(1000, "тысяча");
    }

    public static String numberToText(@NonNull @Size(min = 1, max = 1000) Integer number) {
        Stack<Integer> truncatedNumbers = new Stack<>();

        int m = 1;
        if (number / BASE % BASE == 1) {
            m = (int) Math.pow(BASE, 2);
            truncatedNumbers.push(number % m);
            number /= m;
        }

        while (number > 0) {
            int truncatedNumber = (number % BASE) * m;
            if (truncatedNumber != 0) {
                truncatedNumbers.push(truncatedNumber);
            }
            number = number / BASE;
            m = m * BASE;
        }

        List<String> words = new ArrayList<>();
        while (truncatedNumbers.size() > 0) {
            words.add(sWords.get(truncatedNumbers.pop()));
        }

        return TextUtils.join(WORD_SEPARATOR, words);
    }
}
