
public class LUDecomposition {

    static int Counter = 0;

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

        return Out;
    }
}
