double accumulator = 0.0;
		    for (int i =0; i<in.length(); i++)
		{
			char c = in.charAt(i);
			int d = digits.indexOf(c);
			accumulator += d * (Math.pow(26, (in.length()-(in.indexOf(c)+1))));
		}
		return accumulator;



		// comments:

			//find the decimal value for the whole part (identical to below) -> ab
		 //    for (int i = 0; i < (in.substring(0, in.indexOf('.'))).length(); i++)
			// {
			// 	char c = in.charAt(i);
			// 	int d = digits.indexOf(c);
			// 	accumulator += d * (Math.pow(26, ((in.substring(0, in.indexOf('.'))).length()-(in.indexOf(c)+1))));


			// 	for (int j = 0; j < (in.substring(in.indexOf('.')+1, in.length())).length(); j++)
			// 	{
			// 		char e = in.charAt(j);
			// 		int f = digits.indexOf(e);
			// 		accumulator += f * (Math.pow(26, ((in.substring(in.indexOf('.')+1, in.length())).length()-(in.indexOf(e)+1))));
			// 	}
			// }

        	//String wholePart = in.substring(0, in.indexOf('.'));

		// more comments:

		//find decimal value for the fractioanl part (.cd)
        	//String fracPart = in.substring(in.indexOf('.') + 1);


        	//make a for loop

        	//for each character, get the base value

        	// then let the base value * 26^(  (index+1) * (-1) )

        	//plus the result into the accumulator

		


		//if(in.contains("."))
	    //	{
	    //		double accumulator = 0.0;
	    //		for(int i=0; i<in.substring(1, in.indexOf('.')).length(); i++)
	    /*		{
	    			char c = in.charAt(i);
	    			int d = digits.indexOf(c);
	    			accumulator += d * Math.pow(26, (in.substring(1, indexOf('.'))).length()-(in.indexOf(c)+1)) * (-);
	    		}

	    		for (int j = 0; j < in.substring(in.indexOf('.')+1).length(); j++)
        	{
        		char e = in.charAt(j);
        		int f = digits.indexOf(e);
        		accumulator += f * Math.pow(26, ((in.indexOf(e)+1)*(-1)));
        	}
        	    return accumulator;

        	else
        	{
        		double accumulator = 0.0;
		        for (int i =0; i<in.length(); i++)
		    {
			    char c = in.charAt(i);
			    int d = digits.indexOf(c);
			    accumulator += d * (Math.pow(26, (in.length()-(in.indexOf(c)+1)))) * (-);
		    }
		        return accumulator;
        	}*/
