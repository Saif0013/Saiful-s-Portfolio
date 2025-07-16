/*
// Ex 1.
Write a Java method to find the smallest number among three numbers. Use user input.

You should input the follwing in the terminal:

Input the first number: 25
Input the Second number: 37
Input the third number: 29

Expected Output:
The smallest value is 25.0
*/


import java.util.*;
public class SmallNumber
{
    // method to calculate smallest number
    static double smallestNumber(double a, double b, double c)
    {
        // declare an ArrayList of double
        ArrayList<Double> myList = new ArrayList<Double>();
        // add numbers into myList 
        myList.add(a);
        myList.add(b);
        myList.add(c);
        
        // sort the array
        Collections.sort(myList);

        // return first number of the array list
        double myNumber = myList.get(0);
        return myNumber;
    }



    // main method
    public static void main(String[] args)
    {
        // initialize scanner
        Scanner kb = new Scanner(System.in);
        System.out.print("Input the first number: ");
        double x = kb.nextDouble();
        System.out.print("Input the Second number: ");
        double y = kb.nextDouble();
        System.out.print("Input the third number: ");
        double z = kb.nextDouble();
        System.out.println("The smallest value is " + smallestNumber(x, y, z));
    }
}




/*
import java.util.*;
public class SmallNumber {

 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        double x = in.nextDouble();
        System.out.print("Input the Second number: ");
        double y = in.nextDouble();
        System.out.print("Input the third number: ");
        double z = in.nextDouble();
        System.out.print("The smallest value is " + smallest(x, y, z)+"\n" );
    }

   public static double smallest(double x, double y, double z)
    {
        return Math.min(Math.min(x, y), z);
    }
}

*/








