package creational.abstractfactory.storage;

public class S3Storage implements Storage
{
    private int capMib;

    public S3Storage(int capMib)
    {
        this.capMib = capMib;
    }

    public String getId()
    {
        return "awsKey";
    }

    @Override
    public String toString()
    {
        return "Storage = "+this.capMib;
    }
}
