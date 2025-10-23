//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double[][] matrix = {
                {4, 3, 2},
                {6, 3, 3},
                {6, 3, 8}
        };

        double determinant = LUDecomposition.LUDecompositionDeterminant(matrix);
        System.out.println("Determinant: " + determinant);
    }
}