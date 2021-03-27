package problems.dcp;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

public class JobScheduler {
    private static BlockingQueue<Job> jobs;
    private int allowedSize = 100;

    public JobScheduler(int allowedSize) {
        this.allowedSize = allowedSize;
        jobs = new LinkedBlockingDeque<>();
    }

    public boolean canTakeMore() {
        return jobs.size() < allowedSize;
    }

    public void schedule(Job job) throws InterruptedException {
        new Thread(new JobTaker(), "JobTakerThread").start();
        if (!canTakeMore()) throw new IllegalStateException("Please try after sometime");
        jobs.put(job);
    }

    public static class JobTaker implements Runnable {

        public JobTaker() {
            System.out.println("Job taker initialized");
        }

        @Override
        public void run() {
            try {
                System.out.println("Waiting for a job to arrive.....");
                Job job = jobs.take();
                System.out.printf(String.format("Job - %s will run in %s ms", job.id, job.ms));
                job.schedule();
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
                System.out.println("Some exception occurred during job scheduling");
            }
        }
    }

    public static class Job<T extends Runnable> {
        private long id;
        private T task;
        private long startTime;
        private long ms; // time since when we start monitoring the task

        public Job(T task, long startTime, long ms) {
            this.id = System.currentTimeMillis();
            this.task = task;
            this.ms = ms;
            this.startTime = startTime;
        }

        public void schedule() {
            System.out.printf("Job [%s] scheduled %n", this.id);
            Thread t = new Thread(new MonitorThread());
            t.start();
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", startTime=" + startTime +
                    ", ms=" + ms +
                    '}';
        }

        private class MonitorThread implements Runnable {

            public void run() {
                long timeSinceStart = (System.currentTimeMillis() - startTime);
                while (timeSinceStart <= ms) {
                    timeSinceStart = (System.currentTimeMillis() - startTime);
                }
                System.out.println("Running the task");
                task.run();
            }
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        JobScheduler jobScheduler = new JobScheduler(1000);
        IntStream.rangeClosed(0, 10).forEach(id -> {
            long msec = (random.nextInt(10) + 2) * 1000;
            try {
                Job<Runnable> job = new Job<>(() -> System.out.printf("I [%s] am running%n", msec), msec, System.currentTimeMillis());
                jobScheduler.schedule(job);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        });
    }
}

