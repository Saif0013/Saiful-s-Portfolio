public class Plant
{
	// Initialise name and comment as string
	private String name;
	private String comments;

	// set constructor
	public Plant(String name, String comments)
	{
		this.name = name;
		this.comments = comments;
	}

    // get method for name
	public String getName()
	{
		return name;
	}

    // get method for comments
	public String getComments()
	{
		return comments;
	}
   
    // set method for comments
	public void setComments(String comments)
	{
		this.comments = comments;
	}
    
    // to string method
	public String toString()
	{
		return "Name: " + name + "\n"
		      + "Comments: " + comments;
	}


}