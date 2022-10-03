public class Mod_6_Operators {
    public static void main(String args[]){


        // Unary Operators

        int a = 10;
        System.out.println(a);
        int b = ++a;
        System.out.println(a);
        System.out.println(b);


        
        int c = 23;
        System.out.println(c);
        int d = c++;
        System.out.println(c); 
        System.out.println(d);

        //Relational Operators
 
        int  x = 10;
        int  y = 10;
        int  z = 5;

        System.out.println((x == y));
        System.out.println((x != y));
        System.out.println((x > z));
        System.out.println((z > y));

        //Logical Operators

        System.out.println( (3>2) && (5>0));

        System.out.println( (3>6) || (5>9));
        System.out.println( !(3>2) );

        // Assignmemt operator
        int M =9;
        M += 5;
        System.out.println(M);
        M *= 2;
        System.out.println(M);
        M -= 4;
        System.out.println(M);
        M /= 4;
        System.out.println(M);

        M %= 6;
        System.out.println(M);


    }
}
