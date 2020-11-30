package elevator;

public interface Elevator {
    // a callback for returning the floor number.
    int floor();
    // start
    void start();
    // stop
    void stop();
    // restart
    void restart();
    // health checks
    void health();
    // get command processor
    CommandProcessor getCommandProcessor();
    DisplayUnit getDisplay();
    // move to floor
    void floor(int floor);
    // go up 1 floor
    void upOneFloor();
    // go down 1 floor
    void downOneFloor();
}
