import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        scanner.close();

        int result = counterSum(A, B, C, D);

        System.out.println(result);
    }

    private static int counterSum(int A, int B, int C, int D) {
        int dif = countDif(B, D);

        if (dif <= 0) {
            return A;
        }

        return A + (dif * C);
    }

    private static int countDif(int B, int D) {
        return D - B;
    }

}
