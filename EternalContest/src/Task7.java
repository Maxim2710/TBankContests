import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        solve(n, a);
    }

    private static void solve(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            a[i]--;
        }

        boolean[] vis = new boolean[n];
        int current = 0;
        int count = 0;

        while (!vis[current]) {
            vis[current] = true;
            current = a[current];
            count++;
        }

        if (count == n && current == 0) {
            System.out.println("-1 -1");
            return;
        }

        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[a[i]]++;
        }

        List<Integer> zeroInDeg = new ArrayList<>();
        List<Integer> moreThanOneInDeg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                zeroInDeg.add(i);
            } else if (inDegree[i] > 1) {
                moreThanOneInDeg.add(i);
            }
        }

        if (zeroInDeg.size() == 1 && moreThanOneInDeg.size() == 1) {
            int first = zeroInDeg.get(0);
            int second = moreThanOneInDeg.get(0);

            for (int i = 0; i < n; i++) {
                if (a[i] == second) {
                    a[i] = first;
                    if (isCycle(a)) {
                        System.out.println((i + 1) + " " + (first + 1));
                        return;
                    }
                    a[i] = second;
                }
            }
        }
        System.out.println("-1 -1");
    }

    private static boolean isCycle(int[] a) {
        int n = a.length;
        boolean[] vis = new boolean[n];
        int current = 0;
        int count = 0;

        while (!vis[current]) {
            vis[current] = true;
            current = a[current];
            count++;
        }

        return count == n && current == 0;
    }
}
