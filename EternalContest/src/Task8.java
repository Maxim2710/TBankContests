import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Task8 {

    public static double[] task8(double x, double y, double[] corners) {
        double xx = x;
        double yy = y;

        for (int i = 0; i < 100; ++i) {
            double alpha = xx / x;
            double beta = yy / y;

            xx = (1 - alpha) * ((1 - beta) * corners[0] + beta * corners[6]) +
                    alpha * ((1 - beta) * corners[2] + beta * corners[4]);
            yy = (1 - alpha) * ((1 - beta) * corners[1] + beta * corners[7]) +
                    alpha * ((1 - beta) * corners[3] + beta * corners[5]);
        }

        return new double[]{xx, yy};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.useLocale(Locale.US);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        double[] corners = new double[8];
        for (int i = 0; i < 8; i++) {
            corners[i] = scanner.nextDouble();
        }

        double[] result = task8(x, y, corners);

        System.out.println(result[0] + " " + result[1]);

        scanner.close();
    }
}
