import java.util.*;
public class Mod_12_Arrays {
    //Arrays as function arguments
    public static void update (int marks[]  , int nonchangable) { // arrays are passed as call by reference bt variables are passed as call by values
        nonchangable = 8;
        System.out.println("nonchangable in func = "+nonchangable);
        for(int i=0; i<marks.length; i++){
            marks[i]=marks[i]+1;
        }
    } 

    //linear search
    public static int linearSearch(int numbers[] , int key) {
        for(int i=0; i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            } 
        }
        return -1;
    }
    public static int linearSearchString( String fruits[], String key2) {
        for(int i=0; i<fruits.length; i++){
            if(fruits[i]==key2 ){
                return i;
            }
        }
        return -1;
    }

    //largest in an array

    //-infinity in java --> integer.MIN_VAlUE
    //+infinity in java --> integer.MAX_VALUE
    public static int largest_in_Array(int arr[]) {
        int largest = Integer.MIN_VALUE;   // -infinity
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){    
                largest = arr[i];
            }
        }
        return largest;
    }

    //Binary Search --> Pre-Requisite --> Always it will be sorted like a dictionary (Ascending / Descending)
    //Ascending Order
    public static int BinarySearch(int arr[] , int key) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                start = mid+1;
            }
            if(arr[mid] > key){
                end = mid-1;
            }
        }
        
        return -1;
    }
    //Descending order
    public static int BinarySearchDescending(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                start = mid+1;
            }
            if(arr[mid] < key){
                end = mid-1;
            }
        }
        
        return -1;
    }

    // Reverse an array
    public static void ReverseArray(int arr[]) {
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            // swap
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
    }

    //Pairs in an array
    public static void PairsInArray(int arr[]) {
        int totalPairs=0;
        for(int i=0;i<arr.length; i++){
            int curr = arr[i];
            for(int j=i+1; j<arr.length;j++){
                System.out.print( "("+curr+ " " + arr[j]+ ") " );
                totalPairs++;
            }
        }
        System.out.println();
        System.out.println("Total Pairs : "+totalPairs);
    }


    //Print SubArrays
    public static void PrintSubArrays(int arr[]) {
        //start of a subarray
        int totalSubArrays = 0;
        for(int i=0; i<arr.length ; i++){
            //end of a subarray
            for(int j=i; j<arr.length; j++){
                //start to end
                for(int k=i;k <=j ; k++){
                    System.out.print(arr[k] + " ");
                    
                }
                totalSubArrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total SubArrays are : "+totalSubArrays);

    }

    //SubArraySum
    public static void SubArraySum(int arr[]) {
        int subArraySum = 0;
        for(int i=0; i <arr.length;i++){
            for(int j=i; j<arr.length;j++){
                for(int k=i; k<=j;k++){
                    System.out.print(arr[k]+" ");
                    subArraySum+= arr[k];
                }
                System.out.println();
                System.out.println("sum " + subArraySum);
                subArraySum =0;
            }
            System.out.println();
        }
    }
    //MaxSubArraySum
    //BRUTE FORCE
    public static void MaxSubArraySumBruteForce(int arr[]) {
        int MAXSUM = Integer.MIN_VALUE;
        int subArraySum = 0;
        for(int i=0; i <arr.length;i++){
            for(int j=i; j < arr.length;j++){

                subArraySum =0;
                for(int k=i; k<= j;k++){
                    subArraySum+= arr[k];
                }
                
                if(MAXSUM < subArraySum){
                    MAXSUM = subArraySum;
                }
                
            }
        }
        System.out.println("MAXSubArray Sum by Brute Force : "+ MAXSUM) ;
    }

    //PrefixSUM
    public static void MaxSubArraySumPrefixSUM(int arr[]) {
        int currSUM = 0 ;
        int MAXSUM = Integer.MIN_VALUE ;

        //prefixarray
        
        int prefixArr[] = new int[arr.length];
        prefixArr[0] = arr[0];
        for(int i=1; i < prefixArr.length ; i++){
            prefixArr[i] =  prefixArr[i-1] + arr[i]; 
        }
        
        //maxsubarraysum calculation
        
        for(int i=0;i<arr.length; i++){
            int start = i;
            for(int j=i;j< arr.length;j++){
                int end = j;
                currSUM =  start == 0  ? prefixArr[end] : prefixArr[end] - prefixArr[start-1];
                if(MAXSUM < currSUM){
                    MAXSUM = currSUM;
                }
            }
            
            
        }
        System.out.println("MaxSubArrayPrefixSUM is : "+ MAXSUM);

    }

    //Kadane's Algorithm
    public static int smallestInArray (int arr[]){
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length ; i++){
                smallest = Math.max(smallest, arr[i]);
        }
        return smallest;
    }
    public static void Kadanes(int arr[]){
        int currSUM = 0;
        int maxSUM = Integer.MIN_VALUE;
        for( int i = 0; i<arr.length ; i++ ){

            currSUM += arr[i];
            if(currSUM < 0 ){
                currSUM = 0;
            }
            
            maxSUM = Math.max(maxSUM, currSUM);
            
        }
        if(maxSUM == 0){
            smallestInArray(arr);
        }
        System.out.println("MaxSUM of the array by Kadane's Algo is : "+ maxSUM);
    }
    
    //RainWaterTrapping Problem
    public static void RainWaterTrappingProblem(int arr[], int width){

        int leftMaxBoundary[]=new int [arr.length];
        int rightMaxBoundary[]=new int [arr.length];
        //leftMaxBoundaryArray
        leftMaxBoundary[0] = arr[0];
        for(int i=1; i< arr.length; i++){
            leftMaxBoundary[i] = Math.max(leftMaxBoundary[i-1],arr[i]);
        }
        //rightMaxBoundaryArray
        rightMaxBoundary[arr.length - 1] = arr[arr.length - 1];
        for(int i=arr.length - 2 ; i>=0 ; i--){
            rightMaxBoundary[i] = Math.max(rightMaxBoundary[i+1],arr[i]);
        }
        //volume
        int volume =0;
        for(int i=0; i<arr.length; i++){
            int waterLevel = Math.min(rightMaxBoundary[i],leftMaxBoundary[i]);
            volume  = volume + ((waterLevel - arr[i])*width) ;
        }
        System.out.println("Volume of trapped water : " + volume + " m^3");
        
    }

    //Best Time to Buy , Sell and Stock
    public static int Best_Time_to_Buy_Sell_Stock(int arr[]){
        int maxProfit = 0;
        int BuyPrice = Integer.MAX_VALUE;
        for(int i=1 ; i < arr.length ; i++){
            
            if(BuyPrice < arr[i]){
                BuyPrice = Math.min( arr[i-1],BuyPrice );
                int Profit = (arr[i] - BuyPrice);
                maxProfit = Math.max( Profit , maxProfit); // today's profit
            }
            else {
                BuyPrice = arr[i];
            }
            
        }
        return maxProfit ;
    }
    public static int Seatch_in_RotatedArray(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high ){
            int mid = low + (high - low)/2;
            if(nums[mid] == target ){
                return mid;
            }
                
            // search in left sorted part    
            if(nums[low] <= nums [mid]){
                if(nums[low] <= target && target <= nums[mid] ){
                    high = mid - 1;
                }
                else{
                    low = mid +1;
                }
            }

            //search in right sorted part
            else{
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }

            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //array creation
        int marks[] = new int[50];//we have not stored any numbers in this array yet.
        char charectars[] = {'a','c','e','m','p'};

        
        //input
        int MARKs[] = new int[100];
        System.out.println("Enter Physics Marks");
        MARKs[0] = sc.nextInt();
        System.out.println("Enter Chemistry Marks");
        MARKs[1] = sc.nextInt();
        System.out.println("Enter Mathematics Marks");
        MARKs[2] = sc.nextInt();

        System.out.println("Phy : " + MARKs[0]);
        System.out.println("Chem : " + MARKs[1]);
        System.out.println("Math : " + MARKs[2]);

        //update
        MARKs[2] = 100;
        System.out.println("Math : " + MARKs[2]);

        //Length of an array
        // System.out.println("Length of the array MARKs[] " + MARKs.length);
        // System.out.println("Length of the array marks[] " + marks.length);
        //System.out.println("Length of the array numbers[] " + numbers.length);
        //System.out.println("Length of the array fruits[] " + fruits.length);

        //Arrays as Function arguments
        int arrMarks[]={98,97,99};
        
        

        int nonchangable = 5;
        update(arrMarks , nonchangable);
        System.out.println("nonchangable in main = "+nonchangable);
        //print arrMarks
        for(int i = 0; i<arrMarks.length; i++){
            System.out.print(arrMarks[i]+" ");
        }
        System.out.println();


        //linear search

        String fruits[]= {"orange","mango","apple","banana"}; //size-->4
        // System.out.println("Enter key2");
        String key2 = "apple";
        int index = linearSearchString(fruits, key2);
        if(index == -1){
            System.out.println("Key2 not found");
        }
        else{
            System.out.println("index of key2 in numbers[] "+ index);
        }

        int numbers[] = {1,2,3,9,56,98,34,45,71}; // size -->9
        
        System.out.println("Enter key1");
        int key1 = sc.nextInt();
        int index2 = linearSearch(numbers, key1);
        if(index2 == -1){
            System.out.println("Key1 not found");
        }
        else{
            System.out.println("index of key1 in numbers[] "+ index2);
        }

        //Binary Search
        int keys[] = {2,7,8,9,23,45,67,90}; //should be an sorted array for binary search
        
        System.out.println("Enter key3");
        int key3 = sc.nextInt();
        System.out.println(BinarySearch(keys, key3)); 
        
        int index3 = BinarySearch(keys, key3);
        if(index3 == -1){
            System.out.println("Key3 not Found");
        }
        else{
            System.out.println("Key3 found at index : "+index3);
        }

        //BinarySearchDescending
        int keysDesc[] = {90, 68,32,23,12,4}; //Descending sorted Array
        System.out.println("Key found in a descending array at index : "+BinarySearchDescending(keysDesc, 23));
        

        // largest in an array

        int array[] = {2,9,3,90,34,12,344,12};
        System.out.println("Enter size of the array ");
        int size = sc.nextInt();
        int ars[]=new int[size];
        System.out.println("Enter numbers in the array ars[]");
        for(int i=0; i <ars.length; i++){
            ars[i]=sc.nextInt();
        }

        System.out.print("ars[] is : ");
        for(int i=0; i<ars.length; i++){
            System.out.print(ars[i]+" ");
        }
        System.out.println();
        
        
        System.out.println("largest in the array ars[] is "+largest_in_Array(ars));
        System.out.println("largest in the array array[] is "+largest_in_Array(array));
        
        //Pairs in an array
        System.out.print("Pairs in ars[] are : "); 
        PairsInArray(ars);
        
        //Print SubArrays
        System.out.println("SubArrays of ars[] : ");
        PrintSubArrays(ars);

        //MaxSubArraySUM
        SubArraySum(ars);
        MaxSubArraySumBruteForce(ars);
        MaxSubArraySumPrefixSUM(ars);
        Kadanes(ars);

        //RainwaterTrapping Problem
        System.out.println("RainWaterTrappingProblem");
        System.out.println();
        System.out.println("Enter Width");
        int width = sc.nextInt();
        RainWaterTrappingProblem(ars, width);
        System.out.println();

        System.out.println("MaxProfit : " + Best_Time_to_Buy_Sell_Stock(ars));

        //Search in a Rotated Array
        System.out.println("Enter Target");
        int target = sc.nextInt();
        System.out.println();
        System.out.println("Index in Rotated Array : "+Seatch_in_RotatedArray(ars, target));
        // Reverse an array
        ReverseArray(ars);
        System.out.print("Reversed Array of ars[] is : ");
        for(int i=0; i<ars.length; i++){
            System.out.print(ars[i]+" ");
        }
        System.out.println();

        sc.close();
        

   }
}

