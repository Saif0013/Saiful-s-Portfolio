public class StringDouble
{
	public static void main(String [] args)
	{
		String s1 = "23.6";
		double d1 = Double.parseDouble(s1);

		System.out.println(d1);

		double d2 = 123.60;
		String s2 = String.valueOf(d2);

		System.out.println(s2);

	}
}