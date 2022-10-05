import java.util.Scanner;

public class Mod_9_Patterns{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Star Pattern (nested loops)

        System.out.println("Enter no of lines");
        int n = sc.nextInt();
        System.out.println("Star Pattern");
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //Inverted Star Pattern
        System.out.println("Inverted Star Pattern");
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= n-i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        // Half Pyramid Pattern
        System.out.println("Half Pyramid Pattern");
        for(int i=1; i<=n; i++){

            for(int j=1; j<=i; j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
        //Character Pattern
        System.out.println("Character Pattern");
        char ch = 'A';
        for(int i=1; i <= n; i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }


    }
}