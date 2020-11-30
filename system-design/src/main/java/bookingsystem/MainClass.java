package bookingsystem;

import bookingsystem.domainobjects.moviewatcher.*;
import bookingsystem.factories.ClientFactory;

public class MainClass {
    public static void main(String[] args) {
        MovieWatcherClient client = ClientFactory.createDefaultClient();
        client.register(new RegistrationRequest());
        client.login(new LoginRequest());
        client.book(new ShowBookingRequest());
        client.search(new SearchBookingRequest());
    }
}
