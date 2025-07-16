import java.util.*;

public class MethodExOne
{
    public static void main(String[] args)
    {
        // initialize scanner
        Scanner kb = new Scanner(System.in);

        // ask for user input
        System.out.print("Please input the first number: ");
        double x = kb.nextDouble();
        System.out.print("Please input the second number: ");
        double y = kb.nextDouble();
        System.out.print("Please input the third number: ");
        double z = kb.nextDouble();

        // calculate the small number
        double smallNumber = SmallNumber(x, y, z);

        // print output
        System.out.println("The smallest number: " + smallNumber);

    }

    // method to calculate small number
    static double SmallNumber(double x, double y, double z)
    {
        return Math.min(Math.min(x, y), z);
    }
}