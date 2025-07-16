import java.math.*;
public class multiply
{
	public static void main(String [] args)
	{
        double in = 1234.5678;
        int temp = (int)(in);
		double d1 = in - temp;
		String s1 = Double.toString(in);
        int dotIndex = s1.indexOf('.');
        int length = s1.substring(dotIndex+1).length();

		BigDecimal bVal = new BigDecimal(d1);
		BigDecimal bfVal = bVal.movePointRight(length);
		int frac = bfVal.intValue();


		System.out.println(frac);
		/*double in = 1234.5678;
        int temp = (int)(in);

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
        	char c1 = (char)(currVal + 'a');
        	stringAccumulator1 = c1 + stringAccumulator1;
        	frac = frac/26; 
        }

        //return stringAccumulator1;

        System.out.println(stringAccumulator1);*/
        

        
        
      
	}
}


/*double d1 = 125.7689;
		int a1 = (int)(d1);
		double d2 = d1 - a1;
		String s1 = Double.toString(d1);
		int dotIndex = s1.indexOf('.');
		int length = s1.substring(dotIndex+1).length();

		BigDecimal bValue = new BigDecimal(d2);
		BigDecimal bfValue = bValue.movePointRight(length);

		System.out.println(length);

		double d5 = d2 * Math.pow(10, length);

		System.out.println(d5);

		int a5 = (int)(d5);
		System.out.println(a5);*/

		/*double dVal = 520.0;
		
		String s1 = Double.toString(dVal);
		char c = s1.charAt(0);

		if (c == '-')
		{
			dVal=dVal*(-1);
			int iVal = (int)(dVal);
			double dfVal = dVal - iVal;

			if(dfVal==0)
			{
				System.out.println("Zero");
			} 

			else
			{
				System.out.println("Non-zero");
			}
		}
		else
		{
			int pVal = (int)(dVal);
			double df1Val = dVal - pVal;

			if (df1Val == 0)
			{
				System.out.println("Encrypted code!");
			}

			else
			{
				System.out.println("Encryption corupted!");
			}
		}*/


		/*int a = 2;
		double d1 = a * Math.pow(26, (-1));
		d1 = d1/Math.pow(26, (-1));
		System.out.println(d1);*/
