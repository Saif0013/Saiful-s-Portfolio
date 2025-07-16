public class PracticeProblem
{
      public static void main(String [] args)
      {
        int num1 = 64;
        int num2 = 3;
        num2++;
        int num3 = num1 >> num2;
        int num4 = 25 * num3;
        int solution = num4 - 2;
       
        System.out.println(num2);
        System.out.println(num3); 
        System.out.println("Solution: " + solution);
       }
}