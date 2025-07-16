public class PhoneBookTester
{
 public static void main(String[] args) 
 {
 PhoneBook pb = new PhoneBook();
 pb.insert("Matt", "123");
 pb.insert("Rudri", "888");
 pb.insert("Elle", "987");
 pb.insert("Richard", "323");
 pb.insert("Simran", "246");
 pb.insert("Moises", "101");
 pb.insert("Todd", "456");
 pb.insert("Cam", "456");
 System.out.println(pb);
// deleteEntry and sortByName can be ignored
// but do all the other methods in the UML diagram.
 System.out.println();
 pb.deleteEntry("Richard");
 pb.deleteEntry("Fred");
 System.out.println(pb);
 //pb.sortByName();
 //System.out.println(pb);
 // etc.
 }
}