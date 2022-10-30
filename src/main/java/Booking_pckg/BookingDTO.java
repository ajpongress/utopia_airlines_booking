package Booking_pckg;

public class BookingDTO {

    private int isActive;
    private String stripeId;
    private int bookerId;

    public BookingDTO (int _isActive, String _stripeId, int _bookerId) {

        setIsActive(_isActive);
        setStripeId(_stripeId);
        setBookerId(_bookerId);
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public int getBookerId() {
        return bookerId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
    }
}
