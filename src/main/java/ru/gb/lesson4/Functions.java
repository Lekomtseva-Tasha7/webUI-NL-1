package ru.gb.lesson4;

public class Functions {

    //1234321 - палиндром

    public boolean isPalindrome (String word){
        if (word.length() < 2) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1)); // рекурсивный метод

    }
}
