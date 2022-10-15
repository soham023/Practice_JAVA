import java.util.*;
import java.util.Arrays;
import java.util.Collections;
public class Mod_13_sorting {
    public static void Bubble_Sort(int arr[]) {

        for(int turn = 0; turn < arr.length-1; turn++){

            for(int j = 0; j < arr.length-1-turn; j++ ){ 

                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        
    }

    // public static int compare(int a, int b){
    //     // a < b -ve
    //     // a == b 0
    //     // a > b +ve
    //     return a-b;
    // }

    // if already sorted array is given
    public static void Bubble_Sort_Optimized(int []arr) {
        System.out.println("Using Bubble Sort");
        for(int turn = 0; turn <arr.length - 1; turn++){
            int swaps = 0;
            for(int j = 0; j < arr.length-1-turn; j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps ++;
                }
            }
            System.out.println("swaps "+ "at " +turn+"th turn :" +swaps);
            if(swaps == 0){
                break;
            }
        }
    }

    //Selection Sort
    public static void Selection_Sort(int arr[]) {
        System.out.println("Using Selection Sort");
        int smallest = Integer.MAX_VALUE ;
        for(int i = 0; i < arr.length - 1; i++){
            int minPos = i;
            for(int j = i+1; j< arr.length ; j++){
                     if(arr[minPos] > arr[j]){
                        minPos = j;
                     }
            }
            //swap with outer loop
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }

    }

    //Insertion Sort
    public static void Insertion_Sort(int arr[]) {

        System.out.println("Using Insertion Sort"); 
        for(int i = 1; i<arr.length; i++ ){
            int curr = arr[i];
            int prev = i-1;
            //Finding out the correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;      
            }
            //insertion
            //Why prev+1 ? --> because of prev--, prev position has gone to its previous position than before
            arr[prev+1] = curr;
        }
    }
    

    //Counting Sort
    public static void Counting_Sort(int arr[]) {

        System.out.println("Using Counting Sort");

        //size --> largest 
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length ; i++){
            largest = Math.max(largest, arr[i]);
        }


        int CountArr[] = new int[largest + 1];
        //Frequency Count
        for(int i = 0; i < arr.length ; i++){
            CountArr[arr[i]]++;
        }
        System.out.println();


        System.out.println("Count Array");
        PrintArray(CountArr);

        //sorting
        int j=0;
        for(int i =0 ; i < CountArr.length ; i++){
            while(CountArr[i]>0){
                arr[j] = i;
                j++;
                CountArr[i]--;
            }
        }
        System.out.println("");

        System.out.println("Array after Count Sort");
        PrintArray(arr);
    }

    //Input Array
    public static void InputArray(int arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Inputs in the Array");
        for(int i = 0; i<arr.length ; i++){
            arr[i]=sc.nextInt();
        }
    }
    
    
    //Print Array
    public static void PrintArray(int arr[]) {
        System.out.print("The Array is : ");
        System.out.print("[ ");
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void PrintArrayObject(Integer arr[]) {
        System.out.print("The Array is : ");
        System.out.print("[ ");
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {1,4,1,3,2,4,3,7};
        Counting_Sort(arr);

        System.out.println("Enter size of Array");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        
        InputArray(numbers);
        PrintArray(numbers);

        

        System.out.println("InBuilt Sort according to user input(start index , end index)");
        System.out.println("Enter Start Index");
        int startIndex = sc.nextInt();
        System.out.println("Enter End Index");
        int endIndex = sc.nextInt();


        Integer array[]={5,6,7,8,3,9,4};

        //Descending Order Inbuilt Sort
        //Only works on Object , don't work on primitive
        System.out.println("Descending Order Inbuilt sort according user input (start index , end index)");
        Arrays.sort(array, startIndex, endIndex+1 , Collections.reverseOrder());
        PrintArrayObject(array);

        System.out.println("Ascending Order Inbuilt sort ");
        Arrays.sort(numbers,startIndex, endIndex + 1);
        PrintArray(numbers);

        Bubble_Sort_Optimized(numbers);
        PrintArray(numbers);

        Selection_Sort(numbers);
        PrintArray(numbers);

        Insertion_Sort(numbers);
        PrintArray(numbers);
        
        System.out.println("Using Inbuilt Sort");
        Arrays.sort(numbers);
        PrintArray(numbers);

        System.out.println("Reverse Order Using Inbuilt Sort");
        Arrays.sort(array, Collections.reverseOrder());        
        
        

    }
}
