import java.util.*;

public class Mod_15_Strings {

    // Input
    // public static void InputString(String str){
    //     Scanner sc = new Scanner(System.in);
    //     str = sc.nextLine();
    //     System.out.println(str);
    // }

    //Print letters by charAt method
    public static void CharAtMethod_PrintLetters(String str) {
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+"  ");
        }
        System.out.println();
    }

    //Check Palindrome
    public static boolean CheckPalindrome_String(String str) {
       int i = 0;
       int j = str.length()-1;
        while(i!=j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;

    }

    public static float ShortestPath_String(String str) {
        int Xth = 0;
        int Yth = 0;
        
        for(int i =0; i<str.length();i++){
            if(str.charAt(i) == 'N' || str.charAt(i) == 'n'){
                Yth++;
            }
            if(str.charAt(i) == 'E' || str.charAt(i) == 'e'){
                Xth++;
            }
            if(str.charAt(i) == 'S' || str.charAt(i) == 's'){
                Yth--;
            }
            if(str.charAt(i) == 'W' || str.charAt(i) == 'w'){
                Xth--;
            }
        }

        System.out.println("Xth : "+Xth);
        System.out.println("Yth : "+Yth);
        int displacement2 = (Xth*Xth + Yth*Yth);
        float displacement = (float)Math.sqrt(displacement2);

        return displacement;
    }

    //Substring
    public static String SubString( String str, int startIndex  , int endIndex ) {
        String substr = "";
        for(int i = startIndex ; i < endIndex; i++){
            substr += str.charAt(i);
        }
        System.out.println();
        return substr ;
    }

    
    //Largest_in_String_Lexicographically
    public static String LargestString(String str[]) {
        String largest = str[0];
        for(int i = 0; i < str.length ; i++){
            if(largest.compareTo(str[i]) < 0){
                largest = str[i];
            }
        } 
        return largest;   
    }

    //1stLetter of Every String converted to UpperCase
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase( str.charAt(0) );
        sb.append(ch);
        for(int i =1; i< str.length(); i++){
            if( str.charAt(i) == ' '  &&  i < str.length()-1 ){

                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            

            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // String Compression
    public static String String_Compression(String str) {
       
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i < str.length() ; i++){
            Integer frequency = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                frequency++;
                i++;
            }
            sb.append(str.charAt(i));
            if (frequency > 1) {
                sb.append(frequency.toString());
            }
        }

        return sb.toString();
    }

    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter String");
        
        
        String str ="";
        str= sc.nextLine();

        System.out.println("New String After Compression : "+String_Compression(str));

        
        System.out.print("Letters are : ");
        CharAtMethod_PrintLetters(str);
        System.out.println("String is : "+str);

        if(CheckPalindrome_String(str)==true){
            System.out.println("This is a Palindrome");
        }
        else{
            System.out.println("Not a Palindrome!");
        }

        System.out.println("Shortest Path : "+ ShortestPath_String(str));

        String s1 = "Soham";
        String s2 = "Soham";
        String s3 = new String("Soham");


        if(s1 == s2){
            System.out.println("Strings are Equal");
        }
        else{
            System.out.println("Strings are not equal");
        }
        // When We're making a string by using new keyword , we can't use == for comparison of string
        System.out.println("When We're making a string by using new keyword , we can't use == for comparison of strings");
        if(s1 == s3){
            System.out.println("Strings are Equal");
        }
        else{
            System.out.println("Strings are not equal");
        }
        // When We're making a string by using new keyword , we can't use == for comparison of string, We have to use .equals()
        System.out.println("When We're making a string by using new keyword , we can't use == for comparison of string, We have to use .equals()");
        if(s1.equals(s3)){
            System.out.println("Strings are Equal");
        }
        else{
            System.out.println("Strings are not equal");
        }

        System.out.println("Enter StartIndex");
        int startIndex = sc.nextInt();
        System.out.println("Enter EndIndex");
        int endIndex = sc.nextInt();
        System.out.println("Substring from " + startIndex + " to " + endIndex + " : " +  SubString(str,startIndex, endIndex));

        String fruits[] = {"apple","mango","banana", "Guava"};
        
        // String largest = fruits[0];
        // for(int i = 0; i < fruits.length ; i++){
        //     if(largest.compareTo(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // } 
        // System.out.println(largest);
        
        System.out.println("Largest String : "+LargestString(fruits));


        StringBuilder sb = new StringBuilder("");
        for( char ch = 'a' ; ch <= 'z'; ch ++ ){
            sb.append(ch);
        }

        // //  StringBuilder --> O(26)/ O(N)
        // // if we take String & use += instead of StringBuilder & append --> O(*N^2)
        System.out.println(sb);
        

        Integer a = 10; // here we can use .toString() 
        //int a=10; --> can't use .toString() here

        a.toString();
        System.out.println(a);

        //UpperCaseConversion of 1st Character of each & every element
        System.out.println("UpperCase Converted String is : "+toUpperCase(str));
    }
}
