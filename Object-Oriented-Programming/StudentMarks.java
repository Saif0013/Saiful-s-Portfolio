import java.util.*;
public class StudentMarks
{
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		
        
		System.out.print("Please enter the number of tests: ");
		int testSize = kb.nextInt();

		
		System.out.print("Please enter the number of students: ");
		int studentSize = kb.nextInt();
        
        
		double [][] marks = new double [studentSize] [testSize];
        
        
		for(int s=0; s<studentSize; s++)
		{
		
			System.out.println("Enter Student " + (s+1) 
				+ " marks (" + testSize + " Tests - seperate by spaces)");

			
			for(int t=0; t<testSize; t++)
			{
                
				marks[s][t] = kb.nextDouble();
			}
		}

		
		
		for(int s=0; s<studentSize; s++)
		{
			
			    double sum = 0;

			
			for(int t=0; t<testSize; t++)
			{
                
				sum += marks[s][t];

			}
			
			    double studentAverage = sum/testSize;

				
				System.out.println("Average for student " + (s+1) + ": " + studentAverage);
		}

			
			
			for(int t=0; t<testSize; t++)
			{
				
				    double sum = 0;

				
				for(int s=0; s<studentSize; s++)
				{
					
					sum += marks[s][t];

					
					double testAverage = sum/studentSize;

					
					System.out.println("Average for test " + (t+1) + ": " + testAverage);
				}
			}
		
	}
}