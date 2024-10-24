import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        String[] numbers = scanner.nextLine().split(" ");
        ArrayList<Integer> dif = new ArrayList<>();

        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                char el = number.charAt(i);
                int curDigit = el - '0';
                int maxDigit = 9;

                int difference = maxDigit - curDigit;

                if (difference > 0) {
                    difference *= (int) Math.pow(10, number.length() - 1 - i);
                    dif.add(difference);
                }
            }
        }

        Collections.sort(dif, Collections.reverseOrder());

        long maxDif = 0;
        for (int i = 0; i < Math.min(k, dif.size()); i++) {
            maxDif += dif.get(i);
        }

        System.out.println(maxDif);
    }
}