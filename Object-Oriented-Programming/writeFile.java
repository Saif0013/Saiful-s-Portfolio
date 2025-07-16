import java.util.*;
import java.io.*;
public class writeFile
{
	public static void main(String [] args) throws IOException
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Please type your file name: ");
		String fname = kb.nextLine();
		FileWriter myFile = new FileWriter(fname, true);
		PrintWriter out = new PrintWriter(myFile);

		String s1 = "My file is encrypted";

		for(int i=0; i<10; i++)
		{
			out.println(s1);
		}

		out.close();
	}
}