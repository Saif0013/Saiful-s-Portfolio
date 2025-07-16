public class PlusPlus
{
      public static void main(String [] args)
      {
        String str1 = "Facetious";
        String str2 = str1.substring(6,8);
        String str3 = str2.toUpperCase();
        String str4 = str1 + str3;
        char c = str4.charAt(5);
         
        System.out.println(c);
        System.out.println(str2);
}
}