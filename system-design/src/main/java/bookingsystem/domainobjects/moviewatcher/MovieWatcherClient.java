package bookingsystem.domainobjects.moviewatcher;

import bookingsystem.controller.SystemController;
import bookingsystem.interfaces.BookingSystemClient;
import bookingsystem.interfaces.BookingSystemResponse;

public class MovieWatcherClient implements BookingSystemClient {
    private SystemController controller;

    public MovieWatcherClient(SystemController controller) {
        this.controller = controller;
    }

    @Override
    public BookingSystemResponse login(LoginRequest request) {
        return controller.login(request);
    }

    @Override
    public BookingSystemResponse register(RegistrationRequest request) {
        return controller.register(request);
    }

    @Override
    public BookingSystemResponse book(ShowBookingRequest request) {
        return controller.book(request);
    }

    @Override
    public BookingSystemResponse search(SearchBookingRequest request) {
        return controller.search(request);
    }

    // more behaviours
}
