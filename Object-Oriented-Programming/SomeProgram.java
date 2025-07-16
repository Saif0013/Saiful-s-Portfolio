import java.util.*;
public class SomeProgram
{
    public static void main(String [] args)
    {
        /*int myNumber = 15;
        int someNumber = 20;
        System.out.println("The total of two number is: " + (myNumber+someNumber));
        */
       // initialize scanner
       Scanner kb = new Scanner(System.in);

       // print message on the screen
       System.out.print("Please Enter the First Number: ");
       // get the integer from user
       int myNumber = kb.nextInt();
       // print message on the screen
       System.out.print("Please Enter the Second Number: ");
       // get the integer from user
       int someNumber = kb.nextInt();
       // calculate total 
       int total = myNumber + someNumber;
       
       // print total on the screen
       System.out.println("The total of two number is: " + total);
    }
}