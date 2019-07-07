import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In this example we will let two or more threads access an array list
 */
public class ConcurrentModificationExceptionExample
{
    private static List<String> strings = new ArrayList<>(Arrays.asList("Transactions", "Bar", "FoooooBar")); // the list which the threads will try to access.

    public static void main(String[] args)
    {
        final int nofThreads = 2;
        for (int i = 0; i < nofThreads; i++)
        {
            new Thread(new TweakerThread( String.format("Tweaker-%d", i)), "Tweaker-"+i).start();
        }
    }

    private static class TweakerThread implements Runnable
    {
        private final String name;

        public TweakerThread(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < strings.size(); i++)
            {
                String s = strings.get(i);
                System.out.printf("[Thread %s] retrieved - %s%n", name, s);
                try
                {
                    Thread.sleep(1000);
                    strings.add("blah"+i);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Exception occurred!");
                }
            }
        }
    }
}
