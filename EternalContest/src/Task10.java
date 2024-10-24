import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
        }

        double totalArea = polygonArea(x, y, n);
        double halfArea = totalArea / 2.0;

        double cutX = findCutX(x, y, n, halfArea);

        System.out.printf("%.9f\n", cutX);
    }

    private static double polygonArea(double[] x, double[] y, int n) {
        double area = 0.0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += (x[i] * y[j] - x[j] * y[i]);
        }
        return Math.abs(area) / 2.0;
    }

    private static double findCutX(double[] x, double[] y, int n, double halfArea) {
        double cumulativeArea = 0.0;

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;

            double trapezoidArea = (x[j] - x[i]) * (y[i] + y[j]) / 2.0;

            if (Math.abs(cumulativeArea + trapezoidArea) >= halfArea) {
                double remainingArea = halfArea - cumulativeArea;
                double ratio = remainingArea / Math.abs(trapezoidArea);
                return x[i] + ratio * (x[j] - x[i]);
            }

            cumulativeArea += trapezoidArea;
        }

        return x[0];
    }
}
