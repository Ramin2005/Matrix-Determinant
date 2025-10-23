
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    //
    public static double[][] GetDoubleMatrixFromFile(String FilePath) throws Exception {
        //create 2D array for output matrix
        double[][] Out;

        //create obj file of path
        File TextFile = new File(FilePath);

        //check path is exists
        if (!TextFile.exists()) {

            //throw exception
            throw new Exception("Path not Exists!");
        }

        //check for path is a file
        if (!TextFile.isFile()) {

            //throw exception
            throw new Exception("Path is not a file!");
        }

        //create list of array of strings for saving 
        ArrayList<String[]> TokenArrays = new ArrayList<>();

        //try catch blocks
        try (BufferedReader BufferReader = Files.newBufferedReader(Path.of(FilePath))) {

            //string variable for saving lines after reading for adding to list
            String Line;

            //read lines
            while ((Line = BufferReader.readLine()) != null) {

                //split lines to numbers(tokens)
                //string array for save splitted tokens
                String[] Tokens = Line.trim().split("\\s+");

                //add tokens array to list
                TokenArrays.add(Tokens);
            }

        } //catch errors in reading file 
        catch (IOException e) {

            //printing file reading error
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        //get size of matrix
        int n = TokenArrays.size();

        //declaring 
        Out = new double[n][n];

        //casting tokens to numbers
        for (int i = 0; i < n; i++) {

            //getting tokens 
            String[] Tokens = TokenArrays.get(i);

            //check for equation rows and columns length
            if (Tokens.length != n) {

                //throw exception
                throw new Exception("Numbers in this file can not make a matrix, length of some rows not equals with number of columns!");
            }

            //create a boolean flag for handling errors
            boolean CastingErr = false;

            //casting string numbers to double
            for (int j = 0; j < n; j++) {
                try {

                    //casting string to double
                    Out[i][j] = Double.parseDouble(Tokens[j]);

                } catch (NumberFormatException e) {

                    //printing casting error
                    System.err.println("Error in casting file data: " + e.getMessage());

                    //make flag true
                    CastingErr = true;

                    //break for exit from loop
                    break;
                }
            }

            //check error flag 
            if (CastingErr) {

                //throw exception
                throw new NumberFormatException("Some tokens can not casting string to double!");
            }
        }

        //return final matrix
        return Out;
    }

    //
    public static float[][] GetFloatMatrixFromFile(String FilePath) throws Exception {
        //create 2D array for output matrix
        float[][] Out;

        //create obj file of path
        File TextFile = new File(FilePath);

        //check path is exists
        if (!TextFile.exists()) {

            //throw exception
            throw new Exception("Path not Exists!");
        }

        //check for path is a file
        if (!TextFile.isFile()) {

            //throw exception
            throw new Exception("Path is not a file!");
        }

        //create list of array of strings for saving 
        ArrayList<String[]> TokenArrays = new ArrayList<>();

        //try catch blocks
        try (BufferedReader BufferReader = Files.newBufferedReader(Path.of(FilePath))) {

            //string variable for saving lines after reading for adding to list
            String Line;

            //read lines
            while ((Line = BufferReader.readLine()) != null) {

                //split lines to numbers(tokens)
                //string array for save splitted tokens
                String[] Tokens = Line.trim().split("\\s+");

                //add tokens array to list
                TokenArrays.add(Tokens);
            }

        } //catch errors in reading file 
        catch (IOException e) {

            //printing file reading error
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        //get size of matrix
        int n = TokenArrays.size();

        //declaring 
        Out = new float[n][n];

        //casting tokens to numbers
        for (int i = 0; i < n; i++) {

            //getting tokens 
            String[] Tokens = TokenArrays.get(i);

            //check for equation rows and columns length
            if (Tokens.length != n) {

                //throw exception
                throw new Exception("Numbers in this file can not make a matrix, length of some rows not equals with number of columns!");
            }

            //create a boolean flag for handling errors
            boolean CastingErr = false;

            //casting string numbers to float
            for (int j = 0; j < n; j++) {
                try {

                    //casting string to float
                    Out[i][j] = Float.parseFloat(Tokens[j]);

                } catch (NumberFormatException e) {

                    //printing casting error
                    System.err.println("Error in casting file data: " + e.getMessage());

                    //make flag true
                    CastingErr = true;

                    //break for exit from loop
                    break;
                }
            }

            //check error flag 
            if (CastingErr) {

                //throw exception
                throw new NumberFormatException("Some tokens can not casting string to float!");
            }
        }

        //return final matrix
        return Out;
    }

    //
    public static long[][] GetLongMatrixFromFile(String FilePath) throws Exception {
        //create 2D array for output matrix
        long[][] Out;

        //create obj file of path
        File TextFile = new File(FilePath);

        //check path is exists
        if (!TextFile.exists()) {

            //throw exception
            throw new Exception("Path not Exists!");
        }

        //check for path is a file
        if (!TextFile.isFile()) {

            //throw exception
            throw new Exception("Path is not a file!");
        }

        //create list of array of strings for saving 
        ArrayList<String[]> TokenArrays = new ArrayList<>();

        //try catch blocks
        try (BufferedReader BufferReader = Files.newBufferedReader(Path.of(FilePath))) {

            //string variable for saving lines after reading for adding to list
            String Line;

            //read lines
            while ((Line = BufferReader.readLine()) != null) {

                //split lines to numbers(tokens)
                //string array for save splitted tokens
                String[] Tokens = Line.trim().split("\\s+");

                //add tokens array to list
                TokenArrays.add(Tokens);
            }

        } //catch errors in reading file 
        catch (IOException e) {

            //printing file reading error
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        //get size of matrix
        int n = TokenArrays.size();

        //declaring 
        Out = new long[n][n];

        //casting tokens to numbers
        for (int i = 0; i < n; i++) {

            //getting tokens 
            String[] Tokens = TokenArrays.get(i);

            //check for equation rows and columns length
            if (Tokens.length != n) {

                //throw exception
                throw new Exception("Numbers in this file can not make a matrix, length of some rows not equals with number of columns!");
            }

            //create a boolean flag for handling errors
            boolean CastingErr = false;

            //casting string numbers to long
            for (int j = 0; j < n; j++) {
                try {

                    //casting string to long
                    Out[i][j] = Long.parseLong(Tokens[j]);

                } catch (NumberFormatException e) {

                    //printing casting error
                    System.err.println("Error in casting file data: " + e.getMessage());

                    //make flag true
                    CastingErr = true;

                    //break for exit from loop
                    break;
                }
            }

            //check error flag 
            if (CastingErr) {

                //throw exception
                throw new NumberFormatException("Some tokens can not casting string to long!");
            }
        }

        //return final matrix
        return Out;
    }

    //
    public static int[][] GetIntMatrixFromFile(String FilePath) throws Exception {
        //create 2D array for output matrix
        int[][] Out;

        //create obj file of path
        File TextFile = new File(FilePath);

        //check path is exists
        if (!TextFile.exists()) {

            //throw exception
            throw new Exception("Path not Exists!");
        }

        //check for path is a file
        if (!TextFile.isFile()) {

            //throw exception
            throw new Exception("Path is not a file!");
        }

        //create list of array of strings for saving 
        ArrayList<String[]> TokenArrays = new ArrayList<>();

        //try catch blocks
        try (BufferedReader BufferReader = Files.newBufferedReader(Path.of(FilePath))) {

            //string variable for saving lines after reading for adding to list
            String Line;

            //read lines
            while ((Line = BufferReader.readLine()) != null) {

                //split lines to numbers(tokens)
                //string array for save splitted tokens
                String[] Tokens = Line.trim().split("\\s+");

                //add tokens array to list
                TokenArrays.add(Tokens);
            }

        } //catch errors in reading file 
        catch (IOException e) {

            //printing file reading error
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        //get size of matrix
        int n = TokenArrays.size();

        //declaring 
        Out = new int[n][n];

        //casting tokens to numbers
        for (int i = 0; i < n; i++) {

            //getting tokens 
            String[] Tokens = TokenArrays.get(i);

            //check for equation rows and columns length
            if (Tokens.length != n) {

                //throw exception
                throw new Exception("Numbers in this file can not make a matrix, length of some rows not equals with number of columns!");
            }

            //create a boolean flag for handling errors
            boolean CastingErr = false;

            //casting string numbers to integer
            for (int j = 0; j < n; j++) {
                try {

                    //casting string to integer
                    Out[i][j] = Integer.parseInt(Tokens[j]);

                } catch (NumberFormatException e) {

                    //printing casting error
                    System.err.println("Error in casting file data: " + e.getMessage());

                    //make flag true
                    CastingErr = true;

                    //break for exit from loop
                    break;
                }
            }

            //check error flag 
            if (CastingErr) {

                //throw exception
                throw new NumberFormatException("Some tokens can not casting string to integer!");
            }
        }

        //return final matrix
        return Out;
    }
}
