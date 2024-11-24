package org.example.DynamicProgramming;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0 || (target + sum) < 0) {
            return 0;
        }
        int diff = (target + sum) / 2;
        int[] dp = new int[diff + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = diff; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[diff];
    }
}
