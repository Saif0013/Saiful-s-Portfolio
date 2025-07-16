public class Poisonous extends Plant
{
	// set attributes
	private int dangerRating;

	// set constructor
	public Poisonous(String name, String comments, int dangerRating)
	{
		super(name, comments);
		this.dangerRating = dangerRating;
	}

	// get danger rating method
	public int getDangerRating()
	{
		return dangerRating;
	}

	// to string method
	public String toString()
	{
		return super.toString() + "\n"
		       + "Danger Rating: " + dangerRating;
	}
}