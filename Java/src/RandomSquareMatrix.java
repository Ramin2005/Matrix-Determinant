
import java.security.SecureRandom;

public class RandomSquareMatrix {

    public static double[][] generate(int size) {
        double[][] matrix = new double[size][size];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10, 50); // Random values between 10 and 50          
            }
        }
        return matrix;
    }
}
