import java.util.*;
import java.io.*;
public class intConverter
{
	public static void main(String [] args) throws Exception 
	{
		try
		{
		// open file for reading from args[0]
		File myFile = new File(args[0]);

		// initialise scanner to read file
		Scanner sc = new Scanner(myFile);
		
		// initialise array list
		ArrayList<Object> lineUp = new ArrayList<Object>();

		//print statement
		System.out.println("Home team: ");
		System.out.println("----------");

		// read team name
		String teamName = sc.nextLine();
		

		// read coach name and position
		String newStr = sc.nextLine();
		int indexOfComa = newStr.indexOf(',');
		String cName = newStr.substring(0,indexOfComa);
		String cPosition = newStr.substring(indexOfComa+2);
		// create alf team member object
		AFLTeamMember coach = new AFLTeamMember(cName, cPosition);
		

		// read player lineUp
		while(sc.hasNextLine())
		{
			String myStr = sc.nextLine();
			int comaNum = myStr.replaceAll("[^,]","").length(); 
			if(comaNum!=3)
			{
				int comaIndex = myStr.indexOf(',');
				String str1 = myStr.substring(0, comaIndex);
				int pNum = Integer.parseInt(str1);

				// exception handling
				if(pNum<0)
				{
					throw new IOException("Invalid player number!");
				}

				String str2 = myStr.substring(comaIndex+2);
				int comaIndex1 = str2.indexOf(',');
				String pName = str2.substring(0, comaIndex1);
				String pPosition = str2.substring(comaIndex1+2);
				AFLPlayer tPlayer = new AFLPlayer(pNum, pName, pPosition);
				lineUp.add(tPlayer);
			}
			else
			{
				int comaIndex = myStr.indexOf(',');
				String str1 = myStr.substring(0, comaIndex);
				int pNum = Integer.parseInt(str1);

				// exception handling
				if(pNum<0)
				{
					throw new IOException("Invalid player number!");
				}

				String str2 = myStr.substring(comaIndex+2);
				int comaIndex1 = str2.indexOf(',');
				String pName = str2.substring(0, comaIndex1);
				String str3 = str2.substring(comaIndex1+2);
				int comaIndex2 = str3.indexOf(',');
				String pPosition = str3.substring(0, comaIndex2);
				String pCap =str3.substring(comaIndex2+2);
				AFLPlayer tPlayer1 = new AFLPlayer(pNum, pName, pPosition, pCap);
				lineUp.add(tPlayer1);
				int numOfCap = tPlayer1.getCount();
				System.out.println(numOfCap);
			}
		}

		// count the length of lineUp
		int numOfPlayers = lineUp.size();
		if(numOfPlayers>22 || numOfPlayers<18)
		{
			throw new IOException("Incorrect line up size!");
		}

		// create alf home team
		AFLTeam homeTeam = new AFLTeam(teamName, coach, lineUp);
		System.out.println(homeTeam);
		sc.close();

		// ---------------------------------------------------
		// open file for reading from args[1]
		File awayFile = new File(args[1]);
		Scanner reader = new Scanner(awayFile);

		//initialise array list
		ArrayList<Object> myList = new ArrayList<Object>();

		//print statement
		System.out.println("---------------------");
		System.out.println("Away team: ");
		System.out.println("-----------");

		// read team name
		String teamName2 = reader.nextLine();

		// read coach name and position 
		String newStr1 = reader.nextLine();
		int indexOfComa1 = newStr1.indexOf(',');
		String cName1 = newStr1.substring(0,indexOfComa1);
		String cPosition1 = newStr1.substring(indexOfComa1+2);
		// create afl team member object
		AFLTeamMember coach1 = new AFLTeamMember(cName1, cPosition1);


		// read player lineUp
		while(reader.hasNextLine())
		{
			String myStr = reader.nextLine();
			int comaNum = myStr.replaceAll("[^,]","").length(); 
			if(comaNum!=3)
			{
				int comaIndex = myStr.indexOf(',');
				String str1 = myStr.substring(0, comaIndex);
				int pNum = Integer.parseInt(str1);

				// exception handling
				if(pNum<0)
				{
					throw new IOException("Invalid player number!");
				}

				String str2 = myStr.substring(comaIndex+2);
				int comaIndex1 = str2.indexOf(',');
				String pName = str2.substring(0, comaIndex1);
				String pPosition = str2.substring(comaIndex1+2);
				AFLPlayer tPlayer = new AFLPlayer(pNum, pName, pPosition);
				myList.add(tPlayer);
			}
			else
			{
				int comaIndex = myStr.indexOf(',');
				String str1 = myStr.substring(0, comaIndex);
				int pNum = Integer.parseInt(str1);

				// exception handling
				if(pNum<0)
				{
					throw new IOException("Invalid player number!");
				}

				String str2 = myStr.substring(comaIndex+2);
				int comaIndex1 = str2.indexOf(',');
				String pName = str2.substring(0, comaIndex1);
				String str3 = str2.substring(comaIndex1+2);
				int comaIndex2 = str3.indexOf(',');
				String pPosition = str3.substring(0, comaIndex2);
				String pCap =str3.substring(comaIndex2+2);
				AFLPlayer tPlayer1 = new AFLPlayer(pNum, pName, pPosition, pCap);
				myList.add(tPlayer1);
			}
		}

		// count the length of myList
		int numOfPlayer = myList.size();
		if(numOfPlayer>22 || numOfPlayer<18)
		{
			throw new IOException("Incorrect line up size!");
		}

		// create away afl team
		AFLTeam awayTeam = new AFLTeam(teamName2, coach1, myList);
		System.out.println(awayTeam);
		reader.close();
		//-------------------------------------------------------

		//create afl match
		AFLMatch newMatch = new AFLMatch(homeTeam, awayTeam);

		//---------------------------------------------------------
		// initialise scanner
		Scanner kb = new Scanner(System.in);

		// print a statement
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("GAME START");

		// ask user to input scores
		while(true)
		{
			System.out.println("Please type h for home team, a for away team, f for full time");
			System.out.print("Which team scored(h/a/f)? ");
			char t = kb.nextLine().charAt(0);

			if(t == 'h')
			{
				System.out.print("Goal or behind(g/b)? ");
				String input = kb.nextLine();
				char score = input.charAt(0);
				if(score == 'g')
				{
					newMatch.setHomeGoals(1);
				}
				else if(score == 'b')
				{
					newMatch.setHomeBehinds(1);
				}
				System.out.println("The current score is " + newMatch.getHomeScores() + 
					" (" + newMatch.getHomePoints() + ") " + "to " + newMatch.getAwayScores() + 
					" (" + newMatch.getAwayPoints() + ")");
			}

			else if(t == 'a')
			{
				System.out.print("Goal or behind(g/b)? ");
				String input = kb.nextLine();
				char score = input.charAt(0);
				if(score == 'g')
				{
					newMatch.setAwayGoals(1);
				}
				else if(score == 'b')
				{
					newMatch.setAwayBehinds(1);
				}
				System.out.println("The current score is " + newMatch.getHomeScores() + 
					" (" + newMatch.getHomePoints() + ") " + "to " + newMatch.getAwayScores() + 
					" (" + newMatch.getAwayPoints() + ")");
			}

			else if(t == 'f')
			{
				System.out.println("FULL TIME.");
				if(newMatch.getHomeScores()>newMatch.getAwayScores())
				{
					System.out.println(teamName + " " + newMatch.getHomeScores() + " (" +
						newMatch.getHomePoints() + ") " + "defeated " + teamName2 + " " +
						newMatch.getAwayScores() + " (" + newMatch.getAwayPoints() + ")");
				}
				else if(newMatch.getHomeScores()<newMatch.getAwayScores())
				{
					System.out.println(teamName2 + " " + newMatch.getAwayScores() + " (" + 
						newMatch.getAwayScores() + ") " + "defeated " + teamName + " " +
						newMatch.getHomeScores() + " (" + newMatch.getHomePoints() + ")");
				}
				else if(newMatch.getHomeScores() == newMatch.getAwayScores())
				{
					System.out.println("Match Tie!");
				}
				break;
			}

			else if(t!='h' || t!='a' || t!='g' || t!='b' || t!='f')
			{
				throw new IOException("Invalid input!");
			}
		}
		kb.close();
		}

		catch(FileNotFoundException e) 
		{
   			System.out.println("File not found!");
   			System.out.println(e);
   		}
   		catch(NoSuchElementException e) 
		{
   			System.out.println("Data format does not match!");
   			System.out.println(e); 
		}
		catch(NumberFormatException e) 
		{
   			System.out.println("Player number is not an integer!");
   			System.out.println(e); 
		}

	}
	
}