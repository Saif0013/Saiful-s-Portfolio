import java.util.*;
import java.io.*;
public class UserInpFile
{
	public static void main(String [] args) throws IOException
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fname = kb.nextLine();
		File f = new File(fname);
		Scanner fScan = new Scanner(f);

		String outPut = fScan.nextLine();

		System.out.println(outPut);
	}
}