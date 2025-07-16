import java.util.*;
public class Average
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int size = keyboard.nextInt();

		int [] num = new int[size];

		System.out.println("Please enter ten numbers: ");

		for(int i=0; i<num.length; i++)
		{
			num[i] = keyboard.nextInt();
		}

		double average = calculateAverage(num);
		int blAvg = totalBelowAverage(num, average);
		int abAvg = totalAboveAverage(num, average);

		System.out.println("Average: " + average);
		System.out.println("Total below average: " + blAvg);
		System.out.println("Total above average: " + abAvg);
	}

	public static double calculateAverage(int[] data)
	{
		int sum = 0;
		for(int i=0; i<data.length; i++)
		{
			sum += data[i];
		}
		return ((double)sum/data.length);
	}

	public static int totalBelowAverage(int [] data, double average)
	{
		int belowAvg = 0;
		for(int i=0; i<data.length; i++)
		{
			if(data[i]<average)
			{
				belowAvg++;
			}
		}
		return belowAvg;
	}

	public static int totalAboveAverage(int [] data, double average)
	{
		int aboveAvg = 0;
		for(int i=0; i<data.length; i++)
		{
			if(data[i]>average)
			{
				aboveAvg++;
			}
		}
		return aboveAvg;
	}
}