public class Edible extends Plant
{
	// setting attributes
	private String season;
	private boolean canHarvest;

	// set constructor
	public Edible(String name, String comments,String season, boolean canHarvest)
	{
		super(name, comments);
		this.season = season;
		this.canHarvest = canHarvest;
	}

	// get method for season
	public String getSeason()
	{
		return season;
	}

	// get method for canHarvest
	public boolean canHarvest()
	{
		return canHarvest;
	}

	// to string method
	public String toString()
	{
		return super.toString() + "\n"
		    + "Season: " + season + "\n"
		    + "Ready to harvest: " + canHarvest;

	}

}