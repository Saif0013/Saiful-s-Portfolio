import java.util.*;

public class MyShapes
{
	public static int volume(int side)
	{
		return (int)Math.pow(side, 3);
	}

	public static double volume(double radius)
	{
		return (4/3)* Math.PI * Math.pow(radius, 3);
	}

	public static double volume(double length, double width, double height)
	{
		return length * width * height;
	}

	public static double volume(double radius, double height)
	{
		return Math.PI * Math.pow(radius, 2) * height;
	}

	public static void main(String [] args)
	{
		System.out.println("Please enter side: ");
		Scanner k1 = new Scanner(System.in);
		int s1 = k1.nextInt();
		System.out.println("Voume of Cube: " + MyShapes.volume(s1));

		System.out.println("Please enter radius of the circle: ");
		double r1 = k1.nextDouble();
		System.out.println("Volume of sphere: "+ MyShapes.volume(r1));

		System.out.println("Please enter rectangle prism: ");
		double d1 = k1.nextDouble();
		double d2 = k1.nextDouble();
		double d3 = k1.nextDouble();
		System.out.println("Volume of rectangle: "+ MyShapes.volume(d1, d2, d3));

		System.out.println("Please enter radius and height: ");
		double c1 = k1.nextDouble();
		double c2 = k1.nextDouble();
		System.out.println("Volume of cylinder: "+ MyShapes.volume(c1, c2));

		System.out.println(volume(7.800000, 13.400000, 13.100000));

	}
}