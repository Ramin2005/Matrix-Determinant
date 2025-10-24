package with_counter;

public class Laplace {

    // Determinant with operation counter
    public static double[] Det(double[][] Matrix) {

        // Counter
        int Counter = 0;

        // Get matrix size
        ++Counter; // declaration
        ++Counter; // assignment
        int n = Matrix.length;

        // Check base cases
        ++Counter; // condition
        if (n == 1) {
            ++Counter; // return
            double[] Out = new double[]{Matrix[0][0], Counter};
            return Out;
        }

        ++Counter; // condition
        if (n == 2) {
            ++Counter; // multiplication
            ++Counter; // multiplication
            ++Counter; // subtraction
            ++Counter; // return
            double det2x2 = (Matrix[0][0] * Matrix[1][1]) - (Matrix[0][1] * Matrix[1][0]);
            double[] Out = new double[]{det2x2, Counter};
            return Out;
        }

        // Initialize determinant
        ++Counter; // declaration
        ++Counter; // assignment
        double Det = 0;

        // Main Laplace expansion loop
        Counter += n + 1; // condition
        Counter += n;     // increment
        for (int j = 0; j < n; ++j) {

            ++Counter; // declaration
            ++Counter; // assignment
            int nn = Matrix.length - 1;

            ++Counter; // declaration
            ++Counter; // assignment
            double[][] DelRowAndColumn = new double[nn][nn];

            Counter += n; // outer loop condition
            Counter += n; // outer loop increment
            for (int i = 1; i < n; ++i) {

                Counter += j; // first inner loop condition
                Counter += j; // first inner loop increment
                for (int k = 0; k < j; ++k) {
                    ++Counter; // assignment
                    ++Counter; // get element
                    DelRowAndColumn[i - 1][k] = Matrix[i][k];
                }

                Counter += (nn - j); // second inner loop condition
                Counter += (nn - j); // second inner loop increment
                for (int k = j; k < nn; ++k) {
                    ++Counter; // assignment
                    ++Counter; // get element
                    DelRowAndColumn[i - 1][k] = Matrix[i][k + 1];
                }
            }

            // Recursive call
            ++Counter; // function call
            double[] SubResult = Det(DelRowAndColumn);

            Counter += SubResult[1]; // add recursive counter
            ++Counter; // multiplication
            ++Counter; // multiplication
            ++Counter; // addition
            Det += (Matrix[0][j] * Math.pow(-1, j) * SubResult[0]);

            // Add recursive counter
            ++Counter; // addition
            Counter += (int) SubResult[1];
        }

        ++Counter; // return
        double[] Out = new double[]{Det, Counter};
        return Out;
    }
}
