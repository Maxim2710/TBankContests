import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int result = findAllCombs(n, a, b, c);

        System.out.println(result);

        scanner.close();
    }

    private static int findAllCombs(int n, int a, int b, int c) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - a * i); j++) {
                int ost = n - a * i - b * j - 1;

                if (ost >= 0) {
                    cnt += (ost / c) + 1;

                }
            }
        }

        return cnt;
    }
}
