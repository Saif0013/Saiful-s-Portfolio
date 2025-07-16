import java.util.*;

public class ReadLine
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your string: ");
		String s1 = keyboard.nextLine();
		System.out.println("Your output: " + s1);
	}
}