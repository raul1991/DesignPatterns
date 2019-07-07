package streams;

import streams.domainobjects.Dish;
import streams.domainobjects.Trader;
import streams.domainobjects.Transaction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClient
{
    public static void main(String[] args)
    {
        // difference between external and internal iteration.
        int[] arr = new int[]{1, 3, 5};
        // here foreach does the iteration for us and only asks for a function to be executed.
        Arrays.stream(arr).forEach(System.out::println);

        // construct dishes
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 150, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // Construct Trader and Transaction
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // intermediate operations.
        // See the output - They are being printed as they are encountered in the list and not all at once.
        List<String> names = menu.stream().filter(d -> {
            System.out.println("Filtering" + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("Mapping" + d.getName());
            return d.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(names);

        //Operations - Map
        // example: Given a list of words, output : char count of each
        String[] words = new String[]{"hello", "foo"};
        Arrays.stream(words).map(String::length).forEach(System.out::println);

        // When to use a Flatmap - consider the below example
        // we are given an array of words and we need to return unique chars in the array
        // using the below solution gives us a Stream<Stream<String>>
        System.out.println(Arrays.stream(words)
                                 .map(s -> s.split(""))
                                 .map(Arrays::stream)
                                 .distinct()
                                 .collect(Collectors.toList()));
        // this is the right solution - If you have intellij, you can see it while you type code.
        System.out.println(Arrays.stream(words)
                                 .map(s -> s.split(""))
                                 .flatMap(Arrays::stream)
                                 .distinct()
                                 .collect(Collectors.toList()));

        // example: return pairs
        // given two list of numbers, output : all pairs that can be formed
        List<Integer> numbers = Arrays.asList(1,3,4,5);
        List<Integer> moreNumbers = Arrays.asList(14,15);
        numbers.stream()
               .flatMap(i -> moreNumbers.stream().filter(j -> i + j % 3 == 0).map(j -> new int[]{i,j}))
        .collect(Collectors.toList());

        // Operations - finding and matching
        menu.stream().anyMatch(Dish::isVegetarian);
        menu.stream().noneMatch(Dish::isVegetarian);

        // Operations - reduce
        Arrays.stream(new int[]{1,3,4,5,6}).reduce(1, (a,b) -> a * b);
        menu.stream().map(d -> 1).reduce(0, Integer::sum);
//        menu.stream().sorted().map(d -> 1).reduce(0, Integer::sum);

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println(transactions.stream()
                    .filter(transaction -> transaction.getYear() == 2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .map(Transaction::getValue)
                    .collect(Collectors.toList()));
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).collect(Collectors.toList());
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct();
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).filter(s -> s.equals("Cambridge"));
        System.out.println("Sorted alphabetically \n" +
                transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .collect(Collectors.joining()));

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("/tmp/out.txt"), Charset.defaultCharset()))
        {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct().count();
        }
        catch (IOException e)
        {
            System.out.println("Exception occurred!");
        }

        // infinite streams
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]}).limit(3).forEach( t -> System.out.println(t[0] + "," + t[1]));

        // odd even numbers partitioned using partitioning
        System.out.println(Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).
              boxed().collect(Collectors.partitioningBy(integer -> integer %2 == 0)));

        // show max calories of dishes group by veg/non-veg
        menu.stream()
            .collect(Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));

        System.out.println(IntStream.rangeClosed(2, 35).boxed().collect(Collectors.partitioningBy(StreamClient::isPrime)));


        // practice - lambda expression
        Supplier<StreamClient> clientSupplier = StreamClient::create;
        // passing in a bi function
        System.out.println(replaceNChars("hello", 'l', (s, character) -> !s.replace(character, 'a').equals(s)));
    }

    public static boolean replaceNChars(String input, Character ch, BiFunction<String, Character, Boolean> function)
    {
        return function.apply(input, ch);
    }

    public static StreamClient create()
    {
        return new StreamClient();
    }

    public static boolean isPrime(int num)
    {
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
    }

    @FunctionalInterface
    public interface TemporalAdjuster
    {
        Temporal adjustInto(Temporal temporal);
    }

    public class NextWorkingDay implements TemporalAdjuster
    {

        @Override
        public Temporal adjustInto(Temporal temporal)
        {

            return null;
        }
    }
}
