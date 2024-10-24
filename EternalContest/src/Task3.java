import java.util.ArrayList;
import java.util.Scanner;
public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] floors = new int[n];
        for (int i = 0; i < n; i++) {
            floors[i] = scanner.nextInt();
        }

        int floorNum = scanner.nextInt() - 1;

        int result = findSolution(n, t, floors, floorNum);

        System.out.println(result);
    }

    private static int findSolution(int n, int t, int[] floors, int floorNum) {
        int simpleAns = Math.min((floors[floorNum] - floors[0]), (floors[n-1] - floors[floorNum]));

        int res;

        if (floorNum == 0 || floorNum == n-1 || simpleAns <= t) {
            res = floors[n-1] - floors[0];
        } else {
            res = Math.min((floors[floorNum] - floors[0]), floors[n-1] - floors[floorNum]) + floors[n-1] - floors[0];
        }

        return res;
    }
}