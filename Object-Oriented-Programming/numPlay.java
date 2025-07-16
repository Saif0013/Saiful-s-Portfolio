import java.util.*;
import java.io.*;
public class numPlay
{
	public static void main(String [] args)throws IOException 
	{
		AFLMatch newMatch = new AFLMatch("Hawthorn", "Lynbrook");

		newMatch.setHomeGoals(1);
		newMatch.setHomeBehinds(1);
		newMatch.setAwayGoals(1);

		System.out.println("Current score for home team: " + newMatch.getHomeScores());
		System.out.println("Current score for away team: " + newMatch.getAwayScores());
		System.out.println("Current points for home team: " + newMatch.getHomePoints());
		System.out.println("Current points for away team: " + newMatch.getAwayPoints());

	}
}

/*
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
			String myStr1 = reader.nextLine();
			int comaNumb = myStr1.replaceAll("[^,]","").length(); 
			if(comaNumb!=3)
			{
				int comaIndex1 = myStr1.indexOf(',');
				String str5 = myStr1.substring(0, comaIndex1);
				int pNum1 = Integer.parseInt(str5);
				String str6 = myStr1.substring(comaIndex1+2);
				int comaIndex5 = str6.indexOf(',');
				String pName1 = str6.substring(0, comaIndex5);
				String pPosition1 = str6.substring(comaIndex5+2);
				// create alf player object
				AFLPlayer tPlayer1 = new AFLPlayer(pNum1, pName1, pPosition1);
				myList.add(tPlayer1);
			}
			else
			{
				int comaIndex1 = myStr1.indexOf(',');
				String str5 = myStr1.substring(0, comaIndex1);
				int pNum1 = Integer.parseInt(str5);
				String str6 = myStr1.substring(comaIndex1+2);
				int comaIndex5 = str6.indexOf(',');
				String pName1 = str6.substring(0, comaIndex5);
				String str7 = str6.substring(comaIndex5+2);
				int comaIndex6 = str7.indexOf(',');
				String pPosition1 = str7.substring(0, comaIndex6);
				String pCap1 =str7.substring(comaIndex6+2);
				// create alf player object
				AFLPlayer tPlayer1 = new AFLPlayer(pNum1, pName1, pPosition1, pCap1);
				myList.add(tPlayer1);
			}
		}

		// create away alf team
		AFLTeam awayTeam = new AFLTeam(teamName2, coach1, myList);
		System.out.println(awayTeam);


		// initialise scanner
		Scanner kb = new Scanner(System.in);

		// print a statement
		System.out.println("GAME START");

		// ask user to input scores
		while(true)
		{
			System.out.print("Which team scored(h/a/f)? ");
			char t = kb.nextLine().charAt(0);
			if(t!='h'|| t!='a' || t!='b' || t!='g' || t!='f')
			{
				throw new IOException("Invalid input!");
			}
			else if(t == 'f')
			{
				System.out.println("FULL TIME.");
				break;
			}
			else if(t == 'h')
			{
				System.out.print("Goal or behind(g/b)? ");
				String gOrB = kb.nextLine();
				System.out.println("The current score is: " + gOrB);
			}
			else if(t == 'a')
			{
				System.out.print("Goal or behind(g/b)? ");
				String gOrB = kb.nextLine();
				System.out.println("The current score is: " + gOrB);
			}
			
		}
*/