import java.util.Scanner;

public class CountMultiples
{
    public static void main(String[] args)
    {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // ask the user for input
        System.out.print("The input is: ");
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int x = scanner.nextInt();


        // count the multiple factor of x
        int count = 0;
        for (int i = low; i <= high; i++) 
        {
            if (i % x == 0)
            {
                count++;
            }
        }

        // print output
        System.out.println(count);

    }
}