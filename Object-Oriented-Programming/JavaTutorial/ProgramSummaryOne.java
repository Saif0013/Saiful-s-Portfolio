import java.util.*;

public class ProgramSummaryOne
{
    public static void main(String[] args)
    {
        // Create table to using format
        // Format the columns
        System.out.format("%-14s %-14s %-14s %-14s %-14s", " ", "Bronze", "Silver", "Gold", "Platinum");
        // Print blank line to take the cursor to next line
        System.out.println();
        // Put the data into the table
        System.out.format("%-14s %-14s %-14s %-14s %-14s", "Score Range", "500 - 999", "1000 - 1999", "2000 - 2999", "3000 +");
        // Print blank line to take the cursor to next line
        System.out.println();
        
        
        // initialize scanner
        Scanner kb = new Scanner(System.in);

        // Promt user to enter an integer
        System.out.print("Please enter the user's score: ");
        int scoreRange = kb.nextInt();

        // condition for different leagues
        if(scoreRange < 500)
        {
            System.out.println("You have not yet made it into a league!");
        }
        else if(scoreRange >= 500 && scoreRange <= 999)
        {
        // print message on the screen
        System.out.println("Congratulations you have made it into the Bronze league!!!");
        }
        else if(scoreRange >= 1000 && scoreRange <= 1999)
        {
        // print message on the screen
        System.out.println("Congratulations you have made it into the Silver league!!!");
        }
        else if(scoreRange >= 2000 && scoreRange <= 2999)
        {
        // print message on the screen
        System.out.println("Congratulations you have made it into the Gold league!!!");
        }
        else if(scoreRange > 3000)
        {
        // print message on the screen
        System.out.println("Congratulations you have made it into the Platinum league!!!");
        }

        // close scanner
        kb.close();
    }
}