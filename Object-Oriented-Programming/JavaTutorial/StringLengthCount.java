import java.util.*;
public class StringLengthCount 
{

  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the string: ");
        String str = in.nextLine();

        System.out.println("Number of words in the string: " + str.length());
    }
}