package creational.simplefactory;

public class Main
{
    public static void main(String[] args)
    {
        final Product washingMachine = ProductFactory.createProduct(123);
        System.out.println(washingMachine.name());
        final Product monitor = ProductFactory.createProduct(12312);
        System.out.println(monitor.name());
    }
}
