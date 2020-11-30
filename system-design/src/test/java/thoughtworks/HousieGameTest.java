package thoughtworks;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;



public class HousieGameTest {

    @Mock
    private Bank bank;
    @Mock
    private Board board;
    private List<Player> players;
    private HousieGame game;

    @Before
    public void setup() {
        // init mocks
        Dice dice = new HardCodedDice(
                "2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1",
                ",",
                3);

        String input = "J,H,L,H,E,L,H,J,H,J";
        players = Arrays.asList(new HousiePlayer("Ted", dice, 1000),
                new HousiePlayer("Foo", dice, 1000),
                new HousiePlayer("Bar", dice, 1000));
        game = new HousieGame(
                new ArrayLikeBoard(new DelimitedConfiguration(",", input),
                        new ConsoleDisplayModule()),
                Arrays.asList(new HousiePlayer("Ted", dice, 1000),
                        new HousiePlayer("Foo", dice, 1000),
                        new HousiePlayer("Bar", dice, 1000)),
                new Bank(5000)
        );    }

    @Test
    public void playWithGameOverExpectPlayersBalanceToRemainSame() {
        game.start();
        game.play();
        game.setGameOver(true);
        players.forEach(player -> Assertions.assertSame(player.money(), 1000));
    }
}
