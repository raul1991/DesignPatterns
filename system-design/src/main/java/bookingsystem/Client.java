package bookingsystem;

public class Client {

    public static void main(String[] args) {
        BookingReservationSystem paytm = BookingReservationSystem.getInstance();
        SearchCriteria criterias = null;
        paytm.search(new MovieShow(), criterias);
    }
}
