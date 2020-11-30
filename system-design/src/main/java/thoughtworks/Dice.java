package thoughtworks;

import java.util.Random;

public interface Dice {

    default int roll() {
        return new Random().nextInt(13) + 1;
    }
}
