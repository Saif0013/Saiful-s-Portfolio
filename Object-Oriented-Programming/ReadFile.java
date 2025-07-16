import java.util.*;
import java.io.*;

public class ReadFile
{
	public static void main(String [] args) throws IOException
	{
		File f = new File("Quiz.txt");
		Scanner scan = new Scanner(f);

		String name = scan.nextLine();
		double hours = scan.nextDouble();
		double pRate = scan.nextDouble();
		double tSales = scan.nextDouble();

		double bonus = (tSales - (hours*200)) * 0.1;
		double wage;

		if (bonus>0)
		{
			wage = (hours*pRate)+bonus;
		}

		else
		{
			wage = hours * pRate;
		}

		System.out.println(name + " must be paid " + wage + " this week.");
	}
}

