package org.alexis.spring.controller;

public class Palindrome {

    public String palindrome(String str) {
        if(checkPalindrome(str)) {
            return "La palabra " + str + " es un palindrome";
        } else {
            return "la palabra " + str + " NO es un palindrome";
        }
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
