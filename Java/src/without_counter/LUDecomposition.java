package without_counter;

public class LUDecomposition {

    public static double LUCalculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        // Check if the matrix is square
        if (n != matrix[0].length) {

            // Throw new exception
            throw new ArithmeticException("Matrix must be square to calculate determinant.");

        }

        // Create a copy of the matrix to avoid modifying the original one
        double[][] LU = new double[n][n];

        // Copy the original matrix into LU
        for (int i = 0; i < n; i++) {

            // Copy each row
            System.arraycopy(matrix[i], 0, LU[i], 0, n);

        }

        // Tracks sign changes due to row swaps
        int sign = 1;

        // Initialize determinant
        double det = 1.0;

        // LU Decomposition with Partial Pivoting
        for (int j = 0; j < n; j++) {

            // Find the pivot with the largest absolute value in column j
            int pivot = j;

            // Find the maximum value in the column
            double maxVal = Math.abs(LU[j][j]);

            for (int i = j + 1; i < n; i++) {

                // Get the absolute value of the current element
                double absVal = Math.abs(LU[i][j]);

                // Update pivot if a larger value is found
                if (absVal > maxVal) {

                    // Update maximum value
                    maxVal = absVal;

                    // Update pivot row index
                    pivot = i;

                }

            }

            // Swap rows if a better pivot is found
            if (pivot != j) {

                // Swap the rows in LU matrix
                double[] temp = LU[j];
                LU[j] = LU[pivot];
                LU[pivot] = temp;

                // Each row swap changes the determinant sign
                sign = -sign;

            }

            // Check for singular or near-singular matrix
            if (Math.abs(LU[j][j]) < 1e-12) {

                // Matrix is singular
                return 0.0;

            }

            // Gaussian Elimination process
            for (int i = j + 1; i < n; i++) {

                // Calculate the multiplier
                double factor = LU[i][j] / LU[j][j];

                // Store the multiplier (L matrix component)
                LU[i][j] = factor;

                // Update the rest of the row
                for (int k = j + 1; k < n; k++) {

                    // Eliminate the element
                    LU[i][k] -= factor * LU[j][k];

                }
            }
        }

        // The determinant is the product of the diagonal elements times the sign
        for (int i = 0; i < n; i++) {

            // Multiply diagonal elements
            det *= LU[i][i];

        }

        // Return the final determinant value
        return sign * det;
    }

}
