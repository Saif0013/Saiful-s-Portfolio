import java.util.*;
import java.io.*;
public class AssTester
{
	public static void main(String [] args)throws Exception 
	{
		// open file for reading from args[0]
		File myFile = new File(args[0]);
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
		
		//count coma
		int comaNumber = newStr.replaceAll("[^,]","").length();
		System.out.println(comaNumber);

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
				String str2 = myStr.substring(comaIndex+2);
				int comaIndex1 = str2.indexOf(',');
				String pName = str2.substring(0, comaIndex1);
				String str3 = str2.substring(comaIndex1+2);
				int comaIndex2 = str3.indexOf(',');
				String pPosition = str3.substring(0, comaIndex2);
				String pCap =str3.substring(comaIndex2+2);

				AFLPlayer tPlayer1 = new AFLPlayer(pNum, pName, pPosition, pCap);
				lineUp.add(tPlayer1);

			}
		}



				/*int numOfCap = Collections.frequency(lineUp, tPlayer1);
				System.out.println(numOfCap);*/	




		// create alf home team
		AFLTeam homeTeam = new AFLTeam(teamName, coach, lineUp);
		System.out.println(homeTeam);
	}
}


		