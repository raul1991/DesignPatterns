package bookingsystem.controller;

import bookingsystem.domainobjects.moviewatcher.RegistrationRequest;
import bookingsystem.domainobjects.moviewatcher.LoginRequest;
import bookingsystem.domainobjects.moviewatcher.SearchBookingRequest;
import bookingsystem.domainobjects.moviewatcher.ShowBookingRequest;
import bookingsystem.interfaces.BookingSystem;
import bookingsystem.interfaces.BookingSystemResponse;
import bookingsystem.modules.auth.AuthModule;
import bookingsystem.modules.booking.BookingModule;
import bookingsystem.modules.registration.RegistrationModule;

public class SystemController implements BookingSystem {

    private AuthModule authModule;
    private RegistrationModule registrationModule;
    private BookingModule bookingModule;

    public SystemController(AuthModule authModule,
                            RegistrationModule registrationModule,
                            BookingModule bookingModule) {
        this(authModule, registrationModule);
        this.bookingModule = bookingModule;
    }

    public SystemController(AuthModule authModule,
                            RegistrationModule registrationModule) {
        this.authModule = authModule;
        this.registrationModule = registrationModule;
    }

    @Override
    public BookingSystemResponse login(LoginRequest request) {
        return authModule.login(request);
    }

    @Override
    public BookingSystemResponse register(RegistrationRequest request) {
        return registrationModule.register(request);
    }

    @Override
    public BookingSystemResponse book(ShowBookingRequest request) {
        return bookingModule.book(request);
    }

    @Override
    public BookingSystemResponse search(SearchBookingRequest request) {
        return bookingModule.search(request);
    }
}
