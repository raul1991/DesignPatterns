package bookingsystem.modules.registration;

import bookingsystem.domainobjects.moviewatcher.DeRegistrationRequest;
import bookingsystem.domainobjects.moviewatcher.RegistrationRequest;
import bookingsystem.interfaces.RegistrationResponse;

public interface RegistrationModule {
    RegistrationResponse register(RegistrationRequest request);
    RegistrationResponse deRegister(DeRegistrationRequest user);
}
