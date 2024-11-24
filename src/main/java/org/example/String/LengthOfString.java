package org.example.String;

public class LengthOfString {
    public static int getStringLength(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            cnt++;
        }
        return cnt;
    }

}
