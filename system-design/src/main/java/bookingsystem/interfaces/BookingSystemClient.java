package bookingsystem.interfaces;

import bookingsystem.domainobjects.moviewatcher.RegistrationRequest;
import bookingsystem.domainobjects.moviewatcher.LoginRequest;
import bookingsystem.domainobjects.moviewatcher.SearchBookingRequest;
import bookingsystem.domainobjects.moviewatcher.ShowBookingRequest;

public interface BookingSystemClient extends DefaultClient {
    BookingSystemResponse login(LoginRequest request);
    BookingSystemResponse register(RegistrationRequest request);
    BookingSystemResponse book(ShowBookingRequest request);
    BookingSystemResponse search(SearchBookingRequest request);
}
