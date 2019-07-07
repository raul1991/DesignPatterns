package creational.factory;

public class Client
{
    public static void main(String[] args)
    {
        Message jsonMessage = new JsonMessageMessageCreator().getMessage();
        Message textMessage = new TextMessageMessageCreator().getMessage();
        System.out.println(jsonMessage.getContent());
        System.out.println(textMessage.getContent());
    }
}
