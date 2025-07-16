import java.util.*;
public class ExperimentOne
{
    public static void main(String [] args)
    {
        // initialize scanner
        Scanner kb = new Scanner(System.in);
        
        // Print message
        System.out.println("Enter an integer (between 1 and 7): ");
        // Ask for input
        int day = kb.nextInt();

        // write switch case
        switch (day)
        {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }
}







