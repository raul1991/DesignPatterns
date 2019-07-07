package creational.prototype;

public class Client
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        RPGGameUnit rpgGameUnit = new RPGGameUnit();
        rpgGameUnit.addGuns();
        System.out.println("Got guns ?" + rpgGameUnit.hasGuns());
        final RPGGameUnit clone = (RPGGameUnit) rpgGameUnit.clone();
        System.out.println("Got guns ?" + clone.hasGuns());
    }
}
