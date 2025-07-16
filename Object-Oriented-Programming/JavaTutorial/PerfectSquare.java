import java.util.*;
import javax.swing.*;

public class PerfectSquare
{
    public static void main(String [] args)
    {
        // Initialize scanner
        Scanner kb = new Scanner(System.in);

        // Ask for user input
        System.out.print("Please input your first decimal value: ");
        // store the input value
        double num1 = kb.nextDouble();
        // find the square root of input and store as integer
        int squareRoot1 = (int) Math.sqrt(num1);
        // check perfect square root or not
        boolean checkNum1 = perfectSquare(num1);

        // Ask for user input
        System.out.print("Please input your second decimal value: ");
        // store the input value
        double num2 = kb.nextDouble();
        // find the square root of input and store as integer
        int squareRoot2 = (int) Math.sqrt(num2);
        // check perfect square root or not
        boolean checkNum2 = perfectSquare(num2);

        // Ask for user input
        System.out.print("Please input your third decimal value: ");
        // store the input value
        double num3 = kb.nextDouble();
        // find the square root of input and store as integer
        int squareRoot3 = (int) Math.sqrt(num3);
        // check perfect square root or not
        boolean checkNum3 = perfectSquare(num3);

        // create table to pritn output
        JFrame frame = new JFrame();

        // set column names into an array
        String [] columnNames = {"Input", "Square Root as Integer", "Perfect Square"};

        // create an object using multidimentional array with given data
        Object[][] data = {
            {num1, squareRoot1, checkNum1},
            {num2, squareRoot2, checkNum2},
            {num3, squareRoot3, checkNum3}
        };

        // format all the data as table
        JTable table = new JTable(data, columnNames);

        // add table to the frame and edit frame
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        //table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);

    }

    // method to find perfect square
    static boolean perfectSquare(double num)
    {
        // calculate square root
        int squareRoot = (int) Math.sqrt(num);
        // find the square of squareRoot
        int square = squareRoot * squareRoot;

        // determine if number is perfect square
        if ((num - square) == 0) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}