import java.util.*;
public class Mod_20_RecursionBasics {
    

    // Decreasing Order
    public static void RecursionPrint_numbers_Descending(int n) {
        if(n==1){
            System.out.print(n + " ");
            return;
        } 
        
        else{
            System.out.print(n + " ");
            RecursionPrint_numbers_Descending(n-1) ;
        }
        
    }

    //Increasing Order
    public static void RecursionPrint_numbers_Ascending(int n) {
        if(n == 1){
            System.out.print(1 + " ");
            return;
        } 
        
        else{
           
            RecursionPrint_numbers_Ascending(n-1) ;
            System.out.print(n + " ");
        }
        
    }

    //Factorial
    public static int Recursive_Factorial(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        else{
            return n*Recursive_Factorial(n-1);
        }
        
    }
    //Sum of natural numbers
    public static int Sum_Of_N_natural_numbers_Recursive(int n) {
        if(n == 0 ){
            return 0;
        }
        else{
            return n + Sum_Of_N_natural_numbers_Recursive(n-1);
        }

    }

    // Nth Fibonacci Number
    public static int Nth_Fibonacci(int n) {
        if(n == 0 || n == 1 ){
            return n;
        }
        else{
            return Nth_Fibonacci(n-2)+Nth_Fibonacci(n-1);
        }

    }

    // Check if an array is sorted or not
    public static boolean Check_Array_Sorted_or_Not(int arr[] , int i) {
        if(i == arr.length - 1){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }
        else{
            return  Check_Array_Sorted_or_Not(arr, i+1);
        }
    }

    //last Occurence
    public static int Last_Occurence(int arr[], int i, int key) {
        if(i == arr.length){
            return -1;
        }
        //1st Look Forward & then compare with self
        int isFound = Last_Occurence(arr, i+1, key);
        // if(isFound != -1){
        //     return isFound;
        // }

        // //check with self
        // if(arr[i] == key){
        //     return i ;
        // }
        // else{
        //     return -1;
        // }

        //optimized
        if(isFound == -1 && arr[i] == key){
            return i ;
        }
        return isFound;
    }

    //First Occurence
    public static int First_Occurence(int arr[], int i, int key) {
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        else{
            return First_Occurence(arr, i+1, key);
        }
    }

    //Print X^n
    public static int x_Power_n(int x , int n) {
        if(n == 0){
            return 1;
        }
        else{
            return x * x_Power_n(x, n-1);
        }
    }

    //Optimized X^n
    public static int Optimized_Power(int x , int n) {
        if(n == 0){
            return 1;
        }

        
        // if(n%2 == 0){
        //     return Optimized_Power(x, n/2)*Optimized_Power(x, n/2);
        // }
        // else{
        //     return x*Optimized_Power(x, n/2)*Optimized_Power(x, n/2);
        // }

        //More Optimised
        int halfPower =  Optimized_Power(x, n/2);
        int halfPowersq = halfPower * halfPower;
        if(n%2 == 0){
            return halfPowersq;
        }
        else{
            return x*halfPowersq;
        }
    }
    //Tiling Problem
    public static int Tiling_Problem(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        // horizontal way
        int horizontalWays = Tiling_Problem(n-2);
        // Vertical way
        int verticalWays = Tiling_Problem(n-1);

        int totalWays = horizontalWays + verticalWays;
        return totalWays;
    }
    //Remove Duplicates in string{'a' - 'z'}
    public static void Remove_Duplicates(String str , int index, StringBuilder newStr , boolean map[] ) {
        //base case
        if(index == str.length()){
            System.out.println(newStr);
            return;
        }

        //work
        char currChar = str.charAt(index);
        if(map[currChar - 'a'] == true ){
            //duplicate
            Remove_Duplicates(str, index+1, newStr, map);
        }
        else{
            map[currChar -'a'] = true;
            Remove_Duplicates(str, index+1, newStr.append(currChar), map);
        }
    }

    //  Friends Pairing Problem
    public static int Friends_Pairing(int n) {
        if(n == 1 || n == 2){
            return n;
        }

        int singleWays = Friends_Pairing(n-1);
        int pairingWays = (n-1) * Friends_Pairing(n-2);
        int totalWays = singleWays + pairingWays; 

        return totalWays;
    }

    //Binary Strings Problem without consecutive 1s
    public static void Binary_Strings_Problem(int n , String str, String lastPlace) {
        if(n == 0){
            System.out.println(str);
            return;
        }

        if(lastPlace == "0"){
            //sit 0 on chair N
            Binary_Strings_Problem(n-1, str+"0", "0" );
            Binary_Strings_Problem(n-1, str+"1", "1");
        }
        else if (lastPlace == "1"){
            Binary_Strings_Problem(n-1, str+"0", "0");
        }


        //more better way to write above comment part
        // Binary_Strings_Problem (n-1, str+"0", "0");
        // if(lastPlace == "0"){
        //     //sit 0 on chair n
        //     Binary_Strings_Problem(n-1, str+"1", "1");
        // } 
    }


    //All occurences 
    public static void All_Occurences(int arr[] , int i , int key ) {
        if(i == arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i+" ");
            // All_Occurences(arr, i+1, key);
        }
        All_Occurences(arr, i+1, key);
    }

    public static void main(String[] args) {
        System.out.println("Decreasing Order");
        RecursionPrint_numbers_Descending(7);
        System.out.println();
        System.out.println("Increasing Order");
        RecursionPrint_numbers_Ascending(7);
        System.out.println();
        System.out.println("Factorial");
        System.out.println(Recursive_Factorial(5));
        System.out.println("Sum of natural numbers");
        System.out.println("Sum of N natural numbers");
        System.out.println(Sum_Of_N_natural_numbers_Recursive(8));
        System.out.println("Nth Fibonacci");
        System.out.println(Nth_Fibonacci(6));
        int arr[] ={1,2,4,5,6};
        System.out.println(Check_Array_Sorted_or_Not(arr, 0));
        int arr1[] = {3,4,2,6,9,9}; 
        System.out.println(Check_Array_Sorted_or_Not(arr1, 0));
        System.out.println("First Occurence");
        System.out.println(First_Occurence(arr1, 0, 9));
        System.out.println("Last Occurence");
        System.out.println(Last_Occurence(arr1, 0, 9));
        System.out.println("X to the power of N");
        System.out.println(x_Power_n(2, 4)); 
        System.out.println(Optimized_Power(2, 5));
        System.out.println("Tiling Problem");
        System.out.println("Total Ways : "+Tiling_Problem(3));
        System.out.println("Remove Duplicates");
        String str = "sohamsadhukhan";
        Remove_Duplicates(str, 0, new StringBuilder(), new boolean[26]);
        System.out.println("Friends Pairing");
        System.out.println(Friends_Pairing(3));
        System.out.println("Binary Strings Problem");
        Binary_Strings_Problem(3, "", "0");
        All_Occurences(arr1, 0, 9);


    }
}