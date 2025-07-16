/*
Write a Java method to compute the average of three numbers. Use user input.

You should input the follwing in the terminal:

Input the first number: 25
Input the second number: 45
Input the third number: 65

Expected Output:
The average value is 45.0
*/

import java.util.*;
public class Exercise2 {

 public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the first number: ");
        double x = in.nextDouble();
        System.out.print("Input the second number: ");
        double y = in.nextDouble();
        System.out.print("Input the third number: ");
        double z = in.nextDouble();
        System.out.println("The average value is " + average(x, y, z));
    }

  public static double average(double x, double y, double z)
    {
        return (x + y + z) / 3;
    }
}



