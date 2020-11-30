package thoughtworks;

public class HousiePlayer implements Player {

    private int balance;
    private Dice dice;
    private int currentPos;
    private String name;

    public HousiePlayer(String name, Dice dice, int initBalance) {
        this.dice = dice;
        this.balance = initBalance;
        this.currentPos = 0;
        this.name = name;
    }

    @Override
    public int rollDice() {
        int roll = dice.roll();
        System.out.println("Dice rolled = " + roll);
        return roll;
    }

    @Override
    public int moveTo(int pos) {
        currentPos += pos;
        System.out.printf("Player %s moving to pos = %d%n", name, currentPos);
        return currentPos;
    }

    @Override
    public int giveMoney(int howMuch) {
        System.out.printf("Player %s gives %d to bank %n", name, howMuch);
        balance -= howMuch;
        return balance;
    }

    @Override
    public int takeMoney(int howMuch) {
        System.out.printf("Player %s receives %d from bank %n", name, howMuch);
        balance += howMuch;
        return balance;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int money() {
        return balance;
    }

    @Override
    public String toString() {
        return "HousiePlayer{" +
                "balance=" + balance +
                ", dice=" + dice +
                ", currentPos=" + currentPos +
                ", name='" + name + '\'' +
                '}';
    }
}
