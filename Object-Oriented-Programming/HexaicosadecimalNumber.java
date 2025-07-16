/*MD SAIFUL ISLAM
STUDENT ID - 18882762*/

import java.util.*;
import java.math.*;
public class HexaicosadecimalNumber
{
	private String stringRepresentation;
	private double doubleRepresentation;
    
    // Constructor 1
	public HexaicosadecimalNumber(String stringRepresentation)
	{
		this.stringRepresentation = stringRepresentation;
		this.doubleRepresentation = hexaicosadecimalStringToDouble(stringRepresentation);
	}


	// Constructor 2
	public HexaicosadecimalNumber(double doubleRepresentation)
	{
		this.doubleRepresentation = doubleRepresentation;
		this.stringRepresentation = doubleToHexaicosadecimalString(doubleRepresentation);
	}

	// helper function
	public double hexaicosadecimalStringToDouble(String in)
	{
		in = in.toLowerCase();
        
        if (in.contains(".") && !in.contains("-"))
        {
        	// example: ab.cd
        	double accumulator = 0.0;
        	int baseValue = 0;

        	int dotIndex = in.indexOf('.');
        	for (int i = 0; i < dotIndex; i++)
        	{
        		baseValue = in.charAt(i) - 'a';
        		
        		accumulator += baseValue * (Math.pow(26,dotIndex-(i+1)));
        	}

        	for (int j = dotIndex+1; j < in.length(); j++)
        	{
        		baseValue = in.charAt(j) - 'a';
        		accumulator += baseValue * Math.pow(26, (dotIndex+1)-(j+1));
        	}
        	return accumulator;
	    }

	    else if(in.contains("-") && in.contains("."))
	    {
	    	double accumulator = 0.0;
	    	int baseValue = 0;
	    	int dotIndex = in.indexOf('.');
	    	int negIndex = in.indexOf("-");
	    
	    	for(int i = negIndex+1; i < dotIndex; i++)
	    	{
	    		baseValue = in.charAt(i) - 'a';
	    		accumulator += baseValue * (Math.pow(26, dotIndex-(i+1)));
	    	}

	    	for(int j = dotIndex+1; j < in.length(); j++)
	    	{
	    		baseValue = in.charAt(j) - 'a';
	    		accumulator += baseValue * Math.pow(26, (dotIndex+1)-(j+1));
	    	}
	    	return accumulator * (-1);
        }

        else if(in.contains("-"))
        {
        	double accumulator = 0.0;
        	int baseValue = 0;
        	int negIndex = in.indexOf("-");

        	for(int i = negIndex+1; i < in.length(); i++)
        	{
        		baseValue = in.charAt(i) - 'a';
        		accumulator += baseValue * (Math.pow(26, (in.length()-(i+1))));
        	}
        	return accumulator * (-1);
        }




	    else
	    {
	    	double accumulator = 0.0;
	    	int baseValue = 0; 

		    for (int i =0; i<in.length(); i++)
		{
			baseValue = in.charAt(i) - 'a';
			accumulator += baseValue * (Math.pow(26, (in.length()-(i+1))));
		}
		return accumulator;
	    }
	}

	

    // helper function
	public String doubleToHexaicosadecimalString(double in)
	{
		String str = Double.toString(in);
		char c1 = str.charAt(0);

		if (c1 == '-')
		{
			in = in*(-1);
			int iVal = (int)(in);
			double dfVal = in - iVal;

			if(dfVal==0)
			{
				int temp = (int)(in);
		        String stringAccumulator = "";

		     while(temp>0)
		    {
			int currValue = temp%26;
			char c = (char)(currValue + 'a');
			stringAccumulator = c + stringAccumulator;
			temp = temp/26;
		    }
		    return "-"+stringAccumulator;


			} 

			else
			{
				int temp = (int)(in);
		        String stringAccumulator = "";

		      while(temp>0)
		    {
			int currValue = temp%26;
			char c = (char)(currValue + 'a');
			stringAccumulator = c + stringAccumulator;
			temp = temp/26;
		    }
        
        
		    double d1 = in - temp;
		    String s1 = Double.toString(in);
            int dotIndex = s1.indexOf('.');
            int length = s1.substring(dotIndex+1).length();

		    BigDecimal bVal = new BigDecimal(d1);
		    BigDecimal bfVal = bVal.movePointRight(length);
		    int frac = bfVal.intValue();


            String stringAccumulator1 = "";
            while(frac>0)
            {
        	int currVal = frac%26;
        	char c2 = (char)(currVal + 'a');
        	stringAccumulator1 = c2 + stringAccumulator1;
        	frac = frac/26; 
            }
             return "-"+stringAccumulator+"."+stringAccumulator1;

			}
		}
		else
		{
			
			int i1Val = (int)(in);
			double df1Val = in - i1Val;

			if (df1Val == 0)
			{
				int temp = (int)(in);
		        String stringAccumulator = "";

		       while(temp>0)
		    {
			int currValue = temp%26;
			char c = (char)(currValue + 'a');
			stringAccumulator = c + stringAccumulator;
			temp = temp/26;
		    }
		    return stringAccumulator;

		    }

			else
			{
				int temp = (int)(in);
		        String stringAccumulator = "";

		       while(temp>0)
		    {
			int currValue = temp%26;
			char c = (char)(currValue + 'a');
			stringAccumulator = c + stringAccumulator;
			temp = temp/26;
		    }
        
        
		    double d1 = in - temp;
		    String s1 = Double.toString(in);
            int dotIndex = s1.indexOf('.');
            int length = s1.substring(dotIndex+1).length();

		    BigDecimal bVal = new BigDecimal(d1);
		    BigDecimal bfVal = bVal.movePointRight(length);
		    int frac = bfVal.intValue();


            String stringAccumulator1 = "";
            while(frac>0)
            {
        	int currVal = frac%26;
        	char c2 = (char)(currVal + 'a');
        	stringAccumulator1 = c2 + stringAccumulator1;
        	frac = frac/26; 
            }
            return stringAccumulator+"."+stringAccumulator1;
			
			}
		}
	}

	public String toString()
	{
		return stringRepresentation + "(" + doubleRepresentation + ")";

	}

	


     public static void main(String [] args)
	 {
		while (true)
		{
		Scanner Keyboard = new Scanner(System.in);
		System.out.print("Please enter mode(h for hexaicosa /d for decimal /q for quit): ");
		char c = Keyboard.nextLine().charAt(0);

		if (c =='H' || c == 'h')
		{
			System.out.print("Please enter your hexiacosadecimal number(string): ");
			String s1 = Keyboard.nextLine();
			HexaicosadecimalNumber myStr = new HexaicosadecimalNumber(s1);
			System.out.println(myStr);
		}

		else if (c == 'd' || c == 'D')
		{
			System.out.print("Please enter your Decimal number(double): ");
			Double d1 = Keyboard.nextDouble();
			HexaicosadecimalNumber myNum = new HexaicosadecimalNumber(d1);
			System.out.println(myNum);
		}

		else if (c == 'q' || c == 'Q')
		{
			System.out.println("Program Ended.");
			break;
		}

		else
		{
			System.out.println("Invalid input");
		}
	     }
	}


}