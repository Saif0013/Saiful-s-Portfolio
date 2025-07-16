public class VintageCar
{
	private String make;
	private String model;
	private int year;
	private boolean originalBody;
	private String category;

	// private method
	private void setCategory()
	{
		if (year < 1919)
		{
			category = "Historic";
		}
		else if (year == 1919 && year == 1930)
		{
			category = "Vintage";
		}
		else if (year == 1931 && year == 1939)
		{
			category = "Postvintage";
		}
		else
		{
			category = "Other";
		}
	}

	// constructor
	public VintageCar(String make, String model, int year, boolean originalBody)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.originalBody = originalBody;
	}

	// accessor methods
	public String getMake()
	{
		return make;
	}

	public String getModel()
	{
		return model;
	}

	public int getYear()
	{
		return year;
	}

	public boolean getOriginalBody()
	{
		return originalBody;
	}

	public String getCategory()
	{
		return category;
	}

	// mutator method
	public void setOriginalBody(boolean originalBody)
	{
		this.originalBody = originalBody;
	}

	public boolean isEligibleCar()
	{
		if (year < 1940)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int compareAge(VintageCar other)
	{
		return this.year - other.year;
	}

	public boolean sameType(VintageCar other)
	{
		if (this.make.equalsIgnoreCase(other.make) && this.model.equalsIgnoreCase(other.model))
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return "VintageCar [make: " + make + ", " + "model: " +
		model + ", " + "year: " + year + ", " + "originalBody: "+
		originalBody + ", " + "category: " + category + "]";
	}


}