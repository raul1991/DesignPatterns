package creational.simplefactory;

public class ProductFactory
{
    public static Product createProduct(int id)
    {
        switch (id)
        {
            case 123:
                return new WashingMachine();
            case 12312:
                return new Monitor();
            default:
                throw new IllegalArgumentException("Id not supported");
        }
    }
}
