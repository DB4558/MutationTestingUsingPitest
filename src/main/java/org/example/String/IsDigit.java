package org.example.String;

public class IsDigit {
    public static boolean isDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Iterate through each character and check if it's a digit
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;  // If any character is not a digit, return false
            }
        }

        return true;  // If all characters are digits, return true
    }
}
