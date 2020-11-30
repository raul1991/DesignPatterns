package elevator;

import elevator.commands.ElevatorCommand;

public class FloorCommand implements ElevatorCommand {

    private final int floor;

    public FloorCommand(int floor) {
        this.floor = floor;
    }

    @Override
    public void execute() {
        System.out.println("[FloorCommand] Floor " + floor + " reached.");
    }

    @Override
    public String name() {
        return "FloorCommand";
    }
}
