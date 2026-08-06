package org.alexis.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palindromes.
 */

@RestController
public class Palindrome {

    /**
     *
     * @param str es la palabra a verificar.
     * @return un mensaje indicando si es palindromo o no
     */

    @GetMapping("/validar-palindrome/{str}")
    public String palindrome(@PathVariable String str) {
        if (checkPalindrome(str)) {
            return "La palabra " + str + " es un palindrome";
        } else {
            return "la palabra " + str + " NO es un palindrome";
        }
    }

    /**
     * metodo para verificar si una palabra es un palindrome
     * @param str la palabra a verificar
     * @return true si es palindrome o false de lo contrario.
     */

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
