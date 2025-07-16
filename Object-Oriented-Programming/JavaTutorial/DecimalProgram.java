import java.util.*;
public class DecimalProgram
{
    public static void main(String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.print ("Enter a number: ");
        double number = keyboard.nextDouble ();
        //int squareRoot1 = (int) Math.sqrt(number);
        int squareRoot = (int) Math.sqrt(number);

        System.out.println(squareRoot*squareRoot);


    }
}