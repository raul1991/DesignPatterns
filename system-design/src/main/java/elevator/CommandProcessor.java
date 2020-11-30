package elevator;

import elevator.commands.ElevatorCommand;

/**
 * A processor would be responsible of executing the commands it gets. Mostly, the one shot commands like fan toggling,
 * alarms and phone, will be run directly. However, commands like floor button pressed would be guided by the logic of
 * the elevator which must be encapsulated inside the concrete processors.
 *
 * For example, you could have a LazyCommandProcessor which executes commands with a delay of 1 second or a processor
 * that runs a command in FCFS manner. Such implementations must be provided inside in concrete classes.
 *
 */
public interface CommandProcessor {
   // processes the command.
   void enqueueCommand(ElevatorCommand command) throws InterruptedException;
   // clears the queue.
   void clear();
   // lists all the commands in the processor queue.
   void list();
   // process loop that just keeps on executing the commands from the command list.
   void process() throws InterruptedException;
   // stop processing
   void shutdown();
}
