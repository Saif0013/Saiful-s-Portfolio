import java.util.*;

public class Kname2
{
	public static void main(String [] args)
	{
		Scanner Keyboard = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = Keyboard.nextLine();

		int spaceIndex = name.indexOf(" ");
		String outPut = name.substring(0, spaceIndex) + ", " + name.charAt(spaceIndex+1) + ".";

		System.out.println(outPut);
	}
}