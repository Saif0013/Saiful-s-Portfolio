import java.util.*;
import javax.swing.*;

public class ProgramSummary
{
    public static void main(String[] args)
    {
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

        // create table to pritn output
        JFrame frame = new JFrame();

        // set column names into an array
        String [] columnNames = {" ", "Bronze", "Silver", "Gold", "Platinum"};

        // create an object using multidimentional array with given data
        Object[][] data = {
            {"Score Range", "500 - 999", "1000 - 1999", "2000 - 2999", "3000+"}
        };    

        // format all the data as table
        JTable table = new JTable(data, columnNames); 

        // add table to the frame and edit frame
        table.getColumnModel().getColumn(0).setPreferredWidth(14);
        table.getColumnModel().getColumn(1).setPreferredWidth(14);
        table.getColumnModel().getColumn(2).setPreferredWidth(14);
        table.getColumnModel().getColumn(3).setPreferredWidth(14); 
        table.getColumnModel().getColumn(4).setPreferredWidth(14);             

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);   
        
    }
}
