package edu.miracosta.cs113;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Iterator;

/**
 * PalindromeTester : a test class for isPalindrome, a method intended to utilize stacks to evaluate if a given
 * string is a palindrome.
 *
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards as it does
 * forwards. Such sequences include "madam," "top spot," or "no lemon, no melon".
 */
public class PalindromeTester {

    /** True test cases which include spaces and symbols */
    private static final String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
    /** False test cases which include spaces and symbols */
    private static final String[] SIMPLE_FALSE = { "AC", "71", "@+" };

    /** True test cases which include spaces */
    private static final String[] WHITE_SPACE_TRUE = { " x ", " t   t  ", " 5 5", " #      # " };
    /** False test cases which include spaces */
    private static final String[] WHITE_SPACE_FALSE = { "m   n  ", "   8  7 ", "  ^      &  "};

    /** Case-sensitive palindromes */
    private static final String[] CASE_SENSITIVE_TRUE = { "ABba", "roTOR", "rAceCaR" };

    /** Complex palindromes which include spaces, symbols, and varied capitalization */
    private static final String[] COMPLEX_TRUE = { "fOO race CAR oof", "AbBa ZaBba", "1 3 3 7  331",
                                                "N0 LEm0n, n0 Mel0n",
                                                "sT RJKLEeE R#@ $A$ @# REeEL K  JRT s" };

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    private boolean isPalindrome(String s)
    {
        String palindrome = s;
        //Remove whitespace and the case sensitivity.
        palindrome = palindrome.replaceAll("\\s","");
        palindrome = palindrome.toLowerCase();
        //create array stack.
        ArrayListStack<Character> stackOfLetters = new ArrayListStack<Character>();
        ArrayListStack<Character> stackOfLetters2 = new ArrayListStack<Character>();

        boolean isApalindrone = true;

        //Populates stack with a word or phrase.
        for (int i = 0;i < palindrome.length(); i++)
        {
            stackOfLetters.push(palindrome.charAt(i));
        }

        //Fill second stack half way.
        for (int i = 0; i < (palindrome.length()/2); i++)
        {
            stackOfLetters2.push(stackOfLetters.pop()) ;
        }

        //test stack
        for (int i = 0;i < ((palindrome.length()/2)); i++)
        {
            if(stackOfLetters.pop() != (stackOfLetters2.pop()) )
            {
                isApalindrone = false;
            }
        }

        return  isApalindrone;


    } // End of method isPalindrome

    // region isPalindrome tests =======================================================================================

    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(SIMPLE_TRUE[i]));
        }
    }

    @Test
    public void testSimpleFalseCases() {
        for (int i = 0; i < SIMPLE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(SIMPLE_FALSE[i]));
        }
    }

    @Test
    public void testWhitespaceCases() {
        for (int i = 0; i < WHITE_SPACE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(WHITE_SPACE_TRUE[i]));
        }

        for (int i = 0; i < WHITE_SPACE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(WHITE_SPACE_FALSE[i]));
        }
    }

    @Test
    public void testCaseSensitivityCases() {
        for (int i = 0; i < CASE_SENSITIVE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(CASE_SENSITIVE_TRUE[i]));
        }
    }

    @Test
    public void testComplexCases() {
        for (int i = 0; i < COMPLEX_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(COMPLEX_TRUE[i]));
        }
    }

    // endregion isPalindrome tests ====================================================================================

} // End of class PalindromeTester