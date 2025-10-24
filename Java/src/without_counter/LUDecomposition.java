package without_counter;

public class LUDecomposition {

    //az claude
    // Optimized version without operation counting
    public static double calculateDeterminant(double[][] matrix) {
        // Check if matrix is square
        if (matrix.length != matrix[0].length) {
            throw new ArithmeticException("Matrix must be square to calculate determinant");
        }

        int n = matrix.length;

        // Create a copy to avoid modifying the original matrix
        double[][] LU = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, LU[i], 0, n);
        }

        // Track row exchanges for determinant sign
        int exchanges = 0;
        double determinant = 1.0;

        // LU decomposition with partial pivoting
        for (int j = 0; j < n; j++) {
            // Find pivot
            int pivot = j;
            double maxVal = Math.abs(LU[j][j]);

            for (int i = j + 1; i < n; i++) {
                double absValue = Math.abs(LU[i][j]);
                if (absValue > maxVal) {
                    maxVal = absValue;
                    pivot = i;
                }
            }

            // If a better pivot is found, swap rows
            if (pivot != j) {
                double[] temp = LU[j];
                LU[j] = LU[pivot];
                LU[pivot] = temp;
                exchanges++;
            }

            // Check for zero pivot (singular matrix)
            if (Math.abs(LU[j][j]) < 1e-10) {
                return 0.0; // Early exit for singular matrix
            }

            // Gaussian elimination
            for (int i = j + 1; i < n; i++) {
                double factor = LU[i][j] / LU[j][j];
                LU[i][j] = factor; // Save multiplier for L matrix if needed

                for (int k = j + 1; k < n; k++) {
                    LU[i][k] -= factor * LU[j][k];
                }
            }

            // Multiply by diagonal for determinant
            determinant *= LU[j][j];
        }

        // Apply sign changes from pivoting
        return (exchanges % 2 == 0) ? determinant : -determinant;
    }

    //az gpt
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

        double det = 1.0;
        int sign = 1; // Tracks sign changes due to row swaps

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
                sign = -sign; // Each row swap changes the determinant sign
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

    
    //az khodam
    // Original implementation for reference/comparison
    public static double LUDecompositionDeterminant(double[][] Matrix) {

        //check for equation number of rows and columns
        if (Matrix.length != Matrix[0].length) {
            throw new ArithmeticException("Number of rows and columns is not equals!");
        }

        //get length of matrix
        int n = Matrix.length;

        // Create a copy to avoid modifying the original matrix
        double[][] LU = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(Matrix[i], 0, LU[i], 0, n);
        }

        //out variable declaration
        double Out = 1;

        //LU
        for (int j = 0; j < n; j++) {

            int pivot = j;
            for (int i = j + 1; i < n; i++) {
                if (Math.abs(LU[i][j]) > Math.abs(LU[pivot][j])) {
                    pivot = i;
                }
            }

            // If pivot row is different, swap them
            if (pivot != j) {
                double[] temp = LU[j];
                LU[j] = LU[pivot];
                LU[pivot] = temp;
            }

            for (int i = (j + 1); i < n; i++) {

                double t = LU[i][j] / LU[j][j];

                for (int k = (j + 1); k < n; k++) {
                    LU[i][k] -= t * LU[j][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Out *= LU[i][i];
        }

        //return result
        return Out;
    }
}
