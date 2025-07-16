import java.util.*;

public class Kienergy
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the mass of the object: ");
		double mass = keyboard.nextDouble();
		System.out.print("Please enter the velocity of the object: ");
		double volume = keyboard.nextDouble();
		System.out.println("The Kinetic Energy is: "+ (0.5 * mass * Math.pow(volume, 2)));
	}
}