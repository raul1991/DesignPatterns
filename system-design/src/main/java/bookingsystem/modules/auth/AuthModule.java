package bookingsystem.modules.auth;

import bookingsystem.domainobjects.moviewatcher.LoginRequest;
import bookingsystem.interfaces.LoginResponse;

public interface AuthModule {
    LoginResponse login(LoginRequest request);
}
