package thoughtworks;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        Dice dice = new HardCodedDice(
                "2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1",
                ",",
                3);

        String input = "J,H,L,H,E,L,H,J,H,J";
        Game game = new HousieGame(
                new ArrayLikeBoard(new DelimitedConfiguration(",", input),
                        new ConsoleDisplayModule()),
                Arrays.asList(new HousiePlayer("Ted", dice, 1000),
                        new HousiePlayer("Foo", dice, 1000),
                        new HousiePlayer("Bar", dice, 1000)),
                new Bank(5000)
        );
        game.start();
        game.play();
        game.stop();
    }
}
