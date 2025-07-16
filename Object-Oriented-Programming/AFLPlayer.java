/* Name: Md Saiful Islam
Student Id: 18882762 */

import java.util.*;
import java.io.*;
public class AFLPlayer extends AFLTeamMember
{
	// declare attributes
	private int playerNum;
	private String captain;
	private int count = 0;

	// constructor
	public AFLPlayer(int playerNum, String name, String position)throws IOException 
	{
		super(name, position);
		this.playerNum = playerNum;
	}

	// constructor
	public AFLPlayer(int playerNum, String name, String position, String captain)throws IOException
	{
		super(name, position);
		this.playerNum = playerNum;
		this.captain = captain;
	}

	// get method for player number
	public int getPlayerNum()
	{
		return playerNum;
	}

	// get method for captain
	public String getCaptain()
	{
		return captain;
	}

	// count method to count number of captain
	public int getCount()
	{
		count++;
		return count;
	}

	// toString method
	public String toString()
	{
		if(captain == null)
		{
			return "[" + playerNum + "]" + " " + super.toString();
		}
		else
		{
			return "[" + playerNum + "]" + " " + super.toString() + " " + "(" + captain + ")";
		}
	}

}