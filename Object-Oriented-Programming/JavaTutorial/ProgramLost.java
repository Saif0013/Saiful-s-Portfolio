public class ProgramLost
{
    public static void main(String [] args)
    {
       int [] myNumber;

       int [] anotherNumber = {12, 13, 25, 46};

       /*System.out.println(anotherNumber[1]); // indexing starts from 0

        System.out.println(anotherNumber.length); // length counting starts from 1 */

        for (int i = 0; i < anotherNumber.length; i++)
        {
            System.out.println(anotherNumber[i]);
        }

 

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (String i : cars) 
        {
             System.out.println(i);
        }

    }

}