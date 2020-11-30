package elevator;

import elevator.commands.ElevatorCommand;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FCFSDelayedCommandProcessor implements CommandProcessor {
    private volatile boolean isElevatorRunning = true;
    private BlockingQueue<ElevatorCommand> commandList = new LinkedBlockingDeque<>();

    @Override
    public void enqueueCommand(ElevatorCommand command) throws InterruptedException {
        commandList.put(command);
    }

    @Override
    public void clear() {
        commandList.clear();
    }

    @Override
    public void list() {
        commandList.forEach(ElevatorCommand::name);
    }

    @Override
    public void process() throws InterruptedException {
        while (isElevatorRunning) {
            ElevatorCommand currentCommand = commandList.take();
            currentCommand.execute();
        }
    }

    @Override
    public void shutdown() {
        isElevatorRunning = false;
    }
}
