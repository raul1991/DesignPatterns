package bookingsystem.modules.auth;

import bookingsystem.domainobjects.moviewatcher.LoginRequest;
import bookingsystem.interfaces.LoginResponse;

public class PlainAuthModule implements AuthModule {
    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}
