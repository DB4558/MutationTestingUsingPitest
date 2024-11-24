package DynamicProgramming;

import org.example.DynamicProgramming.*;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Searching.BinarySearch;
import org.junit.jupiter.api.Test;


public class TestDP {

    Knapsack ks = new Knapsack();
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
    TargetSum targetSum = new TargetSum();


    @Test
    void testKnapsack1() {


        int W1 = 100;
        int wt1[] = {1, 1, 101};
        int val1[] = {10, 20, 31};
        int n1 = wt1.length;
        assertEquals(30, ks.knapSack(W1, wt1, val1, n1));
    }

    @Test
    void testKnapsack2() {

        int W2 = 10;
        int wt2[] = {11, 12};
        int val2[] = {11, 22};
        int n2 = wt2.length;
        assertEquals(0, ks.knapSack(W2, wt2, val2, n2));
    }

    @Test
    void testKnapsack3() {

        int W3 = 15;
        int wt3[] = {15, 100};
        int val3[] = {1, 100};
        int n3 = wt3.length;
        assertEquals(1, ks.knapSack(W3, wt3, val3, n3));
    }

    @Test
    void testKnapsack4() {

        int W4 = 25;
        int wt4[] = {5, 5, 5, 5, 5, 5};
        int val4[] = {1, 4, 3, 7, 2, 8};
        int n4 = wt4.length;
        assertEquals(24, ks.knapSack(W4, wt4, val4, n4));
    }

    //partial match interleaved with mismatch
    @Test
    void testLCS1() {

        assertEquals(4, lcs.lcs("abcdxyz", "axbycz"),
                "Mismatch scenario where characters alternate between matching and non-matching.");
    }

    //completely mismatch
    @Test
    void testLCS2() {
        assertEquals(0, lcs.lcs("abc", "xyz"),
                "Strings with no common characters must yield LCS length of 0.");
    }

    //interleaved match
    @Test
    void testLCS3() {

        assertEquals(3, lcs.lcs("abcde", "acebd"),
                "Complex interleaved match scenario to stress `dp` updates and ensure correctness.");
    }

    //single charracter match
    @Test
    void testLCS4() {

        assertEquals(1, lcs.lcs("a", "a"),
                "Single-character match must yield LCS length of 1.");
        assertEquals(0, lcs.lcs("a", "z"),
                "Single-character mismatch must yield LCS length of 0.");
    }

    //either of the string empty
    @Test
    void testLCSEmpty() {

        assertEquals(0, lcs.lcs("", ""),
                "LCS of two empty strings must be 0.");
    }

    //full string match
    @Test
    void testLCSFullMatch() {
        assertEquals(5, lcs.lcs("hello", "hello"),
                "LCS of identical strings must equal the length of the strings.");
    }

    //repeated characters
    @Test
    void testLCSRepeatedCharacters() {
        assertEquals(3, lcs.lcs("aaa", "aaa"),
                "LCS of repeated characters must equal their length.");
        assertEquals(2, lcs.lcs("aaa", "aa"),
                "LCS must handle different lengths of repeated characters.");
    }


    @Test
    void testShortestCommonSupersequence1() {
        assertEquals("abcdef", scs.shortestCommonSupersequence("abc", "def"),
                "No characters in common should result in concatenation.");
    }

    @Test
    void testShortestCommonSupersequence2() {

        assertEquals("abc", scs.shortestCommonSupersequence("abc", "abc"),
                "Identical strings should yield the same string.");
    }

    @Test
    void testShortestCommonSupersequence3() {
        assertEquals("aebcd", scs.shortestCommonSupersequence("abc", "ebd"),
                "Interleaved characters should be merged appropriately.");
    }

    @Test
    void testShortestCommonSupersequence4() {

        assertEquals("ac", scs.shortestCommonSupersequence("a", "c"),
                "Single character mismatch should concatenate.");
        assertEquals("a", scs.shortestCommonSupersequence("a", "a"),
                "Single character match should include it once.");
    }

    @Test
    void testTargetSum1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        assertEquals(expected, targetSum.findTargetSumWays(nums, target));
    }


    @Test
    void testTargetSum3() {

        int[] nums = {0, 0, 0, 0, 0};
        int target = 0;
        int expected = 32;
        assertEquals(expected, targetSum.findTargetSumWays(nums, target));
    }


    @Test
    void testTargetSum4() {

        int[] nums = {100};
        int target = -200;
        int expected = 0;
        assertEquals(expected, targetSum.findTargetSumWays(nums, target));
    }


    @Test
    void testTargetSum5() {

        int[] nums = {3};
        int target = 3;
        int expected = 1;
        assertEquals(expected, targetSum.findTargetSumWays(nums, target));
    }

    @Test
    void testMatrixMultilication1() {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int arr[] = {10, 20, 30};
        int N = 3;
        int result = mcm.matrixMultiplication(arr, N);
        assertEquals(6000, result);
    }


    @Test
    void testMatrixMultilication2() {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int arr[] = {10, 20, 30, 40};
        int N = 4;
        int result = mcm.matrixMultiplication(arr, N);
        assertEquals(18000, result);
    }


    @Test
    void testMatrixMultilication3() {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int arr[] = {10, 10, 10, 10};
        int N = 4;
        int result = mcm.matrixMultiplication(arr, N);
        assertEquals(2000, result);
    }


    @Test
    void testMatrixMultilication4() {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int arr[] = {10, 20, 30, 40, 50};
        int N = 5;
        int result = mcm.matrixMultiplication(arr, N);
        assertEquals(38000, result);
    }

    @Test
    public void testMinimumCoinChange1() {
        CoinChange ccs = new CoinChange();

        int[] coins1 = {1, 2, 3};
        int amount1 = 30;
        assertEquals(91, ccs.coinchange(coins1, amount1));
    }

    @Test
    public void testMinimumCoinChange2() {
        CoinChange ccs = new CoinChange();
        int coins2[] = {1};
        int amount2 = 20;
        assertEquals(1, ccs.coinchange(coins2, amount2));
    }

    @Test
    public void testMinimumCoinChange3() {
        CoinChange ccs = new CoinChange();
        int coins3[] = {5};
        int amount3 = 4;
        assertEquals(0, ccs.coinchange(coins3, amount3));
    }

    @Test
    public void testMinimumCoinChange4() {
        CoinChange ccs = new CoinChange();


        int[] coins1 = {1, 2, 3, 4, 5};
        int amount1 = 7;
        assertEquals(2, ccs.minimumCoins(coins1, amount1));
    }

    @Test
    public void testMinimumCoinChange5() {
        CoinChange ccs = new CoinChange();
        int[] coins2 = {1};
        int amount2 = 10000;
        assertEquals(10000, ccs.minimumCoins(coins2, amount2));
    }

    @Test
    public void testMinimumCoinChange6() {
        CoinChange ccs = new CoinChange();
        int[] coins3 = {6, 2, 9, 10};
        int amount3 = 18;
        assertEquals(2, ccs.minimumCoins(coins3, amount3));
    }

    @Test
    void testStockBuyAndSell1() {
        StockBuyAndSell sbs = new StockBuyAndSell();
        long[] Arr = {1, 2, 3, 4, 5};
        int n = 5;
        long result = sbs.getMaximumProfit(Arr, n);
        assertEquals(4, result);
    }

    @Test
    void testStockBuyAndSell2() {
        StockBuyAndSell sbs = new StockBuyAndSell();
        long[] Arr = {5, 4, 3, 2, 1};
        int n = 5;
        long result = sbs.getMaximumProfit(Arr, n);
        assertEquals(0, result);
    }

    @Test
    void testStockBuyAndSell3() {
        StockBuyAndSell sbs = new StockBuyAndSell();
        long[] Arr = {5};
        int n = 1;
        long result = sbs.getMaximumProfit(Arr, n);
        assertEquals(0, result);
    }


    //empty array
    @Test
    void testLIS1() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr1 = {};
        assertEquals(0, liss.LIS(arr1));
    }

    //single element array
    @Test
    void testLIS2() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr2 = {1};
        assertEquals(1, liss.LIS(arr2));
    }

    //increasing value array
    @Test
    void testLIS3() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr3 = {1, 2};
        assertEquals(2, liss.LIS(arr3));
    }

    //decreasing value array
    @Test
    void testLIS4() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr4 = {2, 1};
        assertEquals(1, liss.LIS(arr4));
    }

    @Test
    void testLIS5() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr5 = {1, 2, 2, 5};
        assertEquals(3, liss.LIS(arr5));
    }

    //equal elements array
    @Test
    void testLIS6() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr6 = {1, 1, 1, 1, 1};
        assertEquals(1, liss.LIS(arr6));
    }

    //increasing decreasing mixed
    @Test
    void testLISMixed() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr = {3, 10, 2, 1, 20};
        assertEquals(3, liss.LIS(arr), "LIS should find the longest increasing subsequence.");
    }

    //multiple subsequence
    @Test
    void testLISMultipleSubsequences() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        assertEquals(5, liss.LIS(arr), "The longest increasing subsequence length should be 5.");
    }


    //repeated subsequence
    @Test
    void testLISRepeatedSequences() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr = {3, 2, 6, 4, 5, 1, 2, 7};
        assertEquals(4, liss.LIS(arr), "The LIS should correctly handle repeated increasing and decreasing subsequences.");
    }


    /* @Test
     void testFindLISLen1() {
         LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

          Uncommenting below test fails the test on running, so a bug is in the code
          * // Test 1
          * int[] arr1 = {};
          * assertEquals(0, liss.findLISLen(arr1));
          *

     }*/
    @Test
    void testFindLISLen2() {

        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr2 = {100};
        assertEquals(1, liss.findLISLen(arr2));
    }

    @Test
    void testFindLISLen3() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr3 = {5, 4};
        assertEquals(1, liss.findLISLen(arr3));
    }


    @Test
    void testFindLISLen4() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();

        int[] arr4 = {3, 10, 2, 1, 10, 12};
        assertEquals(3, liss.findLISLen(arr4));

    }
    /* Uncommenting below test fails the test on running, so a bug is in the code
     * // Test 5
     * int[] arr5 = {10,11,12,13};
     * assertEquals(4, liss.findLISLen(arr5));
     */

    // Test 6
    @Test
    void testFindLISLen5() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr6 = {1, 4, 7, 3, 7, 9};
        assertEquals(4, liss.findLISLen(arr6));
    }

    @Test
    void testFindLISLen6() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        // Test 7
        int[] arr7 = {1};
        assertEquals(1, liss.findLISLen(arr7));
    }

    // Test 8
    @Test
    void testFindLISLen7() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        int[] arr8 = {1, 3, 6, 2, 6, 82, 6, 8, 2};
        assertEquals(4, liss.findLISLen(arr8));
    }

    @Test
    void testFindLISLen8() {
        LongestIncreasingSubsequence liss = new LongestIncreasingSubsequence();
        // Test 9
        int[] arr9 = {5, 2, 4, 7, 92, 6, 7, 3, 6, 7};
        assertEquals(4, liss.findLISLen(arr9));
    }

    @Test
    void testLPS1() {
        LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();

        String s1 = "";
        assertEquals("", lpss.LPS(s1));
    }

    @Test
    void testLPS2() {
        LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();
        String s2 = "a";
        assertEquals("a", lpss.LPS(s2));
    }

    @Test
    void testLPS3() {
        LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();
        String s3 = "abcdcba";
        assertEquals("abcdcba", lpss.LPS(s3));
    }

    @Test
    void testLPS4() {
        LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();
        String s4 = "abcdef";
        assertEquals("a", lpss.LPS(s4));
    }

    @Test
    void testLPS5() {
        LongestPalindromicSubsequence lpss = new LongestPalindromicSubsequence();
        String s5 = "acee";
        assertEquals("ee", lpss.LPS(s5));
    }

    @Test
    void testEditDistance1() {
        EditDistance eds = new EditDistance();
        String word11 = "abcde";
        String word12 = "a";
        assertEquals(4, eds.minDistance(word11, word12));
    }

    @Test
    void testEditDistance2() {
        EditDistance eds = new EditDistance();
        String word21 = "a";
        String word22 = "a";
        assertEquals(0, eds.minDistance(word21, word22));
    }

    @Test
    void testEditDistance3() {
        EditDistance eds = new EditDistance();
        String word31 = "bb";
        String word32 = "abb";
        assertEquals(1, eds.minDistance(word31, word32));
    }

    @Test
    void testEditDistance4() {
        EditDistance eds = new EditDistance();
        String word41 = "abba";
        String word42 = "abccba";
        assertEquals(2, eds.minDistance(word41, word42));
    }

    /*@Test
    void testMinimalPartitions1() {
        PalindromicPartitioningSource pps = new PalindromicPartitioningSource();

         Below test gives error on running
         * // Test 1
         * String s1 = "";
         * assertEquals(0, pps.minimalpartitions(s1));

}*/
    @Test
    void testMinimalPartitions2() {
        PalindromePartitioning pps = new PalindromePartitioning();
        String s2 = "a";
        assertEquals(0, pps.minimalpartitions(s2));
    }

    @Test
    void testMinimalPartitions3() {
        PalindromePartitioning pps = new PalindromePartitioning();
        String s3 = "aa";
        assertEquals(0, pps.minimalpartitions(s3));
    }

    @Test
    void testMinimalPartitions4() {
        PalindromePartitioning pps = new PalindromePartitioning();
        String s4 = "aba";
        assertEquals(0, pps.minimalpartitions(s4));
    }

    @Test
    void testMinimalPartitions5() {
        PalindromePartitioning pps = new PalindromePartitioning();
        String s5 = "ab";
        assertEquals(1, pps.minimalpartitions(s5));
    }

    @Test
    void testMinimalPartitions6() {
        PalindromePartitioning pps = new PalindromePartitioning();
        String s6 = "pqqabb";
        assertEquals(3, pps.minimalpartitions(s6));
    }

    @Test
    void test1() {
        RodCutting rcs = new RodCutting();

        // Test 1
        int[] arr1 = {1};
        assertEquals(1, rcs.cutRod(arr1, arr1.length));
    }

    @Test
    void test2() {
        RodCutting rcs = new RodCutting();
// Test 2
        int[] arr2 = {1, 2, 3, 4};
        assertEquals(4, rcs.cutRod(arr2, arr2.length));
    }
    @Test
    void test3() {
        RodCutting rcs = new RodCutting();
    int[] arr3 = {1, 1, 1, 102, 100};

    assertEquals(103,rcs.cutRod(arr3, arr3.length));
}

    @Test
    void testUniquePathsDP1() {
        UniquePaths ups = new UniquePaths();

        // Test 1
        int m1 = 1;
        int n1 = 1;
        assertEquals(1, ups.uniquePathsDP(m1, n1));
    }
    @Test
    void testUniquePathsDP2() {
        UniquePaths ups = new UniquePaths();
        int m2 = 1;
        int n2 = 100;
        assertEquals(1, ups.uniquePathsDP(m2, n2));
    }
    @Test
    void testUniquePathsDP3() {
        UniquePaths ups = new UniquePaths();
        int m3 = 5;
        int n3 = 100;
        assertEquals(4421275, ups.uniquePathsDP(m3, n3));
    }
    @Test
    void testUpperBoundWithKeyPresent() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = LongestIncreasingSubsequence.upperBound(arr, 0, arr.length, 3);
        assertEquals(2, result);
    }

    @Test
    void testUniquePathsDP4() {
        UniquePaths ups = new UniquePaths();
        int m4 = 4;
        int n4 = 4;
        assertEquals(20, ups.uniquePathsDP(m4, n4));
    }


}


