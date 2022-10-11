import java.util.Scanner;
public class Mod_11_Patterns_Advanced {

    //Hollow Rectangle
    public static void HollowRectangle(int n , int m){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m;j++){
                if(i==1 || i==n || j==1 || j==m){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }
            System.out.println("");
        }
    }

    //Inverted & Rotated Half Pyramid
    public static void Inverted_Rotated_HalfPyramid(int n) {
        for(int i =1; i<=n; i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    //Inverted Half Pyramid with Numbers
    public static void Inverted_Half_Pyramid_Num(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //Floyd's Triangle Pattern
    public static void Floyds_Triangle(int n) {
        int counter=1;
        for(int i=1; i<=n ; i++){
            for(int j=1;j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println("");
        }
    }
    //0-1 Triangle Pattern
    public static void x0_1_Triangle(int n) {
        for(int i=1; i<=n ; i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }   
            }
            System.out.println("");
        }
        
    }

    //Butterfly Pattern
    public static void ButterflyPattern(int n) {
        //1st Half
        for(int i=1; i<=n ; i++){
            //stars of 1st part
            for(int j=1; j<=i;j++){
                System.out.print("* ");
            }
            //spaces
            for(int j=1 ; j<=2*(n-i);j++){
                System.out.print("  ");
            }
            //stars of 2nd part
            for(int j=1; j <=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //2nd Half
        for(int i=n; i>=1; i--){
            //stars of 1st part
            for(int j=1; j<=i;j++){
                System.out.print("* ");
            }
            //spaces
            for(int j=1 ; j<=2*(n-i);j++){
                System.out.print("  ");
            }
            //stars of 2nd part
            for(int j=1; j <=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Solid Rhombus Pattern
    public static void Solid_Rhombus(int n) {
        for(int i=1; i <= n; i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1; j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Hollow Rhombus Pattern
    public static void HollowRectangle(int n) {
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            //hollow rectangle
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
    }

    //Diamond Pattern
    public static void DiamondPattern(int n) {
        //1st Half
        for(int i=1; i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //2nd Half
        for(int i=n; i>=1; i--){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Number Pyramid
    public static void NumberPyramid(int n) {
        for(int i = 1; i<=n ; i++ ){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+"   ");
            }
            System.out.println();
        }
        
    }

    //Palindromic Pattern
    public static void PalindromicPattern(int n) {
        for(int i=1; i<=n ; i++){

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //Descending Part
            for(int j=i; j>=1; j--){
                System.out.print(j+" ");
            }
            //Ascending Part
            for(int j=2; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
            
        }
        
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println("Enter noOFRows");
            int o = sc.nextInt();
            System.out.println("Enter noOFCols");
            int m = sc.nextInt();
            
            System.out.println("Hollow Rectangle");
            HollowRectangle(o, m);
            System.out.println();
    
            System.out.println("Inverted & Rotated Half Pyramid");
            Inverted_Rotated_HalfPyramid(o);
            System.out.println();
    
            System.out.println("Inverted Half Pyramid with numbers");
            Inverted_Half_Pyramid_Num(o);
            System.out.println();
    
            System.out.println("Floyd's Triangle");
            Floyds_Triangle(o);
            System.out.println();
    
            System.out.println("0-1 Triangle");
            x0_1_Triangle(o);
            System.out.println();
    
            System.out.println("Butterfly Pattern");
            ButterflyPattern(o);
            System.out.println();
    
            System.out.println("Solid Rhombus Pattern");
            Solid_Rhombus(o);
            System.out.println();
    
            System.out.println("Hollow Rhombus Pattern");
            HollowRectangle(o);
            System.out.println();
    
            System.out.println("Diamond Pattern");
            DiamondPattern(o);
            System.out.println();

            System.out.println("Number Pyramid");
            NumberPyramid(o);
            System.out.println();

            System.out.println("Palindromic Pattern");
            PalindromicPattern(o);
            System.out.println();

        }while(true);

        
    }
}
