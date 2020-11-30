package bookingsystem.domainobjects.moviewatcher;

import bookingsystem.interfaces.BookingSystemRequest;

public class SearchShowRequest extends BookingSystemRequest {
    private String query;
    private int resultsCount;

    public SearchShowRequest(String query, int count) {
        super();
        this.resultsCount = count;
        this.query = query;
    }
}
