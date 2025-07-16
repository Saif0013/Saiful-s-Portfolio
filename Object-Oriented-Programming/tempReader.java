import java.util.*;
public class tempReader
{
 	public static void main(String [] args)
   {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Please enter the number of available hours: ");
	int size = keyboard.nextInt();

	double[] temp = new double[size];
	System.out.println("Please enter the available temparetures: ");
	for(int i=0; i<temp.length; i++)
	{
		temp[i] = keyboard.nextDouble(); 
	}

	
    double average = calculateAverage(temp);
	System.out.println("Highest tempareture: " + calculateHighest(temp));
	System.out.println("Lowest temperature: " + calculateLowest(temp));
	System.out.println("Average tempareture: " + average);
	differenceFromAverage(temp, average);

  

   }

   public static double calculateHighest(double[] data)
   {
   	double max = data[0];
   	for(int i=1; i<data.length; i++)
   	{
   		if(data[i]> max)
   		{
   			max = data[i];
   		}
   	}
   	return max;
   }

   public static double calculateLowest(double [] data)
   {
   	double low = data[0];
   	for(int i=1; i<data.length; i++)
   	{
   		if(data[i]<low)
   		{
   			low = data[i];
   		}
   	}
   	return low;
   }

   public static double calculateAverage(double [] data)
   {

   	double total = 0.0;
   	for(int i=0; i<data.length; i++)
   	{
   		total += data[i];
   	}
   	return total/data.length;

   }

   public static void differenceFromAverage(double [] data, double average)
   {

   	for(int i=0; i<data.length; i++)
   	{
   		System.out.printf("Difference is - %.2f \n",data[i]-average);
   	}

   	double total = 0.0;
   	for(int i=0; i<data.length; i++)
   	{
       total = total + Math.pow((data[i]-average), 2);
   	}

   	System.out.println(Math.sqrt(total/data.length));

   }
}
