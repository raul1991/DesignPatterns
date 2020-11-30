package elevator;

import elevator.commands.ElevatorCommand;

public interface ElevatorController {
    void start();
    void stop();
    void restart();
    void execute(ElevatorCommand command);
}
