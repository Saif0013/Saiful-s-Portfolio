import java.util.*;
public class NumberGame 
{
    public static void main(String[] args)
    {
        // initialize scanner
        Scanner kb = new Scanner(System.in);

        // Prompt user for range of numbers
        System.out.print("Please enter the number of elements to be paired: ");
        int range = kb.nextInt();

        // Create collection to hold number pairs
        List<Integer> pairs = new ArrayList<>();

        // Populate collection with all numbers including duplicates in ascending order
        for (int i = 1; i <= range; i++) 
        {
            pairs.add(i);
            pairs.add(i);
        }

        // Shuffle collection using a fixed seed for testing purposes
        System.out.print("Please enter a seed number for testing purposes: ");
        int seed = kb.nextInt();
        Collections.shuffle(pairs, new Random(seed));

        // Print table of number pairs with 5 numbers per row
        int count = pairs.size();
        int newLineCount = 0;
        for (int i = 0; i < count; i++)
        {
            int num = pairs.get(i);
            if (num != 0) 
            {
                System.out.printf("%4d", num);
                pairs.set(i, 0); // mark number as used
                if (++newLineCount == 5)
                {
                    System.out.println();
                    newLineCount = 0;
                }
            }
        }          



    }
}