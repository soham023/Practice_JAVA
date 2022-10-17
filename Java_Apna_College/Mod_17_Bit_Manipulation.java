import java.util.Scanner;

public class Mod_17_Bit_Manipulation {

    // Odd or Even
    public static void Check_Odd_Even(int number) {
        int bitMask = 1;
        if((number & bitMask) == 0){
            System.out.println("It's Even");
        }
        else  {
            System.out.println("It's Odd");
        }
    }

    // Get Ith Bit
    public static int GetIthBit(int number , int i) {
        int bitMask = (1 << i) ;
        if((number & bitMask)==0){
            return 0; //0
        }
        else{
            return 1; //1
        }

    }

    //Set Ith Bit
    public static int SetIthBit(int number , int i) {
        int bitMask = ( 1<< i );
        return (number | bitMask);
    }

    // Clear ith bit
    public static int ClearIthBit(int number , int i) {
        int bitMask = (~(1 << i));
        return (number & bitMask);
    }

    // Update ith bit
    public static int UpdateIthBit(int number , int i , int update) {
        if(update == 1){
            return SetIthBit(number, i);
        }
        else{
            return ClearIthBit(number, i);
        }
    }
    //Clear last i bits
    public static int Clearlast_IBits(int number ,  int i) {
        int bitMask = (~0)<<i;
        return number&bitMask;
    }

    // Clear range of bits
    public static int Clear_RangeofBits(int number , int starti, int endi){
        int bitMask1 = (~0) << (endi+1) ;
        int bitMask2 = ~((~0) << (starti)) ;
        // int bitMask2 = (1<<i)-1; // (2^i)
        return (number & (bitMask1|bitMask2)) ;

    }

    // Check Power of 2 or not!
    public static boolean Check_PowerOf2_or_not(int number) {
        if((number & (number-1))==0){
            return true;
        }
        else{
            return false;
        }
    }

    // Count Set Bit
    public static int CountSetBits(int number) {
        int count = 0;
        // int i=0;
        while(number > 0){
            // if(GetIthBit(number, i) != 0){
            //     count++;
            // }
            if((number & 1) != 0) {
                count++;
            }
            number = number >> 1 ;
        }
        return count;
    }

    // Fast Exponentiation
    public static int Fast_Exponentiation(int n , int a) {
        int ans = 1;
        
        while(n > 0){
            
            if((n & 1) != 0){
                ans = ans * a;
            }
            
            a = a * a;
            n = n >> 1;

        }
        return ans;
    } 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(5&6);
        System.out.println(5|6);
        

        System.out.println("Enter Number");
        int number = sc.nextInt();
        
        System.out.println("Set Bit Count : "+CountSetBits(number));

        if(Check_PowerOf2_or_not(number) == true){
            System.out.println("Number is Power of 2");
        }
        else{
            System.out.println("Number is not Power of 2");
        }
        
        
        System.out.println("Enter Start Index");
        int starti = sc.nextInt();
        System.out.println("Enter End Index");
        int endi = sc.nextInt();
        System.out.println("After Clearing bits from index-"+starti+" to index-"+ endi+" number is : " + Clear_RangeofBits(number, starti, endi));
        


        System.out.println("Enter i");
        int i = sc.nextInt();
        System.out.println("Enter UpdateBit");
        int updateBit = sc.nextInt();
        ClearIthBit(number, i);
        
        System.out.println("After Clearing last i bits number is : "+ Clearlast_IBits(number, i));
        System.out.println("After Update Ith Bit implementation number is : "+ UpdateIthBit(number, i, updateBit));
        System.out.println("After Clear Ith Bit implementation number is : " + ClearIthBit(number, i));
        System.out.println("After Set Ith Bit implementation number is : "+ SetIthBit(number, i)); 
        GetIthBit (number, i);

        System.out.println("Enter Base");
        int base = sc.nextInt();
        System.out.println("Enter Power");
        int power = sc.nextInt();
        System.out.println(base+"^"+power+" is : "+Fast_Exponentiation( power , base ));


    }
}
