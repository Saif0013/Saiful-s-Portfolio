import java.util.*;
import java.io.*;
public class PlantLoader
{
 public static Plant[] loadFromFile(String filename) 
 throws IOException
 {
 // Open file for reading
    Scanner s = new Scanner(new File(filename));

 // Read number of plants in file
    int num = s.nextInt();
    s.nextLine(); // clear \n

 // Initialize array of plants
    Plant[] plants = new Plant[num];

 // Read in the appropriate number of records by repeatedly
    for(int i=0; i<num; i++)
    {
        // Read type
        String type = s.nextLine();

        // Read name
        String name = s.nextLine();

        // Read comments
        String comments = s.nextLine();

        if(type.equals("Plant"))
        {
            plants[i] = new Plant(name, comments);
        }

        else if(type.equals("Edible"))
        {
            String season = s.nextLine();
            boolean harvestable = s.nextBoolean();
            s.nextLine(); //clear \n
            plants[i] = new Edible(name, comments, season, harvestable);
        }

        else if(type.equals("Poisonous"))
        {
            int dangerRating = s.nextInt();
            s.nextLine(); // clear /n
            plants[i] = new Poisonous(name, comments, dangerRating);
        }
    }

 // creating an object of the required type and saving it in the array
 // Close file and return the array
    s.close();
    return plants;
 }
   public static void main(String[] args) throws IOException
   {
   if(args.length < 1)
   {
       System.out.println
      ("Error! Command line argument for filename " +
       "not given!");
       return;
   }
      Plant[] plants =  loadFromFile(args[0]);

      // to complete – call method to load plants from file then display to screen

      System.out.println("Read " + plants.length + 
                        " plants from file.....");

      for(Plant p : plants)
      {
         System.out.println("----------");
         System.out.println("Plant " + p);
         System.out.println("-----------");
         System.out.println(p);
      }

   }
}
