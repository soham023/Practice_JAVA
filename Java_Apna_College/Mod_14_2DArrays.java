import java.security.Key;
import java.util.*;
public class Mod_14_2DArrays {

    //Input 2D Array
    public static void Input2DArray(int arr[][]) {
        Scanner sc = new Scanner(System.in);        
        int row = arr.length;
        int col = arr[0].length;

        System.out.println("Enter Elements");
        for(int i = 0 ; i < row; i++ ){
            for(int j = 0 ; j < col ; j++){
                arr[i][j] = sc.nextInt();
            }
        }    
    }

    // Output 2D Array
    public static void Output2DArray(int matrix[][]) {
        System.out.println("The 2D Array / Matrix is : ");
        for(int i = 0; i< matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Search in 2D Array
    public static boolean Search(int matrix[][], int key) {
        for(int i = 0; i< matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                if( matrix[i][j] == key){
                    System.out.println("Found at cell: ("+i+","+j+")");
                    return true;
                }

            }
            
        }
        System.out.println("Key not found");
        return false;
    }

    //Print the Matrix  in a spiral way
    public static void PrintSpiralMatrix(int matrix[][]) {
        System.out.print("Spiral: ");
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(startRow <= endRow && startCol <= endCol ){
            //Top Boundary
            for(int j = startCol; j <= endCol; j++ ){
                System.out.print(matrix[startRow][j]+"  ");
            }
            //Right Boundary
            for(int i = startRow + 1; i<= endRow; i++){
                System.out.print(matrix[i][endCol]+"  ");
            }
            //Bottom Boundary
            for(int j = endCol - 1; j>=startCol; j--){
                if( startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j]+"  ");
            }
            //Left Boundary
            for(int i = endRow-1; i>=startRow + 1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+"  ");
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        System.out.println();
        
    }

    // Diagonal Sum
    public static int Diagonal_Sum_In_Matrix_BruteForce(int matrix[][]) {
        int sum = 0;
        for(int i = 0; i<matrix.length ; i++){
            for(int j = 0; j<matrix[0].length; j++){

                //Primary Diagonal
                if(i==j){
                    sum += matrix[i][j];
                }

                //Secondary Diagonal
                if( i+j== matrix.length-1 && i!= matrix.length-1-i){
                    sum += matrix[i][j];
                }

            }
        }
        return sum;
    }

    public static int Diagonal_Sum_In_Matrix_Optimized(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length;i++){
            // Primary Diagonal 
            sum += matrix[i][i];
            // Secondary Diagonal
            if(i!=matrix.length-1-i ){
                sum += matrix[i][matrix.length-1-i];
            }
            
        }
        return sum;
    }
    //Search a key in sorted Matrix
    public static boolean Search_In_Sorted_Matrix(int matrix[][],int key) {
        // here We'are considering TopMost Right Point as our starting point
        
        // int row = 0; 
        // int col =matrix[0].length-1;
        // while(col>=0 && row < matrix.length){
        //     if(key == matrix[row][col]){
        //         System.out.println("key found at index : ("+row+","+col+")");
        //         return true;
        //     }
        //     else if(key < matrix[row][col]){
        //         col--;
        //     }
        //     else{
        //         row++;
        //     }
        // }
        // System.out.println("Key not Found!");
        // return false;

        //here We're considering leftmost Bottom Element as our starting Point
        int row = matrix.length - 1;
        int col = 0;
        while(row>=0 && col < matrix[0].length-1){
            if(key == matrix[row][col]){
                System.out.println("key found at index : ("+row+","+col+")");
                return true;
            }
            else if(key < matrix[row][col]){
                row --;
            }
            else{
                col++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter no of Rows");
        int row = sc.nextInt();
        System.out.println("Enter no of Columns");
        int col = sc.nextInt();


        int matrix[][] = new int[row][col];
        Input2DArray(matrix);
        //    int matrix[][] = {{1,2,3},
        //                     {4,5,6},
        //                     {7,8,9}};

        //Output
        Output2DArray(matrix);
        System.out.println("Enter Key ");
        int key = sc.nextInt();
        Search(matrix, key);
        PrintSpiralMatrix(matrix);
        System.out.println("Sum of Diagonals : "+ Diagonal_Sum_In_Matrix_BruteForce(matrix));
        System.out.println("Sum of Diagonals by Optimized Approach : "+ Diagonal_Sum_In_Matrix_Optimized(matrix));
        System.out.println("StairCase Search");
        System.out.println(Search_In_Sorted_Matrix(matrix, key));
    }
}
