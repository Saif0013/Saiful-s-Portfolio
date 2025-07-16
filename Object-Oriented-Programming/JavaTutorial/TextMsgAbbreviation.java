import java.util.Scanner;

public class TextMsgAbbreviation
{
    public static void main(String[] args)
    {
        // scanner
        Scanner kb = new Scanner(System.in);

        // ask the user for abbreviation
        System.out.print("Input an abbreviation: ");
        String abbreviation = kb.nextLine();

        // make it case insensitive
        abbreviation = abbreviation.toUpperCase();

        // check the abbreviation 
        if (abbreviation.equals("LOL")) 
        {
            System.out.println("Laughing Out Loud");
        } 
        else if (abbreviation.equals("IDK")) 
        {
            System.out.println("I Don't Know");
        } 
        else if (abbreviation.equals("RTFM"))
        {
            System.out.println("Read The Full Manual");
        }
        else if (abbreviation.equals("IMHO"))
        {
            System.out.println("In My Humble Opinion");
        }
        else if (abbreviation.equals("TMI"))
        {
            System.out.println("Too Much Information");
        }        
        else 
        {
            System.out.println("Unknown");
        }
    }
}