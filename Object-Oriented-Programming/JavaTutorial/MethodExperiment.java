import java.util.*;

public class MethodExperiment
{
  // plus method
  static double DistanceCalculation(double x1, double x2, double y1, double y2)
  {
    // Calculate distance 
    double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    return distance;
  }
  
  
  // main method
  public static void main(String [] args)
  {
    // declare variables
    double x1, x2, y1, y2;
    // initialise scanner
    Scanner kb = new Scanner(System.in);

    // ask for input
    System.out.print("Please Enter Your First Number: ");
    // working code
    x1 = kb.nextDouble();

    // ask for input
    System.out.print("Please Enter Your Second Number: ");
    // working code
    x2 = kb.nextDouble();

    // ask for input
    System.out.print("Please Enter Your Third Number: ");
    // working code
    y1 = kb.nextDouble();

    // ask for input
    System.out.print("Please Enter Your Fourth Number: ");
    // working code
    y2 = kb.nextDouble();

    // calculate distance
    double totalDistance = DistanceCalculation(x1, x2, y1, y2);

    // print output
    System.out.println("Total distance: " + totalDistance);

  }
}