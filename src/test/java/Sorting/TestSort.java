package Sorting;

import org.example.Sorting.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSort {
    MergeSort mergeSort=new MergeSort();
    @Test
    public void testMergeSort1() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {3, 9, 10, 27, 38, 43, 82};
        assertArrayEquals(expected, arr, "The array should be sorted correctly.");
    }

    @Test
    public void testMergeSortedArrays() {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        mergeSort.merge(arr, 0, 3, 7);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }



    @Test
    public void testMergeSort2() {
        int[] arr = {};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {};
        assertArrayEquals(expected, arr, "The array should remain empty.");
    }


    @Test
    public void testMergeSort3() {
        int[] arr = {5};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {5};
        assertArrayEquals(expected, arr, "An array with one element should not change.");
    }

    @Test
    public void testMergeSort4() {
        int[] arr = {7, 7, 7, 7, 7};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {7, 7, 7, 7, 7};
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }


    @Test
    public void testMergeSort5() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
    @Test
    public void testMergeSortWithNegatives() {
        int[] arr = {-3, -1, -7, -2, -5};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {-7, -5, -3, -2, -1};
        assertArrayEquals(expected, arr, "The array with negative numbers should be sorted correctly.");
    }
    @Test
    public void testMergeSortMixedNegativesAndPositives() {
        int[] arr = {-3, 10, -7, 2, 5};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {-7, -3, 2, 5, 10};
        assertArrayEquals(expected, arr, "The array with mixed negative and positive numbers should be sorted correctly.");
    }
    @Test
    public void testMergeSortWithZeros() {
        int[] arr = {0, 0, 0, 1, -1};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {-1, 0, 0, 0, 1};
        assertArrayEquals(expected, arr, "The array with zeros should be sorted correctly.");
    }
    @Test
    public void testMergeSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr, "The already sorted array should remain unchanged.");
    }

    @Test
    public void testMergeSortWithDuplicates() {
        int[] arr = {4, 2, 4, 3, 2};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {2, 2, 3, 4, 4};
        assertArrayEquals(expected, arr, "The array with duplicate values should be sorted correctly.");
    }
    @Test
    public void testMergeSortWithMinMaxInt() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        assertArrayEquals(expected, arr, "The array with minimum and maximum integer values should be sorted correctly.");
    }

    @Test
    public void testMergeSortAlternatingValues() {
        int[] arr = {1, 100, 2, 99, 3};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        int[] expected = {1, 2, 3, 99, 100};
        assertArrayEquals(expected, arr, "The array with alternating high and low values should be sorted correctly.");
    }

    @Test
    public void testQuickSort1() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testQuickSort2() {
        int[] arr = {};
        int[] expected = {};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testQuickSort3() {
        int[] arr = {1};
        int[] expected = {1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }

    @Test
    public void testQuickSort4() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }

    @Test
    public void testQuickSort5() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array sorted in reverse order should be correctly sorted.");
    }

    @Test
    public void testQuickSortWithNegatives() {
        int[] arr = {-3, -1, -7, -2, -5};
        int[] expected = {-7, -5, -3, -2, -1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array with negative numbers should be sorted correctly.");
    }
    @Test
    public void testQuickSortMixedNegativesAndPositives() {
        int[] arr = {-3, 10, -7, 2, 5};
        int[] expected = {-7, -3, 2, 5, 10};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array with mixed negative and positive numbers should be sorted correctly.");
    }
    @Test
    public void testQuickSortWithZeros() {
        int[] arr = {0, 0, 0, 1, -1};
        int[] expected = {-1, 0, 0, 0, 1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array with zeros should be sorted correctly.");
    }
    @Test
    public void testQuickSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The already sorted array should remain unchanged.");
    }
    @Test
    public void testQuickSortRepeatedValue() {
        int[] arr = {3,3,3,3,3,3,};
        int[] expected = {3,3,3,3,3,3};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The already sorted array should remain unchanged.");
    }
    @Test
    public void testQuickSortWithDuplicates() {
        int[] arr = {4, 2, 4, 3, 2};
        int[] expected = {2, 2, 3, 4, 4};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array with duplicate values should be sorted correctly.");
    }
    @Test
    public void testQuickSortAlternatingValues() {
        int[] arr = {1, 100, 2, 99, 3};
        int[] expected = {1, 2, 3, 99, 100};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "The array with alternating high and low values should be sorted correctly.");
    }



    @Test
    public void testHeapSort1() {
        int[] arr = {12, 111, 13, 2, 6, 17};
        int[] expected = {2, 6, 12, 13, 17,111};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testHeapSort2() {
        int[] arr = {};
        int[] expected = {};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testHeapSort3() {
        int[] arr = {1};
        int[] expected = {1};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }

    @Test
    public void testHeapSort4() {
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }

    @Test
    public void testHeapSort5() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "The array sorted in reverse order should be correctly sorted.");
    }
    @Test
    public void testHeapSortWithZeros() {
        int[] arr = {0, 0, 0, 1, -1};
        int[] expected = {-1, 0, 0, 0, 1};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "The array with zeros should be sorted correctly.");
    }
    @Test
    public void testHeapSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr, "The already sorted array should remain unchanged.");
    }
    @Test
    void testHeapSortMixedPositiveNegative() {
        int[] arr = {-5, 10, 0, -2, 3, 5};
        HeapSort.heapSort(arr);
        assertArrayEquals(new int[]{-5, -2, 0, 3, 5, 10}, arr);
    }
    @Test
    void testHeapSortWithNegatives() {
        int[] arr = {-5, 3, 0, -1, -3};
        HeapSort.heapSort(arr);
        assertArrayEquals(new int[]{-5, -3, -1, 0, 3}, arr);
    }


    @Test
    public void testBubbleSort1() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
    @Test
    void testBubbleSortLargeBlocksOfIdentical() {
        int[] arr = {10, 10, 10, 1, 1, 1, 5, 5, 5};
        int[] expected = {1, 1, 1, 5, 5, 5, 10, 10, 10};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with multiple large blocks of identical elements should be sorted.");
    }
    @Test
    void testBubbleSortTwoElements() {
        int[] arr = {5, 3};
        int[] expected = {3, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with two elements should be correctly sorted.");
    }
    @Test
    void testBubbleSortAlreadySortedAscendingwithDuplicate() {
        int[] arr = {1, 2, 3, 3, 4};
        int[] expected = {1, 2, 3, 3, 4};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array in ascending order should remain unchanged.");
    }
    @Test
    void testBubbleSortAlreadySortedAscending() {
        int[] arr = {1, 2, 3, 4, 8};
        int[] expected = {1, 2, 3, 4,8};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array in ascending order should remain unchanged.");
    }
    @Test
    void testBubbleSortAlreadySortedDescending() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array in descending order should be correctly sorted.");
    }

    @Test
    void testBubbleSortAlreadySortedDescendingwithDuplicates() {
        int[] arr = {8, 4, 3, 3, 1};
        int[] expected = {1, 3, 3, 4, 8};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array in descending order should be correctly sorted.");
    }
    @Test
    void testBubbleSortRandomWithDuplicates() {
        int[] arr = {10, 3, 10, 2, 4, 7, 10};
        int[] expected = {2, 3, 4, 7, 10, 10, 10};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with random order and duplicates should be sorted correctly.");
    }

    @Test
    public void testBubbleSort2() {
        int[] arr = {};
        int[] expected = {};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testBubbleSort3() {
        int[] arr = {5};
        int[] expected = {5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }

    @Test
    public void testBubbleSort4() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }


    @Test
    void testBubbleSortAllNegative() {
        int[] arr = {-5, -1, -9, -3, -7};
        int[] expected = {-9, -7, -5, -3, -1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with all negative numbers should be sorted in ascending order.");
    }
    @Test
    void testBubbleSortMixedNumbers() {
        int[] arr = {-1, 5, 3, -2, 8, -4};
        int[] expected = {-4, -2, -1, 3, 5, 8};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with mixed positive and negative numbers should be sorted.");
    }
    @Test
    void testBubbleSortLargeNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1000, 999};
        int[] expected = {Integer.MIN_VALUE, 0, 999, 1000, Integer.MAX_VALUE};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with large numbers should be sorted correctly.");
    }
    @Test
    void testBubbleSortRepeatedValues() {
        int[] arr = {3, 3, 2, 2, 1, 1};
        int[] expected = {1, 1, 2, 2, 3, 3};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Array with repeated values should be sorted correctly.");
    }


    @Test
    public void testSelectionSort1() {
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
    @Test
    void testSelectionSortAlreadySortedAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array in ascending order should remain unchanged.");
    }


    @Test
    public void testSelectionSort2() {
        int[] arr = {};
        int[] expected = {};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testSelectionSort3() {
        int[] arr = {5};
        int[] expected = {5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }

    @Test
    public void testSelectionSort4() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }
    @Test
    void testSelectionSortLargeNumbersWithDuplicates() {
        int[] arr = {5000, 100000, 5000, 2500, 5000};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{2500, 5000, 5000, 5000, 100000}, arr);
    }
    @Test
    void testSelectionSortMixedLargeNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 500, -1000};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, -1000, 0, 500, Integer.MAX_VALUE}, arr);
    }
    @Test
    void testSelectionSortTwoElements() {
        int[] arr1 = {5, 3};
        SelectionSort.selectionSort(arr1);
        assertArrayEquals(new int[]{3, 5}, arr1);

        int[] arr2 = {3, 5};
        SelectionSort.selectionSort(arr2);
        assertArrayEquals(new int[]{3, 5}, arr2);
    }
    @Test
    void testSelectionSortLargeArray() {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000); // Random values
        }
        SelectionSort.selectionSort(arr);
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]); // Check sorted order
        }
    }
    @Test
    void testSelectionSortMixedPositiveNegative() {
        int[] arr = {-5, 10, 0, -2, 3, 5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{-5, -2, 0, 3, 5, 10}, arr);
    }


    @Test
    public void testSelectionSort5() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "The array sorted in reverse order should be correctly sorted.");
    }

    @Test
    public void testInsertionSort1() {
        int[] arr = {12, 11, 13, 5, 6};
        int[] expected = {5, 6, 11, 12, 13};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
    @Test
    void testSelectionSortAllNegative() {
        int[] arr = {-5, -1, -9, -3, -7};
        int[] expected = {-9, -7, -5, -3, -1};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "Array with all negative numbers should be sorted in ascending order.");
    }
    @Test
    void testSelectionSortMixedNumbers() {
        int[] arr = {-1, 5, 3, -2, 8, -4};
        int[] expected = {-4, -2, -1, 3, 5, 8};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "Array with mixed positive and negative numbers should be sorted.");
    }
    @Test
    void testSelectionSortRandomWithDuplicates() {
        int[] arr = {10, 3, 10, 2, 4, 7, 10};
        int[] expected = {2, 3, 4, 7, 10, 10, 10};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr, "Array with random order and duplicates should be sorted correctly.");
    }


    @Test
    public void testInsertionSort2() {
        int[] arr = {};
        int[] expected = {};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testInsertionSort3() {
        int[] arr = {5};
        int[] expected = {5};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }

    @Test
    public void testInsertionSort4() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }

    @Test
    public void testInsertionSort5() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "The array sorted in reverse order should be correctly sorted.");
    }
    @Test
    void testInsertionSortNegativeAndPositive() {
        int[] arr = {-5, 3};
        int[] expected = {-5, 3};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "Array with one negative and one positive number should be sorted.");
    }
    @Test
    void testInsertionSortAlreadySortedAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "An already sorted array should remain unchanged.");
    }
    @Test
    void testInsertionSortAlreadySortedDescending() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "An array sorted in descending order should be correctly sorted.");
    }
    @Test
    void testInsertionSortIdenticalElements() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "Array with identical elements should remain unchanged.");
    }
    @Test
    void testInsertionSortSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr, "A single element array should remain unchanged.");
    }


    @Test
    public void testCountSort1() {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] expected = {1, 2, 2, 3, 3, 4, 8};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testCountSort2() {
        int[] arr = {};
        int[] expected = {};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testCountSort3() {
        int[] arr = {5};
        int[] expected = {5};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "A single-element array should remain unchanged.");
    }

    @Test
    public void testCountSort4() {
        int[] arr = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }

    @Test
    public void testCountSort5() {
        int[] arr = {10, 5, 8, 5, 9, 1, 6};
        int[] expected = {1, 5, 5, 6, 8, 9, 10};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "The array with unsorted values should be sorted in ascending order.");
    }

    @Test
    public void testCountSortLargeRange() {
        int[] arr = {1000, 1, 999, 2, 500, 10};
        int[] expected = {1, 2, 10, 500, 999, 1000};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "Array with a large range of values should be sorted correctly.");
    }
    @Test
    public void testCountSortWithDuplicates() {
        int[] arr = {7, 7, 5, 5, 3, 3, 1};
        int[] expected = {1, 3, 3, 5, 5, 7, 7};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "Array with duplicate values should be sorted correctly.");
    }
    @Test
    public void testCountSortDescendingOrder() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "Array sorted in descending order should be sorted in ascending order.");
    }
    @Test
    public void testCountSortAllZeros() {
        int[] arr = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0};
        CountingSort.countingSort(arr);
        assertArrayEquals(expected, arr, "Array with all zeros should remain unchanged.");
    }


    @Test
    public void testBucketSort1() {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.87f, 0.45f, 0.91f, 0.56f};
        float[] expected = {0.23f, 0.32f, 0.42f, 0.45f, 0.56f, 0.87f, 0.91f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort2() {
        float[] arr = {};
        float[] expected = {};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "An empty array should remain empty.");
    }

    @Test
    public void testBucketSort3() {
        float[] arr = {1.0f};
        float[] expected = {1.0f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "A single-element array should remain unchanged.");
    }

    @Test
    public void testBucketSort4() {
        float[] arr = {0.5f, 0.5f, 0.5f, 0.5f};
        float[] expected = {0.5f, 0.5f, 0.5f, 0.5f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "An array with identical elements should remain unchanged.");
    }

    @Test
    public void testBucketSort5() {
        float[] arr = {0.9f, 0.1f, 0.7f, 0.3f, 0.2f};
        float[] expected = {0.1f, 0.2f, 0.3f, 0.7f, 0.9f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort6() {
        float[] arr = {0.99f, 0.01f, 0.55f, 0.75f, 0.33f, 0.66f};
        float[] expected = {0.01f, 0.33f, 0.55f, 0.66f, 0.75f, 0.99f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort7() {
        float[] arr = {10f, 5f, 8f, 5f, 9f, 1f, 6f};
        float[] expected = {1f, 5f, 5f, 6f, 8f, 9f, 10f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort8() {
        float[] arr = {0.91f, 0.89f, 0.91f, 0.85f, 0.92f, 0.88f};
        float[] expected = {0.85f, 0.88f, 0.89f, 0.91f, 0.91f, 0.92f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort9() {
        float[] arr = {0.99f, 0.25f, 0.50f, 0.75f, 0.33f, 0.5f, 0.25f};
        float[] expected = {0.25f, 0.25f, 0.33f, 0.5f, 0.5f, 0.75f, 0.99f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBucketSort10() {
        float[] arr = {1000f, 2000f, 1500f, 1200f};
        float[] expected = {1000f, 1200f, 1500f, 2000f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array should be sorted in ascending order.");
    }
    @Test
    public void testBucketSortCloseValues() {
        float[] arr = {0.33333f, 0.33334f, 0.33332f, 0.33331f};
        float[] expected = {0.33331f, 0.33332f, 0.33333f, 0.33334f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with close floating-point values should be sorted correctly.");
    }
    @Test
    public void testBucketSortExtremeValues() {
        float[] arr = {0.00001f, 9999.99f, 0.00002f, 5000.00f};
        float[] expected = {0.00001f, 0.00002f, 5000.00f, 9999.99f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with extreme values should be sorted correctly.");
    }
    @Test
    public void testBucketSortDescendingOrder() {
        float[] arr = {0.9f, 0.7f, 0.5f, 0.3f, 0.1f};
        float[] expected = {0.1f, 0.3f, 0.5f, 0.7f, 0.9f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The descending array should be sorted correctly.");
    }
    @Test
    public void testBucketSortOneUniqueValue() {
        float[] arr = {0.5f, 0.5f, 0.5f, 0.7f, 0.5f};
        float[] expected = {0.5f, 0.5f, 0.5f, 0.5f, 0.7f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with one unique value should be sorted correctly.");
    }
    @Test
    public void testBucketSortZerosAndOnes() {
        float[] arr = {0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        float[] expected = {0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with zeros and ones should be sorted correctly.");
    }
    @Test
    public void testBucketSortDuplicatesAcrossRanges() {
        float[] arr = {0.1f, 0.9f, 0.1f, 0.9f, 0.5f, 0.5f};
        float[] expected = {0.1f, 0.1f, 0.5f, 0.5f, 0.9f, 0.9f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with duplicates across ranges should be sorted correctly.");
    }
    @Test
    public void testBucketSortOneBucket() {
        float[] arr = {0.11f, 0.15f, 0.19f, 0.13f, 0.14f};
        float[] expected = {0.11f, 0.13f, 0.14f, 0.15f, 0.19f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "All elements in one bucket should be sorted correctly.");
    }
    @Test
    public void testBucketSortNonUniformDistribution() {
        float[] arr = {0.1f, 0.9f, 0.1f, 0.8f, 0.2f, 0.7f};
        float[] expected = {0.1f, 0.1f, 0.2f, 0.7f, 0.8f, 0.9f};
        BucketSort.bucketSort(arr);
        assertArrayEquals(expected, arr, "The array with non-uniform distribution should be sorted correctly.");
    }

}
