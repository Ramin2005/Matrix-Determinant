package without_counter;

public class Laplace {

    // Det
    public static double Det(double[][] Matrix) {
        int n = Matrix.length;

        if (n == 1) {
            return Matrix[0][0];
        }

        if (n == 2) {
            return ((Matrix[0][0] * Matrix[1][1]) - (Matrix[0][1] * Matrix[1][0]));

        }

        double Det = 0;

        for (int j = 0; j < n; ++j) {
            int nn = (Matrix.length - 1);

            double[][] DelRowAndColumn = new double[nn][nn];

            for (int i = 1; i < n; ++i) {
                for (int k = 0; k < j; ++k) {
                    DelRowAndColumn[(i - 1)][k] = Matrix[i][k];
                }
                for (int k = j; k < nn; ++k) {
                    DelRowAndColumn[(i - 1)][k] = Matrix[i][(k + 1)];
                }

            }

            Det += (Matrix[0][j] * Math.pow(-1, j) * Det(DelRowAndColumn));
        }

        return Det;
    }
}
