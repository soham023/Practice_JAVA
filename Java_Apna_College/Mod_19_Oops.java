import java.util.*;
import java.util.concurrent.CancellationException;


public class Mod_19_Oops {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                //Object Creation 
                Pen p1 = new Pen(); // created a pen object called p1
                
                System.out.println("Enter newColor");
                String col = sc.nextLine();
                p1.setColor(col);
                System.out.println(p1.getColor());

                p1.setTip(8);
                System.out.println(p1.getTip());

                // p1.color = "Yellow"; // can't do in this way bcz properties are private
                p1.setColor("Yellow");
                System.out.println(p1.getColor());

                

                Student s1 = new Student(); // created a Student object called s1
                //System.out.println(s1.name);
                // Student s2 = new Student();
                // s1.calcPercentage(85,93,99);

                //s1.setAge(17);
                s1.name ="Soham";
                s1.rollNo = 34;
                s1.password = "abcd";
                s1.marks[0] = 100;
                s1.marks[1] = 90;
                s1.marks[2] = 80;

                // s1.name = "Soham";
                //System.out.println(s1.name+" "+s1.age+" "+s1.percentage+"%");
                Student s2 = new Student(s1); // copy constructor
                s2.password = "xyz";
                for(int i = 0; i < 3 ; i++){
                        System.out.println("Before Changeing  s1, s2marks are : "+s2.marks[i]);
                }
                s1.marks[2] = 100;
                for(int i = 0; i < 3 ; i++){
                        System.out.println("After Changing s1.marks[2] s2 marks are : "+s2.marks[i]);
                }
                
                //
                BankAccount B1 = new BankAccount();
                B1.setUserName("Soham");
                // B1.setPassword("abcdefg");
                // B1.passWord = "abcdefg"; // Can't access password through main function
                System.out.println(B1.userName);
                //System.out.println(B1.passWord);

                // this : this Object is used tp refer current object


                Test t1 = new Test();
                Test t2 = new Test(9);
                Test t3 = new Test("Soham");
                System.out.println( "No of Objects created here : "+Test.countObject() );
               

                Fish shark = new Fish();
                shark.eat(); 


                Dog Bulldog = new Dog();
                Bulldog.Life();
                Bulldog.legs = 4;
                System.out.println(Bulldog.legs);

                Hunting_Mammals Tiger = new Hunting_Mammals();
                Tiger.Alive();

                Birds Sparrow = new Birds();
                Sparrow.Alive();

                //Function Overloading
                Calculator calc = new Calculator();
                System.out.println(calc.sum(3, 5));
                System.out.println(calc.sum(6.7f, 8.9f));
                System.out.println(calc.sum(5, 5, 10));

                //Function Overriding


                //Abstract Classes
                Horse h = new Horse();
                h.eat();
                h.walk();
                System.out.println("Previous color by default : "+h.color);
                h.changeColor();
                System.out.println("NewColor : "+h.color);

                Chicken c = new Chicken();
                c.eat();
                c.walk();

                //Animalous a = new Animalous();
                //Animalous is abstract; cannot be instantiated


                //interfaces
                Queen q = new Queen();
                q.moves();

                //Multiple Level Inheritance
                Bear b = new Bear();
                b.eats_Grass();
                b.eats_Meat();

                //Static
                Puple Soham = new Puple();
                Soham.schoolName = "HVI";

                Puple p2 = new Puple();
                System.out.println(p2.schoolName);

                Puple p3 = new Puple();
                p3.schoolName = "Zilla";

                System.out.println(Soham.schoolName);
                System.out.println(p2.schoolName);
                System.out.println(p3.schoolName);
                
                hor Mustag = new hor();
                System.out.println(Mustag.color);

                
        }       
}

class BankAccount{
        //properties
        public  String userName;
        private String passWord;

        

        //function
        void setUserName(String userName){
                this.userName = userName;
        }
        void setPassword(String passWord){
                this.passWord = passWord;
        }
}


class Pen{
        
        // this : this Object is used tp refer current object
        //properties
        private String color ;
        private int tip ;

        // functions

        // Getters
        String getColor(){
                return this.color;
        }

        // Setters
        void setColor(String Color){
                this.color = Color;
        }
        // Getters
        int getTip(){
                return this.tip;
        }
        // Setters
        void setTip(int newTip){
                tip = newTip;
        }
}

/* Encapsulation is defined as the wrapping up of data & Methuds under a single unit.
  it also implements Data hiding */

/* Constructor is a special method which is invoked automatically at the time of object creation*/
// Constructor have the sameName as class or structure
// Constructors are only called once . at object creation.
// Constructors don't have a return type.(Not even void)
// Memory Allocations happens when constructor is called.
/*in java when we don't call a constructor , java itself makes a default constructor
   bt in automatic constructor there is no initialisation eg: class Pen Object in code*/
// Bt if we make a constructor , java won't make constructor by itself. 

//Constructor Overloading


class Student{
        String name;
        int rollNo;
        int age;
        String password;
        int marks[];
        float percentage;
        


        

        //Shallow Copy Constructor
        // Student(Student s1){
        //         marks = new int[3];
        //         this.name = s1.name;
        //         this.rollNo = s1.rollNo;
        //         this.marks = s1.marks;
        // }


        // Search Lazy Copy in Google 


        // Deep Copy Constructor
        Student(Student s1){
                marks = new int[3];
                this.name = s1.name;
                this.rollNo = s1.rollNo;
                for(int i = 0; i < marks.length; i++ ){
                        this.marks[i] = s1.marks[i];
                }
        }

        // Non-Paramerised Constructor
        Student(){
                marks = new int[3];
                System.out.println("Constructor is called");
        }

        // Paramerised Constructor
        Student(String name){
                marks = new int[3];
                this.name = name;
        }
        
        Student(int rollNo){
                marks = new int[3];
                this.rollNo = rollNo;
        }



        // void setName(String nm){
        //         name = nm;
        // }
        void setAge(int age){
                this.age = age;
        }
        void calcPercentage(int Phy , int Chem , int Math){
                percentage = (Phy + Chem + Math)/3;
        }

        //Destructors
        //There is Garbage collector that's why we don't need to write Destructors in java
}

// class MyFraction{
//         int numerator;
//         int denominator;

//         MyFraction(){
                
//         }
//         void Display(){

//         }

// }

// MidTerm Qstn-1
class Test{

        static int count = 0;
        public Test(){
                count++;
        }
        public Test(int n){
                count++;
        }
        public Test (String s){
                count++;
        }
        static int countObject(){
                 //System.out.println(count);
                 return count;
                 
        }

        

}

//Inheritance
//Inheritance is when properties & methods of base/parent class are passed on to a derived/child class.
// 4 Types of Inheritance
//Single level inheritance
//Base Class
class Animal {
        String color;

        void eat(){
                System.out.println("Eats");
        }

        void breathe(){
                System.out.println("breathes");
        }
}

//Derived Class
class Fish extends Animal{
        int fins;

        void swim(){
                System.out.println("swims in water");
        }
}


//Multi-level Inheritance
class Living_Beings{
        void Life(){
                System.out.println("We're alive");
        }
}
class Mammals extends Living_Beings{
        int legs;

}

class Dog extends Mammals{
        String breed;
}


//Hierarchical Inheritance
class Lives{
        void Alive(){
                System.out.println("We live here");
        }
        void breathe(){
                System.out.println("Breathes");
        }
}

class Birds extends Lives{
        void fly(){
                System.out.println("Flies");
        }
}
class Hunting_Mammals extends Lives{
        void kill(){
                System.out.println("Kills other Animals");
        }
} 

//Hybrid Inheritance
//Polymorphism
//Compile Time Polymorphism --> Method Overloading -->
//Method Overloading --> Multiple functions with same name but different parameters 
//parameters type different / count different

class Calculator{
        int sum (int a , int b){
                return a+b;
        }
        float sum (float a , float b){
                return a+b;
        }
        int sum(int a , int b , int c){
                return a+b+c;
        }
}


//RunTime Polymorphism --> Method Over-Riding
//Method Overriding-> Parent and Child classes both contain the same function with a different definition
// basically working different 


//Packages in java
//Package is a group of similar types of class , interfaces and sub-packages
//1. Inbuilt Packages  (java.util.*)
//2. User-Defined Packages(package myPackage)


//Abstraction
//Hiding all the unnecessary details and showing only the important parts to the user.



//1.Abstract Classes
//can't create an instance/object of abstract class
//can have abstract/non-abstract methods
//can have constructors
abstract class Animalous{
        String color;

        //constructor
        /* Constructor will work like when it's created , it will be created as color brown by default
          Until we call changeColor() for any object. */
        Animalous(){
                color = "brown";
        }
        //non-abstract functions
        void eat(){
                System.out.println("Animal eats");
        }

        abstract void walk(); // abstract method // doesn't have its own implementation
}

class Horse extends Animalous{
        void changeColor(){
                color = "Dark Brown";
        }
        void walk(){
                System.out.println("walks on 4 legs");
        }
}

class Chicken extends Animalous{
        void changeColor(){
                color = "White";
        }
        void walk(){
                System.out.println("walks on 2 legs");
        }
}


//2.Interfaces -- > Blueprint of a class.
// implements Multiple Inheritance
// total abstraction
// All methods are public , abstract & without implementation
// used to achieve total abstraction
// variables in the interface are final , public, static.class
// interface --> implements
interface ChessPlayer{
        void moves();
}

class Queen implements ChessPlayer {
        public void moves(){ // we've to write public otherwise it'll be default type
                System.out.println("up, down, left , right, diagonally in all 4 directions");
        }
}
class Rook implements ChessPlayer {
        public void moves(){ // we've to write public otherwise it'll be default type
                System.out.println("up, down, left , right");
        }
}
class King implements ChessPlayer {
        public void moves(){ // we've to write public otherwise it'll be default type
                System.out.println("up, down, left , right, diagonally in all 4 directions(by 1 step)");
        }
}

//Multiple Inheritance by Interface
interface Harbivore{
        void eats_Grass();
}
interface Carnivore{
        void eats_Meat();
}

class Bear implements Harbivore,Carnivore{
        public void eats_Grass(){
                System.out.println("eats grass");
        }
        public void eats_Meat() {
                System.out.println("eats meat");
        }    
}

//Static keyword in java is used to share the same variable or method of a given class
//( Properties , Functions , Blocks , Nested Classes )
// main is a static function

class Puple{
      
        // static functions
      static int returnPercentage(int phy , int chem , int math){
        return (math + chem + math)/3;
      }
      String name;
      int roll;

      static String schoolName;

      void setName(String name){
        this.name = name;
      }
      String getName(){
        return this.name;
      }



}

//super keyword
//super keyword is used to refer immediate parent class object
// to acces parent's properties 
// to acces parent's functions
// to acces parent's constructor
class Ani{
        String color ; 
        Ani(){
                System.out.println("Animal Constructor is called");
        }
}

class hor extends Ani {
        hor(){
                super(); // Animal class constructor will be called
                super.color = " brown ";
                System.out.println("Horse Constructor is called");
        }
}

//Constructor Chaining // (implememntation) Google Search