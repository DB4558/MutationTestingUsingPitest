package org.example.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static int upperBound(int[] ar, int l, int r, int key) {
        while (l < r - 1) {
            int m = (l + r) >>> 1;
            if (ar[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }
    public static int LIS(int[] array) {
        int N = array.length;
        if (N == 0) {
            return 0;
        }

        int[] tail = new int[N];
        int length = 1;

        tail[0] = array[0];
        for (int i = 1; i < N; i++) {
            if (array[i] < tail[0]) {
                tail[0] = array[i];
            }
            else if (array[i] > tail[length - 1]) {
                tail[length++] = array[i];
            }
            else {
                tail[upperBound(tail, -1, length - 1, array[i])] = array[i];
            }
        }

        return length;
    }
    public static int findLISLen(int a[]) {
        int size = a.length;
        int arr[] = new int[size];
        arr[0] = a[0];
        int lis = 1;
        for (int i = 1; i < size; i++) {
            int index = binarySearchBetween(arr, lis, a[i]);
            arr[index] = a[i];
            if (index > lis) {
                lis++;
            }
        }
        return lis;
    }
    public static int binarySearchBetween(int[] t, int end, int key) {
        int left = 0;
        int right = end;
        if (key < t[0]) {
            return 0;
        }
        if (key > t[end]) {
            return end + 1;
        }
        while (left < right - 1) {
            int middle = (left + right) / 2;
            if (t[middle] < key) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right;
    }
}
