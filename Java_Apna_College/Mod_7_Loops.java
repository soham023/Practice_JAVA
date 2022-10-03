import java.util.*;

public class Mod_7_Loops {
    public static void main(String[] args) {


    //WHILe LOOP
        //Print numbers from 1 to 10

        int counter = 1;

        while(counter <= 10 ){
            System.out.print(counter + " ");
            counter++;
        }
        System.out.println(" ");
        //Print numbers from 1 to N

        
        Scanner sc = new Scanner (System.in);
        int N = sc.nextInt();
        int count = 1;
        while(count <= N){
            System.out.print(count + " ");
            count++;

        }
        System.out.println(" ");

        //Sum of 1st N natuaral numbers
        int sum = 0;
        System.out.println("Enter the number upto natural num sum will be counted");
        int X = sc.nextInt();

        

        int naturalcount = 1;
        while(naturalcount <= X){
            sum += naturalcount;
            naturalcount++;
        }
        System.out.println("Sum of 1st N natural numbers : "+ sum);

       



        //FOR LOOP
        for (int i = 1; i <= 10; i++) {
        System.out.println("Hello WOrld");
        }

        // Reverse a Number
        System.out.println("Enter the number which will be reversed");
        int Num = sc.nextInt();
        
            while(Num > 0){
                int lastDigit = Num % 10;
                System.out.print(lastDigit);
                Num /= 10;
                
            }
            System.out.println(" ");

        //Reverse the original number
        System.out.println("Enter the number which will be reversed");
        int Number = sc.nextInt();
        int Reverse=0;
            while(Number > 0){
                int LastDigit = Number % 10;
                Reverse = Reverse*10 + LastDigit;
                Number /= 10;
            }
            System.out.println(Reverse);
        

        

        // do while loop 
        
        int  cnt = 1;
        do {

            System.out.println("Hello, Soham");
            cnt++;

        }  
      //while(false);
        while(cnt <= 10);

        // break
        for(int i=0; i<=10; i++){
            if(i==7){
                break;
            }
            System.out.print(i + " ");
            
        }
        System.out.println(" ");
        System.out.println("I'm out of the loop");



        // Keep entering a number till user enters a multiple of 10
        do{
            System.out.println("Enter Number");
            int number = sc.nextInt();
            if(number % 10 == 0){
                System.out.println("Number's fucked up!");
                break;
            }
            System.out.println("Your Entered number is "+number);

        }while(true);
        
        // continue 
        //Display all numbers entered by user except multiples of 10
        /*do{
            System.out.print("enter your number :");
            int num = sc.nextInt();
            if(num%10==0){
                System.out.println("Not displaying!");
                continue;
                
            }
            System.out.println("Your entered number is "+ num);

        }while(true);
         */


        // check if your entered number is prime or not!
        do{
            System.out.println("Enter your number");
            int n = sc.nextInt();
            boolean isPrime = true;
            if (n == 2){
                System.out.println("It's prime!");
            }
            else{
                for(int i=2; i<=Math.sqrt(n); i++){
                    if (n%i==0){
                        System.out.println("It's not Prime!");
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime == true){
                    System.out.println("It's Prime!");
                } 
            }
            
        }while(true);


        //Break & Continue Statement
    }

}
