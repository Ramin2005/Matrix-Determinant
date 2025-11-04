package without_counter;

public class LUDecomposition {

    public static double LUCalculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        // Check if the matrix is square
        if (n != matrix[0].length) {
            
            throw new ArithmeticException("Matrix must be square to calculate determinant.");

        }

        // Create a copy of the matrix to avoid modifying the original one
        double[][] LU = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, LU[i], 0, n);
        }

        // Tracks sign changes due to row swaps
        int sign = 1;
        double det = 1.0;

        // LU Decomposition with Partial Pivoting
        for (int j = 0; j < n; j++) {

            // Find the pivot with the largest absolute value in column j
            int pivot = j;
            double maxVal = Math.abs(LU[j][j]);

            for (int i = j + 1; i < n; i++) {
                double absVal = Math.abs(LU[i][j]);
                if (absVal > maxVal) {
                    maxVal = absVal;
                    pivot = i;
                }
            }

            // Swap rows if a better pivot is found
            if (pivot != j) {
                double[] temp = LU[j];
                LU[j] = LU[pivot];
                LU[pivot] = temp;
                // Each row swap changes the determinant sign
                sign = -sign;
            }

            // Check for singular or near-singular matrix
            if (Math.abs(LU[j][j]) < 1e-12) {
                return 0.0;
            }

            // Gaussian Elimination process
            for (int i = j + 1; i < n; i++) {
                double factor = LU[i][j] / LU[j][j];
                LU[i][j] = factor; // Store the multiplier (L matrix component)

                // Update the rest of the row
                for (int k = j + 1; k < n; k++) {
                    LU[i][k] -= factor * LU[j][k];
                }
            }
        }

        // The determinant is the product of the diagonal elements times the sign
        for (int i = 0; i < n; i++) {
            det *= LU[i][i];
        }

        return sign * det;
    }

}
