package org.example;

import org.example.DynamicProgramming.*;

import static org.example.DynamicProgramming.LongestIncreasingSubsequence.LIS;
import static org.example.DynamicProgramming.LongestIncreasingSubsequence.findLISLen;

public class Main {
    public static void main(String[] args) {
        Knapsack ks=new Knapsack();
        int W=4,n=3;
        int w[]={4,5,1};
        int val[]={1,2,3};
        int result=ks.knapSack(W,w,val,n);
        System.out.println("Result of Knapsack="+result);

        LongestCommonSubsequence lcs=new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Longest Common Subsequence: " + lcs.lcs(text1, text2));


        ShortestCommonSupersequence scs=new ShortestCommonSupersequence();
        String str1 = "abc";
        String str2 = "ebd";
        System.out.println("Shortest Common Supersequence of \"" + str1 + "\" and \"" + str2 + "\": "
                + scs.shortestCommonSupersequence(str1, str2));

        TargetSum targetSum=new TargetSum();
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("TargetSum Ways are: " + targetSum.findTargetSumWays(nums1, target1));

        MatrixChainMultiplication mcm=new MatrixChainMultiplication();
        int arr[] = {10, 20, 30, 40, 50};
        int n1 = arr.length;
        System.out.println("Matrix Multiplication,The minimum number of operations are "+
                mcm.matrixMultiplication(arr,n1));

        CoinChange change=new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Number of ways to make change for amount " + amount + ": " + change.coinchange(coins, amount));
        System.out.println("Minimum number of coins to make change for amount " + amount + ": " + change.minimumCoins(coins, amount));


        StockBuyAndSell stockBuyAndSell=new StockBuyAndSell();
        int n2= 6;
        long[] Arr = {7, 1, 5, 3, 6, 4};
        System.out.println("Stock Buy and Sell,The maximum profit that can be generated is " + stockBuyAndSell.getMaximumProfit(Arr, n2));

        int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        LongestIncreasingSubsequence longestIncreasingSubsequence=new LongestIncreasingSubsequence();
        int lisLength1 = longestIncreasingSubsequence.LIS(array);
        System.out.println("Length of Longest Increasing Subsequence (LIS) using first approach: " + lisLength1);
        int lisLength2 = longestIncreasingSubsequence.findLISLen(array);
        System.out.println("Length of Longest Increasing Subsequence (LIS) using second approach:(binary search) " + lisLength2);

        LongestPalindromicSubsequence longestPalindromicSubsequence=new LongestPalindromicSubsequence();
        String input1 = "BBABCBCAB";
        System.out.println("Longest Palindromic Subsequence of \"" + input1 + "\": " + longestPalindromicSubsequence.LPS(input1));

    }

}