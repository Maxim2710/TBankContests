import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] heightStudents = new int[n];
        for (int i = 0; i < n; i++) {
            heightStudents[i] = scanner.nextInt();
        }

        scanner.close();

        findSolution(n, heightStudents);
    }

    private static void findSolution(int n, int[] hS) {
        int failOnOdd = 0, failOnEven = 0, oodInd = 0, evenInd = 0;
        for (int i = 0; i < hS.length; i++) {
            if ((i+1) % 2 == 0 && hS[i] % 2 != 0) {
                evenInd = i + 1;
                failOnEven++;
            } else if ((i + 1) % 2 != 0 && hS[i] % 2 == 0) {
                oodInd = i + 1;
                failOnOdd++;
            }
        }

        if (failOnOdd == 1 && failOnEven == 1) {
            System.out.println(oodInd + " " + evenInd);
        } else if(failOnOdd == 0 && failOnEven == 0) {
            if (n < 3) {
                System.out.println("-1 -1");
            }
            System.out.println("1 3");
        } else  {
            System.out.println("-1 -1");
        }
    }
}
