import java.util.Scanner;
public class Mod_10_Functions {

    public static void printHelloWorld(){
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        //return;    
    }
    public static int PrintHello(){
        System.out.println("Hello");
        System.out.println("Hello");
        return 0;
    }

    // return Type Void (Add Functon)
    public static void CalculateSum(int numa, int numb) { //numa , numb --> Parameters or Formal Parameters during function definition
        int sum = numa + numb;
        System.out.println("Sum is : "+ sum);
    }

    // return Type int (Add Functon)
    public static int CalculateSUM1(int num1, int num2){//num1 , num2 --> Parameters or Formal Parameters during function definition
        return num1 + num2 ;
    }
    
    //Swapping Function
    public static void Swap(int r , int t){
        int temp = r;
         r = t;
         t = temp;
        System.out.println("Value of r " + r);
        System.out.println("Value of t "+ t);
    }

    //Product Function
    public static int CalculateProduct(int a , int b){
        return a*b;
    }

    //Factorial Function
    public static int Factorial(int n){
        int a = 1;
        for(int i = 1; i<=n; i++){
            a=a*i;
        }
        return a;
    }

    //Binomial Co-Efficient
    public static int BinomialCoefficient(int n, int r){
        return (Factorial(n)/(Factorial(r)*Factorial(n-r)));
    }

    //Function Overloading using parameters
    //func to calculate sum of 2 nums
    public static int sum(int a , int b) {
        return a+b;
    }
    //func to calculate sum of 3 nums
    public static int sum(int a, int b , int c) {
        return a+b+c;
    }

    //Function Overloading using Data Types
    //func to calculate sum of 2 int types 
    public static int sum1(int a , int b) {
        return a+b;
    }
    //func to calculate sum of 2 float types
    public static float sum1(float a, float b) {
        return a+b;
    }
    //func to calculate sum of 1 float type and 1 int type
    public static float sum1(float a, int b) {
        return a+b;
    }
    //func to calculate sum of 2 double types
    public static double sum1(double a, double b) {
        return a+b;
    }

    //number Prime or not
    public static boolean CheckPrime(int n) {
        //boolean isPrime = true;
        if(n == 2){
            return true;
        }
        else{
            for(int i=2; i<= Math.sqrt(n); i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
            /* 
            if(isPrime == true){
                System.out.println("It's Prime!");
            }
            else{
                System.out.println("It's not Prime!");
            }*/
        }
        
    }

    //Print all Primes in a range
    public static void PrintPrimesUpto(int n) {
        for(int i=2 ; i<=n; i++){
                if(CheckPrime(i)==true){
                    System.out.print(i+" ");
            }
        }     
    }

    // Binary to Decimal
    public static int BinaryToDecimal(int n) {
        int power = 0;
        int decimal = 0;
        while(n>0){
            int lastDigit = n%10;
            decimal = decimal + lastDigit*((int)Math.pow(2,power));
            n=n/10;
            power++;
        }
        return decimal;
    }

    // Decimal to Binary
    public static void DecimalToBinary(int n) {
        int myNum = n;
        int Binary = 0;
        int power = 0;
        while(n>0){
            int rem = n%2;
            Binary = Binary + rem*(int)Math.pow(10 , power);
            power++;
            n=n/2;
        }
        System.out.println("Binary of "+myNum+" is : "+Binary);        
    }

    //Practice Questions of Functions
    //sum of the digits in an integer
    public static int SumOFtheDigits(int n) {
        int sum=0;
        while(n>0){
            int lastDigit = n%10;
            sum+=lastDigit;
            n=n/10;
        }
        return sum;
    }

    //Average of 3 numbers
    public static double Avg3(double a ,double b , double c) {
            double x = (a+b+c)/3;
            return x;
    }       
    
    //Even or Odd
    public static boolean IsEven(int n) {
        if(n%2 == 0){
            return true;
        }
        return false;
    }

    //reverse
    public static int reverse(int n) {
        int rev = 0;
        while(n>0){
            int lastDigit = n%10;
            rev = rev*10 + lastDigit ;
            n=n/10;
        }
        return rev;
    }

    //palindrome or not
    public static boolean palindrome(int n) {
        if(reverse(n) == n){
            return true;
        }
        return false;
    }
     

    public static void main(String[] args) {
        printHelloWorld();
        PrintHello();
        Scanner  sc = new Scanner(System.in);
        
        
        
        System.out.println("Enter a");
        int a = sc.nextInt();
        System.out.println("Enter b");
        int b = sc.nextInt();
        CalculateSum(a, b);                    // a , b --> Arguments or Actual Parameters during function Call

        System.out.println("Enter x");
        int x = sc.nextInt();
        System.out.println("Enter y");
        int y = sc.nextInt();
        int SUM = CalculateSUM1(x , y);         // x , y --> Arguments or Actual Parameters during function Call
        System.out.println("Sum is : "+ SUM);

        int Product = CalculateProduct(a, b);
        System.out.println("product of a & b "+ Product);

        System.out.println("Enter r");
        int r = sc.nextInt();
        System.out.println("Enter t");
        int t = sc.nextInt();
        
        // Example of Call by Value
        Swap(r, t);
        System.out.println(r-t);
        System.out.println("Value of r in main func " + r);
        System.out.println("Value of t in main func " + t);


        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter m");
        int m = sc.nextInt();
        //factorial & Binomial Co-efficient
        int fact = Factorial(n);
        System.out.println("factorial of "+ n +" is "+ fact);        
        System.out.println( "Binomial Co-Efficient --> "+n+"C"+m +" is "+ BinomialCoefficient(n,m) );
        
        //func overloading using parameters
        System.out.println("Sum of func overloading of 2 numbers "+sum(a, b));
        System.out.println("Sum of func overloading of 3 numbers "+ sum(a, b, fact));

        //func overloading using data types
        System.out.println("Sum of 2 int Types in func overloading "+sum1(fact, b));
        System.out.println("Sum of 2 float Types in func overloading "+sum1(4.5f , b));
        System.out.println("Sum of 1 float type & 1 int type in func overloading " + sum1(6.4f , 5.4f ));
        System.out.println("Sum of 2 double Types in func overloading "+sum1(4.5 , b));

        //Prime Checker
        System.out.println("Enter your numberv to check prime or not!");
        int w = sc.nextInt();
        System.out.println(CheckPrime(w));
        PrintPrimesUpto(w);
        System.out.println();

        //sum of Digits
        System.out.println("Enter the number for its digits");
        int q= sc.nextInt();       
        int sumOFDigits = SumOFtheDigits(q);
        System.out.println("Sum of digits "+sumOFDigits);

        //Avg of 3 numbers
        System.out.println("Avg of 3 numbers 34,23,6 is "+ Avg3(34,23 ,6 ));

        //Even or Odd
        System.out.println(IsEven(92));

        //reverse
        System.out.println(reverse(789));

        //Palindrome or not
        System.out.println(palindrome(787));

        //BinarytoDecimal
        System.out.println(BinaryToDecimal(101));

        //DecimaltoBinary
        DecimalToBinary(5);
    }
}
