import java.util.*;
public class ProPro
{
	public String doubleToHexaicosadecimalString(double in)
	{
		int a1 = (int)(in);
		String stringAccumulator="";
		double temp = in - a1;

		if (temp == 0)
		{
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
                	String s1 = Double.toString(in);
                	int dotIndex = s1.indexOf('.');
                	String s2 = s1.substring(dotIndex);
                	double temp1 = Double.parseDouble(s2);

                	while(temp1>0)
                	{
                		temp1 = temp1*26;
                		int tempVal = (int)(temp1);
                		char c = (char)(tempVal + 'a');
                		stringAccumulator = c + stringAccumulator;
                	}
                }


                public static void main(String [] args)
               {
	        HexaicosadecimalNumber myNumber = new HexaicosadecimalNumber(1234.5678);
        
                System.out.println(myNumber);

               }


        }
			

}




			


       