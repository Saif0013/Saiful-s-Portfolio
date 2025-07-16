public class ColonyTest
{
	public static void main(String[] args)
	{
		System.out.println("\nTest1: ");
		Colony colony1 = new Colony();
		colony1.display();

		System.out.println("\nTest2: Population after 12 months");
		Colony colony2 = new Colony();
		while (colony2.getMonth() < 12)
		{
			colony2.aheadAMonth();
		}
		System.out.println("After 12 months: " + 
			colony2.getPopulation());

		System.out.println("\nTest3: Reach a million?");
		Colony colony3 = new Colony();
		while (colony3.getPopulation() < 1000000)
		{
			colony3.aheadAMonth();
		}
		System.out.println("1 million: " + 
			colony3.getMonth() + "months");


	}
}