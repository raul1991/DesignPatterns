package thoughtworks;

import java.util.Arrays;

public class HardCodedDice implements Dice {

    private final String rollOuts;
    private final int noOfPlayers;
    private final String delimiter;
    private int rollCall = 0;

    public HardCodedDice(String input, String delimiter, int numberOfPlayers) {
        this.rollOuts = input;
        this.noOfPlayers = numberOfPlayers;
        this.delimiter = delimiter;
    }

    @Override
    public int roll() {
        // todo: validation
        String[] totalRolls = rollOuts.split(this.delimiter);
        int partition = totalRolls.length / noOfPlayers;
        return Integer.parseInt(totalRolls[rollCall++]);
    }
}
