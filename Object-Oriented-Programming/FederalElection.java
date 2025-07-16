public class FederalElection
{
	public static void main(String [] args)
	{
	   int coalitionVotes = 6818824;
	   int laborVotes = 6722277;
	   int formalVotes = coalitionVotes + laborVotes;
	   double coalitionPercentage = ((double)coalitionVotes/formalVotes)*100;
	   double laborPercentage = ((double)laborVotes/formalVotes)*100;

	   System.out.println("Total formal votes: " + formalVotes);
	   System.out.println("Coalition percentage: " + coalitionPercentage + " %");
	   System.out.println("Labor percentage: " + laborPercentage + " %");
	}
}