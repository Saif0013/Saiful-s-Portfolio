import java.util.*;

public class HourCalc
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your seconds: ");
		double one1 = keyboard.nextInt();
		double hours = one1/3600;
		double mins = (one1%3600)/60;


		System.out.println("Number of minutes: " + mins);
		System.out.println("Number of hours: " + hours);

	}
}