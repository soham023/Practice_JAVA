import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Mod_16_String_Assignments {

    // String 1st Assignment
    // Count lower case vowels
    public static int CountlowerCaseVowels(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'|| str.charAt(i) == 'o'||str.charAt(i) == 'u'){
                count++;
            }
        }
        return count;

    }


    //String 4th Assignment
    //Check anagram or not (eg: race , care are anagrams)

    public static void CheckAnagram(String str1 , String str2){
        
        

        System.out.println("1st String : "+str1);
        System.out.println("2nd String : "+str2);

        
        
        //Convert string to lower case because we don't have to deal with upper case separately 
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){

            //convert string to char array because we can't sort them in string format
            
            char charArray1[] = str1.toCharArray();
            char charArray2[] = str2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            if(Arrays.equals(charArray1,charArray2)){
                System.out.println(str1 +" and " + str2 + " are anagrams " );
            }
            else{
                System.out.println( str1 +" and " + str2 + " are not anagrams ");
            }

        }
        else{
            System.out.println(str1 +" and " + str2 + " are not anagrams ");
        }
    }


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);
        // String 1st Assignment
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println("Count of Lower Case Vowels : "+ CountlowerCaseVowels(str));

        //String 2nd Assignment
        String Str1 = "Soham Sadhukhan";
        String Str2 = "GCECT";
        String Str3 = "Soham Sadhukhan";
        System.out.println(Str1.equals(Str2)+" "+ Str1.equals(Str3));
        
        //String 3rd Assignment
        String str2="ApnaCollege".replace("l","");
        System.out.println(str2);

        //checkAnagram
        System.out.println("Enter 1st string");
        String st1 = br.readLine();
        System.out.println("Enter 2nd String");
        String st2 = br.readLine();
        
        //Check Anagrams or not
        CheckAnagram(st1, st2);

        sc.close();
        br.close();
    }
}
