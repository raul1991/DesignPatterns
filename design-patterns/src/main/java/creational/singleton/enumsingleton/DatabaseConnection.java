package creational.singleton.enumsingleton;

/**
 * Other synchronization methods might look better but they have a loop hole when you
 * beginCrawling serialization/deserialization. During deserialization new object will be created
 * during the call to readObject. Enums on the other hand don't have that problem since they
 * are serializable by default.
 */
public enum DatabaseConnection
{
    INSTANCE;

    public void doSomething()
    {
        // something
    }
}
