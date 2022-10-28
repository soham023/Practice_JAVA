import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class Mod_23_ArrayList {


    // SWAP
    public static void Swap(ArrayList<Integer> list , int idx1 , int idx2) {
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2 , temp);
    }

    //Brute Force (Container with Most Water)
    public static int Container_with_MostWater_Brute_Force(ArrayList<Integer>Height) {
        int maxWater = 0;
        for(int i = 0; i<Height.size(); i++){
            for(int j = i+1; j<Height.size(); j++){
                int Ht = Math.min(Height.get(i), Height.get(j));
                int width = j - i;
                int Water = Ht * width;
                maxWater = Math.max(maxWater, Water);
            }
        }
        return maxWater;
        
    }

    //2 Pointer Approach --> Container with most water
    public static int Container_with_MostWater_2_Pointer_Approach(ArrayList<Integer>list) {
        int leftPtr = 0;
        int RightPtr = list.size() - 1;
        int maxWater = 0;
        while(leftPtr < RightPtr){
            int Ht = Math.min(list.get(RightPtr), list.get(leftPtr));
            int width = RightPtr - leftPtr;
            int Water = Ht * width;
            maxWater = Math.max(maxWater, Water);
            if(list.get(leftPtr) < list.get(RightPtr)){
                leftPtr++;
            }
            else // if(list.get(RightPtr) < list.get(leftPtr))
            {
                RightPtr--;
            }
        }
        return maxWater;       
    }

    // Brute Force Pair_Sum-I
    public static boolean PairSUM_1_Brute_Force(ArrayList<Integer>list , int targetSUM) {
        for(int i = 0 ; i < list.size(); i++){
            for(int j = i+1 ; j < list.size(); j++){
                if(list.get(i)+list.get(j) == targetSUM) {
                    //System.out.println(i+","+j );
                    return true;
                }
                
            }
            System.out.println();
        }
        return false;
    }
    
    // 2 Pointer Approach Pair_SUM-I
    public static boolean _2_PointerApproach_PairSUM_1(ArrayList<Integer>list , int targetSUM) {
        int i = 0;
        int j = list.size() - 1;
        while(i != j){
            if((list.get(i) + list.get(j)) == targetSUM ){
                return true;
            }
            if((list.get(i) + list.get(j)) > targetSUM ){
                j--;
            }
            if((list.get(i) + list.get(j)) < targetSUM ){
                i++;
            }
        }
        return false;

    }

    // PairSUM-2 __2 Pointer Approach // 
    public static boolean _2_Pointer_Approach_PairSUM_2( ArrayList<Integer>list , int targetSUM ) {
        int smallest_Index = -1;
        int largest_Index = -1;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) > list.get(i+1)){
                smallest_Index = i+1;
                largest_Index = i;
                break;
            }
        }
        while( smallest_Index != largest_Index){
            if(list.get(smallest_Index) + list.get(largest_Index) == targetSUM){
                return true;
            }
            if(list.get(smallest_Index) + list.get(largest_Index) > targetSUM){
                largest_Index = ( list.size()+largest_Index-1 ) % list.size();
            }
            if(list.get(smallest_Index) + list.get(largest_Index) < targetSUM){
                smallest_Index = ( smallest_Index + 1 ) % list.size();
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        ArrayList <String> list1 = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        
        int element = 1;
        for(int i = 0; i < 4; i++ ){
            list.add(element);
            element++;
        }
        System.out.println(list);

        list.add(6);
        System.out.println(list);
        

        //Get Operation
        System.out.println(list.get(2));

        // Delete Element
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());


        //set element at index
        list.set(2, 7);
        System.out.println(list);

        //contains element or not
        System.out.println(list.contains(7));
        System.out.println(list.contains(3));

        list.add(0, 20); // O(n)
        System.out.println(list);


        System.out.println(list.size());

        //printing arraylist
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        
        //Print Reverse of an arraylist
        for(int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //Max in arraylist
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println(max);

        Swap(list, 1,4 );
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        // for descending sort
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        //comparator -- fnx logic
        
        //Multi Dimensional ArrayList
        ArrayList<ArrayList<Integer>>mainList = new ArrayList<>();

        ArrayList<Integer>list3 = new ArrayList<>();
        for(int i=1; i<=5; i++){
            list3.add(i);
        }
        mainList.add(list3);
        
        ArrayList<Integer>list4 = new ArrayList<>();
        for(int i = 1; i<=5 ; i++){
            list4.add(i*2);
        }
        mainList.add(list4);

        ArrayList<Integer>list5 = new ArrayList<>();
        for(int i = 1; i<=5 ; i++){
            list5.add(i*3);
        }
        mainList.add(list5);

        for(int i=0 ; i<mainList.size(); i++){
            ArrayList <Integer> currlist = mainList.get(i);    
           for(int j = 0 ; j < currlist.size();j++ ){
            System.out.print(currlist.get(j)+" ");
           }
           System.out.println();
        }

        System.out.println(mainList);

        ArrayList<Integer>list6 = new ArrayList<>();
        list6.add(1);
        list6.add(8);
        list6.add(6);
        list6.add(2);
        list6.add(5);
        list6.add(4);
        list6.add(8);
        list6.add(3);
        list6.add(7);
        System.out.println("MaxWater is : "+Container_with_MostWater_Brute_Force(list6));

        System.out.println("2-Pointer Approach : "+ Container_with_MostWater_2_Pointer_Approach(list6));
        
        ArrayList<Integer>list7 = new ArrayList<>();
        for(int i = 1; i<=6; i++){
            list7.add(i);
        }
        System.out.println( PairSUM_1_Brute_Force(list7, 5) );
        System.out.println(_2_PointerApproach_PairSUM_1(list7,5));

        ArrayList<Integer>list8 = new ArrayList<>();
        list8.add(11);
        list8.add(15);
        list8.add(6);
        list8.add(8);
        list8.add(9);
        list8.add(10);
        System.out.println(_2_Pointer_Approach_PairSUM_2(list8, 21));
    }
}
