package elevator;

import elevator.commands.ElevatorCommand;

public class FCFSElevatorController implements ElevatorController {
    private Elevator elevator;

    public FCFSElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void start() {
        elevator.start();
    }

    @Override
    public void stop() {
        elevator.stop();
    }

    @Override
    public void restart() {
        elevator.restart();
    }

    @Override
    public void execute(ElevatorCommand command) {
        try {
            elevator.getCommandProcessor().enqueueCommand(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
