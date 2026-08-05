package org.alexis.spring.controller;

public class Palindrome {

    public String palindrome(String str) {
        return "";
    }

    private boolean checkPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
