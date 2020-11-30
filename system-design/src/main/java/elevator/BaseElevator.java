package elevator;

// a skeleton implementation for a basic elevator
// which must contain a command processor and display unit
public abstract class BaseElevator implements Elevator {
    protected CommandProcessor processor;
    protected DisplayUnit displayUnit;
    // state variables
    protected int currentFloor; // current floor where the lift is.
    protected boolean isWorking;

    protected BaseElevator(CommandProcessor processor, DisplayUnit displayUnit) {
        this.processor = processor;
        this.displayUnit = displayUnit;
    }

    // a callback for initialisation of the lift.
    final void init() {
        health(); // do health checks
        start(); // starting up the elevator
    }
}
