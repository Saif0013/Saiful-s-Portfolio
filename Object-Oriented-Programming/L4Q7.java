public class L4Q7
{
	public static void main(String [] args)
	{
	  double initialBalance = 25000.00;
	  final int years = 10;
	  final double Rate = 0.04;
	  double balance = initialBalance;

	  for (int year = 1; year <= years; year++)
	  {
	  	double interest = balance * Rate;
	  	balance = balance + interest;

	    System.out.println("Balance at year " + year + ": " + balance);
	  }
	}
}