import java.util.*;
public class Assessment4
{
	public static void main(String [] args)
	{
		ArrayList<Double> a = new ArrayList<Double>();

		a.add(17.9);
    	a.add(8.7);
    	a.add(6.9);
    	a.add(11.0);
    	a.add(-7.8);
    	a.add(-0.1);
    	a.add(-13.2);
    	a.add(9.5);
    	a.add(14.5);
    	a.add(9.6);

    	ArrayList<Double> b = new ArrayList<Double>();

    	b.add(10.3);
    	b.add(10.7);
    	b.add(-4.5);
    	b.add(-14.8);
    	b.add(1.6);
    	b.add(-15.2);
    	b.add(0.2);
    	b.add(-3.9);
    	b.add(7.3);
    	b.add(-2.7);

    	a.addAll(b);
    	System.out.println(a);

    	
    	 // Sorting in decreasing order
	   Collections.sort(a, Collections.reverseOrder());

	   System.out.println(a.get(17));



	   /* Sorted List in reverse order*/
	   /*System.out.println("ArrayList in descending order:");
	   for(double str: a){
			System.out.println(str);
		}*/
    	

	}
}