public class Colony
{
	private final int START_PAIRS = 1;
	private int month;
	private int newBornPairs;
	private int oneMonthPairs;
	private int maturePairs;

	public Colony()
	{
		month = 2;
		newBornPairs = 0;
		maturePairs = 0;
		oneMonthPairs = START_PAIRS;
	}

	public void aheadAMonth()
	{
		maturePairs += oneMonthPairs;
		oneMonthPairs = newBornPairs;
		newBornPairs = maturePairs;
		month++;
	}

	public int getMonth()
	{
		return month;
	}

	public int getNewBornPairs()
	{
		return newBornPairs;
	}

	public int getOneMonthPairs()
	{
		return oneMonthPairs;
	}

	public int getMaturePairs()
	{
		return maturePairs;
	}

	public int getPopulation()
	{
		return (newBornPairs + oneMonthPairs + maturePairs) * 2;
	}

	public void display()
	{
		System.out.println("Colony [month: " + month +
		 ", newBornPairs: " + newBornPairs +
		  ", oneMonthPairs: " + oneMonthPairs + 
		  ", maturePairs: " + maturePairs + "]");
	}
}