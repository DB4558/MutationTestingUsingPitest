package Searching;

import org.example.Searching.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearch {
    @Test
    void testLinearSearch1() {
        // Test: Target is in the middle of the array
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        int result = LinearSearch.linearSearch(array, target);
        assertEquals(2, result, "Target should be at index 2");
    }

    @Test
    void testLinearSearch2() {
        // Test: Target is at the beginning of the array
        int[] array = {10, 20, 30, 40};
        int target = 10;
        int result = LinearSearch.linearSearch(array, target);
        assertEquals(0, result, "Target should be at index 0");
    }

    @Test
    void testLinearSearch3() {
        // Test: Target is at the end of the array
        int[] array = {5, 10, 15, 20};
        int target = 20;
        int result = LinearSearch.linearSearch(array, target);
        assertEquals(3, result, "Target should be at index 3");
    }

    @Test
    void testLinearSearch4() {
        // Test: Target is not in the array
        int[] array = {7, 14, 21, 28};
        int target = 35;
        int result = LinearSearch.linearSearch(array, target);
        assertEquals(-1, result, "Target is not in the array, should return -1");
    }

    @Test
    void testLinearSearch5() {
        // Test: Empty array
        int[] array = {};
        int target = 1;
        int result = LinearSearch.linearSearch(array, target);
        assertEquals(-1, result, "Empty array should always return -1");
    }

    @Test
    void testBinarySearch1() {
        // Test: Target is in the middle of the array
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(2, result, "Target should be at index 2");
    }

    @Test
    void testBinarySearch2() {
        // Test: Target is the first element
        int[] array = {10, 20, 30, 40, 50};
        int target = 10;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(0, result, "Target should be at index 0");
    }

    @Test
    void testBinarySearch3() {
        // Test: Target is the last element
        int[] array = {10, 20, 30, 40, 50};
        int target = 50;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(4, result, "Target should be at index 4");
    }

    @Test
    void testBinarySearch4() {
        // Test: Target is not in the array
        int[] array = {5, 15, 25, 35, 45};
        int target = 20;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(-1, result, "Target is not in the array, should return -1");
    }

    @Test
    void testBinarySearch5() {
        // Test: Array is empty
        int[] array = {};
        int target = 10;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(-1, result, "Empty array should always return -1");
    }

    @Test
    void testBinarySearch6() {
        // Test: Number repeated
        int[] array = {2, 2, 2, 2, 2, 2, 2};
        int target = 2;
        int result = BinarySearch.binarySearch(array, target);
        assertEquals(3, result, "Empty array should always return -1");
    }


    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
        assertEquals(-1, bs.binarySearch(arr, -1));
        assertEquals(-1, bs.binarySearch(arr, 35));
        assertEquals(-1, bs.binarySearch(arr, 100));
        assertEquals(-1, bs.binarySearch(arr, -100));
        assertEquals(17, bs.binarySearch(arr, 17));
        assertEquals(34, bs.binarySearch(arr, 34));
        assertEquals(0, bs.binarySearch(arr, 0));
        assertEquals(5, bs.binarySearch(arr, 5));
        assertEquals(9, bs.binarySearch(arr, 9));
        assertEquals(26, bs.binarySearch(arr, 26));
        assertEquals(21, bs.binarySearch(arr, 21));
        assertEquals(30, bs.binarySearch(arr, 30));
    }

    @Test
    void testExponentialSearchTargetInRightSubarray() {
        // Target lies in the right subarray
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 13; // Target is in the right half
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(6, result, "Target should be at index 6");
    }

    @Test
    void testExponentialSearchTargetInLeftSubarray() {
        // Target lies in the left subarray
        int[] array = {10, 20, 30, 40, 50};
        int target = 20; // Target is in the left half
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(1, result, "Target should be at index 1");
    }

    @Test
    void testExponentialSearchWithDuplicates() {
        // Array with duplicate elements
        int[] array = {5, 5, 5, 10, 10, 15};
        int target = 10; // Target matches duplicates
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(4, result, "Should return the first occurrence of target (index 3)");
    }
    @Test
    void testExponentialSearchTargetLargerThanAll() {
        // Target is greater than all elements, ensuring the bound grows to exceed array size
        int[] array = {2, 4, 8, 16, 32};
        int target = 64; // Target is greater than the largest element
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(-1, result, "Target should not be found and loop should exit gracefully");
    }
    @Test
    void testExponentialSearchTargetAtBound() {
        // Target is exactly at the calculated bound
        int[] array = {1, 2, 4, 8, 16, 32, 64};
        int target = 16; // Target matches a calculated bound
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(4, result, "Target should be found exactly at the bound");
    }
    @Test
    void testExponentialSearchTargetSmallerThanBound() {
        // Ensure loop stops when arr[bound] > target
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 3; // Target lies within the first few elements
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(2, result, "Target should be found correctly without overshooting bound");
    }
    @Test
    void testExponentialSearchSparseLargeArray() {
        // Large array with gaps to test how quickly the bound increases
        int[] array = {1, 10, 100, 1000, 10000, 100000};
        int target = 1000; // Target matches one of the elements
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(3, result, "Target should be found correctly in a sparse large array");
    }



    @Test
    void testExponentialSearchTargetGreaterThanLargest() {
        // Target greater than the largest element
        int[] array = {2, 4, 6, 8, 10};
        int target = 12; // Target is out of bounds
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(-1, result, "Should return -1 for target greater than largest element");
    }

    @Test
    void testExponentialSearchTargetLessThanSmallest() {
        // Target less than the smallest element
        int[] array = {5, 10, 15, 20};
        int target = 1; // Target is out of bounds
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(-1, result, "Should return -1 for target less than smallest element");
    }


    @Test
    void testExponentialSearch1() {
        // Test: Target is at the beginning of the array
        int[] array = {10, 20, 30, 40, 50};
        int target = 10;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(0, result, "Target should be at index 0");
    }

    @Test
    void testExponentialSearch2() {
        // Test: Target is at the end of the array
        int[] array = {5, 15, 25, 35, 45};
        int target = 45;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(4, result, "Target should be at index 4");
    }

    @Test
    void testExponentialSearch3() {
        // Test: Target is in the middle of the array
        int[] array = {2, 4, 6, 8, 10};
        int target = 6;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(2, result, "Target should be at index 2");
    }

    @Test
    void testExponentialSearch4() {
        // Test: Target is not in the array
        int[] array = {3, 6, 9, 12, 15};
        int target = 10;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(-1, result, "Target is not in the array, should return -1");
    }

    @Test
    void testExponentialSearch5() {
        // Test: Empty array
        int[] array = {};
        int target = 10;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(-1, result, "Empty array should return -1");
    }

    @Test
    void testExponentialSearch() {
        // Test: Empty array
        int[] array = {1,1,1,1,1,1,1};
        int target = 1;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(0, result, "Empty array should return -1");
    }

    @Test
    void testExponentialSearch6() {
        // Test: Array with one element
        int[] array = {42};
        int target = 42;
        int result = ExponentialSearch.exponentialSearch(array, target);
        assertEquals(0, result, "Target should be at index 0 in a single-element array");
    }

    @Test
    void testJumpSearch1() {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 1; // Target is at the beginning
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(0, result, "Target should be at index 0");
    }

    // Test case for jumpSearch with the target at the end
    @Test
    void testJumpSearch2() {
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 20; // Target is at the end
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(9, result, "Target should be at index 9");
    }

    // Test case for jumpSearch with the target in the middle
    @Test
    void testJumpSearch3() {
        int[] array = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28};
        int target = 13; // Target is in the middle
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(4, result, "Target should be at index 4");
    }

    // Test case for jumpSearch where the target is not in the array
    @Test
    void testJumpSearch4() {
        int[] array = {3, 6, 9, 12, 15, 18};
        int target = 10; // Target is not in the array
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(-1, result, "Target should not be found and return -1");
    }

    @Test
    void testJumpSearch5() {
        int[] array = {};
        int target = 10;
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(-1, result, "Target should not be found and return -1");
    }

    @Test
    void testJumpSearch6() {
        int[] array = {10,10,10};
        int target = 10; // Target is not in the array
        int result = JumpSearch.jumpSearch(array, target);
        assertEquals(0, result, "Target should not be found and return -1");
    }
    @Test
    void testJumpSearchTargetAtExactBlockBoundary() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 4; // Target is exactly at the block boundary
        assertEquals(3, JumpSearch.jumpSearch(array, target), "Target should be at index 3");
    }

    @Test
    void testJumpSearchTargetWithinBlock() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7; // Target lies within a block after jumps
        assertEquals(6, JumpSearch.jumpSearch(array, target), "Target should be at index 6");
    }
    @Test
    void testJumpSearchTargetSmallerThanFirstElement() {
        int[] array = {5, 10, 15};
        int target = 1; // Target is smaller than the smallest element
        assertEquals(-1, JumpSearch.jumpSearch(array, target), "Target should not be found and return -1");
    }

    @Test
    void testJumpSearchEmptyArray() {
        int[] array = {};
        int target = 5; // Target in an empty array
        assertEquals(-1, JumpSearch.jumpSearch(array, target), "Empty array should always return -1");
    }

    @Test
    void testJumpSearchAllIdenticalElements() {
        int[] array = {7, 7, 7, 7, 7};
        int target = 7; // Target matches the repeated elements
        assertEquals(0, JumpSearch.jumpSearch(array, target), "Target should return the first index where it is found");
    }
    @Test
    void testJumpSearchRepeatedValuesNoMatch() {
        int[] array = {4, 4, 4, 4};
        int target = 5; // Target is not in the array
        assertEquals(-1, JumpSearch.jumpSearch(array, target), "Target should not be found and return -1");
    }

}
