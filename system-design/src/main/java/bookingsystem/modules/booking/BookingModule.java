package bookingsystem.modules.booking;

import bookingsystem.domainobjects.moviewatcher.SearchBookingRequest;
import bookingsystem.domainobjects.moviewatcher.SearchBookingResponse;
import bookingsystem.domainobjects.moviewatcher.ShowBookingRequest;
import bookingsystem.domainobjects.moviewatcher.ShowBookingResponse;

public interface BookingModule {
    ShowBookingResponse book(ShowBookingRequest request);
    SearchBookingResponse search(SearchBookingRequest request);
}
