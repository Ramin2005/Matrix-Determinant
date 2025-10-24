
import java.io.File;
import java.util.Formatter;
import with_counter.LUDecomposition;
import with_counter.Laplace;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        File file = new File("C:/output.txt");

        try (Formatter out = new Formatter(file)) {
            for (int n = 1; n <= 15; n++) {
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

                long startTime2 = System.nanoTime();
                double[] temp2 = Laplace.Det(matrix);
                detLaplace = temp2[0];
                countLaplace = (long) temp2[1];
                timeLaplace = System.nanoTime() - startTime2;

                out.format("%d %f %d %d %f %d %d%n", n, detLU, countLU, timeLU, detLaplace, countLaplace, timeLaplace);
            }
        } catch (Exception e) {
        }
    }
}
