package creational.factory;

public class TextMessageMessageCreator extends MessageCreator
{
    public Message createMessage()
    {
        return new TextMessage();
    }
}
