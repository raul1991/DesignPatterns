import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample
{
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(5);
        int nofWorkers = 5;
        for (int i = 0; i < nofWorkers; i++)
        {
            int finalI = i;
            new Thread(() -> {
                System.out.printf("Worker thread %s%n", finalI);
                latch.countDown();
            }).start();
        }
    }
}
