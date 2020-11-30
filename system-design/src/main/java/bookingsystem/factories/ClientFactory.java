package bookingsystem.factories;

import bookingsystem.controller.SystemController;
import bookingsystem.domainobjects.moviewatcher.MovieWatcherClient;
import bookingsystem.domainobjects.theatre.TheatreClient;
import bookingsystem.modules.auth.PlainAuthModule;
import bookingsystem.modules.booking.BookingModuleImpl;
import bookingsystem.modules.registration.TheatreRegistrationModule;
import bookingsystem.modules.registration.UserRegistrationModule;

public class ClientFactory {
    private ClientFactory() {
        // left empty for non instantiation
    }
    public static MovieWatcherClient createDefaultClient() {
        return new MovieWatcherClient(new SystemController(
                new PlainAuthModule(),
                new UserRegistrationModule(),
                new BookingModuleImpl()
        ));
    }

    public static TheatreClient createTheatreClient() {
        return new TheatreClient(new SystemController(
                new PlainAuthModule(),
                new TheatreRegistrationModule()
        ));
    }
}
