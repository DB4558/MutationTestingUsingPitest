package String;
import org.example.String.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class TestAllString {

    ReverseString reverseString = new ReverseString();
    @Test
    public void testReverseString1() {
        // Test case 1: Regular string
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        char[] expected1 = {'o', 'l', 'l', 'e', 'h'};
        reverseString.reverseString(input1);
        assertArrayEquals(expected1, input1);
    }
    @Test
    public void testReverseString2() {
        // Test case 2: String with special characters
        char[] input6 = {'@', '1', '#', '2', '$'};
        char[] expected6 = {'$', '2', '#', '1', '@'};
        reverseString.reverseString(input6);
        assertArrayEquals(expected6, input6);
    }
    @Test
    public void testReverseString3() {
        // Test case 3: Single character string
        char[] input3 = {'a'};
        char[] expected3 = {'a'};
        reverseString.reverseString(input3);
        assertArrayEquals(expected3, input3);
    }
    @Test
    public void testReverseString4() {
        // Test case 4: Empty array
        char[] input4 = {};
        char[] expected4 = {};
        reverseString.reverseString(input4);
        assertArrayEquals(expected4, input4);
    }
    @Test
    public void testReverseString5() {
        // Test case 5: String with spaces
        char[] input5 = {' ', 'a', 'b', 'c', ' '};
        char[] expected5 = {' ', 'c', 'b', 'a', ' '};
        reverseString.reverseString(input5);
        assertArrayEquals(expected5, input5);
    }

    IsPalindrome isPalindrome=new IsPalindrome();
    @Test
    public void testisPalindrome1() {
        assertTrue(IsPalindrome.ispalindrome("madam"));
    }

    @Test
    public void testisPalindrome2() {
        // Test case 2: Non-palindrome
        assertFalse(IsPalindrome.ispalindrome("hello"));
    }
    @Test
    public void testisPalindrome3() {
        // Test case 3: Empty string
        assertTrue(IsPalindrome.ispalindrome(""));

    }
    @Test
    public void testisPalindrome4() {
        // Test case 4: Single character
        assertTrue(IsPalindrome.ispalindrome("a"));
    }
    @Test
    public void testisPalindrome5() {
        // Test case 5: Palindrome with spaces
        assertFalse(IsPalindrome.ispalindrome("a man a plan a canal panama"));

    }

    Anagram anagram=new Anagram();
    @Test
    public void testAnagram1(){
        String s1 = "a";
        String s2 = "a";
        assertTrue(Anagram.areAnagrams(s1, s2), "A single character should be an anagram of itself.");
    }
    @Test
    public void testAnagram2(){
        // Test case 2: Identical strings (simple anagram)
        String s1 = "listen";
        String s2 = "silent";
        assertTrue(Anagram.areAnagrams(s1, s2), "Strings with the same characters in different order should be anagrams.");

    }
    @Test
    public void testAnagram3(){
        // Test case 3: Different strings of the same length but different characters
        String s5 = "hello";
        String s6 = "world";
        assertFalse(Anagram.areAnagrams(s5, s6), "Strings with different characters should not be anagrams.");

    }
    @Test
    public void testAnagram4(){
        // Test case 4: Empty strings (should be anagrams)
        String s9 = "";
        String s10 = "";
        assertTrue(Anagram.areAnagrams(s9, s10), "Two empty strings should be considered anagrams.");

    }
    @Test
    public void testAnagram5(){

        // Test case 5: Strings with different lengths (cannot be anagrams)
        String s11 = "apple";
        String s12 = "apples";
        assertFalse(Anagram.areAnagrams(s11, s12), "Strings of different lengths cannot be anagrams.");

    }


    @Test
    public void testGetStringLength1() {
        // Test case 1: Regular string
        String input1 = "hello";
        int expected1 = 5;
        assertEquals(expected1, LengthOfString.getStringLength(input1), "The length of the string 'hello' should be 5.");

    }
    @Test
    public void testGetStringLength2() {
      // Test case 2: Empty string
        String input2 = "";
        int expected2 = 0;
        assertEquals(expected2, LengthOfString.getStringLength(input2), "The length of an empty string should be 0.");

    }

    @Test
    public void testGetStringLength3() {
       // Test case 3: String with spaces
        String input3 = "hello world";
        int expected3 = 11;
        assertEquals(expected3, LengthOfString.getStringLength(input3), "The length of the string 'hello world' should be 11.");

    }
    @Test
    public void testGetStringLength4() {
        // Test case 4: String with special characters
        String input4 = "!@#$%^";
        int expected4 = 6;
        assertEquals(expected4, LengthOfString.getStringLength(input4), "The length of the string '!@#$%^' should be 6.");
    }
    @Test
    public void testGetStringLength5() {
        // Test case 5: String with a single character
        String input6 = "a";
        int expected6 = 1;
        assertEquals(expected6, LengthOfString.getStringLength(input6), "The length of the string 'a' should be 1.");

    }

/*   FirstOccurance firstOccurrence=new FirstOccurance();
    @Test
    public void testFirstOccurrence1() {
        // Test case 1: Regular string with multiple characters
        String input = "programming";
        char character = 'r';
        int expected = 2;
        assertEquals(expected,  FirstOccurance.firstOccurrence(input, character));
    }*/
    @Test
    public void testFirstOccurrence2() {
        // Test case 2: Character not in the string
        String input = "programming";
        char character = 'z';
        int expected = -1;
        assertEquals(expected, FirstOccurance.firstOccurrence(input, character));
    }

    @Test
    public void testFirstOccurrence3() {
        // Test case 3: String with the character appearing at the beginning
        String input = "apple";
        char character = 'a';
        int expected = 0;
        assertEquals(expected, FirstOccurance.firstOccurrence(input, character));
    }

    @Test
    public void testFirstOccurrence4() {
        // Test case 6: Empty string
            String input = "";
            char character = 'a';
            int expected = -1;
            assertEquals(expected, FirstOccurance.firstOccurrence(input, character));
    }

    IsDigit isDigit=new IsDigit();

    // Test case 1: Valid string with only digits
    @Test
    public void testIsDigit_validDigits() {
        assertTrue(isDigit.isDigit("12345"), "The string contains only digits.");
    }

    // Test case 2: String with a mix of digits and characters
    @Test
    public void testIsDigit_mixedString() {
        assertFalse(isDigit.isDigit("123a45"), "The string contains non-digit characters.");
    }

    // Test case 3: Empty string
    @Test
    public void testIsDigit_emptyString() {
        assertFalse(isDigit.isDigit(""), "An empty string is not considered a digit string.");
    }


    @Test
    public void testKMP1() {
        // Test case 1: Simple string match
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        // Test KMP search function
        // The pattern should be found at index 10
        KMP.KMPSearch(pat, txt);
    }


    @Test
    public void testKMP2() {
        // Test case 2: Pattern found at the beginning of the string
        String txt = "AAAAA";
        String pat = "AAA";

        // The pattern "AAA" should be found starting at index 0
        KMP.KMPSearch(pat, txt);
    }


    @Test
    public void testKMP3() {
        // Test case 3: Pattern not found in the string
        String txt = "ABCDEFGHIJ";
        String pat = "XYZ";

        // Since the pattern "XYZ" is not present, nothing should be found
        KMP.KMPSearch(pat, txt);
    }


 /*   @Test
    public void testKMP4() {
        // Test case 4: Pattern is empty string
        String txt = "ABCDEF";
        String pat = "";

        // An empty pattern should not match, should not print anything
        KMP.KMPSearch(pat, txt);
    }
*/

    @Test
    public void testKMP5() {
        // Test case 5: Text is empty string
        String txt = "";
        String pat = "ABC";

        // An empty text should not match, should not print anything
        KMP.KMPSearch(pat, txt);
    }


    @Test
    public void testKMP6() {
        // Test case 6: Pattern appears multiple times in the string
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";

        // The pattern "AABA" should be found at index 0, 9, and 12
        KMP.KMPSearch(pat, txt);
    }
/*

    @Test
    public void testRabinKarp1() {
        // Test case 1: Simple pattern match
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        int q = 101; // A prime number for hash computation

        // The pattern "ABABCABAB" should be found at index 10 in the text
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }


    @Test
    public void testRabinKarp2() {
        // Test case 2: Pattern appears at the beginning of the string
        String txt = "AAAAA";
        String pat = "AAA";
        int q = 101;

        // The pattern "AAA" should be found starting at index 0
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }
    @Test
    public void testRabinKarp3() {
        // Test case 3: Pattern not found in the string

        String txt = "ABCDEFGHIJ";
        String pat = "XYZ";
        int q = 101;

        // The pattern "XYZ" is not present in the text
        // Nothing should be printed
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }

    @Test
    public void testRabinKarp4() {
        // Test case 4: Pattern is empty string
        String txt = "HELLO";
        String pat = "";
        int q = 101;

        // An empty pattern should not match any part of the text
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }


   @Test
    public void testRabinKarp5() {
        // Test case 5: Text is empty string
        String txt = "";
        String pat = "HELLO";
        int q = 101;

        // Since the text is empty, no match should be found
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }


    @Test
    public void testRabinKarp6() {
        // Test case 6: Multiple occurrences of the pattern
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";
        int q = 101;

        // The pattern "AABA" should be found at indices 0, 9, and 12
        RabinKarp.rabinKarpSearch(pat, txt, q);
    }
*/
    @Test
    void testRabinKarp1() { // Exact Match
        String txt = "ABABAC";
        String pat = "ABA";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 0"));
        assertTrue(outContent.toString().contains("Pattern found at index 2"));

        System.setOut(System.out);
    }

    @Test
    void testRabinKarp2() { // No Match
        String txt = "ABABAC";
        String pat = "XYZ";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertEquals("", outContent.toString().trim());

        System.setOut(System.out);
    }


    @Test
    void testRabinKarp6() { // Special Characters
        String txt = "A@B!A#C";
        String pat = "@B!";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 1"));

        System.setOut(System.out);
    }

    @Test
    void testRabinKarp7() { // Repeated Pattern
        String txt = "AAAAAA";
        String pat = "AAA";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 0"));
        assertTrue(outContent.toString().contains("Pattern found at index 1"));
        assertTrue(outContent.toString().contains("Pattern found at index 2"));
        assertTrue(outContent.toString().contains("Pattern found at index 3"));

        System.setOut(System.out);
    }

    @Test
    void testRabinKarp8() { // Pattern at End
        String txt = "XYZABABAC";
        String pat = "ABAC";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 5"));

        System.setOut(System.out);
    }

    @Test
    void testRabinKarp9() { // Case Sensitivity
        String txt = "abcABC";
        String pat = "ABC";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 3"));

        System.setOut(System.out);
    }

    @Test
    void testRabinKarp10() { // Large Input
        StringBuilder txtBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            txtBuilder.append("ABCD");
        }
        String txt = txtBuilder.toString();
        String pat = "ABCD";
        int q = 101;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RabinKarp.rabinKarpSearch(pat, txt, q);

        assertTrue(outContent.toString().contains("Pattern found at index 0"));

        System.setOut(System.out);
    }

}
