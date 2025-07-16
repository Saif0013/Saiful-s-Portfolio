import java.util.*;

public class TestingProgram
{
    public static void main(String[] args)
    {
      // initialize scanner
      Scanner kb = new Scanner(System.in);

      // Prompt the user for the range of numbers
      System.out.print("Please enter the number of elements to be paired.");
      int range = kb.nextInt();

      // Create a collection to hold 2 of each number
      List<Integer> numbers = new ArrayList<Integer>();
      for (int i = 1; i <= range; i++) 
      {
         numbers.add(i);
         numbers.add(i);
      }

      // Sort the collection in ascending order
      Collections.sort(numbers);

      // Print line
      System.out.println("--------------------------");
      
      // Print the table of numbers with a maximum of 5 numbers per row
      int count = 0;
      for (int i = 0; i < numbers.size(); i++) 
      {
         System.out.format("|%4s", numbers.get(i));
         count++;
         if (count == 5) 
         {
            System.out.print("|");
            System.out.println();
            System.out.println("--------------------------");
            count = 0;
         }
      }

      // Set the counter to track how many numbers have not been used
      int unusedNumbers = numbers.size();
       


      // use a fixed seed for testing purposes
      System.out.print("Please enter a seed number for testing purposes.");
      int seed = kb.nextInt();

      // Seed a randomizer for testing purposes
      Random random = new Random(seed);  

      // Print line
      System.out.println("--------------------------");

      // Iterate over the collection until all numbers have been used
      while (unusedNumbers > 0) 
      {
         // Retrieve a random number (to be used as an index for retrieving a value from the original collection)
         int index = random.nextInt(numbers.size());
         int number = numbers.get(index);

         // Check if the number has not been used before
         if (number != 0) 
         {
            // Print the number
            System.out.format("|%4s", number);

            // Set the original number to zero to mark as used
            numbers.set(index, 0);

            // Check if a new line is required
            if (--unusedNumbers % 5 == 0) 
            {
               System.out.print("|");
               System.out.println();
               System.out.println("--------------------------");
               count = 0;
            }
         }
      }
      
    }
}