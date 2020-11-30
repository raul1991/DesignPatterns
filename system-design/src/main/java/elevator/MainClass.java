package elevator;

public class MainClass {
    public static void main(String[] args) {
        Elevator elevator = new FCFSElevator(
                new FCFSDelayedCommandProcessor(),
                new SevenSegmentDisplayUnit()
        );
        elevator.health();
        elevator.floor();
        elevator.floor(1);
        elevator.floor(2);
        elevator.floor(3);
        elevator.stop();
    }
}
