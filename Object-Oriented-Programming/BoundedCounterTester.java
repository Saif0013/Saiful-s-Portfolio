public class BoundedCounterTester
{
    public static void main(String [] args)
    {
        // Test1: Create a new counter and display it.

        System.out.println("Test1");
        BoundedCounter myCounter = new BoundedCounter();
        myCounter.display();

        // Test2: Send the next message to the counter a few times
        // and display the counter each time.

        System.out.println("Test2");
        myCounter.next();
        myCounter.display();
        myCounter.next();
        myCounter.display();

        myCounter.next();
        myCounter.display();

        // Test3: Test reset and display the counter

        System.out.println("Test3");
        myCounter.reset();
        myCounter.display();

        // Test4: Test getCounter

        System.out.println("Test4");

        System.out.println("getCounter: " + myCounter.getCounter());

         // Test5: Test the device behaviour near the MAXIMUM and
         // after MAXIMUM is reached. Hint: write a for loop to
        // increment the counter to around 996. Then write a for
        // loop that increments the counter 10 more times,
        // displaying the counter each time it is incremented.

        System.out.println("Test5");

        for (int i = 0; i < 996; i++)
        {
            myCounter.next();
        }

        myCounter.display();

        for (int i = 0; i < 10; i++)
        {
            myCounter.next();
            myCounter.display();
        }


 
    }
}














 