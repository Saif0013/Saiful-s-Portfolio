import java.util.*;
public class L8Q1
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please type your first integer: ");
		int one1 = keyboard.nextInt();
		System.out.print("Please type your second integer: ");
		int two2 = keyboard.nextInt();

		System.out.println("Sum of your integers: " + (one1 + two2));
		System.out.println("Average of your integers: " + (one1+two2)/2);
	}
}