/* Name: Md Saiful Islam
Student Id: 18882762 */

import java.util.*;
import java.io.*;
public class AFLTeamMember
{
	// declare attributes
	private String name;
	private String position;

	// declare constructor
	public AFLTeamMember(String name, String position) throws IOException 
	{
		this.name = name;
		
		// condition on position ( FB, HB, C, HF, FF, FOL, IC, COACH.)
		if(position.equals("FB"))
		{
			this.position = position;
		}
		else if(position.equals("HB"))
		{
			this.position = position;
		}
		else if(position.equals("C"))
		{
			this.position = position;
		}
		else if(position.equals("HF"))
		{
			this.position = position;
		}
		else if(position.equals("FF"))
		{
			this.position = position;
		}
		else if(position.equals("FOL"))
		{
			this.position = position;
		}
		else if(position.equals("IC"))
		{
			this.position = position;
		}
		else if(position.equals("COACH"))
		{
			this.position = position;
		}
		else
		{
			throw new IOException("This position is invalid!");
		}
	} 


	// get method for name
	public String getName()
	{
		return name;
	}

	// get method for position
	public String getPosition()
	{
		return position;
	}

	// toString method
	public String toString()
	{
		return name + ", " + position;
	}

}