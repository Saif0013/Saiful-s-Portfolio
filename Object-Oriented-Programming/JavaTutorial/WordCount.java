/*
Write a Java method to count all words in a string. Use user input.

You should input the follwing in the terminal:

Input the string: The quick brown fox jumps over the lazy dog.

Expected Output:
Number of words in the string: 9
*/

import java.util.*;
public class WordCount
{
    // method to count word
    static int numberOfWords(String myStr)
    {
       int count = 0;
       for(int i = 0; i < myStr.length(); i++)
       {
        if (myStr.charAt(i) == ' ')
        {
            count++;
        }
       }
       count = count + 1;
       return count;
    }
    
    // main method
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Input the string: ");
        String str = kb.nextLine();

        System.out.println("Number of words in the string: " + numberOfWords(str));   
    }
}


/*
import java.util.*;
public class Exercise5 {

  public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the string: ");
        String str = in.nextLine();

        System.out.print("Number of words in the string: " + count_Words(str)+"\n");
    }

 public static int count_Words(String str)
    {
       int count = 0;
        if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1))))
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    count++;
                }
            }
            count = count + 1; 
        }
        return count; // returns 0 if string starts or ends with space " ".
    }
 }

 */