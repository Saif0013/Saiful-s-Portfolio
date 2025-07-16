import java.util.*;
public class sampleTest
{
	public static void main(String [] args)
	{
		boolean myBoo = true;
		String myStr = "My String";

		String newStr = String.valueOf(myBoo);
		String uStr = Boolean.toString(myBoo);

		boolean newBoo = Boolean.parseBoolean(myStr);
		boolean uBoo = Boolean.valueOf(myStr);

		System.out.println(newStr);
		System.out.println(uStr);
		System.out.println("---------");
		System.out.println(newBoo);
		System.out.println(uBoo);
	}
}