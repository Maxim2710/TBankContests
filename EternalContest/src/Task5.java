import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long l = scanner.nextLong();
        long r = scanner.nextLong();

        scanner.close();

        int result = countDigits(l, r);

        System.out.println(result);
    }

    private static int countDigits(long l, long r) {
        int cnt = 0;

        for (int i = 1; i <= 9; i++) {
            long number = i;

            while (number <= r) {
                if (number >= l) {
                    cnt++;
                }

                number = number * 10 + i;
            }
        }

        return cnt;
    }
}
