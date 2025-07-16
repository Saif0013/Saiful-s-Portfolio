public class BoundedCounter
{
	private final int Maximum = 999;
	private int counter;
	// constructor
	public BoundedCounter()
	{
		int counter = 0;
	}

	public void next()
	{

		if (counter < Maximum)
		{
			counter++;
		}
		else
		{
			System.out.println("maximum reached");
		}

	}

	public void reset()
	{
		counter = 0;
	}

	public int getCounter()
	{
		return counter;
	}

	public void display()
	{
		System.out.println("Bounded counter: " + counter);
	}
	
}