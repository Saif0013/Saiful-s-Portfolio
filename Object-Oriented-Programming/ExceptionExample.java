public class ExceptionExample 
{
  public static void main(String[] args) 
  {
    try {
      int a1 = Integer.parseInt(args[0]);
      int a2 = Integer.parseInt(args[1]);

      int[] array = new int[a1];
      array[a2] = a1 / a2;

    } catch (ArithmeticException e) {
      System.out.println("ArithmeticException");
      return;
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException");
      return;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("IndexOutOfBoundsException");
      return;
    } catch (NegativeArraySizeException e) {
      System.out.println("NegativeArraySizeException");
      return;
    }

    System.out.println("OK");

    return;
  }
}