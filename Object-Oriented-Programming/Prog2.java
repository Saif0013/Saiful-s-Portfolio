public class Prog2
{
	public static String dtoh(double in)
	{
		int temp = (int)(in);
		String stringAccumulator = "";

		while(temp>0)
		{
			int currValue = temp%26;
			char c = (char)(currValue + 'a');
			stringAccumulator = c + stringAccumulator;
			temp = temp/26;
		}
		return stringAccumulator;
	}

	public static void main(String [] args)
	{
		double decNum = 76890.0;
		String hexNum = dtoh(decNum);

		System.out.println(hexNum);
	}
}


/* int temp = (int)(in);
String stringAccumulator = "";

while(temp>0)
{
	int currValue = temp%26;
	char c = (char)(currValue + 'a');
	stringAccumulator = c + stringAccumulator;
	temp = temp/26;
} 
return stringAccumulator;*/
	
	
		
		

	