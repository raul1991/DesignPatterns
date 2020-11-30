package bookingsystem.domainobjects.theatre;

import bookingsystem.controller.SystemController;
import bookingsystem.interfaces.TheatreRegistrationClient;

public class TheatreClient implements TheatreRegistrationClient {

    private final SystemController controller;

    public TheatreClient(SystemController controller) {
        this.controller = controller;
    }

    // more behaviours
}
