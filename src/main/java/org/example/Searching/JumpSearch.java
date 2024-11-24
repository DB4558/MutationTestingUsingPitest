package org.example.Searching;

public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;

        // Determine the optimal jump size
        int step = (int) Math.sqrt(n);

        // Find the block where the element might be present
        int prev = 0;
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);

            // If we go beyond the array size
            if (prev >= n) {
                return -1;
            }
        }

        // Perform linear search in the identified block
        return linearSearch(arr, target, prev, Math.min(step, n));
    }

    public static int linearSearch(int[] arr, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
