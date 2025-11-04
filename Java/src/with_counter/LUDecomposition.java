package with_counter;

public class LUDecomposition {

    public static double[] calculateDeterminantWithCounter(int[][] matrix) {

        int Counter = 0;

        // Check if matrix is square
        ++Counter; // get length
        int n = matrix.length;

        ++Counter; // get element
        ++Counter; // get length
        ++Counter; // condition
        if (n != matrix[0].length) {
            ++Counter; // throw
            throw new ArithmeticException("Matrix must be square to calculate determinant.");
        }

        // Create a copy of the matrix
        ++Counter; // declaration
        double[][] LU = new double[n][n];

        ++Counter; // declaration
        ++Counter; // assignment
        Counter += n + 1; // condition
        Counter += n; // increment
        for (int i = 0; i < n; i++) {

            ++Counter; // declaration
            ++Counter; // assignment
            Counter += n + 1; // condition
            Counter += n; // increment
            for (int j = 0; j < n; j++) {

                ++Counter;//assignment
                ++Counter;//get element
                LU[i][j] = matrix[i][j];
            }
        }

        // Determinant and sign variables
        ++Counter; // declaration
        ++Counter; // assignment
        double det = 1.0;

        ++Counter; // declaration
        ++Counter; // assignment
        int sign = 1;

        // LU decomposition with partial pivoting
        Counter += n + 1; // condition
        Counter += n; // increment
        for (int j = 0; j < n; j++) {

            // Find pivot
            ++Counter; // declaration
            ++Counter; // assignment
            int pivot = j;

            ++Counter; // declaration
            ++Counter; // assignment
            ++Counter; // abs
            double maxVal = Math.abs(LU[j][j]);

            Counter += (n - j); // condition
            Counter += (n - j - 1); // increment
            for (int i = j + 1; i < n; i++) {
                ++Counter; // abs
                ++Counter; // get element
                double absVal = Math.abs(LU[i][j]);
                ++Counter; // condition
                if (absVal > maxVal) {
                    ++Counter; // assignment
                    maxVal = absVal;
                    ++Counter; // assignment
                    pivot = i;
                }
            }

            // Swap rows if pivot is different
            ++Counter; // condition
            if (pivot != j) {
                ++Counter; // declaration
                ++Counter; // assignment
                ++Counter; // get element
                double[] temp = LU[j];

                ++Counter; // assignment
                ++Counter; // get element
                LU[j] = LU[pivot];

                ++Counter; // assignment
                LU[pivot] = temp;

                ++Counter; // negate sign
                sign = -sign;
            }

            // Check for near-zero pivot
            ++Counter; // abs
            ++Counter; // condition
            if (Math.abs(LU[j][j]) < 1e-12) {
                ++Counter; // return
                double[] Out = new double[]{0.0, Counter};
                System.out.println("Number of operations: " + Counter);
                return Out;
            }

            // Gaussian elimination
            Counter += (n - j); // condition
            Counter += (n - j - 1); // increment
            for (int i = j + 1; i < n; i++) {
                ++Counter; // declaration
                ++Counter; // assignment
                ++Counter; // divide
                ++Counter; // get element
                ++Counter; // get element
                double factor = LU[i][j] / LU[j][j];

                ++Counter; // assignment
                LU[i][j] = factor;

                Counter += (n - j); // condition
                Counter += (n - j - 1); // increment
                for (int k = j + 1; k < n; k++) {
                    ++Counter; // multiply
                    ++Counter; // get element
                    ++Counter; // subtract
                    LU[i][k] -= factor * LU[j][k];
                }
            }
        }

        // Multiply diagonal elements
        Counter += n + 1; // condition
        Counter += n; // increment
        for (int i = 0; i < n; i++) {
            ++Counter; // get element
            ++Counter; // multiply
            det *= LU[i][i];
        }

        // Apply sign
        ++Counter; // multiply
        det *= sign;

        ++Counter; // return
        double[] Out = new double[]{det, Counter};
        return Out;
    }

}
