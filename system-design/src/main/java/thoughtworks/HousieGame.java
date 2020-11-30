package thoughtworks;

import java.util.Iterator;
import java.util.List;

public class HousieGame implements Game {

    private Board board;
    private List<Player> playerList;
    private Bank bank;
    private boolean isGameOver;
    private static final int lotteryValue = 200;
    private static final int jailFine = 150;
    private int plays;

    public HousieGame(Board board, List<Player> players, Bank bank) {
        this.board = board;
        this.playerList = players;
        this.bank = bank;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    @Override
    public void start() {
        board.init();
        board.render();
    }


    @Override
    public void stop() {
        board.clear();
    }

    @Override
    public void play() {
        plays = 1;
        while (!isGameOver) {
            // render
            Player nextPlayer = playerList.get(getNextPlayerIdx(plays++));
            if (nextPlayer == null) return;
            int pos = nextPlayer.rollDice();
            int newPos = nextPlayer.moveTo(pos);
            if (isValidPos(pos)) {
                CellArtifact type = board.fromPos(pos);
                if (type.type().equals("jail")) {
                    nextPlayer.giveMoney(jailFine);
                    bank.deposit(jailFine);
                } else if (type.type().equals("hotel")) {
                    System.out.println(nextPlayer + "At a hotel");
                    Hotel artifact = (Hotel) type;
                    int upgradeValue = artifact.upgrade();
                    // deduct from user
                    nextPlayer.giveMoney(upgradeValue);
                    // add to bank
                    bank.deposit(upgradeValue);
                } else if (type.type().equals("empty")) {
                    System.out.println(nextPlayer + "at an empty cell");
                } else if (type.type().equals("lottery")) {
                    bank.deduct(type.value());
                    nextPlayer.takeMoney(type.value());
                }
                System.out.println(nextPlayer);
            }
            else {
                System.out.println("[Game over for] " + nextPlayer);
            }
        }
        printResult();
        isGameOver = true;
    }

    private void printResult() {
        System.out.println("=============================");
        System.out.println("Result");
        System.out.println("=============================");
    }

    // MAX_POS = 10
    // MAX_POS - NEW_POS => MAX_POS + 5 % MAX_POS
    private boolean isValidPos(int pos) {
        return board.isValidPos(pos);
    }

    private int getNextPlayerIdx(int turn) {
        if (turn % 3 == 1) return 0;
        else if (turn % 3 == 2) return 1;
        else if (turn % 3 == 0) return 2;
        plays = Math.min(3, turn) == 3 ? 0 : turn;
        return -1;
    }
}
