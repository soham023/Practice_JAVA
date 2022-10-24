public class Mod_21_Divide_Conquer {

    public static void PrintArray(int arr[]){
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void MergeSort(int arr[], int si , int ei ) {
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;
        MergeSort(arr, si, mid);    // Left part
        MergeSort(arr, mid+1 , ei);  // Right Part
        Merge(arr, si , ei , mid);
    }

    public static void Merge(int arr[] , int si , int ei , int mid) {
        int temp [] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0;

        while(i <= mid && j <= ei ){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            } 
            else{
                temp[k] = arr[j];
                j++;
                k++;
            }


        }
        //for left remaining elements
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        //For right remaining elements
        while(j <= ei ){
            temp[k++] = arr[j++];
        }

        //copy temp to original array 
        for(k=0,i=si ; k < temp.length; k++,i++){
            arr[i] = temp[k]; 
        }

    }


    // Quick Sort
    public static void Quick_Sort(int arr[], int si , int ei) {
        if(si >= ei){
            return;
        }
        //last element
        int pivotIndex = partition(arr, si , ei);
        Quick_Sort(arr, si, pivotIndex - 1 );
        Quick_Sort(arr, pivotIndex + 1, ei);
    }

    public static int partition(int arr[] , int si , int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot

        for(int j = si; j < ei ; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i]; 
                arr[i] = temp; 
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i]; // pivot = arr[i] --> pivot is a variable change in variable within function can't reflect in main function because of call by value
        arr[i] = temp;
        return i;
    }


    //Search in rotated and sorted array
    public static int Search_in_Rotated_Sorted_Array(int arr[] , int Target , int si , int ei) {

        //base case
            if(si > ei){
                return -1;
            }


            int mid = si+(ei - si)/2;
            if(arr[mid] == Target){
                return mid;
            }

            if(arr[si] <= arr[mid]){
                if(arr[si]<=Target&& Target<= arr[mid]){
                    return Search_in_Rotated_Sorted_Array(arr, Target , si, mid-1);
                }
                else{
                    return Search_in_Rotated_Sorted_Array(arr, Target, mid+1, ei);
                }
                
            }
            else{
                if(arr[mid]< Target && Target <= arr[ei]){
                    return Search_in_Rotated_Sorted_Array(arr, Target, mid+1, ei);
                }
                else{
                    return Search_in_Rotated_Sorted_Array(arr, Target, si, mid-1);
                }
            }



        
        
    }
    public static void main(String[] args) {
        int arr1[] = {3,4,2,6,9,9}; 
        MergeSort(arr1, 0, arr1.length-1 );
        PrintArray(arr1);
        
        int arr[] = {4,7,2,6,9,1};
        Quick_Sort(arr, 0, arr.length-1);
        PrintArray(arr);

        int arr2[] = {4,5,6,7,0,1,2};
        int targetIndex = Search_in_Rotated_Sorted_Array(arr2, 6, 0, arr.length - 1);
        System.out.println("targetIndex is : "+ targetIndex);
    }
}
