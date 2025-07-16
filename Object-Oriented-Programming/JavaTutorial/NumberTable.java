/*
Promt the user for the range of numbers.
Create collection to hold 2 of each number.
Populate the collection with all the numbers including duplicates in ascending order
Print the table of numbers in the original order with a maximum of 5 numbers per row.
Set counter to maximum index of collection to track how many numbers have not been used.
SEED a randomiser for testing purposes (use the Random class for this).
Iterate over the collection until all numbers have been used
	Retrieve a random number (to be used as an index for retrieving a value
	from the original collection.)
	IF the number has not been used before (check if the value is equal to zero,
	meaning it has already been used)
		Print the number 
		Set the original number to zero to mark as used
		IF a new line is required.
			Print new line
			Reset new line required counter
	Decrement unusedNumbers


*/

import java.util.*;

public class NumberTable {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // Prompt the user for the range of numbers
      System.out.print("Enter the range of numbers: ");
      int range = scanner.nextInt();

      // Create a collection to hold 2 of each number
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= range; i++) {
         numbers.add(i);
         numbers.add(i);
      }

      // Sort the collection in ascending order
      Collections.sort(numbers);

      // Print the table of numbers with a maximum of 5 numbers per row
      int count = 0;
      for (int i = 0; i < numbers.size(); i++) {
         System.out.print(numbers.get(i) + " ");
         count++;
         if (count == 5) {
            System.out.println();
            count = 0;
         }
      }

      // Set the counter to track how many numbers have not been used
      int unusedNumbers = numbers.size();

      // use a fixed seed for testing purposes
      System.out.print("Please enter a seed number for testing purposes: ");
      int seed = scanner.nextInt();

      // Seed a randomizer for testing purposes
      Random random = new Random(seed);

      // Iterate over the collection until all numbers have been used
      while (unusedNumbers > 0) {
         // Retrieve a random number (to be used as an index for retrieving a value from the original collection)
         int index = random.nextInt(numbers.size());
         int number = numbers.get(index);

         // Check if the number has not been used before
         if (number != 0) {
            // Print the number
            System.out.print(number + " ");

            // Set the original number to zero to mark as used
            numbers.set(index, 0);

            // Check if a new line is required
            if (--unusedNumbers % 5 == 0) {
               System.out.println();
               count = 0;
            }
         }
      }
   }
}

