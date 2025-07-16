public class Progr
{
	public static double htod(String in)
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

	public static void main(String [] args)
	{
		String hexNum = "done";
		double decNum = htod(hexNum);

		System.out.println(decNum);
	}
}