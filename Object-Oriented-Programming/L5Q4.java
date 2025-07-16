public class L5Q4
{
 public static void main(String[] args)
 {
    String s1 = "We are in week5 of the semester";
    int spaceIndex1 = s1.indexOf(" ");
    String firstWord = s1.substring(0, spaceIndex1);

    int spaceIndex2 = s1.lastIndexOf(" ");
    String lastWord = s1.substring(spaceIndex2 + 1);
 
 System.out.println(firstWord + " "+ lastWord);
 }
}