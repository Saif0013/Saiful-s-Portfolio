public class votes
{
    public static void main(String [] args)
    {
        // First part

        // declare and initialize liberal/National Coalition votes
        int libNatVotes = 6818824;
        // declare and initialize labor votes
        int laborVotes = 6722277;
        // calculate total formal votes
        int totalFormalVotes = libNatVotes + laborVotes;
        // print formal votes
        System.out.println("Total number of formal Votes: " + totalFormalVotes);


        // Second part

        // calculate percentage for liberal party
        // previous numbers were int 
        // int divided by an int would give you a result 0
        // you need use type casting to convert at least one 
        // number to double
        // please refer to type casting from w3schools
        double libNatPercentage = ((double) libNatVotes) / totalFormalVotes;
        // calculate percentage for labor party
        double laborPercentage = ((double) laborVotes) / totalFormalVotes;

        // print output on the screen
        System.out.println("Liberal/National Percentage: " + libNatPercentage);
        System.out.println("Labor Percentage: " + laborPercentage);

    }
}