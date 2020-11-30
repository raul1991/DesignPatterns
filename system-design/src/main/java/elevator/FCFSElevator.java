package elevator;

public class FCFSElevator extends BaseElevator {

    private final CommandProcessor commandProcessor;
    private final DisplayUnit display;
    private static final int TOTAL_FLOORS = 9;

    public FCFSElevator(CommandProcessor commandProcessor, DisplayUnit display) {
        super(commandProcessor, display);
        this.commandProcessor = commandProcessor;
        this.display = display;
        // how about a sound manager here to play weird sounds on every action ?
    }

    @Override
    public int floor() {
        System.out.println("Elevator is currently at " + currentFloor);
        return currentFloor;
    }

    @Override
    public void start() {
        // do something crazy'
        System.out.println("[FCFSElevator] Starting up the elevator");
    }

    @Override
    public void stop() {
        // be dramatic
        commandProcessor.shutdown();
        System.out.println("[FCFSElevator] Stopping the elevator.");
    }

    @Override
    public void restart() {
        // again!
    }

    @Override
    public void health() {
        // check all buttons are working.
        // check power supply
        // check backup supply
        // check doors
        // check lights
        // check sounds.
        System.out.println("All systems healthy!");
    }

    @Override
    public CommandProcessor getCommandProcessor() {
        return commandProcessor;
    }

    @Override
    public DisplayUnit getDisplay() {
        return display;
    }

    @Override
    public void floor(int floor) {
        try {
            System.out.println("Received request for adding " + floor + " to command queue");
            commandProcessor.enqueueCommand(new FloorCommand(floor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.currentFloor = floor;
    }

    @Override
    public void upOneFloor() {
        this.currentFloor = Math.max(TOTAL_FLOORS, this.currentFloor++);
    }

    @Override
    public void downOneFloor() {
        this.currentFloor = Math.min(TOTAL_FLOORS, this.currentFloor--);
    }
}
