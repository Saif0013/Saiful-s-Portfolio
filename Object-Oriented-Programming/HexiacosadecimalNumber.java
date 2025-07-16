import java.util.*;

public class HexiacosadecimalNumber
{
	public static void main(String [] args)
	{
		while (true)
		{
		Scanner Keyboard = new Scanner(System.in);
		System.out.print("Please specify mode(h/d/q): ");
		char c = Keyboard.nextLine().charAt(0);

		if (c =='H' || c == 'h')
		{
			System.out.println("Enter hexiacosadecimal number: ");
			String s1 = Keyboard.nextLine();
			System.out.println("Your hexiacosadecimal number: " + s1);
		}

		else if (c == 'd' || c == 'D')
		{
			System.out.println("Enter Decimal number(double): ");
			Double d1 = Keyboard.nextDouble();
			System.out.println("Your decimal number: "+ d1);
		}

		else if (c == 'q' || c == 'Q')
		{
			System.out.println("Exiting program");
			break;
		}

		else
		{
			System.out.println("Invalid input");
		}
	     }
	}

	
}