import java.util.Scanner;

public class AustralianTax
{
    public static void main(String[] args)
    {
        // scanner
        Scanner kb = new Scanner(System.in);
        
        // ask the user for input
        System.out.print("The input is: ");
        int wagesEarned = kb.nextInt();
        int interestEarned = kb.nextInt();
        int unemploymentBenefits = kb.nextInt();
        int relationshipStatus = kb.nextInt();
        int taxesWithheld = kb.nextInt();
        // calculate the AGI
        int agi = wagesEarned + interestEarned + unemploymentBenefits;

        // Determine the tax deduction based on relationship status
        int deduction = (relationshipStatus == 2) ? 24000 : 12000;

        // Calculate the taxable income
        int taxableIncome = agi - deduction;
        taxableIncome = (taxableIncome < 0) ? 0 : taxableIncome;

        // Print the results
        System.out.printf("AGI: %,d%n", agi);
        System.out.printf("Deduction: %,d%n", deduction);
        System.out.printf("Taxable Income: %,d%n", taxableIncome);

    }
}


