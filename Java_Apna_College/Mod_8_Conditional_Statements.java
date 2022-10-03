import java.util.*;
public class Mod_8_Conditional_Statements {
    public static void main(String[] args) {
// if else   
        Scanner sc = new Scanner(System.in);    
        System.out.println("Enter Age");         
        int age = sc.nextInt();
        if(age >= 18){
            System.out.println("adult : drive , vote");
        }

        else if(age> 13 && age < 18){
            System.out.println("Teenager");
        }

        else{
            System.out.println("Not Adult");
        }

// Find Greater number

        
        System.out.println("Enter A");
        
        int A = sc.nextInt();
        System.out.println("Enter B");
        int B = sc.nextInt();

        if( A > B){
            System.out.println(A + " is larger");
        }
        else{
            System.out.println(B + " is larger");
        }

// Even or Odd

        System.out.println("Enter The number to check If it's even or odd");
        int N = sc.nextInt();
        if (N % 2 == 0){
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }

// Income Tax calculator
        System.out.println("Enter income");
        int income = sc.nextInt();
        int tax;
        if(income < 500000) {
            tax = 0;
            System.out.println("Tax is "+ tax);
        }
        else if(income >= 500000 && income < 100000){
            tax = income * 20/100;
            System.out.println("Tax is "+ tax);
        }
        else {
            tax = income*30/100;
            System.out.println("Tax is " + tax);
        }

// largest of 3 numbers
        System.out.println("Enter a");
        int a = sc.nextInt();
        System.out.println("Enter b");
        int b = sc.nextInt();
        System.out.println("Enter c");
        int c = sc.nextInt();
        if(a>b){
            if(a>c){
                System.out.println(a+" is largest");
            }
            else{
                System.out.println(c + " is largest");
            }
        }
        else{
            if(b>c){
                System.out.println(b + " is largest");
            }
            else{
                System.out.println(c + " is largest");
            }   
        }

// Largesy of 3 numbers using Ternary Operator        
        
        System.out.println("Enter x");
        int x = sc.nextInt();
        System.out.println("Enter y");
        int y = sc.nextInt();
        System.out.println("Enter z");
        int z = sc.nextInt();

        int m = (x>y)?(x>z?x:z):(y>z?y:z);
        System.out.println("largest number is "+m);

// Check if a student'll pass or fail
        System.out.println("Enter Student's Marks");
        int marks = sc.nextInt();
        if(marks >= 33){
            System.out.println("He passed the exam");

        }
        else{
            System.out.println("He failed");
        }
// Calculater using Switch Statement
        System.out.println("Enter q");
        int q = sc.nextInt();
        System.out.println("Enter r");
        int r = sc.nextInt();
        System.out.println("Enter Operator");
        char ch = sc.next().charAt(0);

        

        switch(ch){
            case '+' : System.out.println("addition is :" + (q + r) );
            break;
            case '-' : System.out.println("subtraction is :" + (q - r) );
            break;
            case '*' : System.out.println("multiplication is :" + (q * r) );
            break;
            case '/' : System.out.println("division is :" + (q / r) );
            break;
            case '%' : System.out.println("Remainder is :" + (q % r) );
            break;
            default : System.out.println("Not Found");
        }
// Number  Negative or Positive
        System.out.println("Enter the Number");
        int number = sc.nextInt();
        if(number>0){
            System.out.println("Number is Positive");
        }
        else {
            System.out.println("Number is Negative");
        }
// You've a fever or not;
        System.out.println("Enter Your Temperature");
        float temperature = sc.nextFloat();
        if(temperature > 100){
            System.out.println("You have a fever");
        }
        else{
            System.out.println("You have not a fever");
        }

        

// Week = Day using Switch Statement
        System.out.println("Enter Week Number(1-7): ");
        int week = sc.nextInt();
        switch(week){
            case 1 : System.out.println("Monday");
            break;
            case 2 : System.out.println("Tuesday");
            break;
            case 3 : System.out.println("Wednesday");
            break;
            case 4 : System.out.println("Thursday");
            break;
            case 5 : System.out.println("Friday");
            break;
            case 6 : System.out.println("Saturday");
            break;
            case 7 : System.out.println("Sunday");
            break; 
            default : System.out.println("Invalid Input!");
        }
        sc.close();
    }
}
