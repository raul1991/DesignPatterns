package bookingsystem.interfaces;

public abstract class BookingSystemRequest {
    protected long id;

    public BookingSystemRequest()
    {
        this.id = System.currentTimeMillis();
    }
}
