package org.example.DynamicProgramming;

public class CoinChange {
    public static int coinchange(int[] coins, int amount) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                combinations[i] += combinations[i - coin];
            }
        }

        return combinations[amount];
    }

    public static int minimumCoins(int[] coins, int amount) {

        int[] minimumCoins = new int[amount + 1];

        minimumCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            minimumCoins[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub_res = minimumCoins[i - coin];
                    if (
                            sub_res != Integer.MAX_VALUE &&
                                    sub_res + 1 < minimumCoins[i]
                    ) {
                        minimumCoins[i] = sub_res + 1;
                    }
                }
            }
        }
        return minimumCoins[amount];
    }
}
