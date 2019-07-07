package creational.abstractfactory.storage;

public class GoogleComputeStorage implements Storage
{

    private final int capMib;

    public GoogleComputeStorage(int capMib)
    {
        this.capMib = capMib;
    }

    public String getId()
    {
        return "apiKeyGCS";
    }

    @Override
    public String toString()
    {
        return "Google storage = "+ capMib;
    }
}
