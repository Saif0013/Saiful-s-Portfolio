import java.util.Scanner;

public class OddEven
{
	public static void main(String [] args)
	{
		Scanner reader = new Scanner(System.in);

		System.out.print("Enter a number: ");
	  int number = reader.nextInt();

	  if (number % 2 == 0)
	  {
	  if (number % 4 == 0)
	  {
	    System.out.println("Even again");
	  }
	  else 
	  {
	    System.out.println("Only even");
	  }
	  }
	  else 
	  {
	  if (number < 0)
	  {
	    System.out.println("Negatively odd");
	  }
	  else
	  {
	    System.out.println("Positively odd");
	  }
	  }
	}
}