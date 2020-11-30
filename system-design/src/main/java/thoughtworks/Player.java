package thoughtworks;

public interface Player {
    int rollDice();
    int moveTo(int pos);
    int giveMoney(int howMuch);
    int takeMoney(int howMuch);
    String name();

    int money();
}
