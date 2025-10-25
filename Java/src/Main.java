
import java.io.File;
import java.util.Formatter;
import with_counter.LUDecomposition;
import with_counter.Laplace;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
    }

    public static void test1() {

        File file = new File("output.txt");

        try (Formatter out = new Formatter(file)) {
            for (int n = 1; n <= 13; n++) {
                System.out.print("Processing matrix size: " + n);
                double detLU;
                long countLU;
                long timeLU;
                double detLaplace;
                long countLaplace;
                long timeLaplace;

                double[][] matrix = RandomSquareMatrix.generate(n);

                long startTime1 = System.nanoTime();
                double[] temp1 = LUDecomposition.calculateDeterminantWithCounter(matrix);
                detLU = temp1[0];
                countLU = (long) temp1[1];
                timeLU = System.nanoTime() - startTime1;
                System.out.printf(" - LU done %fms, starting Laplace...", timeLU / 1e6);

                long startTime2 = System.nanoTime();
                double[] temp2 = Laplace.Det(matrix);
                detLaplace = temp2[0];
                countLaplace = (long) temp2[1];
                timeLaplace = System.nanoTime() - startTime2;

                out.format("%d %f %d %d %f %d %d%n", n, detLU, countLU, timeLU, detLaplace, countLaplace, timeLaplace);
                System.out.printf(" - Laplace done %fms%n", timeLaplace / 1e6);
            }
        } catch (Exception e) {
        }
    }

    public static void test2() {
        try {
            for (int n = 1; n <= 12; n++) {
                String path = "./test2/output_" + n + ".txt";
                File file = new File(path);
                Formatter out = new Formatter(file);

                double[][] matrix = RandomSquareMatrix.generate(n);

                out.format("Matrix size: %d%n", n);
                out.format("Matrix:%n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.format("%2.0f ", matrix[i][j]);
                    }
                    out.format("%n");
                }

                out.format("%nResults:%n");

                System.out.print("Processing matrix size: " + n);
                double detLU;
                long countLU;
                long timeLU;
                double detLaplace;
                long countLaplace;
                long timeLaplace;

                long startTime1 = System.nanoTime();
                double[] temp1 = LUDecomposition.calculateDeterminantWithCounter(matrix);
                detLU = temp1[0];
                countLU = (long) temp1[1];
                timeLU = System.nanoTime() - startTime1;
                System.out.printf(" - LU done %fms, starting Laplace...", timeLU / 1e6);

                long startTime2 = System.nanoTime();
                double[] temp2 = Laplace.Det(matrix);
                detLaplace = temp2[0];
                countLaplace = (long) temp2[1];
                timeLaplace = System.nanoTime() - startTime2;

                int qubed = n * n * n;

                //LU
                out.format("LU Decomposition:%n");
                out.format("Determinant: %f%n", detLU);
                out.format("Operation Count: %d%n", countLU);
                double operationCubedRatio = (double) qubed / countLU;
                out.format("Operation Count LU / n^3: %f%n", operationCubedRatio);
                out.format("Time (ns): %d%n%n", timeLU);

                //fac n
                int factorial = 1;
                for (int i = 2; i <= n; i++) {
                    factorial *= i;
                }

                //Laplace
                out.format("Laplace Expansion:%n");
                out.format("Determinant: %f%n", detLaplace);
                out.format("Operation Count: %d%n", countLaplace);
                double operationFactorialRatio = (double) factorial / countLaplace;
                out.format("Operation Count Laplace / n!: %f%n", operationFactorialRatio);
                out.format("Time (ns): %d%n%n", timeLaplace);

                double operationRatio = (double) countLaplace / countLU;
                out.format("Operation Count Laplace / LU: %f%n", operationRatio);

                double timeRatio = (double) timeLaplace / timeLU;
                out.format("Time Laplace / LU: %f%n%n", timeRatio);

                out.close();

                System.out.printf(" - Laplace done %fms%n", timeLaplace / 1e6);
            }
        } catch (Exception e) {
        }
    }
}
