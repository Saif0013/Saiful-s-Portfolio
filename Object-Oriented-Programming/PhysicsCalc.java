import java.util.*;
public class PhysicsCalc
{
	public static void main(String [] args)
	{
		double time = 3.0;
		double initialVelocity = 4.5;
		double acceleration = 9.5;
		double finalVelocity = 0;
		double displacement = 0;

        // Equation 1:
		double displacement1 = initialVelocity * time;

		System.out.println("Equation 1: " + displacement1);

		// Equation 2:
		double displacement2 = initialVelocity * time + (1/2 * acceleration * time * time);

		System.out.println("Equation 2: " + displacement2);

		// Equation 3:
		double finalVelocity1 = initialVelocity + acceleration * time;

		System.out.println("Equation: " + finalVelocity1);

		// Equation 4:
		double finalVelocity2 = Math.sqrt((initialVelocity * initialVelocity) + 2*acceleration*displacement1);

		System.out.println("Equation 4: " + finalVelocity2);
	}
}