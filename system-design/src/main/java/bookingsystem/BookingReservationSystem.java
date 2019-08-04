package bookingsystem;

import java.util.List;

public class BookingReservationSystem {

    private static final BookingReservationSystem INSTANCE = new BookingReservationSystem();
    private List<Theatre> theatres;
    private BookingReservationSystem()
    {
        // to avoid creating objects.
    }

    public static BookingReservationSystem getInstance() {
        return INSTANCE;
    }

    public List<SearchResult> search(MovieShow movieShow, SearchCriteria criteria) {
        theatres.forEach(theatre -> theatre.matches(criteria));
        return null;
    }
}
