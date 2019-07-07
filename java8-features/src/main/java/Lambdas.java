import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Lambdas
{
    @FunctionalInterface
    public interface ExceptionHandler
    {
        void execute() throws FileNotFoundException;
    }

    public static void handleErrors(ExceptionHandler handler)
    {
        try
        {
            handler.execute();
        }
        catch (FileNotFoundException e)
        {

        }
    }

    public static class Transactions
    {
        private String name;
        private int age;

        public Transactions(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public int getAge()
        {
            return age;
        }
    }

    public static void main(String[] args)
    {
        // predicate 1
        new File("/tmp").listFiles(File::isHidden);
        // predicate 2
        new File("/tmp").listFiles(File::isDirectory);

        // stream operations to group by foo
        Map<String, List<Transactions>> foos = new HashMap<>();
        final List<Transactions> transactions =
                Arrays.asList(new Transactions("white", 20), new Transactions("black", 1));
        foos.put("foo1", transactions);
        final List<Transactions> moreTransactions =
                Arrays.asList(new Transactions("white", 10), new Transactions("black", 12));
        foos.put("foo2", moreTransactions);
        // before java8 - In order to group transactions by name we would have lot of boiler plate code
        // now in java8
        final Map<Integer, List<Transactions>> collect = transactions.stream().filter((Transactions t) -> t.age > 10)
                                                                     .collect(Collectors
                                                                             .groupingBy(Transactions::getAge));


        final Lambdas lambdas = new Lambdas();
        handleErrors(() -> {
            lambdas.validateStartsWithLowerCaseChar("aAaA");
            lambdas.validateEmptyString("AaAaA");
        });

        // order of evaluation
        final List<Integer> collect1 = transactions.stream().filter(n -> {
            System.out.println("Filtering " + n);
            return n.getAge() > 1;
        }).map(t -> {
            System.out.println("Mapping -> " + t.getAge());
            return t.getAge();
        }).limit(2).collect(toList());
        System.out.println(collect1);

        // flat streams
        List<String> words = Arrays.asList("hello", "world");
        final List<String> collect2 =
                words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect2);

        List<Integer> numbers = Arrays.asList(1, 3, 5, 6);
        List<Integer> moreNums = Arrays.asList(11, 33);
        System.out.println(numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList()));
        numbers.stream().flatMap(n -> moreNums.stream().filter(integer -> (integer + n) % 3 == 0).map(mn -> new int[]{n, mn})).collect(toList()).forEach(ints -> System.out
                .println(ints[0] + ", " + ints[1]));
        // reduction operation
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        // transactions in a year sorted by value
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println(transactionList.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList()));
        System.out.println(transactionList.stream()
                                          .map(Transaction::getTrader)
                                          .filter(t -> t.getCity().equals("Cambridge"))
                                          .sorted(Comparator.comparing(Trader::getName))
                                          .collect(toList()));
        System.out.println(transactionList.stream()
                                          .map(t -> t.getTrader().getName())
                                          .sorted()
                                          .distinct()
                                          .collect(toList()));
        System.out.println(transactionList.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
        System.out.println(transactionList.stream()
                                          .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                                          .map(Transaction::getValue)
                                          .collect(Collectors.toList()));
        System.out.println(transactionList.stream()
                                          .map(Transaction::getValue)
                                          .reduce(Integer::max).orElse(-1));
        System.out.println(transactionList.stream()
                                          .map(Transaction::getValue)
                                          .reduce(Integer::min).orElse(-1));


        // fibonacci series
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(2).forEach(t -> System.out.printf("(%d,%d)%n,", t[0], t[1]));
        // group transactions based on the names of the traders
        transactionList.stream().collect(groupingBy(Transaction::getTrader, counting())).forEach((trader, aLong) -> {
            System.out.printf("%s - %d%n", trader.getName(), aLong);
        });

        // partition by cities
        System.out.println(transactionList.stream().map(t -> t.getTrader().getName()).distinct().collect(partitioningBy(t -> t.startsWith("R"))));
        // summarizingInt
        System.out.println(transactionList.stream().map(Transaction::getValue).collect(summarizingInt(Integer::intValue)));
    }

    public void validateStartsWithLowerCaseChar(String str) throws FileNotFoundException
    {
        if (str.startsWith("A")) throw new FileNotFoundException("A is not allowed");
    }

    public void validateEmptyString(String str) throws FileNotFoundException
    {
        if (str.isEmpty()) throw new FileNotFoundException("Give me something.");
    }

    public static class Trader
    {
        private final String name;
        private final String city;

        public Trader(String n, String c)
        {
            this.name = n;
            this.city = c;
        }

        public String getName()
        {
            return this.name;
        }

        public String getCity()
        {
            return this.city;
        }

        public String toString()
        {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction
    {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value)
        {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader()
        {
            return this.trader;
        }

        public int getYear()
        {
            return this.year;
        }

        public int getValue()
        {
            return this.value;
        }

        public String toString()
        {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }
}
