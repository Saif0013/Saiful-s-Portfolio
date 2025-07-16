import java.util.*;

public class NameGame
{
	public static void main(String [] args)
	{
			Scanner Keyboard = new Scanner(System.in);

			System.out.println("Enter full name: ");
			String name = Keyboard.nextLine();

			int spaceIndex = name.indexOf(' ');
			String outPut = name.substring(spaceIndex + 1) + ", " + name.charAt(0) + ".";

			System.out.println(outPut);
	}
}



