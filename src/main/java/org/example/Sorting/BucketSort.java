package org.example.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        float max = arr[0];
        float min = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int bucketCount = (int) Math.sqrt(n);
        float range = (max - min) / bucketCount;

        ArrayList<Float>[] buckets = new ArrayList[bucketCount];

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute the elements into the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] - min) / range);
            if (bucketIndex == bucketCount) {
                bucketIndex--;
            }
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort each bucket and place back into the array
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }
}
