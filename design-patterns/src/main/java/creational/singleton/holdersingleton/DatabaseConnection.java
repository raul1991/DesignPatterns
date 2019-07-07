package creational.singleton.holdersingleton;

public class DatabaseConnection
{
    private DatabaseConnection()
    {
        // to avoid instantiation
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    private static class DatabaseConnectionHolder
    {
        static final DatabaseConnection CONNECTION = new DatabaseConnection();
    }
    public static DatabaseConnection getInstance()
    {
        return DatabaseConnectionHolder.CONNECTION;
    }
}
