import java.util.*;
public class RandomTest
{
	public static void main(String [] args)
	{
		Random rndObject = new Random();
		int randomNumber = rndObject.nextInt(500);
		System.out.println("The generated random integer is: " + randomNumber);
	}
}