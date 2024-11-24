package org.example.String;

public class FirstOccurance {
    public static int firstOccurrence(String str, char ch) {
        // Loop through the string
        for (int i = 0; i < str.length(); i++) {
            // Check if the character at index i matches the target character
            if (str.charAt(i) == ch) {
                return i; // Return the index if a match is found
            }
        }
        return -1; // Return -1 if the character is not found in the string
    }
}
