package bookingsystem.modules.registration;

import bookingsystem.domainobjects.moviewatcher.DeRegistrationRequest;
import bookingsystem.domainobjects.moviewatcher.RegistrationRequest;
import bookingsystem.interfaces.RegistrationResponse;

public class UserRegistrationModule implements RegistrationModule {

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        return null;
    }

    @Override
    public RegistrationResponse deRegister(DeRegistrationRequest user) {
        return null;
    }
}
