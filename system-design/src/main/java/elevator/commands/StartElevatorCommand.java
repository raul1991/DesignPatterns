package elevator.commands;

public class StartElevatorCommand implements ElevatorCommand {

    @Override
    public void execute() {
        System.out.println("Starting the elevator");
        System.out.println("[Sound] - Welcome to the lazy elevator");
    }

    @Override
    public String name() {
        return "StartElevatorCommand";
    }
}
