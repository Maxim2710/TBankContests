import java.util.Scanner;

public class Task11 {
    public static long modInverse(long x, long p) {
        return powMod(x, p - 2, p);
    }

    public static long powMod(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static long sumModInverses(int l, int r, int p) {
        long result = 0;
        for (int x = l; x <= r; x++) {
            result = (result + modInverse(x, p)) % p;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int p = scanner.nextInt();

        System.out.println(sumModInverses(l, r, p));

        scanner.close();
    }
}