import java.util.Arrays;
import java.util.Scanner;

public class Task9 {
    public static int calculateMinCost(int[] dinnerCosts) {
        int[][] dp = new int[dinnerCosts.length + 1][dinnerCosts.length + 2];

        for (int[] row : dp) {
            Arrays.fill(row, 100 * 300 + 1);
        }

        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dinnerCosts[i - 1]);

                if (dinnerCosts[i - 1] > 100) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][j] + dinnerCosts[i - 1]);
                }

                if (j >= 1) {
                    dp[i][j - 1] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int minResult = Integer.MAX_VALUE;
        for (int j = 0; j <= dinnerCosts.length; j++) {
            minResult = Math.min(minResult, dp[dinnerCosts.length][j]);
        }

        return minResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDinners = scanner.nextInt();
        int[] dinnerPrices = new int[numberOfDinners];

        for (int i = 0; i < numberOfDinners; i++) {
            dinnerPrices[i] = scanner.nextInt();
        }

        int result = calculateMinCost(dinnerPrices);
        System.out.println(result);
    }
}
