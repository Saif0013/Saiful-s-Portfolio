public class PlantTester
{
	public static void main(String [] args)
	{
		Plant myPlant = new Plant("sss", "a dashing plant");

		Edible myEdible = new Edible("Palm tree", "A nice tree", "Winter", true);
		Poisonous myP = new Poisonous("ttt", "very poisonous", 5);

		System.out.println(myPlant);
		System.out.println();
		System.out.println(myEdible);
		System.out.println();
		System.out.println(myP);
	}
}