/* Name: Md Saiful Islam
Student Id: 18882762 */

import java.util.*;
public class AFLTeam
{
	// declare attributes
	private String name;
	private AFLTeamMember coach;
	private ArrayList<Object> lineUp = new ArrayList<Object>();

	// constructor
	public AFLTeam(String name, AFLTeamMember coach, ArrayList<Object> lineUp)
	{
		this.name = name;
		this.coach = coach;
		this.lineUp = lineUp;
	}

	// get method for name
	public String getName()
	{
		return name;
	}

	// get method for lineUp
	public ArrayList<Object> getLineUp()
	{
		return lineUp;
	}

	// to string method
	public String toString()
	{
		return "Team Name: " + name + "\n" + 
			   "Coach: " + coach + "\n"
				+ "LineUp: " + "\n" + lineUp;
	}

}