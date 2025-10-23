public class LUDecomposition {
    
    private static int Counter = 0;

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
    
    // Original implementation for reference/comparison
    public static double LUDecompositionDeterminant(double[][] Matrix) {

        //check for equation number of rows and columns
        ++Counter;//condition
        ++Counter;//get element
        ++Counter;//get length
        ++Counter;//get length
        if (Matrix.length != Matrix[0].length) {
            ++Counter;//throw
            throw new ArithmeticException("Number of rows and columns is not equals!");
        }

        //get length of matrix
        ++Counter;//declaration 
        ++Counter; //assignment
        int n = Matrix.length;

        //out variable declaration
        ++Counter;//declaration
        double Out = 1;

        //LU
        ++Counter;//declaration
        ++Counter; //assignment
        Counter += n + 1; //condition
        Counter += n; //increment
        for (int j = 0; j < n; j++) {

            int pivot = j;
            for (int i = j + 1; i < n; i++) {
                if (Math.abs(Matrix[i][j]) > Math.abs(Matrix[pivot][j])) {
                    pivot = i;
                }
            }

            // If pivot row is different, swap them
            if (pivot != j) {
                double[] temp = Matrix[j];
                Matrix[j] = Matrix[pivot];
                Matrix[pivot] = temp;
            }

            ++Counter;//declaration
            ++Counter; //assignment
            Counter += (n - j);//condition
            Counter += (n - j - 1);//increment
            for (int i = (j + 1); i < n; i++) {

                ++Counter; //declaration
                ++Counter; //assignment  
                ++Counter; //divide
                ++Counter;//get element
                ++Counter;//get element
                double t = Matrix[i][j] / Matrix[j][j];

                ++Counter;//declaration
                ++Counter; //assignment
                Counter += (n - j);//condition
                Counter += (n - j - 1);//increment
                for (int k = (j + 1); k < n; k++) {
                    ++Counter;//assignment
                    ++Counter;//multiply
                    ++Counter;//get Element
                    Matrix[i][k] -= t * Matrix[j][k];
                }
            }
        }

        ++Counter;//declaration
        ++Counter; //assignment
        Counter += n + 1; //condition
        Counter += n; //increment
        for (int i = 0; i < n; i++) {
            ++Counter;//get Element
            ++Counter; //multiply
            Out *= Matrix[i][i];
        }

        //return result
        ++Counter;//return

        System.out.println("Number of process: " + Counter);
        Counter = 0;

        return Out;
    }
}
