import java.lang.*;
import java.util.*;

public class ReadKeyboard2
{
       public static void main(String [] args)
       {
         String name;
         Scanner sc=new Scanner(System.in);
       
         System.out.println("What is your name?");
         name=sc.nextLine();          
         
         System.out.println("Welcome "+name);
        }


}