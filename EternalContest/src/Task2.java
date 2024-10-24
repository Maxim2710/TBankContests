import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int result = minCut(n);

        System.out.println(result);

        scanner.close();
    }

    private static int minCut(int n) {
        int cur_cuts = 0;

        while (n > 1) {
            cur_cuts++;

            n = (n + 1) / 2;
        }

        return cur_cuts;
    }
}
