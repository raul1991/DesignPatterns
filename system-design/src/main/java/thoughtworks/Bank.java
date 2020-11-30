package thoughtworks;

public class Bank {
    private int balance;
    private boolean isBankrupt;

    public Bank(int initBalance) {
        this.balance = initBalance;
    }

    public int deduct(int money) {
        if (!isBankrupt && money <= balance) {
            balance -= money;
        }
        isBankrupt = (balance == 0);
        return balance;
    }

    public int deposit(int money) {
        balance += money;
        return balance;
    }

    public boolean isBankrupt() {
        return balance == 0;
    }
}
