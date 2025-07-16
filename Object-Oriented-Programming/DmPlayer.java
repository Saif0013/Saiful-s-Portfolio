import java.util.*;
public class DmPlayer
{
	// declare attributes
	private int playerNum;
	private String name;
	private String position;
	private String captain;

	// constructor
	public DmPlayer(int playerNum, String name, String position)
	{
		this.playerNum = playerNum;
		this.name = name;
		this.position = position;
	}

	// 2nd constructor
	public DmPlayer(int playerNum, String name, String position, String captain)
	{
		this.playerNum = playerNum;
		this.name = name;
		this.position = position;
		this.captain = captain;
	}


	public int getPlayerNum()
	{
		return playerNum;
	}


	public String getName()
	{
		return name;
	}


	public String getPosition()
	{
		return position;
	}


	public String getCaptain()
	{
		return captain;
	}

	// to string method
	public String toString()
	{
		if(captain == null)
		{
			return playerNum + " " + name + " " + position;
		}
		else
		{
			return playerNum + " " + name + " " + position + " " + "captain";
		}
	}
}