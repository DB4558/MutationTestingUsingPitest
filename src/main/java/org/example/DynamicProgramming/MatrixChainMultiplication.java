package org.example.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
        static int solve(int arr[], int i, int j, int[][] dp){
            if(i == j)
                return 0;

            if(dp[i][j]!=-1)
                return dp[i][j];
            int mini = Integer.MAX_VALUE;


            for(int k = i; k<= j-1; k++){
                int ans = solve(arr,i,k,dp) + solve(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];

                mini = Math.min(mini,ans);

            }
            return mini;
        }
        public int matrixMultiplication(int[] arr, int N){

            int dp[][]= new int[N][N];
            for(int row[]:dp)
                Arrays.fill(row,-1);

            int i =1;
            int j = N-1;
            return solve(arr,i,j,dp);
        }


    }


