import java.util.Date;

public class ResiCheckIn {
    private String nomorResi;
    private Date checkIn;
    private Date checkOut;

    public ResiCheckIn(String nomorResi, Date checkIn, Date checkOut) {
        this.nomorResi = nomorResi;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void printResi() {
        System.out.println("Nomor Resi: " + nomorResi);
        System.out.println("Check-In: " + checkIn);
        System.out.println("Check-Out: " + checkOut);
    }
}
