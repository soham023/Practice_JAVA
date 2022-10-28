public class Mod_22_BackTracking {

    public static void PrintArr(int arr[]) {
        for(int i = 0; i < arr.length; i++ ){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
    }
    public static void ChangeArr(int arr[], int i , int val) {
        if(i == arr.length){
            System.out.print("at the time of base case array is : ");
            PrintArr(arr);
            return;
        }
        
        //recursion
        arr[i] = val;
        ChangeArr(arr, i+1, val+1); // recursion function call
        arr[i] = arr[i] - 2; //backtracking step
    }

    // public static void Print_String(String str) {
        
    // }
    public static void Subset_of_String(String str ,  int i ,  String subset) {
        
        // base case
        if(i == str.length()){
            System.out.println(subset);
            return;
        }
        //recursion
        //yes Add
        Subset_of_String(str, i+1, subset+str.charAt(i));
        //No Add
        Subset_of_String(str, i+1, subset);

    }

    //Find permutation
    public static void Find_Permutations(String str , String permutation) {
        
        //base case
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }

        //recursion
        for(int i = 0 ; i < str.length() ; i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0 , i)  +  str.substring(i+1);  // deleting the string
            Find_Permutations(Newstr, permutation + curr);
        }
    }

    // N-Queen no attack // time complexity --> O(N^N)
    public static void printBoard_NoAttack(char board[][]) {
        System.out.println("-------Chess Board when Queen don't attack each other-------");
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j< board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void N_Queen(char board[][] , int row) {
        //base case
        if(row == board.length){
            printBoard_NoAttack(board);
            return;
        }
        //column loop
        for(int j = 0 ; j<board.length ; j++){
            board[row][j] = 'Q' ;
            N_Queen(board, row+1); // function call
            board[row][j] = 'x' ; // backtracking step
        }
    }


    // N-Queen Attack Mode // time complexity --> O(N!)

    public static boolean isSafe(char board[][] , int row , int col) {
        //vertical up
        for(int i = row - 1 ; i >= 0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonal left up
        for(int i = row-1 , j = col-1; i>=0 && j>=0; i--,j--  ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonal right up
        for(int i = row-1 , j = col+1; i>=0 && j < board[0].length; i--,j++  ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    public static void printBoard_Attack(char board[][]) {
        
        System.out.println("-------Chess Board when Queen attack each other-------" );
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j< board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    
    }

    static int count = 0 ; 
    public static void N_Queen_Attack(char board[][] , int row ) {
        //base case
        if(row == board.length){
            count++;
            System.out.println(count+". Solution");
            printBoard_Attack(board);
            
            return;
        }
        //column loop
        for(int j = 0 ; j<board.length ; j++){

            if(isSafe(board , row , j)){
                board[row][j] = 'Q' ;
                N_Queen_Attack(board, row+1); // function call
                board[row][j] = 'x' ; // backtracking step
            }
            
            
        }

        
    }


    // only one solution of N-Queen Attack Mode
    public static boolean isSafe_One_Sol(char board[][] , int row , int col) {
        //vertical up
        for(int i = row - 1 ; i >= 0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonal left up
        for(int i = row-1 , j = col-1; i>=0 && j>=0; i--,j--  ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonal right up
        for(int i = row-1 , j = col+1; i>=0 && j < board[0].length; i--,j++  ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    public static void printBoard_Attack_One_Sol(char board[][]) {
        System.out.println("-------Chess Board when Queen attack each other-------");
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j< board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int cnt = 0 ; 
    public static boolean N_Queen_Attack_One_Sol(char board[][] , int row ) {
        //base case
        if(row == board.length){
            //printBoard_Attack_One_Sol(board);
            cnt++;
            return true;
        }
        //column loop
        for(int j = 0 ; j<board.length ; j++){

            if(isSafe_One_Sol(board , row , j)){
                board[row][j] = 'Q' ;

                if(N_Queen_Attack_One_Sol(board, row+1)){
                    return true;
                }
                board[row][j] = 'x' ; // backtracking step
            }
        }
        return false;

        
    }

    // Grid Ways count
    public static int Grid_Ways(int i , int j , int n , int m) {
        if(i == n-1 && j == n-1){
            return 1;
        }
        else if(i == n || j == n){
            return 0;
        }

        int w1 = Grid_Ways(i+1, j, n, m);
        int w2 = Grid_Ways(i, j+1, n, m);
        return w1+w2;
    }

    // Grid ways Optimised
    public static int factorial(int n) {

        if(n == 0){
            return 1;
        }

        return n*factorial(n-1);

    }
    public static int Grid_Ways_Optimised( int n , int m) {
        int Grid_ways = factorial(n+m-2)/(factorial(n-1)*factorial(m-1));
        return Grid_ways;
    }


    // Sudoku Code
    public static void Sudoku_Code() {
        
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        ChangeArr(arr, 0, 1);
        System.out.print("after returning by backtracking on main function array is : ");
        PrintArr(arr);
        String str = "xyz";
        System.out.println("Subsets are : ");
        Subset_of_String(str , 0, "");
        System.out.println("Permutations are : ");
        Find_Permutations(str, "");

        // N-Queen Non-Attack Mode
        System.out.println("N-Queen non Attack mode");
        int n = 3;
        char board[][] = new char [n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<n ; j++){
                board[i][j] = 'x';
            }
        }
        //N_Queen(board , 0);
        

        // N-Queen Attack Mode
        System.out.println("N-Queen Attack mode");
        int N = 5;
        char ChessBoard[][] = new char [N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < N ; j++){
                ChessBoard[i][j] = 'x';
            }
        }
        N_Queen_Attack(ChessBoard, 0 );
        System.out.println("No of solutions in attack mode : " + count);


        System.out.println("N-Queen Attack mode One Solution");
        int p = 3;
        char Chess[][] = new char [p][p];
        for(int i = 0 ; i < p ; i++){
            for(int j = 0; j < p ; j++){
                Chess[i][j] = 'x';
            }
        }
        if(N_Queen_Attack_One_Sol(Chess, 0)){
            printBoard_Attack_One_Sol(Chess);
        }
        else{
            System.out.println("Solution not possible for p = "+ p);
        }


        System.out.println(Grid_Ways(0, 0, 3, 3));
        System.out.println(Grid_Ways_Optimised(3, 3));
    }
}
