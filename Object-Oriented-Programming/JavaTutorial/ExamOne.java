import java.util.*;

public class ExamOne
{
    public static void main(String[] args)
    {
        // Scanner
        Scanner kb = new Scanner(System.in);

        // ask user for movie name
        System.out.println("Please input the name of the movie:");
        String nameOfMovie = kb.nextLine();

        // ask user for number of tickets
        System.out.println("Please input the number of tickets purchased:");
        int numOfTickets = kb.nextInt();

        // ask user for number of tickets
        System.out.println("Please input the cost per ticket:");
        double costPerTicket = kb.nextDouble();

        // calculate the total ticket cost
        double totalTicketCost = numOfTickets * costPerTicket; 

        // format the output on the screen
        // Create table to using format
        System.out.printf("%-17s%-17s%-17s%-17s", "Movie Name", "Number Purchased", "Cost Per Ticket", "Total");
        System.out.println();
        // Put the data into the table
        System.out.printf("%-17s%-17d$%-17.2f$%-17.2f", nameOfMovie, numOfTickets, costPerTicket, totalTicketCost);
        // Print blank line to take the cursor to next line
        System.out.println();       

    }
}