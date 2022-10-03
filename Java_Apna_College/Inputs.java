import java.io.IOException;
import java.util.*;
public class Inputs {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);

        // String name =sc.next();
        // System.out.println(name);

        System.out.println("ENTER Name");

        String FullName = sc.nextLine();
        System.out.println(FullName);

        System.out.println("Enter Number ");
        int number=sc.nextInt();
        System.out.println(number);
        

        //Sum of 2 numbers by taking inputs
        
        System.out.println("Enter a & b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a+b;
        System.out.println("Sum of a & b is "+ sum);

        //Product of x & y

        System.out.println("Enter x & y");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int product= x*y;

        System.out.println("Product of x & y is "+ product);

        //Area of a Circle
        System.out.print("Enter radius of a circle");

        double radius = sc.nextDouble();
        double area = 3.14 * radius* radius;
        System.out.println("area of a circle "+ area);

        sc.close();
    }
}
